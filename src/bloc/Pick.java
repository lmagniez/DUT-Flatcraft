package bloc;

import run.MineUtils;

public class Pick extends Ressource {

    public Pick() {
        super("pick", MineUtils.PICK, 1, "ALL");
        this.pattern.add(new RessourceInstance(MineUtils.tabRessources[12]));
    }
}
