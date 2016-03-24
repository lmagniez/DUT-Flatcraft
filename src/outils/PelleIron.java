package outils;

import bloc.RessourceInstance;
import jeux.Jeux;
import run.MineUtils;

public class PelleIron extends Tool {

    public PelleIron() {
        super(MineUtils.PELLE_FER, 30, 3, false);
        this.pattern.add(null);
        this.pattern.add(new RessourceInstance(Jeux.tabRessources[3]));
        this.pattern.add(null);
        this.pattern.add(null);
        this.pattern.add(new RessourceInstance(Jeux.tabRessources[11]));
        this.pattern.add(null);
        this.pattern.add(null);
        this.pattern.add(new RessourceInstance(Jeux.tabRessources[11]));
        this.pattern.add(null);
    }

}
