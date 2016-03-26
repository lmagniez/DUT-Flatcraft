package bloc;

import java.io.Serializable;
import java.util.ArrayList;

import javax.swing.ImageIcon;

import jeux.MineElement;

public class Ressource implements MineElement, Serializable{
    ImageIcon image;
    private String nom;
    private final int valeurVie;
    private String propriete;
    protected ArrayList<RessourceInstance> pattern=new ArrayList<>();
    public static int ID=0;
    private int id;

    public Ressource(String nom, ImageIcon image, int valeurVie, String p) {
        super();
        
        this.nom=nom;
        this.image = image;
        this.propriete = p;
        this.valeurVie = valeurVie;
    }

    

    @Override
	public String toString() {
		return "Ressource [image=" + image + ", id=" + id + ", valeurVie="
				+ valeurVie + ", propriete=" + propriete + ", pattern="
				+ pattern + "]";
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



	public String getId() {
		return this.nom;
	}
}
