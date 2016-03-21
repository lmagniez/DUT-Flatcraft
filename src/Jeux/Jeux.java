package Jeux;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
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

import Outils.HacheBois;
import Outils.HacheDiamond;
import Outils.HacheIron;
import Outils.HachePierre;
import Outils.MainOutils;
import Outils.PelleBois;
import Outils.PelleDiamond;
import Outils.PelleIron;
import Outils.PellePierre;
import Outils.PiocheBois;
import Outils.PiocheDiamond;
import Outils.PiocheIron;
import Outils.PiochePierre;
import Outils.Tool;
import Outils.ToolInstance;

public class Jeux {
	private static Map map;
	private static Inventaire inv;
	private static Outils outils;
	//private Craft craft;
	private TableCraft craft;
	private JFrame frame=new JFrame();
	
	
	public static final int NB_RESSOURCES=8;
	private static final int NB_OUTILS = 13;
	public static Ressource[] tabRessources=new Ressource[NB_RESSOURCES];
	public static Tool[ ] tabOutils= new Tool[NB_OUTILS];

	
	public Jeux() {
		super();
		prepareRessource();
		prepareOutils();
		this.map = new Map();
		this.inv = new Inventaire();
		this.outils = new Outils();
		this.craft = new TableCraft(frame, "Table de craft", false);
		
		JButton button = new JButton("Crafting");

	    button.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent actionevent)
	        {
	            craft.setVisible(true);
	        }
	    });
		outils.add(button);
		outils.Initialize();
		
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
		tabOutils[0]=new MainOutils();
		tabOutils[1]=new PiocheBois();
		tabOutils[2]=new PiochePierre();
		tabOutils[3]=new PiocheIron();
		tabOutils[4]=new PiocheDiamond();
		tabOutils[5]=new PelleBois();
		tabOutils[6]=new PellePierre();
		tabOutils[7]=new PelleIron();
		tabOutils[8]=new PelleDiamond();
		tabOutils[9]=new HacheBois();
		tabOutils[10]=new HachePierre();
		tabOutils[11]=new HacheIron();
		tabOutils[12]=new HacheDiamond();
		
	}
	
	private void prepare() {
		frame.add(BorderLayout.WEST, MineUtils.scrollPane(outils));
		frame.add(BorderLayout.EAST, MineUtils.scrollPane(map.grid));
		frame.add(BorderLayout.SOUTH, MineUtils.scrollPane(inv));
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

	public static Inventaire getInv() {
		return inv;
	}


	public static Outils getOutils() {
		return outils;
	}
	
	public static void changeCursorTo() {
		Component[] components = Jeux.getOutils().getComponents();

		for(int i=1;i<components.length;i++){ //commence a 1 car le premier element est le bouton pour la table 
			ToolInstance tmp=(ToolInstance) Jeux.getOutils().getComponent(i);
			if(tmp.isSelect())
				map.grid.setCursor( Toolkit.getDefaultToolkit().createCustomCursor(tmp.getOutils().image.getImage(), new Point(40, 40), "")); 
		}   
	}
}
