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

	
	public Outils(){
		test();
	}

	private void test() {
		this.add(new ToolInstance(Jeux.tabOutils[0]));
	}

}
