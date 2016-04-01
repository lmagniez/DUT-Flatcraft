package map;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;

import bloc.Lava;
import bloc.RessourceContainer;
import bloc.RessourceInstance;
import jeux.Jeux;
import outils.HacheBois;
import outils.HacheDiamond;
import outils.HacheIron;
import outils.MainOutils;
import outils.PelleBois;
import outils.PelleDiamond;
import outils.PelleIron;
import outils.PiocheBois;
import outils.PiocheDiamond;
import outils.PiocheIron;
import outils.ToolInstance;
import run.MineUtils;

/**
 * Classe g�n�rant une colonne de ressource (repr�sente une case sur la map
 * 
 * @author Vincent Valembois
 * 
 */
public abstract class ColonneDeRessources extends JButton implements ActionListener {
    public ArrayList<RessourceInstance> col = new ArrayList<RessourceInstance>();
    public int taille = 25;

    protected abstract void sol(int index);

    /**
     * Constructeur utilise la fonction create
     */
    public ColonneDeRessources() {
        create();
        this.setIcon(col.get(col.size() - 1).getType().getImage());
        this.setBorder(BorderFactory.createEmptyBorder());
        this.setToolTipText("Niveau: " + (col.size() - taille) + "\n" + " Element : "
                + this.col.get(col.size() - 1).getType().getNom());
        this.addActionListener(this);
    }

    /**
     * Cr�� en fonction de la profondeur et de mani�re al�atoire un ensemble de
     * RessourceInstance
     */
    private void create() {
        float r;
        int i;
        for (i = 0; i < taille; i++) {
            r = (float) (Math.random() * 1);

            if (i > taille - 5 && i < taille) {
                if (r < 0.03)
                    col.add(new RessourceInstance(MineUtils.tabRessources[3])); /* iron */
                else if (r < 0.09)
                    col.add(new RessourceInstance(MineUtils.tabRessources[7])); /* coal */
                else
                    col.add(new RessourceInstance(MineUtils.tabRessources[1])); /* stone */
            } else if (i > 0 && i <= taille - 5) {
                if (r < 0.02)
                    col.add(new RessourceInstance(MineUtils.tabRessources[5])); /* diamond */
                else if (r < 0.1)
                    col.add(new RessourceInstance(MineUtils.tabRessources[3])); /* iron */
                else if (r < 0.17)
                    col.add(new RessourceInstance(MineUtils.tabRessources[7])); /* coal */
                else
                    col.add(new RessourceInstance(MineUtils.tabRessources[1])); /* stone */
            } else if (i == 0)
                col.add(new RessourceInstance(MineUtils.tabRessources[6])); /* lava */
        }
        sol(i);
    }

