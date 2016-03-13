package Main;

import Jeux.Jeux;
import Map.ColonneDeRessources;

public class Main {

	public static void main(String[] args) {
		ColonneDeRessources jeux=new ColonneDeRessources();	
		for(int i=0;i<jeux.col.size();i++)
			System.out.println(jeux.col.get(i));
	}
}