package Map;

import java.util.ArrayList;

import Bloc.Diamond;
import Bloc.Grass;
import Bloc.Iron;
import Bloc.Lava;
import Bloc.Ressource;
import Bloc.Stone;
import Bloc.Wood;

public class ColonneDeRessources{
	public ArrayList<Ressource> col=new ArrayList<Ressource>();
	
	public ColonneDeRessources(){
		create();
	}

	private void create() {
		float r;
		for(int i=0;i<15;i++){
			r= (float) (Math.random() * 1);
			if(i==4)
				col.add(new Grass());
			else if(i<4){
				if(r<0.4)
					col.add(new Wood());
				else 
					continue;
			}
			else if(i>4 && r<8){
				if(r<0.4)
					col.add(new Iron() );
				else
					col.add(new Stone() );
			}
			else if(i>8 && r<=13){
				if(r<0.4)
					col.add(new Diamond() );
				else 
					col.add(new Stone() );
			}
			else 
				col.add(new Lava() );
		}
	}
}
