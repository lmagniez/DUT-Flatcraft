package Outils;

import javax.swing.BorderFactory;
import javax.swing.JToggleButton;

import Jeux.MineElement;
import Jeux.MineElementInstance;

public class ToolInstance  extends JToggleButton implements MineElementInstance{

	private Tool outils;
	private double coef; // vie de la ressource
	private int vie;
	
	
	public ToolInstance(Tool t)
	{
		this.outils=t;
		this.coef=t.getCoef();
		this.vie=t.getVie();
		this.setIcon(t.image);
		this.setBorder(BorderFactory.createEmptyBorder());
	}
	
	@Override
	public MineElement getType() {
		return outils;
	}
	
	public int getVie() {
		return vie;
	}

	public void setVie(int vie) {
		this.vie = vie;
	}


}
