package outils;

import bloc.RessourceInstance;
import run.MineUtils;

public class HacheIron extends Tool {

    public HacheIron() {
        super(MineUtils.HACHE_FER, 30, 3, false);
        this.pattern.add(null);
        this.pattern.add(MineUtils.tabRessources[3]);
        this.pattern.add(MineUtils.tabRessources[3]);
        this.pattern.add(null);
        this.pattern.add(MineUtils.tabRessources[11]);
        this.pattern.add(null);
        this.pattern.add(null);
        this.pattern.add(MineUtils.tabRessources[11]);
        this.pattern.add(null);
    }

}
