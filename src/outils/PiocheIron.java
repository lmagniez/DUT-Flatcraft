package outils;

import bloc.RessourceInstance;
import run.MineUtils;

/**
 * Classe pour Pioche en Fer
 */
public class PiocheIron extends Tool {

    public PiocheIron() {
        super(MineUtils.PIOCHE_FER, 30, 3, false);
        this.pattern.add(MineUtils.tabRessources[3]);
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
