package Outils;

import java.awt.Color;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.Graphics;

import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.JToggleButton;
import javax.swing.TransferHandler;

import Jeux.MineElement;
import Jeux.MineElementInstance;

public class ToolInstance extends JToggleButton implements MineElementInstance{

	private Tool outils;
	private double coef; // vie de la ressource
	private int vie;
	private boolean select;
	
	
	public ToolInstance(Tool t)
	{
		this.outils=t;
		this.coef=t.getCoef();
		this.vie=t.getVie();
		this.setIcon(t.image);
		this.setBorder(BorderFactory.createEmptyBorder());
		this.select=outils.isSelect();
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


	protected void paintComponent(Graphics g) {
        if (this.getVie() > 0) {
            super.paintComponent(g);
            Rectangle rect = g.getClipBounds();
            g.setColor(Color.GRAY);
            g.fillRect(rect.x+5, rect.y+70, 70, 3);
            g.setColor(Color.RED);
            g.fillRect(rect.x+5, rect.y+70, (int)(this.outils.getVie()*70.0)/this.vie, 3);
        }
        if (this.select) {
        	Rectangle rect = g.getClipBounds();
			g.setColor(Color.YELLOW);
			g.fillOval(rect.x + rect.width - 20, rect.y + rect.height - 20 , 20,
					20);
        }
    }
   
}
