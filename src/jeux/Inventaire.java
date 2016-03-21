package jeux;

import java.awt.BorderLayout;
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
import javax.swing.JToggleButton;
import javax.swing.TransferHandler;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import bloc.Ressource;
import bloc.RessourceContainer;
import run.MineUtils;
import map.ColonneDeRessources;

public class Inventaire extends JPanel {
	
	//private JPanel inventaire= new JPanel();
	
	private int idSelect;
	
	public Inventaire()
	{
		//inventaire=new JPanel();
		this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		this.setSize(new Dimension(80, 75)); 
		this.idSelect=-1;
		this.add(new RessourceContainer(1,Jeux.tabRessources[0]));
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
        	System.out.println(me.getSource());
            
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
    		System.out.println(((RessourceContainer) this.getComponent(i)).isSelected()
    				);
    	}
	}

	
	/*
	public JPanel getinv() {
		return inventaire;
	}*/
	public void ajoutinventaire(Ressource r) {
		Component[] components = Jeux.getInv().getComponents();
		for(int i=0; i<components.length; i++){
			JToggleButton elt= (JToggleButton) Jeux.getInv().getComponent(i);
			if(elt.getIcon()==r.getImage())
			{
				((RessourceContainer) elt).setQuantity(((RessourceContainer) elt).getQuantity()+1);
				Jeux.getInv().revalidate();
				Jeux.getInv().repaint();
				return;
			}
		}
		
		RessourceContainer c=new RessourceContainer(1,r);
		//PROBLEME : ON NE PEUT PLUS SELECTIONNER LE JTOGGLE QUAND ON FAIT LE DRAG AND DROP!!
		//c.addMouseListener(Jeux.mouselistener);
		c.addMouseListener(Jeux.mouselistener);
		c.setTransferHandler(c.createTransfertFrom());
		
		
		Jeux.getInv().ajout(c);
		Jeux.getInv().revalidate();
		Jeux.getInv().repaint();
		Jeux.getInv().setSize(500, 60);;
		
		
		
		Jeux.getInv().setVisible(true);
		
	}
	
	
	
}

