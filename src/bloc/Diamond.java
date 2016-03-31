package bloc;

import run.MineUtils;

/**
 * Ressource Diamond
 */
public class Diamond extends Ressource {

    public Diamond() {
        super("diamond", MineUtils.overlay(MineUtils.STONE, "/textures/default_mineral_diamond.png"), 15, "pioche");
        this.changement = true;
    }

}
