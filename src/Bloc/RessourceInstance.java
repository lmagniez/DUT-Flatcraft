package Bloc;

import Jeux.MineElement;
import Jeux.MineElementInstance;

public class RessourceInstance implements MineElementInstance{

	private Ressource ressource;
	private double vie; // vie de la ressource
	
	public RessourceInstance(Ressource r)
	{
		this.ressource=r;
		this.vie=r.getValeurVie();
	}

	@Override
	public Ressource getType() {
		return this.ressource;
	}

	public double getVie() {
		return vie;
	}

	public void setVie(double d) {
		this.vie = d;
	}
	
	
	
}
