package bloc;

import jeux.MineElementInstance;


/**
 * Ressource contenue dans les colonnes de ressources
 * A changer en RessourceContainer quand on la creuse
 */
public class RessourceInstance implements MineElementInstance {

    private Ressource ressource;
    private double vie;

    /**
     * Constructeur
     * @param r (Ressource)
     */ 
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
