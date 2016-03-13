package Map;

import java.awt.GridLayout;

import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Main.MineUtils;

public class Map<T extends JComponent> {
	public JPanel grid;
	public int row=8;
	public int col=12;
	
	public Map() {
		super();
		grid=new JPanel();
		create();
	}

	private void create() {
		int cells = row*col;
		int a = 0,b=0;
		grid.setLayout(new GridLayout(row, col));
		ColonneDeRessources j=null;
		for(int i=0;i<cells;i++){
			j=new ColonneDeRessources();
			grid.add(new JLabel(j.col.get(0).getImage()));
		}
	}
}
