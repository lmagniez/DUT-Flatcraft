package map;

import bloc.RessourceInstance;
import jeux.Jeux;

public class ColonneDeRessourcesNormal extends ColonneDeRessources{
    
    private void sol(int i) {
        float r;
        for(int a=i;a<i+5;a++){
            r = (float) (Math.random() * 1);
        if (a >= i+1) {
            if (r < 0.1)
                col.add(new RessourceInstance(Jeux.tabRessources[2])); // wood
            else
                continue;
        } else if (a == 25)
            col.add(new RessourceInstance(Jeux.tabRessources[0])); // grass
                                                                   // -> sol
        }
     }
    
}
