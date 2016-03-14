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
	public ColonneDeRessources[] gridC= new ColonneDeRessources[row*col] ;
	
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
			gridC[i]=new ColonneDeRessources();
			grid.add(gridC[i].col.get(0));
		}
	}
}