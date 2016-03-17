package Jeux;

import java.awt.Dimension;
import java.util.ArrayList;
import java.util.LinkedList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Bloc.RessourceContainer;
import Main.MineUtils;

public class Inventaire extends JPanel{
	
	//private JPanel inventaire= new JPanel();
	
	
	public Inventaire()
	{
		//inventaire=new JPanel();
		this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		this.setSize(new Dimension(100,50));
		
		
		/*
		JLabel b = new JLabel();
		b.setIcon(MineUtils.BRICOLAGE);
		this.add(b);
		*/
		
		
		
		
	}
	

	/*
	public JPanel getinv() {
		return inventaire;
	}*/
	
	
	
	
}
