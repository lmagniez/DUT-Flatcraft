package outils;

import bloc.RessourceInstance;
import run.MineUtils;

/**
 * Classe pour Hache en Diamand
 */
public class HacheDiamond extends Tool {

    public HacheDiamond() {
        super(MineUtils.HACHE_DIAMOND, 35, 4, false);
        this.pattern.add(null);
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
