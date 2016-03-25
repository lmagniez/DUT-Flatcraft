package outils;

import bloc.RessourceInstance;
import run.MineUtils;

public class PiochePierre extends Tool {

    public PiochePierre() {
        super(MineUtils.PIOCHE_PIERRE, 25, 2, false);
        this.pattern.add(new RessourceInstance(MineUtils.tabRessources[1]));
        this.pattern.add(new RessourceInstance(MineUtils.tabRessources[1]));
        this.pattern.add(new RessourceInstance(MineUtils.tabRessources[1]));
        this.pattern.add(null);
        this.pattern.add(new RessourceInstance(MineUtils.tabRessources[11]));
        this.pattern.add(null);
        this.pattern.add(null);
        this.pattern.add(new RessourceInstance(MineUtils.tabRessources[11]));
        this.pattern.add(null);
    }

}
