package jeux;

import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BoxLayout;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.TransferHandler;

import bloc.Ressource;
import bloc.RessourceContainer;
import run.MineUtils;

public class Inventaire extends JPanel {
    public Inventaire() {

        this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        this.setPreferredSize(new Dimension(80, 80));
        this.setVisible(true);
    }
   
    
    MouseListener mouselistener = new MouseAdapter() {
        @Override
        public void mousePressed(MouseEvent me) {
            setAllNotSelected();
        }
    };

    public void ajout(JComponent c) {
        c.addMouseListener(mouselistener);
        this.add(c);
    }

    public void setAllNotSelected() {
        Component[] components = this.getComponents();
        for (int i = 0; i < components.length; i++) {
            ((RessourceContainer) this.getComponent(i)).setSelected(false);
        }
    }

    public void afficher() {
        Component[] components = this.getComponents();
        for (int i = 0; i < components.length; i++) {
            System.out.println(((RessourceContainer) this.getComponent(i)).isSelected());
        }
    }

    
    
    public boolean estDansLInventaire(RessourceContainer r)
    {
        RessourceContainer ressource1 = r;
        RessourceContainer ressource2;
        Component[] components = Jeux.getInv().getComponents();
        for (int i = 0; i < components.length; i++) {
            ressource2 = (RessourceContainer) (Jeux.getInv().getComponent(i));
            if (ressource1.getID() == (ressource2.getID()))
            {
                return true;
            }
        }
        return false;
    }
    
    public void ajoutinventaire(Ressource r, int nb) {
        int i;
        Component[] components = Jeux.getInv().getComponents();
        System.out.println("AJOUT INVENTAIRE");
        for (i = 0; i < components.length; i++) {
            RessourceContainer elt = (RessourceContainer) this.getComponent(i);
            if (elt.getRessource().getId().equals(r.getId()) && elt.getQuantity() < 64) {
                System.out.println("Trouv�! ");
                elt.setQuantity(elt.getQuantity() + nb);
                this.revalidate();
                this.repaint();
                return;
            }
        }
        RessourceContainer c = new RessourceContainer(nb, r);
        c.addMouseListener(Jeux.mouselistener);
        c.setTransferHandler(c.createTransfertFrom());
        
        Jeux.getInv().setPreferredSize(new Dimension(i*90,80));
        
        this.ajout(c);
        this.revalidate();
        this.repaint();
        this.setSize(500, 60);
        this.setVisible(true);

    }

    public void supprimerInventaire(RessourceContainer r) {
        System.out.println("SUPPRIMER INVENTAIRE");
        RessourceContainer ressource1 = r;
        RessourceContainer ressource2;

        Component[] components = Jeux.getInv().getComponents();
        for (int i = 0; i < components.length; i++) {

            ressource2 = (RessourceContainer) (Jeux.getInv().getComponent(i));

            if (ressource1.getID() == (ressource2.getID()))// trouvé, on
                                                           // supprime
            {
                System.out.println("TROUVE !!");
                Jeux.getInv().remove(i);
                this.revalidate();
                this.repaint();
                return;
            }
        }

    }

    public void ajoutinventaire(RessourceContainer comp) {
        Ressource r = comp.getRessource();
        ajoutinventaire(r, comp.getQuantity());
    }

    TransferHandler createTransfertTo() {
        return new TransferHandler() {

            @Override
            public boolean canImport(TransferSupport support) {
                return support.isDataFlavorSupported(MineUtils.MINE_FLAVOR);
            }

            @Override
            public boolean importData(TransferSupport support) {
                if (support.isDrop()) {
                    JPanel source = (JPanel) support.getComponent();
                    try {

                        RessourceContainer comp = (RessourceContainer) support.getTransferable().getTransferData(MineUtils.MINE_FLAVOR);
                        comp.addMouseListener(Jeux.mouselistener);
                        comp.setTransferHandler(((RessourceContainer) comp).createTransfertFrom());

                        Jeux.getInv().supprimerInventaire((RessourceContainer) comp);
                        Jeux.getTable().supprimerElement((RessourceContainer) comp);
                        Jeux.getInv().ajoutinventaire((RessourceContainer) comp);
                        
                        
                        
                        if(Jeux.getTable().estDansResult(comp)){
                            Jeux.getTable().getResult().removeAll();
                            for(int i=0; i<9; i++)
                            {
                                JPanel element= ((JPanel) Jeux.getTable().getGrille().getComponent(i)); 
                                if(element.getComponentCount()!=0){
                                    RessourceContainer r = (RessourceContainer) element.getComponent(0);
                                    if(r.getQuantity()==1)
                                        element.removeAll();
                                    else
                                        r.setQuantity(r.getQuantity()-1);
                                }
                            }
                            Jeux.getTable().revalidate();
                            Jeux.getTable().repaint();
                        }
                        
                        source.revalidate();
                        source.repaint();

                        Jeux.getTable().creation();
                        
                        return true;

                    } catch (Exception e) {
                        e.printStackTrace();
                        return false;
                    }
                } else {
                    return false;
                }
            }
        };
    }

}
