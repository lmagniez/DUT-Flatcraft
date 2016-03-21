package jeux;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BoxLayout;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JToggleButton;

import bloc.Ressource;
import bloc.RessourceContainer;

public class Inventaire extends JPanel {
	
	private int idSelect;
	
	public Inventaire()
	{
		this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		this.setSize(new Dimension(80, 75)); 
		this.idSelect=-1;
		this.add(new RessourceContainer(1,Jeux.tabRessources[0]));
	}
	
    MouseListener mouselistener = new MouseAdapter() {
        public void mousePressed(MouseEvent me) {
            System.out.println("MOUSE LISTENER ! ");
        	System.out.println(me.getSource());
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
		c.addMouseListener(c.mouselistener);
		c.setTransferHandler(c.createTransfertFrom());
		Jeux.getInv().ajout(c);
		Jeux.getInv().revalidate();
		Jeux.getInv().repaint();
		Jeux.getInv().setSize(500, 60);;
		
		
		
		Jeux.getInv().setVisible(true);
		
	}
	
	
	
}
