package outils;

import bloc.RessourceInstance;
import run.MineUtils;

public class PiocheBois extends Tool {

    public PiocheBois() {
        super(MineUtils.PIOCHE_BOIS, 20, 1, false);
        this.pattern.add(MineUtils.tabRessources[12]);
        this.pattern.add(MineUtils.tabRessources[12]);
        this.pattern.add(MineUtils.tabRessources[12]);
        this.pattern.add(null);
        this.pattern.add(MineUtils.tabRessources[11]);
        this.pattern.add(null);
        this.pattern.add(null);
        this.pattern.add(MineUtils.tabRessources[11]);
        this.pattern.add(null);
    }

}
