package bloc;

import java.io.Serializable;
import java.util.ArrayList;

import javax.swing.ImageIcon;

import jeux.MineElement;

public class Ressource implements MineElement, Serializable{
    ImageIcon image;
    private final int valeurVie;
    private String propriete;
    protected ArrayList<RessourceInstance> pattern=new ArrayList<>();

    public Ressource(ImageIcon image, int valeurVie, String p) {
        super();
        this.image = image;
        this.propriete = p;
        this.valeurVie = valeurVie;
    }

    @Override
    public String toString() {
        return "Ressource [image=" + image + ",propriete=" + propriete + "]";
    }

    public ImageIcon getImage() {
        return image;
    }

    public void setImage(ImageIcon image) {
        this.image = image;
    }

    public String getPropriete() {
        return propriete;
    }

    public void setPropriete(String propriete) {
        this.propriete = propriete;
    }

    public int getValeurVie() {
        return valeurVie;
    }

    @Override
    public RessourceInstance newInstance() {
        return new RessourceInstance(this);
    }

    public ArrayList<RessourceInstance> getPattern() {
        return pattern;
    }
}
