package jeux;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.TransferHandler;

import bloc.Ressource;
import bloc.RessourceContainer;
import bloc.RessourceInstance;
import outils.ToolInstance;
import run.MineUtils;

public class TableCraft extends JDialog {

    private JPanel grille;
    private JPanel result;

    public TableCraft(JFrame parent, String titre, boolean modal) {

        super(parent, titre, modal);
        this.setSize(new Dimension(300, 400));
        this.setResizable(false);
        this.setAlwaysOnTop(true);

        prepare();
    }

    public void prepare() {
        grille = new JPanel();
        grille.setLayout(new GridLayout(3, 3));

        result = new JPanel();
        result.setPreferredSize(new Dimension(100, 100));
        result.add(new RessourceContainer(0, null));
        
        for (int i = 0; i < 9; i++) {
            JPanel jp = new JPanel();

            jp.setPreferredSize(new Dimension(80, 80));
            jp.setSize(new Dimension(100, 100));

            jp.setTransferHandler(this.createTransfertTo());
            grille.add(jp);
        }

        grille.setTransferHandler(this.createTransfertTo());

        this.add(BorderLayout.CENTER, grille);
        this.add(BorderLayout.EAST, result);

        grille.revalidate();
        grille.repaint();

        result.revalidate();
        result.repaint();

        this.pack();

    }

    public void supprimerElement(RessourceContainer r) {
        System.out.println("SUPPRIMER TABLE");
        RessourceContainer ressource1 = r;
        RessourceContainer ressource2;

        Component[] components = grille.getComponents();
        for (int i = 0; i < components.length; i++) {

            JPanel p = (JPanel) (grille.getComponent(i));
            if (p.getComponentCount() != 0) {
                ressource2 = (RessourceContainer) (p.getComponent(0));
                System.out.println(ressource1.getID() + " " + ressource2.getID());

                if (ressource1.getID() == (ressource2.getID()))// trouvÃ©, on
                                                               // supprime
                {
                    System.out.println("TROUVE !!");
                    ((JPanel) grille.getComponent(i)).removeAll();
                    this.revalidate();
                    this.repaint();
                    return;
                }
            }
        }

    }

    // Modifie la quantite de l'element a nb (dans la table de craft)
    public void modifierElement(RessourceContainer r, int nb) {
        if (nb == 0)
            return;

        System.out.println("SUPPRIMER TABLE");
        RessourceContainer ressource1 = r;
        RessourceContainer ressource2;

        Component[] components = grille.getComponents();
        for (int i = 0; i < components.length; i++) {
            JPanel p = (JPanel) (grille.getComponent(i));
            if (p.getComponentCount() != 0) {
                ressource2 = (RessourceContainer) (p.getComponent(0));
                System.out.println(ressource1.getID() + " " + ressource2.getID());

                if (ressource1.getID() == (ressource2.getID()))// trouvÃ©, on
                                                               // supprime
                {
                    System.out.println("TROUVE !! ON MODIFIE");
                    ((RessourceContainer) p.getComponent(0)).setQuantity(nb);
                    ;
                    this.revalidate();
                    this.repaint();
                    return;
                }
            }
        }

    }

