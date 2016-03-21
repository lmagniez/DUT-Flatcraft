package bloc;

import java.awt.Dimension;

import javax.swing.JButton;

import jeux.Jeux;

public class RessourceReceiver extends JButton {

    private RessourceContainer ressource;

    public RessourceReceiver() {
        this.setSize(new Dimension(100, 100));
    }

    public void add(RessourceContainer r) {
        // receiver non vide
        if (ressource != null)
            Jeux.getInv().add(ressource);
        this.ressource = r;

    }

    public void retirer(int quantite) {
        // on supprime tout
        if (ressource.getQuantity() - quantite <= 0)
            ressource = null;
        else
            ressource.setQuantity(ressource.getQuantity() - quantite);
    }

}
