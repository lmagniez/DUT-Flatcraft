package bloc;

import run.MineUtils;

public class Coal extends Ressource {

    public Coal() {
        super(MineUtils.overlay(MineUtils.STONE, "/textures/default_mineral_coal.png"), 7, "pioche");
    }
}
