package outils;

import bloc.RessourceInstance;
import jeux.Jeux;
import run.MineUtils;

public class PiocheBois extends Tool {

    public PiocheBois() {
        super(MineUtils.PIOCHE_BOIS, 20, 1, false);
        this.pattern.add(new RessourceInstance(Jeux.tabRessources[12]));
        this.pattern.add(new RessourceInstance(Jeux.tabRessources[12]));
        this.pattern.add(new RessourceInstance(Jeux.tabRessources[12]));
        this.pattern.add(null);
        this.pattern.add(new RessourceInstance(Jeux.tabRessources[11]));
        this.pattern.add(null);
        this.pattern.add(null);
        this.pattern.add(new RessourceInstance(Jeux.tabRessources[11]));
        this.pattern.add(null);
    }

}
