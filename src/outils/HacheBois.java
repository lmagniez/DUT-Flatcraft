package outils;

import bloc.Ressource;
import bloc.RessourceInstance;
import run.MineUtils;

public class HacheBois extends Tool {

    public HacheBois() {
        super(MineUtils.HACHE_BOIS, 20, 1, false);
        this.pattern.add(null);
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