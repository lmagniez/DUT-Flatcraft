package Map;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JToggleButton;

import Bloc.Ressource;
import Bloc.RessourceContainer;
import Bloc.RessourceInstance;
import Jeux.Jeux;

public class ColonneDeRessources  extends JButton implements ActionListener{
	public ArrayList<RessourceInstance> col=new ArrayList<RessourceInstance>();
	
	public ColonneDeRessources(){
		create();
		this.setIcon(col.get(col.size()-1).getType().getImage());
		this.setBorder(BorderFactory.createEmptyBorder());
		this.addActionListener(this);
	}

	private void create() {
		float r;
		for(int i=0;i<30;i++){
			r= (float) (Math.random() * 1);
			
			if(i==26){
				if(r<0.1)
					col.add(new RessourceInstance(Jeux.tabRessources[2])); //wood
				else 
					continue;
			}
			else if(i==25)
				col.add(new RessourceInstance(Jeux.tabRessources[0])); //grass -> sol
			
			else if(i>15 && i<25){
				if(r<0.03)
					col.add(new RessourceInstance(Jeux.tabRessources[3]) ); //iron
				else if(r<0.09)
					col.add(new RessourceInstance(Jeux.tabRessources[7])); //coal
				else
					col.add(new RessourceInstance(Jeux.tabRessources[1]) ); //stone
			}
			else if(i>0 && i<=15){
				if(r<0.005)
					col.add(new RessourceInstance(Jeux.tabRessources[5]) ); //diamond
				else if (r< 0.09)
					col.add(new RessourceInstance(Jeux.tabRessources[3])); //iron
				else if (r< 0.15)
					col.add(new RessourceInstance(Jeux.tabRessources[7])); //coal
				else 
					col.add(new RessourceInstance(Jeux.tabRessources[1])); //stone
			}
			else if(i==0)
				col.add(new RessourceInstance(Jeux.tabRessources[6]) ); //lava
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		System.out.println("ACTION PERFORMED");
		
		ColonneDeRessources button=(ColonneDeRessources) e.getSource();
		int positionCreuse=button.col.size()-1;
		
		if ((e.getModifiers() & ActionEvent.CTRL_MASK) == ActionEvent.CTRL_MASK) {
	        //DEPOSER 
			Component[] components = Jeux.getInv().getComponents();
			for(int i=0; i<components.length; i++){
				//On recupere l'element i de l'inventaire
				RessourceContainer elt= (RessourceContainer) Jeux.getInv().getComponent(i);
				
				if(elt.isSelected())//est il selected? (1 seul possible)
				{
					//selected, on l'ajoute sur la map
					col.add(new RessourceInstance(elt.getRessource()));
					setIcon(col.get(positionCreuse+1).getType().getImage());
					Jeux.getInv().afficher();
					System.out.println(col.size());
					return;
				}
					
			}
			Jeux.getInv().afficher();
		} else {
			//CREUSER
			
			col.get(positionCreuse).setVie(col.get(positionCreuse).getVie()-10);
			//lave a gerer!!!!
			if(col.get(positionCreuse).getVie()<=0){
				ajoutinventaire(col.get(positionCreuse).getType());
				col.remove(positionCreuse);
				this.setIcon(col.get(positionCreuse-1).getType().getImage());
			}
	    }
	    
		
		
		
	}

	private void ajoutinventaire(Ressource r) {
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
		Jeux.getInv().ajout(c);
		Jeux.getInv().revalidate();
		Jeux.getInv().repaint();
		Jeux.getInv().setSize(500, 60);;
		
		
		
		Jeux.getInv().setVisible(true);
		
	}
}
