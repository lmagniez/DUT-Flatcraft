package outils;

import bloc.RessourceInstance;
import jeux.Jeux;
import run.MineUtils;

public class HachePierre extends Tool {

    public HachePierre() {
        super(MineUtils.HACHE_PIERRE, 25, 2, false);
        this.pattern.add(null);
        this.pattern.add(new RessourceInstance(Jeux.tabRessources[1]));
        this.pattern.add(new RessourceInstance(Jeux.tabRessources[1]));
        this.pattern.add(null);
        this.pattern.add(new RessourceInstance(Jeux.tabRessources[11]));
        this.pattern.add(null);
        this.pattern.add(null);
        this.pattern.add(new RessourceInstance(Jeux.tabRessources[11]));
        this.pattern.add(null);
    }

}
