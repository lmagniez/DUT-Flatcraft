package jeux;

import java.awt.Component;
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

/**
 * Inventaire du joueur
 * Contient des ressourceContainer
 */
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

    /**
     * Ajouter un RessourceContainer � l'inventaire, on lui ajoute un mouseListener pour engendrer le drag and drop
     * @param JComponent element � ajouter � l'inventaire
     */
    public void ajout(JComponent c) {
        c.addMouseListener(mouselistener);
        this.add(c);
    }

    /**
     * Enlever la selection sur tous les elements de l'inventaire 
     */
    public void setAllNotSelected() {
        Component[] components = this.getComponents();
        for (int i = 0; i < components.length; i++) {
            ((RessourceContainer) this.getComponent(i)).setSelected(false);
        }
    }

    /**
     * V�rifier si r appartient � l'inventaire (on regarde en fonction de ID)
     * @param r RessourceContainer � v�rifier
     */
    public boolean estDansLInventaire(RessourceContainer r) {
        RessourceContainer ressource1 = r;
        RessourceContainer ressource2;
        Component[] components = Jeux.getInv().getComponents();
        for (int i = 0; i < components.length; i++) {
            ressource2 = (RessourceContainer) (Jeux.getInv().getComponent(i));
            if (ressource1.getID() == (ressource2.getID())) {
                return true;
            }
        }
        return false;
    }

    /**
     * Ajoute n ressource � l'inventaire, si la ressource existe, on ne cr�� pas de nouvelle instance de 
     * RessourceContainer.
     * On peut r�cup�rer les Ressources depuis un RessourceInstance
     * @param r Ressource � ajouter � l'inventaire
     * @param nb Quantit� de la ressource � ajouter
     */
    public void ajoutinventaire(Ressource r, int nb) {
        int i;
        Component[] components = Jeux.getInv().getComponents();
        for (i = 0; i < components.length; i++) {
            RessourceContainer elt = (RessourceContainer) this.getComponent(i);
            if (elt.getRessource().getId().equals(r.getId()) && elt.getQuantity() < 64) {
                elt.setQuantity(elt.getQuantity() + nb);
                this.revalidate();
                this.repaint();
                return;
            }
        }
        RessourceContainer c = new RessourceContainer(nb, r);
        c.addMouseListener(Jeux.mouselistener);
        c.setTransferHandler(c.createTransfertFrom());

        Jeux.getInv().setPreferredSize(new Dimension(i * 90, 80));

        this.ajout(c);
        this.revalidate();
        this.repaint();
        this.setSize(500, 60);
        this.setVisible(true);

    }

    /**
     * Supprimer un �l�ment de l'inventaire (on regarde en fonction de l'ID)
     * @param r RessourceContainer � supprimer de l'inventaire
     */
    public void supprimerInventaire(RessourceContainer r) {
        RessourceContainer ressource1 = r;
        RessourceContainer ressource2;

        Component[] components = Jeux.getInv().getComponents();
        for (int i = 0; i < components.length; i++) {

            ressource2 = (RessourceContainer) (Jeux.getInv().getComponent(i));

            if (ressource1
                    .getID() == (ressource2.getID()))/*
                                                      * trouvé, on supprime
                                                      */
            {
                Jeux.getInv().remove(i);
                this.revalidate();
                this.repaint();
                return;
            }
        }

    }

    /**
     * Ajouter un RessourceContainer � l'inventaire (utilise ajoutinventaire de ressource)
     * @param comp RessourceContainer � ajouter
     */
    public void ajoutinventaire(RessourceContainer comp) {
        Ressource r = comp.getRessource();
        ajoutinventaire(r, comp.getQuantity());
    }

    /**
     * TransfertTo de inventaire 
     * Si on craft un objet (depuis result) on retire 1 � chaque RessourceContainer de la table
     */
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

                        RessourceContainer comp = (RessourceContainer) support.getTransferable()
                                .getTransferData(MineUtils.MINE_FLAVOR);
                        comp.addMouseListener(Jeux.mouselistener);
                        comp.setTransferHandler(((RessourceContainer) comp).createTransfertFrom());
                        
                        //On tente de supprimer la ressource de l'inventaire/de la table
                        Jeux.getInv().supprimerInventaire((RessourceContainer) comp);
                        Jeux.getTable().supprimerElement((RessourceContainer) comp);
                        //on ajoute � l'inventaire
                        Jeux.getInv().ajoutinventaire((RessourceContainer) comp);

                        //si la ressource est dans result
                        if (Jeux.getTable().estDansResult(comp)) {
                            Jeux.getTable().getResult().removeAll(); //on la supprime(on transfere la ressource dans l'inventaire)
                            //on retire 1 � chaque RessourceContainer de la table de craft
                            for (int i = 0; i < 9; i++) {
                                JPanel element = ((JPanel) Jeux.getTable().getGrille().getComponent(i));
                                if (element.getComponentCount() != 0) {
                                    RessourceContainer r = (RessourceContainer) element.getComponent(0);
                                    if (r.getQuantity() == 1)
                                        element.removeAll();
                                    else
                                        r.setQuantity(r.getQuantity() - 1);
                                }
                            }
                            Jeux.getTable().revalidate();
                            Jeux.getTable().repaint();
                        }

                        source.revalidate();
                        source.repaint();

                      //On teste � nouveau si le pattern correspond
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
