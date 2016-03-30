package jeux;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.TransferHandler;

import bloc.Ressource;
import bloc.RessourceContainer;
import outils.ToolInstance;
import run.MineUtils;

/**
 * Classe représentant la table de Craft
 * JDialog qui s'ouvre en appuyant sur le bouton depuis la fenetre principale
 */
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

    /**
     * Générer la table de craft
     */
    public void prepare() {
        //grille de craft
        grille = new JPanel();
        grille.setLayout(new GridLayout(3, 3));

        //Jpanel correspondant au resultat du craft
        result = new JPanel();
        result.setPreferredSize(new Dimension(100, 100));
        result.add(new RessourceContainer(0, null));

        //creation des 9 JPanel a inserer dans le JPanel principal
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

    /**
     * Supprimer un élément de la table de craft (en fonction de ID)
     * @param r RessourceContainer à supprimer
     */
    public void supprimerElement(RessourceContainer r) {
        RessourceContainer ressource1 = r;
        RessourceContainer ressource2;

        Component[] components = grille.getComponents();
        for (int i = 0; i < components.length; i++) {

            JPanel p = (JPanel) (grille.getComponent(i));
            if (p.getComponentCount() != 0) {
                ressource2 = (RessourceContainer) (p.getComponent(0));

                if (ressource1
                        .getID() == (ressource2.getID()))/*
                                                          * trouvÃ©, on supprime
                                                          */
                {
                    ((JPanel) grille.getComponent(i)).removeAll();
                    this.revalidate();
                    this.repaint();
                    return;
                }
            }
        }

    }

    /** 
     * Modifie la quantite de l'element a nb (dans la table de craft) 
     * @param r Element à modifier
     * @param nb nombre à attribuer
     */
    public void modifierElement(RessourceContainer r, int nb) {
        if (nb == 0)
            return;

        RessourceContainer ressource1 = r;
        RessourceContainer ressource2;

        Component[] components = grille.getComponents();
        for (int i = 0; i < components.length; i++) {
            JPanel p = (JPanel) (grille.getComponent(i));
            if (p.getComponentCount() != 0) {
                ressource2 = (RessourceContainer) (p.getComponent(0));

                if (ressource1
                        .getID() == (ressource2.getID()))/*
                                                          * trouvÃ©, on supprime
                                                          */
                {
                    ((RessourceContainer) p.getComponent(0)).setQuantity(nb);
                    ;
                    this.revalidate();
                    this.repaint();
                    return;
                }
            }
        }

    }

    /**
     * TransfertTo vers la table de craft
     * Peut venir de result -> On enleve 1 à chaque RessourceContainer de la table
     * Peut venir de la table -> On partage en 2 les 2 ressources
     * Vient de l'inventaire -> On récupère tout 
     */
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

                        // Recupere ressource directement dans table de craft
                        if (estDansResult(origine)) {

                            //Enleve 1 à chaque RessourceContainer
                            for (int i = 0; i < 9; i++) {
                                JPanel element = ((JPanel) grille.getComponent(i));
                                if (element.getComponentCount() != 0) {
                                    RessourceContainer r = (RessourceContainer) element.getComponent(0);
                                    if (r.getQuantity() == 1)
                                        element.removeAll();
                                    else
                                        r.setQuantity(r.getQuantity() - 1);
                                }

                            }
                            result.removeAll();
                            result.revalidate();
                            result.repaint();
                            source.add(nouvelle);//ajouter la nouvelle ressource 
                            grille.revalidate();
                            grille.repaint();

                            return true;
                        }

                        //on recupere la ressource d'un autre endroit
                        result.removeAll();
                        result.revalidate();
                        result.repaint();

                        // modifie ancien elements (/2)
                        int divise = origine.getQuantity() / 2;
                        int reste = origine.getQuantity() - divise;

                        if (divise == 0)
                            Jeux.getTable().supprimerElement(origine);
                        if (reste == 0)
                            return false;

                        // modification: change la quantite de l'origine
                        Jeux.getTable().modifierElement(origine, divise);
                        /*
                         * Si vient de l'inventaire ou de result, pas besoin de
                         * 2 le nouveau (on transfere tout)
                         */
                        if (!Jeux.getInv().estDansLInventaire(origine) && !estDansResult(origine))
                            nouvelle.setQuantity(reste);

                        /* On ajoute pas le nouveau si quantite=0 */
                        if (nouvelle.getQuantity() == 0)
                            return true;

                        source.add(nouvelle);
                        source.revalidate();
                        source.repaint();

                        /*
                         * supprime element inventaire (seulement si ca vient de
                         * l'inventaire)
                         */
                        Jeux.getInv().supprimerInventaire((RessourceContainer) origine);
                        if (estDansResult(origine)) {
                            result.removeAll();
                            result.revalidate();
                            result.repaint();
                        }

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

    
    public static MouseListener listener = new MouseAdapter() {
        @Override
        public void mousePressed(MouseEvent me) {

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

            ToolInstance comp = (ToolInstance) me.getSource();

            Jeux.getOutils().add(comp);
            Jeux.getOutils().revalidate();
            Jeux.getOutils().repaint();

            Jeux.getTable().revalidate();
            Jeux.getTable().repaint();

            Jeux.getTable().creation();

        }
    };

    /**
     * Lance la vérification des patterns. Si trouve un pattern, ajoute les mouselistener et transferthandler
     */
    public void creation() {
        result.removeAll();
        ToolInstance newoutil = construireOutils();
        if (newoutil != null) {
            newoutil.addMouseListener(listener);
            result.add(newoutil);
        }

        else {
            RessourceContainer newressource = construireRessource();
            if (newressource != null) {
                newressource.addMouseListener(Jeux.mouselistener);
                newressource.setTransferHandler(newressource.createTransfertFrom());
                result.add(newressource);
            }
        }
        result.revalidate();
        result.repaint();
    }

    /**
     * Vérification des patterns d'outils
     */
    private ToolInstance construireOutils() {
        JPanel jp;
        RessourceContainer r;
        Component[] components;
        ArrayList<Ressource> patterntmp;

        /* Pour chaque pattern d'outils */
        for (int i = 0; i < MineUtils.NB_OUTILS; i++) {
            patterntmp = MineUtils.tabOutils[i].getPattern();

            /* Pour chaque case du pattern */
            for (int a = 0; a < patterntmp.size(); a++) {

                Ressource casePattern = patterntmp.get(a);

                /* Rï¿½cupï¿½re la case de la table craft */
                jp = (JPanel) this.grille.getComponent(a);
                /* case grille pleine */
                if (jp.getComponentCount() != 0) {
                    r = (RessourceContainer) jp.getComponent(0);
                    Ressource caseGrille = r.getRessource();

                    /* si la case pattern = ressource grille */

                    if (casePattern == null)
                        break;
                    if (!casePattern.getId().equals(caseGrille.getId()))
                        break;
                    /* si a = taille pattern, on crï¿½ï¿½ l'outil */

                }
                /* Case grille vide */
                else {
                    if (casePattern != null)
                        break;
                }
                if (a == patterntmp.size() - 1)
                    return new ToolInstance(MineUtils.tabOutils[i]);
            }
        }
        return null;
    }

    
    /**
     * Vérification des patterns de ressource
     */
    private RessourceContainer construireRessource() {
        JPanel jp;
        RessourceContainer r;
        Component[] components;
        ArrayList<Ressource> patterntmp;

        /* Pour chaque pattern de ressources */
        for (int i = 0; i < MineUtils.NB_RESSOURCES; i++) {
            patterntmp = MineUtils.tabRessources[i].getPattern();

            /* Pour chaque case du pattern */
            for (int a = 0; a < patterntmp.size(); a++) {

                Ressource casePattern = patterntmp.get(a);

                /* Rï¿½cupï¿½re la case de la table craft */
                jp = (JPanel) this.grille.getComponent(a);
                if (jp.getComponentCount() != 0) {
                    r = (RessourceContainer) jp.getComponent(0);
                    Ressource caseGrille = r.getRessource();

                    /* si la case pattern = ressource grille */

                    if (casePattern == null)
                        break;
                    /* si la case pattern = ressource grille */
                    if (!casePattern.getId().equals(caseGrille.getId()))
                        break;
                    /* si a = taille pattern, on crï¿½ï¿½ l'outil */

                }
                /* Case grille vide */
                else {
                    if (casePattern != null)
                        break;
                }
                if (a == patterntmp.size() - 1) {
                    return new RessourceContainer(MineUtils.tabRessources[i].getNbGenere(), MineUtils.tabRessources[i]);

                }
            }
        }
        return null;

    }

    /**
     * Teste si la ressource est dans la case de résultat de craft (Vérifie en fonction de ID)
     * @param r Ressource à vérifier
     */
    public boolean estDansResult(JComponent r) {
        if (this.result.getComponentCount() == 0)
            return false;

        JComponent r2 = (JComponent) this.result.getComponent(0);
        if (r instanceof RessourceContainer && r2 instanceof RessourceContainer)
            if (((RessourceContainer) r2).getID() == ((RessourceContainer) r).getID())
                return true;
            else if (r instanceof ToolInstance && r2 instanceof ToolInstance)
                if (((ToolInstance) r2).getID() == ((ToolInstance) r).getID())
                    return true;
        return false;
    }

    public JPanel getGrille() {
        return grille;
    }

    public void setGrille(JPanel grille) {
        this.grille = grille;
    }

    public JPanel getResult() {
        return result;
    }

    public void setResult(JPanel result) {
        this.result = result;
    }

}