    private TransferHandler createTransfertTo() {
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
                        
                        RessourceContainer origine = (RessourceContainer) support.getTransferable()
                                .getTransferData(MineUtils.MINE_FLAVOR);

                        RessourceContainer nouvelle = new RessourceContainer(origine.getQuantity(),
                                origine.getRessource());

                        nouvelle.addMouseListener(Jeux.mouselistener);
                        nouvelle.setTransferHandler(nouvelle.createTransfertFrom());

                        
                        // modifie ancien elements (/2)
                        int divise = origine.getQuantity() / 2;
                        int reste = origine.getQuantity() - divise;

                        
                        
                        if (divise == 0)
                            Jeux.getTable().supprimerElement(origine);
                        if (reste == 0)
                            return false;

                        // modification
                        Jeux.getTable().modifierElement(origine, divise);
                        if (!Jeux.getInv().estDansLInventaire(origine)&&!estDansResult(origine))// Si
                                                                       // vient
                                                                       // de
                                                                       // l'inventaire,
                                                                       // pas
                                                                       // besoin
                                                                       // de -1
                            nouvelle.setQuantity(reste);

                        if (nouvelle.getQuantity() == 0)
                            return true;
                        
                        
                        
                        source.add(nouvelle);
                        source.revalidate();
                        source.repaint();

                        // supprime element inventaire (seulement si ï¿½a vient de
                        // l'inventaire)
                        Jeux.getInv().supprimerInventaire((RessourceContainer) origine);
                        if(estDansResult(origine))
                            result.removeAll();
                        
                        creation();
                        
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

    /*
     * Pour les Outils
     */
    
    private void creation() {
        result.removeAll();
        ToolInstance newoutil=construireOutils();
            if(newoutil!=null) 
            {
                result.add(newoutil); 
            }
            
            else{
                System.out.println("on y va");
                RessourceContainer newressource=construireRessource();
                if(newressource!=null){
                    newressource.addMouseListener(Jeux.mouselistener);
                    newressource.setTransferHandler(newressource.createTransfertFrom());
                    result.add(newressource);
                }
            }
    }

    
    private ToolInstance construireOutils() {
        JPanel jp;
        RessourceContainer r;
        Component[] components;
        ArrayList<Ressource> patterntmp;
        
        //Pour chaque pattern d'outils
        for (int i = 0; i < MineUtils.NB_OUTILS; i++) {
            patterntmp = MineUtils.tabOutils[i].getPattern();
            
            //Pour chaque case du pattern
            for (int a = 0; a < patterntmp.size(); a++) {
                
                Ressource casePattern=patterntmp.get(a);
                
                //Récupère la case de la table craft
                jp = (JPanel) this.grille.getComponent(a);
                //case grille pleine
                if(jp.getComponentCount()!=0)
                {
                    r=(RessourceContainer) jp.getComponent(0);
                    Ressource caseGrille=r.getRessource();
                    
                    //si la case pattern = ressource grille 
                    System.out.println("a: "+a+"i: "+i);
                    
                    if(casePattern==null)
                        break;
                    if (!casePattern.getId().equals(caseGrille.getId()))
                        break;
                    //si a = taille pattern, on créé l'outil
                    
                }
                //Case grille vide
                else
                {
                    if(casePattern!=null)
                        break;//pattern suivant
                }
                if (a == patterntmp.size()-1)
                    return new ToolInstance(MineUtils.tabOutils[i]);
            }
        }
        return null;
    }

    /*
     * Pour les Ressources (Pick,WoodPlancks)
     */
    private RessourceContainer construireRessource() {
        JPanel jp;
        RessourceContainer r;
        Component[] components;
        ArrayList<Ressource> patterntmp;
        
        //Pour chaque pattern de ressources
        for (int i = 0; i < MineUtils.NB_RESSOURCES; i++) {
            patterntmp = MineUtils.tabRessources[i].getPattern();
            
            //Pour chaque case du pattern
            for (int a = 0; a < patterntmp.size(); a++) {
                System.out.println("a: "+a+"i: "+i);
                
                Ressource casePattern=patterntmp.get(a);
                
                //Récupère la case de la table craft
                jp = (JPanel) this.grille.getComponent(a);
                if(jp.getComponentCount()!=0)
                {
                    r=(RessourceContainer) jp.getComponent(0);
                    Ressource caseGrille=r.getRessource();
                    
                    //si la case pattern = ressource grille 
                    
                    
                    if(casePattern==null)
                        break;
                    //si la case pattern = ressource grille 
                    if (!casePattern.getId().equals(caseGrille.getId()))
                        break;
                    //si a = taille pattern, on créé l'outil
                    
                }
                //Case grille vide
                else
                {
                    if(casePattern!=null)
                        break;//pattern suivant
                }
                if (a == patterntmp.size()-1){
                    System.out.println("ok!!");
                    return new RessourceContainer(MineUtils.tabRessources[i].getNbGenere(),MineUtils.tabRessources[i]);
                    
                }
           }
        }
        return null;
               
    }
    
    public boolean estDansResult(RessourceContainer r)
    {
        if(this.result.getComponentCount()==0)return false;
        
        RessourceContainer r2= (RessourceContainer) this.result.getComponent(0);
        if(r2.getID()==r.getID())
            return true;
        return false;
    }
}