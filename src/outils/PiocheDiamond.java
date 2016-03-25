package outils;

import bloc.RessourceInstance;
import run.MineUtils;

public class PiocheDiamond extends Tool {

    public PiocheDiamond() {
        super(MineUtils.PIOCHE_DIAMOND, 35, 4, false);
        this.pattern.add(new RessourceInstance(MineUtils.tabRessources[5]));
        this.pattern.add(new RessourceInstance(MineUtils.tabRessources[5]));
        this.pattern.add(new RessourceInstance(MineUtils.tabRessources[5]));
        this.pattern.add(null);
        this.pattern.add(new RessourceInstance(MineUtils.tabRessources[11]));
        this.pattern.add(null);
        this.pattern.add(null);
        this.pattern.add(new RessourceInstance(MineUtils.tabRessources[11]));
        this.pattern.add(null);
    }

}
