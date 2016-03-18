package Outils;

import javax.swing.ImageIcon;

public class Tool {
	ImageIcon image; //image de la ressource
	private final int valeurVie;
	private final int coef; //outils pour le detruire rapidement
	public int vie;
	
	public Tool(ImageIcon image, int valeurVie,int p) {
		super();
		this.image = image;
		this.coef=p;
		this.valeurVie=valeurVie;
	}

	public int getCoef() {
		return coef;
	}
	
	public int getVie() {
		return vie;
	}

	public void setVie(int vie) {
		this.vie = vie;
	}


}
