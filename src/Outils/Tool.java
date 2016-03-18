package Outils;

import javax.swing.ImageIcon;

import Bloc.RessourceInstance;
import Jeux.MineElement;
import Jeux.MineElementInstance;

public class Tool implements MineElement{
	ImageIcon image; //image de la ressource
	private final int valeurVie;
	private final double coef; //outils pour le detruire rapidement
	public int vie;
	public boolean select=false;
	
	public Tool(ImageIcon image, int valeurVie,double d,boolean s) {
		super();
		this.image = image;
		this.coef=d;
		this.valeurVie=valeurVie;
		this.select=s;
	}

	public double getCoef() {
		return coef;
	}
	
	public int getVie() {
		return valeurVie;
	}

	public void setVie(int vie) {
		this.vie = vie;
	}

	@Override
	public ToolInstance newInstance() {
		return new ToolInstance(this);
	}

	
	public boolean isSelect() {
		return select;
	}

	public void setSelect(boolean select) {
		this.select = select;
	}
}
