package bloc;

import java.io.Serializable;
import java.util.ArrayList;

import javax.swing.ImageIcon;

import jeux.MineElement;

/**
 * Ressource
 */
public abstract class Ressource implements MineElement, Serializable {
    protected ImageIcon image;
    private String nom;
    private final float valeurVie;
    private String propriete;
    protected ArrayList<Ressource> pattern = new ArrayList<>();
    protected int nbGenere = 1;
    private int id;
    protected boolean changement = false;

    /**
     * Constructeur ressource
     * @param nom (String) , image (ImageIcon), valeurvie (int) , p (String)
     */  
    public Ressource(String nom, ImageIcon image, int valeurVie, String p) {
        this.nom = nom;
        this.image = image;
        this.propriete = p;
        this.valeurVie = valeurVie;
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

    public float getValeurVie() {
        return valeurVie;
    }

    @Override
    public RessourceInstance newInstance() {
        return new RessourceInstance(this);
    }

    public ArrayList<Ressource> getPattern() {
        return pattern;
    }

    public String getId() {
        return this.nom;
    }

    public int getNbGenere() {
        return nbGenere;
    }

    public void setNbGenere(int nbGenere) {
        this.nbGenere = nbGenere;
    }

    public String getNom() {
        return nom;
    }
    
    

}
