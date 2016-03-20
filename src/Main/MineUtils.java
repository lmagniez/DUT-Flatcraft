package Main;


import java.awt.Image;
import java.awt.datatransfer.DataFlavor;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JScrollPane;
import javax.swing.JToggleButton;

/**
 * Classe utilitaire permettant d'accéder facilement aux images de
 * MineTest dans un programme Java.
 * 
 * @author leberre
 *
 */
public class MineUtils {
	
	private MineUtils() {
		// pas possible de créer des instances de cette classe
	}
	
	//ressource necessaire pour la map 
	public static final ImageIcon DIAMOND = scaled("/textures/default_mineral_diamond.png");
	public static final ImageIcon GRASS = scaled("/textures/default_grass.png");	
	public static final ImageIcon IRON= scaled("/textures/default_mineral_iron.png");
	public static final ImageIcon LAVA=scaled("/textures/default_lava.png");
	public static final ImageIcon OBSIDIAN=scaled("/textures/default_obsidian.png");
	public static final ImageIcon STONE = scaled("/textures/default_stone.png");
	public static final ImageIcon WOOD = scaled("/textures/default_tree.png");
	public static final ImageIcon COAL = scaled("/textures/default_coal_block.png");
	public static final ImageIcon BRICOLAGE = scaled("/textures/roumain.png");
	
	public static final ImageIcon PIOCHE_BOIS=scaled("/textures/default_tool_woodpick.png");
	public static final ImageIcon PIOCHE_PIERRE=scaled("/textures/default_tool_stonepick.png");
	public static final ImageIcon PIOCHE_FER=scaled("/textures/default_tool_steelpick.png");
	public static final ImageIcon PIOCHE_DIAMOND=scaled("/textures/default_tool_diamondpick.png");

	public static final ImageIcon HACHE_BOIS=scaled("/textures/default_tool_woodaxe.png");
	public static final ImageIcon HACHE_PIERRE=scaled("/textures/default_tool_stoneaxe.png");
	public static final ImageIcon HACHE_FER=scaled("/textures/default_tool_steelaxe.png");
	public static final ImageIcon HACHE_DIAMOND=scaled("/textures/default_tool_diamondaxe.png");
	
	public static final ImageIcon PELLE_BOIS=scaled("/textures/default_tool_woodshovel.png");
	public static final ImageIcon PELLE_PIERRE=scaled("/textures/default_tool_stoneshovel.png");
	public static final ImageIcon PELLE_FER=scaled("/textures/default_tool_steelshovel.png");
	public static final ImageIcon PELLE_DIAMOND=scaled("/textures/default_tool_diamondshovel.png");
	
	public static final ImageIcon MAIN=scaled("/textures/main.png");
	
	/*public static final ImageIcon JUNGLEGRASS = scaled("/textures/default_junglegrass.png");
	public static final ImageIcon DIRT = scaled("/textures/default_dirt.png");
	public static final ImageIcon BRICK = scaled("/textures/default_brick.png");
	public static final ImageIcon CLAY = scaled("/textures/default_clay.png");
	public static final ImageIcon CLOUD = scaled("/textures/default_cloud.png");
	public static final ImageIcon COBBLE = scaled("/textures/default_cobble.png");
	public static final ImageIcon ICE = scaled("/textures/default_ice.png");
*/
	
	public static final DataFlavor MINE_FLAVOR = new DataFlavor(JComponent.class, "MineFlavor");
	
	/**
	 * Create a scaled up version of the original icon, to have a MineCraft effect.
	 * 
	 * @param imageName the name of the texture file.
	 * @return an ImageIcon scaled up to 80x80.
	 */
	public static ImageIcon scaled(String imageName) {
		try {
			return new ImageIcon(ImageIO.read(MineUtils.class.getResource(imageName)).getScaledInstance(80, 80, Image.SCALE_DEFAULT));
		} catch (IOException e) {
			return new ImageIcon();
		}
	}

	/**
	 * Create a JButton without borders, to be used typically in a {@see GridLayout}.
	 * 
	 * @param icon the ImageIcon to be seen on the button.
	 * @return a button displaying icon, with no borders.
	 */
	public static JButton noBorderButton(ImageIcon icon) {
		JButton button = new JButton(icon);
		button.setBorder(BorderFactory.createEmptyBorder());
		return button;
	}

	/**
	 * Create a JToggleButton without borders, to be used typically in a {@see GridLayout}.
	 * 
	 * @param icon1 the ImageIcon to be seen first on the button.
	 * @param icon2 the ImageIcon to be seen once the button is pushed.
	 * @return a button displaying icon, with no borders.
	 */
	public static JToggleButton toggleNoBorderButton(ImageIcon icon1, ImageIcon icon2) {
		JToggleButton button = new JToggleButton(icon1);
		button.setBorder(BorderFactory.createEmptyBorder());
		button.setSelectedIcon(icon2);
		return button;
	}
	
	/**
	 * Create a JScrollPane which is incremented by 1/4 of a tile when scrolling once.
	 * 
	 * @param comp a component to be decorated with scrollbars.
	 * @return a JScrollPane with scroll speed adaptated to tiles.
	 */
	public static JScrollPane scrollPane(JComponent comp) {
		JScrollPane scroller = new JScrollPane(comp);
		scroller.getVerticalScrollBar().setUnitIncrement(20);
		scroller.getHorizontalScrollBar().setUnitIncrement(20);
		return scroller;
	}
}
