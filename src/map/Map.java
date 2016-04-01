package map;

import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.BoxLayout;
import javax.swing.JComponent;
import javax.swing.JPanel;


    /**
    * Classe g�n�rant la map
    * @author  Vincent Valembois
    * 
    */
public class Map<T extends JComponent> {
    public JPanel grid;
    private int row = 15;
    private int col = 15;
    public static final int NOMBRE_RESSOURCES = 7;

    /**
     * Constructeur
     */
    public Map() {
        grid = new JPanel();
        grid.setLayout(new BoxLayout(grid, BoxLayout.Y_AXIS));
        grid.setSize(new Dimension(80, 75));
        create();
    }
    
    /**
     * G�n�rer la map selon les attributs row et col
     */
    private void create() {
        int ligne = 0, coll = 0;
        int cells = row * col;
        grid.setLayout(new GridLayout(row, col));
        for (int i = 0; i < cells; i++) {
            if (ligne < row / 2) {
                if (coll < col / 2) {
                    grid.add(new ColonneDeRessourcesNormal());
                } else {
                    grid.add(new ColonneDeRessourceDesert());
                }
            } else {
                if (coll < col / 2) {
                    grid.add(new ColonneDeRessourcesIce());
                } else {
                    grid.add(new ColonneDeRessourcesNormal());
                }
            }
            coll++;
            if (coll % col == 0) {
                ligne++;
                coll = 0;
            }
        }
    }
}
