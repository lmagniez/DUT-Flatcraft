package outils;

import bloc.RessourceInstance;
import run.MineUtils;

/**
 * Classe pour Pelle en Bois
 */
public class PelleBois extends Tool {

    public PelleBois() {
        super(MineUtils.PELLE_BOIS, 20, 1, false);
        this.pattern.add(null);
        this.pattern.add(MineUtils.tabRessources[12]);
        this.pattern.add(null);
        this.pattern.add(null);
        this.pattern.add(MineUtils.tabRessources[11]);
        this.pattern.add(null);
        this.pattern.add(null);
        this.pattern.add(MineUtils.tabRessources[11]);
        this.pattern.add(null);
    }

}
