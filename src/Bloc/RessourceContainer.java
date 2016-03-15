package Bloc;

import javax.swing.BorderFactory;
import javax.swing.JButton;

public class RessourceContainer extends JButton{
	
	private int quantity;
	private Ressource ressource;
	
	public RessourceContainer(int quantity, Ressource r)
	{
		this.quantity=quantity;
		this.ressource=r;
		this.setIcon(r.image);
		this.setBorder(BorderFactory.createEmptyBorder());
	}

	public Ressource getRessource() {
		return ressource;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
}
