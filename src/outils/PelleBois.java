package outils;

import bloc.RessourceInstance;
import run.MineUtils;

public class PelleBois extends Tool {

    public PelleBois() {
        super(MineUtils.PELLE_BOIS, 20, 1, false);
        this.pattern.add(null);
        this.pattern.add(new RessourceInstance(MineUtils.tabRessources[12]));
        this.pattern.add(null);
        this.pattern.add(null);
        this.pattern.add(new RessourceInstance(MineUtils.tabRessources[11]));
        this.pattern.add(null);
        this.pattern.add(null);
        this.pattern.add(new RessourceInstance(MineUtils.tabRessources[11]));
        this.pattern.add(null);
    }

}
