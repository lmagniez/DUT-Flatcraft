package Jeux;

import java.awt.BorderLayout;

import javax.swing.JButton;
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
import Outils.Main;
import Outils.PiocheBois;
import Outils.PiochePierre;

public class Jeux {
	private Map map;
	private static Inventaire inv;
	private Outils outils;
	private Craft craft;
	private JFrame frame=new JFrame();
	
	public static final int NB_RESSOURCES=8;
	private static final int NB_OUTILS = 13;
	public static Ressource[] tabRessources=new Ressource[NB_RESSOURCES];
	public static Outils[ ] tabOutils= new Outils[NB_OUTILS];

	
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
	
	public void prepareOutils()
	{
		/* Charger les images pour les outils et ensuite modifier constructeur des outils 
		 
		tabRessources[0]=new Main();
		tabRessources[1]=new PiocheBois();
		tabRessources[2]=new PiochePierre();
		tabRessources[3]=new PiocheIron();
		tabRessources[4]=new PiocheDiamond();
	
		tabRessources[5]=new PelleBois();
		tabRessources[6]=new PellePierre();
		tabRessources[7]=new PelleIron();
		tabRessources[8]=new PelleDiamond();
		tabRessources[9]=new HacheBois();
		tabRessources[10]=new HachePierre();
		tabRessources[11]=new HacheIron();
		tabRessources[12]=new HacheDiamond();
		*/

		
		
	}
	
	private void prepare() {
		frame.add(BorderLayout.EAST, MineUtils.scrollPane(map.grid));
		frame.add(BorderLayout.SOUTH, MineUtils.scrollPane(inv));		
		frame.add(BorderLayout.WEST, MineUtils.scrollPane(outils));
		
		
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
		
		
		
	}

	public static Inventaire getInv() {
		return inv;
	}
	
}
