package Bloc;

import javax.swing.ImageIcon;

public class Ressource {
	ImageIcon image; //image de la ressource
	int vie; // vie de la ressource
	String propriete; //outils pour le detruire rapidement
	
	public Ressource(ImageIcon image, int vie,String p) {
		super();
		this.image = image;
		this.vie = vie;
		this.propriete=p;
	}	
}
