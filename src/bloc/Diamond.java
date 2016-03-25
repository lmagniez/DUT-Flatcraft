package bloc;

import run.MineUtils;

public class Diamond extends Ressource {

    public Diamond() {
        super(MineUtils.overlay(MineUtils.STONE, "/textures/default_mineral_diamond.png"), 15, "pioche");
    }

}
