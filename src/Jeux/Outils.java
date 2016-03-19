package Jeux;

import java.awt.Dimension;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JPanel;

import Main.MineUtils;
import Outils.MainOutils;
import Outils.ToolInstance;

public class Outils extends JPanel{

	private JPanel Pioches=new JPanel();
	private JPanel Epees=new JPanel();
	private JPanel Pelles=new JPanel();
	
	public Outils(){
		
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.setSize(new Dimension(100,50));
		//this.add(new JButton("Table de craft"));
	
		
		
		
		test();
		this.add(MineUtils.scrollPane(Pioches));
		this.add(MineUtils.scrollPane(Epees));		
		this.add(MineUtils.scrollPane(Pelles));
		
	}

	private void test() {
		this.add(new ToolInstance(Jeux.tabOutils[0]));
		Pioches.add(new ToolInstance(Jeux.tabOutils[1]));		
	}

}
