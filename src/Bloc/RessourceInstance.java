package Bloc;

import Jeux.MineElement;
import Jeux.MineElementInstance;

public class RessourceInstance implements MineElementInstance{

	
	private Ressource ressource;
	
	public RessourceInstance(Ressource r)
	{
		this.ressource=r;
	}

	@Override
	public MineElement getType() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
