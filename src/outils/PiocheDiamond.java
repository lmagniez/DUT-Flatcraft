package outils;

import bloc.RessourceInstance;
import run.MineUtils;

/**
 * Classe pour Pioche en Diamand
 */
public class PiocheDiamond extends Tool {

    public PiocheDiamond() {
        super(MineUtils.PIOCHE_DIAMOND, 35, 4, false);
        this.pattern.add(MineUtils.tabRessources[5]);
        this.pattern.add(MineUtils.tabRessources[5]);
        this.pattern.add(MineUtils.tabRessources[5]);
        this.pattern.add(null);
        this.pattern.add(MineUtils.tabRessources[11]);
        this.pattern.add(null);
        this.pattern.add(null);
        this.pattern.add(MineUtils.tabRessources[11]);
        this.pattern.add(null);
    }

}
