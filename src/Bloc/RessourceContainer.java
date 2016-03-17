package Bloc;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;

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
	
	 protected void paintComponent(Graphics g) {
	        int qty = this.quantity;
	        if (qty > 0) {
	            super.paintComponent(g);
	            Rectangle rect = g.getClipBounds();
	            g.setColor(Color.YELLOW);
	            g.fillOval(rect.x + rect.width - 30, rect.y + rect.height - 30, 30, 30);
	            g.setColor(Color.BLACK);
	            g.setFont(g.getFont().deriveFont(Font.BOLD, g.getFont().getSize()));
	            if (qty < 10) {
	                g.drawString(String.valueOf(qty), rect.x + rect.width - 17, rect.y + rect.height - 10);
	            } else {
	                g.drawString(String.valueOf(qty), rect.x + rect.width - 21, rect.y + rect.height - 10);
	            }
	        }
	    }
}
