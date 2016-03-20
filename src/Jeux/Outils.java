package Jeux;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JPanel;

import Bloc.RessourceContainer;
import Bloc.RessourceInstance;
import Main.MineUtils;
import Map.ColonneDeRessources;
import Outils.MainOutils;
import Outils.ToolInstance;

public class Outils extends JPanel{
	
	public Outils(){
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.setSize(new Dimension(80, 75)); 

	}
	
	void Initialize() {
		this.add(new ToolInstance(Jeux.tabOutils[0]));
		this.add(new ToolInstance(Jeux.tabOutils[1]));
		this.add(new ToolInstance(Jeux.tabOutils[2]));
	}
}
