package Jeux;

import java.awt.BorderLayout;

import javax.swing.JFrame;

public class Jeux {
	Map map;
	Inventaire inv;
	Outils outils;
	Craft craft;
	JFrame frame;
	public Jeux() {
		super();
		this.map = new Map();
		this.inv = new Inventaire();
		this.outils = new Outils();
		this.craft = new Craft();
		this.frame= new JFrame("Jeux");
		prepare();
	}
	private void prepare() {
		//frame.add(BorderLayout.WEST, outils.lit);
		//frame.add(BorderLayout.SOUTH, inv.lit);
		//frame.add(BorderLayout.EAST, map.list);
	}
	
	
}
