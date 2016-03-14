package Jeux;

import java.awt.BorderLayout;

import javax.swing.JFrame;

import Bloc.Coal;
import Bloc.Diamond;
import Bloc.Grass;
import Bloc.Iron;
import Bloc.Lava;
import Bloc.Obsidian;
import Bloc.Ressource;
import Bloc.Stone;
import Bloc.Wood;
import Main.MineUtils;
import Map.Map;

public class Jeux {
	private Map map;
	private static Inventaire inv;
	private Outils outils;
	private Craft craft;
	private JFrame frame=new JFrame();
	
	public static final int NB_RESSOURCES=8;
	public static Ressource[] tabRessources=new Ressource[NB_RESSOURCES];

	
	public Jeux() {
		super();
		prepareRessource();
		this.map = new Map();
		this.inv = new Inventaire();
		this.outils = new Outils();
		this.craft = new Craft();
		this.frame= new JFrame("Jeux");
		prepare();
		
	}
	
	
	public void prepareRessource()
	{
		tabRessources[0]=new Grass();
		tabRessources[1]=new Stone();
		tabRessources[2]=new Wood();
		tabRessources[3]=new Iron();
		tabRessources[4]=new Obsidian();
		tabRessources[5]=new Diamond();
		tabRessources[6]=new Lava();
		tabRessources[7]=new Coal();
		
		
	}
	
	private void prepare() {
		frame.add(BorderLayout.EAST, MineUtils.scrollPane(map.grid));
		
		/*		
		frame.add(BorderLayout.WEST, outils);
		frame.add(BorderLayout.SOUTH, MineUtils.scrollPane(inv.inventaire));
		*/
		
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

	public static Inventaire getInv() {
		return inv;
	}
	
}
