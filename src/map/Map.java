package map;

import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.BoxLayout;
import javax.swing.JComponent;
import javax.swing.JPanel;

public class Map<T extends JComponent> {
    public JPanel grid;
    private int row = 12;
    private int col = 12;
    public static final int NOMBRE_RESSOURCES = 7;

    public Map() {
        grid = new JPanel();

        grid.setLayout(new BoxLayout(grid, BoxLayout.Y_AXIS));
        grid.setSize(new Dimension(80, 75));

        create();
    }

    private void create() {
        int cells = row * col;
        grid.setLayout(new GridLayout(row, col));
        for (int i = 0; i < cells; i++) {
            grid.add(new ColonneDeRessources());
        }
    }
}
