package Bloc;

import Jeux.MineElement;
import Jeux.MineElementInstance;

public class RessourceInstance implements MineElementInstance{

	private Ressource ressource;
	private int vie; // vie de la ressource
	
	public RessourceInstance(Ressource r)
	{
		this.ressource=r;
		this.vie=r.getValeurVie();
	}

	@Override
	public Ressource getType() {
		return this.ressource;
	}

	public int getVie() {
		return vie;
	}

	public void setVie(int vie) {
		this.vie = vie;
	}
	
	
	
}
