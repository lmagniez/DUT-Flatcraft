package outils;

import bloc.RessourceInstance;
import run.MineUtils;

/**
 * Classe pour Pioche en Pierre
 */
public class PiochePierre extends Tool {

    public PiochePierre() {
        super(MineUtils.PIOCHE_PIERRE, 25, 2, false);
        this.pattern.add(MineUtils.tabRessources[1]);
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
