package bloc;

import run.MineUtils;

public class Pick extends Ressource {

    public Pick() {
        super("pick", MineUtils.PICK, 1, "ALL");
        this.pattern.add(MineUtils.tabRessources[12]);
        this.pattern.add(null);
        this.pattern.add(null);
        this.pattern.add(null);
        this.pattern.add(null);
        this.pattern.add(null);
        this.pattern.add(null);
        this.pattern.add(null);
        this.pattern.add(null);
        this.nbGenere=4;
    }
}
