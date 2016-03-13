package Jeux;

import java.awt.BorderLayout;

import javax.swing.JFrame;

import Map.Map;

public class Jeux {
	Map map;
	Inventaire inv;
	Outils outils;
	Craft craft;
	JFrame frame=new JFrame();
	
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
		frame.add(BorderLayout.EAST, map.grid);
		
		/*		
		frame.add(BorderLayout.WEST, outils);
		frame.add(BorderLayout.SOUTH, inv);
		*/
		
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}	
}
