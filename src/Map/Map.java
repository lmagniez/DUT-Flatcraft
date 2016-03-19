package Map;

import java.awt.GridLayout;

import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Bloc.Ressource;
import Main.MineUtils;

public class Map<T extends JComponent> {
	public JPanel grid;
	private int row=8;
	private int col=12;
	public static final int NOMBRE_RESSOURCES=7;
	
	public Map() {
		super();
		grid=new JPanel();
		create();
	}

	private void create() {
		int cells = row*col;
		grid.setLayout(new GridLayout(row, col));
		for(int i=0;i<cells;i++){
			grid.add(new ColonneDeRessources());
		}
	}
}
