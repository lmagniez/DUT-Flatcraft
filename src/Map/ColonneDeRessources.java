package Map;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;

import Bloc.RessourceContainer;
import Bloc.RessourceInstance;

public class ColonneDeRessources  extends JButton implements ActionListener{
	public ArrayList<RessourceInstance> col=new ArrayList<RessourceInstance>();
	
	public ColonneDeRessources(){
		create();
		this.setIcon(col.get(0).getType().getImage());
		this.setBorder(BorderFactory.createEmptyBorder());
		this.addActionListener(this);
	}

	private void create() {
		float r;
		for(int i=0;i<30;i++){
			r= (float) (Math.random() * 1);
			if(i==4)
				col.add(new RessourceInstance(Jeux.Jeux.tabRessources[0])); //grass -> sol
			
			else if(i<4){
				if(r<0.1)
					col.add(new RessourceInstance(Jeux.Jeux.tabRessources[2])); //wood
				else 
					continue;
			}
			else if(i>4 && i<15){
				if(r<0.03)
					col.add(new RessourceInstance(Jeux.Jeux.tabRessources[3]) ); //iron
				else if(r<0.09)
					col.add(new RessourceInstance(Jeux.Jeux.tabRessources[7])); //coal
				else
					col.add(new RessourceInstance(Jeux.Jeux.tabRessources[1]) ); //stone
			}
			else if(i>15 && i<=28){
				if(r<0.005)
					col.add(new RessourceInstance(Jeux.Jeux.tabRessources[5]) ); //diamond
				else if (r< 0.09)
					col.add(new RessourceInstance(Jeux.Jeux.tabRessources[3])); //iron
				else if (r< 0.15)
					col.add(new RessourceInstance(Jeux.Jeux.tabRessources[7])); //coal
				else 
					col.add(new RessourceInstance(Jeux.Jeux.tabRessources[1])); //stone
			}
			else if(i==29)
				col.add(new RessourceInstance(Jeux.Jeux.tabRessources[6]) ); //lava
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		ColonneDeRessources button=(ColonneDeRessources) e.getSource();
		button.col.get(0).setVie(button.col.get(0).getVie()-10);
		//lave a gerer!!!!
		if(button.col.get(0).getVie()<=0){
			Jeux.Jeux.getInv().add(new RessourceContainer(1,button.col.get(0).getType()));
			button.col.remove(0);
			button.setIcon(col.get(0).getType().getImage());
		}
		
	}
}
