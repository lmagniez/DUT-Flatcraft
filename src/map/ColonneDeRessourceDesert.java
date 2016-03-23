package map;

import bloc.RessourceInstance;
import jeux.Jeux;

public class ColonneDeRessourceDesert extends ColonneDeRessources {

    @Override
    protected void sol(int index) {
        float r;
        for (int i = index; i < index + 5; i++) {
            r = (float) (Math.random() * 1);
            if (i >= index + 1) {
                if (r < 0.1)
                    col.add(new RessourceInstance(Jeux.tabRessources[9]));
                else
                    continue;
            } else if (i == 25)
                col.add(new RessourceInstance(Jeux.tabRessources[8]));
        }
    }

}
