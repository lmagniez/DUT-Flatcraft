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
import outils.MainOutils;
import outils.ToolInstance;
import run.MineUtils;

public abstract class ColonneDeRessources extends JButton implements ActionListener {
    public ArrayList<RessourceInstance> col = new ArrayList<RessourceInstance>();

    protected abstract void sol(int index);

    public ColonneDeRessources() {
        create();
        this.setIcon(col.get(col.size() - 1).getType().getImage());
        this.setBorder(BorderFactory.createEmptyBorder());
        this.addActionListener(this);
    }

    private void create() {
        float r;
        int i;
        for (i = 0; i < 25; i++) {
            r = (float) (Math.random() * 1);

            if (i > 15 && i < 25) {
                if (r < 0.03)
                    col.add(new RessourceInstance(MineUtils.tabRessources[3])); // iron
                else if (r < 0.09)
                    col.add(new RessourceInstance(MineUtils.tabRessources[7])); // coal
                else
                    col.add(new RessourceInstance(MineUtils.tabRessources[1])); // stone
            } else if (i > 0 && i <= 15) {
                if (r < 0.02)
                    col.add(new RessourceInstance(MineUtils.tabRessources[5])); // diamond
                else if (r < 0.1)
                    col.add(new RessourceInstance(MineUtils.tabRessources[3])); // iron
                else if (r < 0.17)
                    col.add(new RessourceInstance(MineUtils.tabRessources[7])); // coal
                else
                    col.add(new RessourceInstance(MineUtils.tabRessources[1])); // stone
            } else if (i == 0)
                col.add(new RessourceInstance(MineUtils.tabRessources[6])); // lava

        }
        sol(i);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        ColonneDeRessources button = (ColonneDeRessources) e.getSource();
        int positionCreuse = button.col.size() - 1;

        if ((e.getModifiers() & ActionEvent.CTRL_MASK) == ActionEvent.CTRL_MASK) {
            // DEPOSER
            Component[] components = Jeux.getInv().getComponents();
            for (int i = 0; i < components.length; i++) {
                // On recupere l'element i de l'inventaire
                RessourceContainer elt = (RessourceContainer) Jeux.getInv().getComponent(i);

                if (elt.isSelected())// est il selected? (1 seul possible)
                {
                    // selected, on l'ajoute sur la map
                    col.add(new RessourceInstance(elt.getRessource()));
                    setIcon(col.get(positionCreuse + 1).getType().getImage());
                    Jeux.getInv().afficher();

                    elt.setQuantity(elt.getQuantity() - 1);
                    if (elt.getQuantity() == 0)
                        Jeux.getInv().remove(i);
                    Jeux.getInv().revalidate();
                    Jeux.getInv().repaint();

                    return;

                }

            }
            Jeux.getInv().afficher();
        } else {
            // CREUSER
            for (int i = 1; i < Jeux.getOutils().getComponents().length; i++) {
                ToolInstance outilsSelected = (ToolInstance) Jeux.getOutils().getComponent(i);

                // lave
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
                // ----------------

                // Si l'outil est selectionné
                if (outilsSelected.isSelect()) {

                    col.get(positionCreuse).setVie(col.get(positionCreuse).getVie() - outilsSelected.getCoef() * 1);
                    if (!(outilsSelected.getType() instanceof MainOutils))
                        outilsSelected.setVie(outilsSelected.getVie() - 1);

                    // Retirer l'outil si vie =0
                    if (outilsSelected.getVie() == 0) {
                        Jeux.getOutils().remove(outilsSelected);
                        ToolInstance main = (ToolInstance) Jeux.getOutils().getComponent(1);
                        main.setSelect(true);
                        Jeux.changeCursorTo();
                    }

                    // Retire la ressource si vie=0
                    if (col.get(positionCreuse).getVie() <= 0) {
                        Jeux.getInv().ajoutinventaire(col.get(positionCreuse).getType(),1);
                        col.remove(positionCreuse);
                        this.setIcon(col.get(positionCreuse - 1).getType().getImage());

                    }

                    // il faut break quand on a trouvé l'outil selectionné
                    break;
                }

            }
            Jeux.getOutils().revalidate();
            Jeux.getOutils().repaint();

        }
    }

}
