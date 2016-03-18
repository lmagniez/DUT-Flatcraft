package Outils;

import Bloc.Ressource;
import Jeux.MineElement;
import Jeux.MineElementInstance;

public class ToolInstance implements MineElementInstance{

	private Tool outils;
	private int coef; // vie de la ressource
	private int vie;
	
	public ToolInstance(Tool t)
	{
		this.outils=t;
		this.coef=t.getCoef();
		this.vie=t.getVie();
	}
	
	@Override
	public MineElement getType() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public int getVie() {
		return vie;
	}

	public void setVie(int vie) {
		this.vie = vie;
	}

}
