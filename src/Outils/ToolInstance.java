package Outils;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JToggleButton;

import Jeux.Jeux;
import Jeux.MineElement;
import Jeux.MineElementInstance;

public class ToolInstance extends JToggleButton implements MineElementInstance,ActionListener{

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
		this.addActionListener(this);
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

	@Override
	public void actionPerformed(ActionEvent e) {
		Component[] components = Jeux.getOutils().getComponents();
		
		for(int i=1;i<components.length;i++){
			ToolInstance tmp=(ToolInstance) Jeux.getOutils().getComponent(i);
			if(tmp.select)
				tmp.select=false;
		}
		
		ToolInstance button=(ToolInstance) e.getSource();
			if(button.select)
				button.select=false;
			else 
				button.select=true;

		Jeux.getOutils().revalidate();
		Jeux.getOutils().repaint();
		
	}
   
}
