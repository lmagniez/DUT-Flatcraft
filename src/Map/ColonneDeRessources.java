package Map;

import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;

import Bloc.Diamond;
import Bloc.Grass;
import Bloc.Iron;
import Bloc.Lava;
import Bloc.Ressource;
import Bloc.RessourceInstance;
import Bloc.Stone;
import Bloc.Wood;

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
				col.add(new Grass());
			else if(i<4){
				if(r<0.1)
					col.add(new Wood());
				else 
					continue;
			}
			else if(i>4 && r<8){
				if(r<0.05)
					col.add(new Iron() );
				else
					col.add(new Stone() );
			}
			else if(i>8 && r<=13){
				if(r<0.005)
					col.add(new Diamond() );
				else 
					col.add(new Stone() );
			}
			else 
				col.add(new Lava() );
		}
	}
}
