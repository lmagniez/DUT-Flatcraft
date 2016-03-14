package Bloc;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

import Jeux.MineElement;
import Jeux.MineElementInstance;

public class Ressource  implements MineElement{
	ImageIcon image; //image de la ressource
	private final int valeurVie;
	String propriete; //outils pour le detruire rapidement
	
	public Ressource(ImageIcon image, int valeurVie,String p) {
		super();
		this.image = image;
		this.propriete=p;
		this.valeurVie=valeurVie;
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
	
	
	
}
