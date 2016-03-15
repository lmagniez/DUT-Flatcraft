package Bloc;

import javax.swing.JButton;

public class RessourceContainer extends JButton{
	
	private int quantity;
	private Ressource ressource;
	
	public RessourceContainer(int quantity, Ressource r)
	{
		this.quantity=quantity;
		this.ressource=r;
		this.setIcon(r.image);
	}
	
}
