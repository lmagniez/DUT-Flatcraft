package map;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;

import bloc.Lava;
import bloc.RessourceContainer;
import bloc.RessourceInstance;
import jeux.Jeux;
import outils.MainOutils;
import outils.ToolInstance;

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
		System.out.println("ACTION PERFORMED!!");
		
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
					
					elt.setQuantity(elt.getQuantity()-1);
					if(elt.getQuantity()==0)
						Jeux.getInv().remove(i);
					Jeux.getInv().revalidate();
					Jeux.getInv().repaint();
					
					return;
					
				}
					
			}
			Jeux.getInv().afficher();
		} else {
			//CREUSER
			
			Component[] components = Jeux.getOutils().getComponents();
			for(int i=1;i<components.length;i++){ //commence a 1 car le premier element est le bouton pour la table 
				ToolInstance tmp=(ToolInstance) Jeux.getOutils().getComponent(i);
				if((tmp.getOutils() instanceof MainOutils)){ 
					col.get(positionCreuse).setVie(col.get(positionCreuse).getVie()-tmp.getCoef()*1);
				}
				else if(col.get(positionCreuse).getType() instanceof Lava && !(tmp.getOutils() instanceof MainOutils) ) {
					Jeux.getOutils().remove(tmp);
					ToolInstance main=(ToolInstance) Jeux.getOutils().getComponent(1);
					main.setSelect(true);
				}
				else if(tmp.isSelect()){ 
					col.get(positionCreuse).setVie(col.get(positionCreuse).getVie()-tmp.getCoef()*1);
					tmp.setVie(tmp.getVie()-1);
				}
				if(tmp.getVie()==0){ 
					Jeux.getOutils().remove(tmp);
					ToolInstance main=(ToolInstance) Jeux.getOutils().getComponent(1);
					main.setSelect(true);
				}
			}
			Jeux.getOutils().revalidate();
			Jeux.getOutils().repaint();
			
			
			if(col.get(positionCreuse).getVie()<=0){
				Jeux.getInv().ajoutinventaire(col.get(positionCreuse).getType());
				col.remove(positionCreuse);
				this.setIcon(col.get(positionCreuse-1).getType().getImage());
			}
	    }
	}

	
}
