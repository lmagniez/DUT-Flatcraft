package bloc;

import run.MineUtils;

public class Iron extends Ressource {

    public Iron() {
        super("iron",MineUtils.overlay(MineUtils.STONE, "/textures/default_mineral_iron.png"), 10, "pioche",true);
    }
    
}
