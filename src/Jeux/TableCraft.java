package Jeux;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;

import Bloc.RessourceContainer;
import Bloc.RessourceReceiver;
import Main.MineUtils;
import Map.ColonneDeRessources;

public class TableCraft extends JDialog {

	   // les données mises à jour par la boîte de dialogue

	  Integer lEntier = new Integer(0);

	  String leNom;

	 

	  public TableCraft(JFrame parent, String titre, boolean modal) {

	       super(parent,titre, modal);
	       this.setSize(new Dimension(500, 400));
       	   this.setResizable(false);
	       prepare();

	  }

	  public void prepare()
	  {
		  JPanel p = new JPanel();
		  p.setLayout(new GridLayout(3, 3));
		  
		  RessourceReceiver result= new RessourceReceiver();
		  
		  for(int i=0;i<9;i++){
				
				p.add(new RessourceReceiver());
		  }
		  this.add(BorderLayout.CENTER, MineUtils.scrollPane(p));
		  this.add(BorderLayout.EAST, MineUtils.scrollPane(result));
		  
	  }

	 

}