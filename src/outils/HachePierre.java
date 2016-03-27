package outils;

import bloc.RessourceInstance;
import run.MineUtils;

public class HachePierre extends Tool {

    public HachePierre() {
        super(MineUtils.HACHE_PIERRE, 25, 2, false);
        this.pattern.add(null);
        this.pattern.add(MineUtils.tabRessources[1]);
        this.pattern.add(MineUtils.tabRessources[1]);
        this.pattern.add(null);
        this.pattern.add(MineUtils.tabRessources[11]);
        this.pattern.add(null);
        this.pattern.add(null);
        this.pattern.add(MineUtils.tabRessources[11]);
        this.pattern.add(null);
    }

}
