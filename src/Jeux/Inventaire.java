package Jeux;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.EventListener;
import java.util.LinkedList;

import javax.swing.AbstractButton;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.TransferHandler;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import Bloc.RessourceContainer;
import Main.MineUtils;
import Map.ColonneDeRessources;

public class Inventaire extends JPanel {
	
	//private JPanel inventaire= new JPanel();
	
	private int idSelect;
	
	public Inventaire()
	{
		//inventaire=new JPanel();
		this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		this.setSize(new Dimension(100,50));
		this.idSelect=-1;
		
		/*
		JLabel b = new JLabel();
		b.setIcon(MineUtils.BRICOLAGE);
		this.add(b);
		*/
		
		
		
		
	}
	
    MouseListener mouselistener = new MouseAdapter() {
    	boolean craft=false;
        public void mousePressed(MouseEvent me) {
            System.out.println("MOUSE LISTENER ! ");
        	
            //A UTILISER AUSSI POUR LE GLISSER DEPOSER? 
            
        	setAllNotSelected();
        	
        	
        }
    };
    
    public void ajout(JComponent c){
    	
    	c.addMouseListener(mouselistener);
    	this.add(c);
    }

	public void setAllNotSelected() 
	{
		Component[] components = this.getComponents();
    	for(int i=0; i<components.length; i++){
    		((RessourceContainer) this.getComponent(i)).setSelected(false);
    	}
	}

	public void afficher() 
	{
		Component[] components = this.getComponents();
    	for(int i=0; i<components.length; i++){
    		System.out.println(((RessourceContainer) this.getComponent(i)).isSelect()
    				);
    	}
	}

	
	/*
	public JPanel getinv() {
		return inventaire;
	}*/
	
	
	
	
}
