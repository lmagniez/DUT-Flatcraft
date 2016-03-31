package map;

import bloc.RessourceInstance;
import run.MineUtils;

/**
 * Classe pour generer un sol Normal
 */
public class ColonneDeRessourcesNormal extends ColonneDeRessources {

    /**
     * Fonction generant le sol a partir d'un index donné
     * @param index (int)
     */
    @Override
    protected void sol(int index) {
        float r;
        for (int a = index; a < index + 5; a++) {
            r = (float) (Math.random() * 1);
            if (a >= index + 1) {
                if (r < 0.08)
                    col.add(new RessourceInstance(MineUtils.tabRessources[2])); /* wood */
                else
                    continue;
            } else if (a == 25)
                col.add(new RessourceInstance(MineUtils.tabRessources[0])); /* grass */
            // -> sol
        }
    }

}
