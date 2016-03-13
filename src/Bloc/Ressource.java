package Bloc;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Ressource{
	ImageIcon image; //image de la ressource
	int vie; // vie de la ressource
	String propriete; //outils pour le detruire rapidement
	
	public Ressource(ImageIcon image, int vie,String p) {
		super();
		this.image = image;
		this.vie = vie;
		this.propriete=p;
	}

	@Override
	public String toString() {
		return "Ressource [image=" + image + ", vie=" + vie + ", propriete=" + propriete + "]";
	}

	public ImageIcon getImage() {
		return image;
	}

	public void setImage(ImageIcon image) {
		this.image = image;
	}

	public int getVie() {
		return vie;
	}

	public void setVie(int vie) {
		this.vie = vie;
	}

	public String getPropriete() {
		return propriete;
	}

	public void setPropriete(String propriete) {
		this.propriete = propriete;
	}	
	
	
	
}
