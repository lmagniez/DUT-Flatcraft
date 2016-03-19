package Outils;

import java.awt.Color;
import java.awt.Rectangle;

import javax.swing.BorderFactory;
import javax.swing.JToggleButton;

import com.sun.prism.Graphics;

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

/*
	@Override
    protected void paintComponent(Graphics g) {
        if (this.getVie() > 0) {
            super.paintComponent(g);
            Rectangle rect = g.getClipBounds();
            g.setColor(Color.GRAY);
            g.fillRect(rect.x+5, rect.y+70, 70, 3);
            g.setColor(Color.YELLOW);
            g.fillRect(rect.x+5, rect.y+70, (int)(this.outils.getVie()*70.0)/this.outils.vie, 3);
        }
    }
*/

}
