package Map;

import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;

import Bloc.RessourceInstance;

public class ColonneDeRessources  extends JButton{
	public ArrayList<RessourceInstance> col=new ArrayList<RessourceInstance>();
	
	public ColonneDeRessources(){
		create();
		this.setIcon(col.get(0).getType().getImage());
		this.setBorder(BorderFactory.createEmptyBorder());
	}

	private void create() {
		float r;
		for(int i=0;i<15;i++){
			r= (float) (Math.random() * 1);
			if(i==4)
				col.add(new RessourceInstance(Jeux.Jeux.tabRessources[0])); //grass
			else if(i<4){
				if(r<0.1)
					col.add(new RessourceInstance(Jeux.Jeux.tabRessources[2])); //wood
				else 
					continue;
			}
			else if(i>4 && r<8){
				if(r<0.03)
					col.add(new RessourceInstance(Jeux.Jeux.tabRessources[3]) ); //iron
				else if(r<0.09)
					col.add(new RessourceInstance(Jeux.Jeux.tabRessources[7])); //coal
				else
					col.add(new RessourceInstance(Jeux.Jeux.tabRessources[1]) ); //stone
			}
			else if(i>8 && r<=13){
				if(r<0.005)
					col.add(new RessourceInstance(Jeux.Jeux.tabRessources[5]) ); //diamond
				else if (r< 0.09)
					col.add(new RessourceInstance(Jeux.Jeux.tabRessources[3])); //iron
				else if (r< 0.15)
					col.add(new RessourceInstance(Jeux.Jeux.tabRessources[7])); //coal
				else 
					col.add(new RessourceInstance(Jeux.Jeux.tabRessources[1])); //stone
			}
			else 
				col.add(new RessourceInstance(Jeux.Jeux.tabRessources[6]) ); //lava
		}
	}
}
