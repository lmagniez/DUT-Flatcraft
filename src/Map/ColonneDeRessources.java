package Map;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;

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
			else if(i>4 && i<8){
				if(r<0.03)
					col.add(new RessourceInstance(Jeux.Jeux.tabRessources[3]) ); //iron
				else if(r<0.09)
					col.add(new RessourceInstance(Jeux.Jeux.tabRessources[7])); //coal
				else
					col.add(new RessourceInstance(Jeux.Jeux.tabRessources[1]) ); //stone
			}
			else if(i>8 && i<=13){
				if(r<0.005)
					col.add(new RessourceInstance(Jeux.Jeux.tabRessources[5]) ); //diamond
				else if (r< 0.09)
					col.add(new RessourceInstance(Jeux.Jeux.tabRessources[3])); //iron
				else if (r< 0.15)
					col.add(new RessourceInstance(Jeux.Jeux.tabRessources[7])); //coal
				else 
					col.add(new RessourceInstance(Jeux.Jeux.tabRessources[1])); //stone
			}
			else if(i==14)
				col.add(new RessourceInstance(Jeux.Jeux.tabRessources[6]) ); //lava
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		ColonneDeRessources button=(ColonneDeRessources) e.getSource();
		button.col.remove(0);
		button.setIcon(col.get(0).getType().getImage());
		
	}
}
