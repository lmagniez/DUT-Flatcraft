package Map;

import java.awt.GridLayout;

import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Main.MineUtils;

public class Map<T extends JComponent> {
	public JPanel grid;

	public Map() {
		super();
		grid=new JPanel();
		create();
	}

	private void create() {
		int cells = 8*12;
		grid.setLayout(new GridLayout(8, 12));
	
	}
}
