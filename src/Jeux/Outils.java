package Jeux;

import java.awt.Component;
import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

public class Outils extends JPanel{

	public Outils(){
		
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.setSize(new Dimension(100,50));
		this.add(new JButton("Table de craft"));
	}

}
