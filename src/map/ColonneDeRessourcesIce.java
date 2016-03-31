package map;

import bloc.RessourceInstance;
import run.MineUtils;

/**
 * Classe pour generer un sol d'Hiver
 */
public class ColonneDeRessourcesIce extends ColonneDeRessources {

    /**
     * Fonction generant le sol a partir d'un index donné
     * @param index (int)
     */
    @Override
    protected void sol(int index) {
        float r;
        for (int i = index; i < index + 5; i++) {
            r = (float) (Math.random() * 1);
            if (i >= index + 1) {
                if (r < 0.2)
                    col.add(new RessourceInstance(MineUtils.tabRessources[10]));
                else
                    continue;
            } else if (i == 25)
                col.add(new RessourceInstance(MineUtils.tabRessources[0]));
        }
    }
}
