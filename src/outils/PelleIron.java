package outils;

import bloc.RessourceInstance;
import run.MineUtils;

public class PelleIron extends Tool {

    public PelleIron() {
        super(MineUtils.PELLE_FER, 30, 3, false);
        this.pattern.add(null);
        this.pattern.add(MineUtils.tabRessources[3]);
        this.pattern.add(null);
        this.pattern.add(null);
        this.pattern.add(MineUtils.tabRessources[11]);
        this.pattern.add(null);
        this.pattern.add(null);
        this.pattern.add(MineUtils.tabRessources[11]);
        this.pattern.add(null);
    }

}
