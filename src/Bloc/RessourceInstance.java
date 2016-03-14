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
	public MineElement getType() {
		return this.ressource;
	}
	
}
