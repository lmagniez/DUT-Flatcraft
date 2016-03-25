package bloc;

import jeux.Jeux;
import run.MineUtils;

public class WoodPlanks extends Ressource{

    public WoodPlanks() {
        super(MineUtils.WOOD_PLANKS, 5, "hache");
        this.pattern.add(new RessourceInstance(Jeux.tabRessources[2]));
    }
}
