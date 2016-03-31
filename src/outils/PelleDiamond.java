package outils;

import bloc.RessourceInstance;
import run.MineUtils;

/**
 * Classe pour Pelle en diamand
 */
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
