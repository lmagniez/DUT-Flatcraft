package bloc;

import jeux.MineElementInstance;

public class RessourceInstance implements MineElementInstance {

    private Ressource ressource;
    private double vie;

    public RessourceInstance(Ressource r) {
        this.ressource = r;
        this.vie = r.getValeurVie();
    }

    public Ressource getType() {
        return this.ressource;
    }

    public double getVie() {
        return vie;
    }

    public void setVie(double d) {
        this.vie = d;
    }

}
