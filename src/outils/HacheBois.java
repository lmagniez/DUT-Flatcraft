package outils;

import bloc.RessourceInstance;
import jeux.Jeux;
import run.MineUtils;

public class HacheBois extends Tool {

    public HacheBois() {
        super(MineUtils.HACHE_BOIS, 20, 1, false);
        this.pattern.add(null);
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