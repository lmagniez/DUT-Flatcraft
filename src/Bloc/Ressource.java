package Bloc;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

import Jeux.MineElement;
import Jeux.MineElementInstance;

public class Ressource  extends JButton implements MineElement{
	ImageIcon image; //image de la ressource
	int vie; // vie de la ressource
	String propriete; //outils pour le detruire rapidement
	
	public Ressource(ImageIcon image, int vie,String p) {
		super();
		this.image = image;
		this.vie = vie;
		this.propriete=p;
		this.setIcon(image);
		this.setBorder(BorderFactory.createEmptyBorder());
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

	@Override
	public RessourceInstance newInstance() {
		// TODO Auto-generated method stub
		return null;
	}	
	
	
	
}
