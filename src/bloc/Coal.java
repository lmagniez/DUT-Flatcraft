package bloc;

import run.MineUtils;

/**
 * Ressource Charbon
 */
public class Coal extends Ressource {

    public Coal() {
        super("coal", MineUtils.overlay(MineUtils.STONE, "/textures/default_mineral_coal.png"), 7, "pioche");
        this.changement = true;
    }

}
