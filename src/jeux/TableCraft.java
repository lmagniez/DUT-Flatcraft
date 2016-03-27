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

                if (ressource1.getID() == (ressource2.getID()))// trouvé, on
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
    
    //Modifie la quantite de l'element a nb (dans la table de craft)
    public void modifierElement(RessourceContainer r, int nb) {
        if(nb==0)return;
        
        System.out.println("SUPPRIMER TABLE");
        RessourceContainer ressource1 = r;
        RessourceContainer ressource2;

        Component[] components = grille.getComponents();
        for (int i = 0; i < components.length; i++) {
            JPanel p = (JPanel) (grille.getComponent(i));
            if (p.getComponentCount() != 0) {
                ressource2 = (RessourceContainer) (p.getComponent(0));
                System.out.println(ressource1.getID() + " " + ressource2.getID());

                if (ressource1.getID() == (ressource2.getID()))// trouvé, on
                                                               // supprime
                {
                    System.out.println("TROUVE !! ON MODIFIE");
                    ((RessourceContainer) p.getComponent(0)).setQuantity(nb);;
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

                        RessourceContainer origine = (RessourceContainer) support.getTransferable().getTransferData(MineUtils.MINE_FLAVOR);
                        
                        RessourceContainer nouvelle = new RessourceContainer(origine.getQuantity(),origine.getRessource());
                        
                        nouvelle.addMouseListener(Jeux.mouselistener);
                        nouvelle.setTransferHandler(nouvelle.createTransfertFrom());

                        //modifie ancien elements (/2)
                        int divise= origine.getQuantity()/2;
                        int reste = origine.getQuantity()-divise;
                        
                        if(divise==0)return false;
                        if(reste==0)return false;
                        
                        //modification
                        Jeux.getTable().modifierElement(origine, divise);                         
                        if(!Jeux.getInv().estDansLInventaire(origine))//Si vient de l'inventaire, pas besoin de -1
                            nouvelle.setQuantity(reste);
                        
                        if(nouvelle.getQuantity()==0)return true;
                        
                        
                        source.add(nouvelle);
                        source.revalidate();
                        source.repaint();

                        //supprime element inventaire (seulement si �a vient de l'inventaire)
                        Jeux.getInv().supprimerInventaire((RessourceContainer) origine);

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
   
    private ToolInstance construireOutils(){

        for(int i=0;i<MineUtils.NB_OUTILS;i++){
            ArrayList<Ressource> patterntmp=MineUtils.tabOutils[i].getPattern();
            for(int a=0;a<patterntmp.size();a++){
                /*
                 * if(non egal) break;
                 * 
                 * else if(a<patterntmp.size())return MineUtils.tabOutils[i]; //cela signifie que tout c'est tout etait identique
                 */
            }    
        }
        return null;
    }

    /*
     * Pour les Ressources (batons,WoodPlancks)
     */
    private RessourceInstance construireRessource(){
        for(int i=0;i<MineUtils.NB_OUTILS;i++){
            ArrayList<Ressource> patterntmp=MineUtils.tabOutils[i].getPattern();
            for(int a=0;a<patterntmp.size();a++){
                /* VOIR POUR LES TAILLES CAR LES PATTERNS DES RESSOURCES CONSTRUCTIVE NE SONT PAS DE TAILLE 9
                 * if(non egal) break;
                 * 
                 * else if(a<patterntmp.size())return MineUtils.tabOutils[i]; //cela signifie que tout c'est tout etait identique
                 */
            } 
        }
        return null;
    }
}