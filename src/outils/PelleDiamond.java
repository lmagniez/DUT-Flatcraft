package outils;

import bloc.RessourceInstance;
import run.MineUtils;

public class PelleDiamond extends Tool {

    public PelleDiamond() {
        super(MineUtils.PELLE_DIAMOND, 35, 4, false);
        this.pattern.add(null);
        this.pattern.add(MineUtils.tabRessources[5]);
        this.pattern.add(null);
        this.pattern.add(null);
        this.pattern.add(MineUtils.tabRessources[11]);
        this.pattern.add(null);
        this.pattern.add(null);
        this.pattern.add(MineUtils.tabRessources[11]);
        this.pattern.add(null);
    }

}
