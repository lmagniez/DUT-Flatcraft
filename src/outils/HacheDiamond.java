package outils;

import bloc.RessourceInstance;
import run.MineUtils;

public class HacheDiamond extends Tool {

    public HacheDiamond() {
        super(MineUtils.HACHE_DIAMOND, 35, 4, false);
        this.pattern.add(null);
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
