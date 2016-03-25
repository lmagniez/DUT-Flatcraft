package jeux;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BoxLayout;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JToggleButton;

import bloc.Ressource;
import bloc.RessourceContainer;

public class Inventaire extends JPanel {
    public Inventaire() {

        this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        this.setPreferredSize(new Dimension(80, 80));
    }

    MouseListener mouselistener = new MouseAdapter() {
        public void mousePressed(MouseEvent me) {
            System.out.println("MOUSE LISTENER ! ");
            System.out.println(me.getSource());

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

    public void ajoutinventaire(Ressource r) {
        Component[] components = Jeux.getInv().getComponents();
        for (int i = 0; i < components.length; i++) {
            RessourceContainer elt = (RessourceContainer) this.getComponent(i);
            if (elt.getIcon() == r.getImage() && elt.getQuantity() < 64) {
                elt.setQuantity(elt.getQuantity() + 1);
                this.revalidate();
                this.repaint();
                return;
            }
        }
        RessourceContainer c = new RessourceContainer(1, r);
        c.addMouseListener(Jeux.mouselistener);
        c.setTransferHandler(c.createTransfertFrom());

        this.ajout(c);
        this.revalidate();
        this.repaint();
        this.setSize(500, 60);
        this.setVisible(true);

    }

    public void supprimerInventaire(RessourceContainer r) {
        System.out.println("SUPPRIMER INVENTAIRE");
        Component[] components = Jeux.getInv().getComponents();
        for (int i = 0; i < components.length; i++) {
            JToggleButton elt = (JToggleButton) Jeux.getInv().getComponent(i);
            if (elt.getIcon() == r.getIcon())// trouvé, on supprime
            {
                System.out.println("TROUVE !!");
                elt.remove(i);
                this.revalidate();
                this.repaint();
                return;
            }
        }

    }

}