    /**
     * D�poser et creuser Si on appui sur CTRL avec le clic sur la case, on
     * d�pose Sinon, on creuse (r�cup�re ressourceContainer dans l'inventaire)
     * 
     * DEPOSER: Si on d�pose la derni�re ressource, le ressourceContainer
     * disparait
     * 
     * CREUSER: Si on creuse dans la lave, l'outil �quip� se brise Si l'outil
     * n'a plus de vie, il se brise
     * 
     */
    @Override
    public void actionPerformed(ActionEvent e) {

        ColonneDeRessources button = (ColonneDeRessources) e.getSource();
        int positionCreuse = button.col.size() - 1;

        if ((e.getModifiers() & ActionEvent.CTRL_MASK) == ActionEvent.CTRL_MASK) {
            /* DEPOSER */
            Component[] components = Jeux.getInv().getComponents();
            for (int i = 0; i < components.length; i++) {
                /* On recupere l'element i de l'inventaire */
                RessourceContainer elt = (RessourceContainer) Jeux.getInv().getComponent(i);

                if (elt.isSelected())/* est il selected? (1 seul possible) */
                {
                    /* selected, on l'ajoute sur la map */
                    col.add(new RessourceInstance(elt.getRessource()));
                    setIcon(col.get(positionCreuse + 1).getType().getImage());
                    this.setToolTipText("Niveau: " + (col.size() - taille) + "\n" + " Element : "
                            + this.col.get(col.size() - 1).getType().getNom());

                    elt.setQuantity(elt.getQuantity() - 1);

                    if (elt.getQuantity() == 0)
                        Jeux.getInv().remove(i);
                    Jeux.getInv().revalidate();
                    Jeux.getInv().repaint();

                    return;

                }

            }
        } else {
            /* CREUSER */
            for (int i = 1; i < Jeux.getOutils().getComponents().length; i++) {
                ToolInstance outilsSelected = (ToolInstance) Jeux.getOutils().getComponent(i);

                /* lave */
                if ((outilsSelected.getOutils() instanceof MainOutils) && outilsSelected.isSelect()
                        && col.get(positionCreuse).getType() instanceof Lava) {
                    return;
                }

                else if (outilsSelected.isSelect() && col.get(positionCreuse).getType() instanceof Lava) {
                    Jeux.getOutils().remove(outilsSelected);
                    ((ToolInstance) Jeux.getOutils().getComponent(1)).setSelect(true);
                    Jeux.changeCursorTo();
                    Jeux.getOutils().revalidate();
                    Jeux.getOutils().repaint();
                    return;
                }

                /* Si l'outil est selectionné */
                if (outilsSelected.isSelect()) {
                    /* Ressource All */
                    if ("All".equals(col.get(positionCreuse).getType().getPropriete())) {
                        if (outilsSelected.getOutils() instanceof PelleBois
                                || outilsSelected.getOutils() instanceof PelleIron
                                || outilsSelected.getOutils() instanceof PelleDiamond) {
                            outilsSelected.setVie(outilsSelected.getVie() - 0.5);
                            col.get(positionCreuse)
                                    .setVie(col.get(positionCreuse).getVie() - outilsSelected.getCoef() * 1.5);
                        } else if (!(outilsSelected.getType() instanceof MainOutils))
                            outilsSelected.setVie(outilsSelected.getVie() - 0.5);
                        col.get(positionCreuse).setVie(col.get(positionCreuse).getVie() - outilsSelected.getCoef() * 1);

                    }

                    /* Ressource Pioche */
                    else if ("pioche".equals(col.get(positionCreuse).getType().getPropriete())) {
                        if ((outilsSelected.getOutils() instanceof PiocheBois
                                || outilsSelected.getOutils() instanceof PiocheIron
                                || outilsSelected.getOutils() instanceof PiocheDiamond)) {
                            outilsSelected.setVie(outilsSelected.getVie() - 0.5);
                            col.get(positionCreuse)
                                    .setVie(col.get(positionCreuse).getVie() - outilsSelected.getCoef() * 1.5);
                        } else
                            col.get(positionCreuse)
                                    .setVie(col.get(positionCreuse).getVie() - outilsSelected.getCoef() * 0.5);
                    }
                    /* Si l'outil est Hache */
                    else if ("hache".equals(col.get(positionCreuse).getType().getPropriete())) {
                        if ((outilsSelected.getOutils() instanceof HacheBois
                                || outilsSelected.getOutils() instanceof HacheIron
                                || outilsSelected.getOutils() instanceof HacheDiamond)) {
                            outilsSelected.setVie(outilsSelected.getVie() - 0.5);
                            col.get(positionCreuse)
                                    .setVie(col.get(positionCreuse).getVie() - outilsSelected.getCoef() * 1.5);
                        } else
                            col.get(positionCreuse)
                                    .setVie(col.get(positionCreuse).getVie() - outilsSelected.getCoef() * 0.7);
                    }
                    /* Mauvais outils pour mauvaise ressource */
                    else if (!(outilsSelected.getType() instanceof MainOutils))
                        outilsSelected.setVie(outilsSelected.getVie() - 1.5);
                    col.get(positionCreuse).setVie(col.get(positionCreuse).getVie() - outilsSelected.getCoef() * 1);

                    /* Retirer l'outil si vie =0 */
                    if (outilsSelected.getVie() <= 0) {
                        Jeux.getOutils().remove(outilsSelected);
                        ToolInstance main = (ToolInstance) Jeux.getOutils().getComponent(1);
                        main.setSelect(true);
                        Jeux.changeCursorTo();
                    }

                    /* Retire la ressource si vie=0 */
                    if (col.get(positionCreuse).getVie() <= 0) {
                        Jeux.getInv().ajoutinventaire(col.get(positionCreuse).getType(), 1);
                        col.remove(positionCreuse);
                        this.setIcon(col.get(positionCreuse - 1).getType().getImage());
                        this.setToolTipText("Niveau: " + (col.size() - taille) + "\n" + " Element : "
                                + this.col.get(col.size() - 1).getType().getNom());
                    }

                    /* il faut break quand on a trouvé l'outil selectionné */
                    break;

                }
                Jeux.getOutils().revalidate();
                Jeux.getOutils().repaint();
            }
        }
    }
}
