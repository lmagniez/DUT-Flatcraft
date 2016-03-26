package run;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.datatransfer.DataFlavor;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JScrollPane;
import javax.swing.JToggleButton;

import bloc.Cactus;
import bloc.Coal;
import bloc.Diamond;
import bloc.Grass;
import bloc.Iron;
import bloc.Lava;
import bloc.Obsidian;
import bloc.Pick;
import bloc.Ressource;
import bloc.Sand;
import bloc.Snow;
import bloc.Stone;
import bloc.Wood;
import bloc.WoodPlanks;
import outils.HacheBois;
import outils.HacheDiamond;
import outils.HacheIron;
import outils.HachePierre;
import outils.MainOutils;
import outils.PelleBois;
import outils.PelleDiamond;
import outils.PelleIron;
import outils.PellePierre;
import outils.PiocheBois;
import outils.PiocheDiamond;
import outils.PiocheIron;
import outils.PiochePierre;
import outils.Tool;

/**
 * Classe utilitaire permettant d'accéder facilement aux images de MineTest dans
 * un programme Java.
 * 
 * @author leberre
 *
 */
public class MineUtils {

    private MineUtils() {
    }

    public static final ImageIcon GRASS = scaled("/textures/default_grass.png");
    public static final ImageIcon LAVA = scaled("/textures/default_lava.png");
    public static final ImageIcon OBSIDIAN = scaled("/textures/default_obsidian.png");
    public static final ImageIcon STONE = scaled("/textures/default_stone.png");
    public static final ImageIcon WOOD = scaled("/textures/default_tree_top.png");
    public static final ImageIcon SAND = scaled("/textures/default_sand.png");
    public static final ImageIcon CACTUS = scaled("/textures/default_cactus_top.png");
    public static final ImageIcon SNOW = scaled("/textures/default_snow.png");
    public static final ImageIcon PICK = scaled("/textures/default_stick.png");
    public static final ImageIcon WOOD_PLANKS = scaled("/textures/default_wood.png");

    public static final ImageIcon PIOCHE_BOIS = scaled("/textures/default_tool_woodpick.png");
    public static final ImageIcon PIOCHE_PIERRE = scaled("/textures/default_tool_stonepick.png");
    public static final ImageIcon PIOCHE_FER = scaled("/textures/default_tool_steelpick.png");
    public static final ImageIcon PIOCHE_DIAMOND = scaled("/textures/default_tool_diamondpick.png");

    public static final ImageIcon HACHE_BOIS = scaled("/textures/default_tool_woodaxe.png");
    public static final ImageIcon HACHE_PIERRE = scaled("/textures/default_tool_stoneaxe.png");
    public static final ImageIcon HACHE_FER = scaled("/textures/default_tool_steelaxe.png");
    public static final ImageIcon HACHE_DIAMOND = scaled("/textures/default_tool_diamondaxe.png");

    public static final ImageIcon PELLE_BOIS = scaled("/textures/default_tool_woodshovel.png");
    public static final ImageIcon PELLE_PIERRE = scaled("/textures/default_tool_stoneshovel.png");
    public static final ImageIcon PELLE_FER = scaled("/textures/default_tool_steelshovel.png");
    public static final ImageIcon PELLE_DIAMOND = scaled("/textures/default_tool_diamondshovel.png");
    
    public static final ImageIcon DIAMOND=scaled("/textures/default_diamond.png");
    public static final ImageIcon IRON=scaled("/textures/default_steel_ingot.png");
    public static final ImageIcon COAL=scaled("/textures/default_coal_lump.png");

    public static final ImageIcon MAIN = scaled("/textures/main.png");
    
    public static final int NB_RESSOURCES = 13;
    public static final int NB_OUTILS = 13;
    public static final Ressource[] tabRessources = new Ressource[NB_RESSOURCES];
    public static final Tool[] tabOutils = new Tool[NB_OUTILS];
    
    public static final DataFlavor MINE_FLAVOR = new DataFlavor(JComponent.class, "MineFlavor");

   public static void prepareRessource() {
        tabRessources[0] = new Grass();
        tabRessources[1] = new Stone();
        tabRessources[2] = new Wood();
        tabRessources[3] = new Iron();
        tabRessources[4] = new Obsidian();
        tabRessources[5] = new Diamond();
        tabRessources[6] = new Lava();
        tabRessources[7] = new Coal();
        tabRessources[8] = new Sand();
        tabRessources[9] = new Cactus();
        tabRessources[10] = new Snow();
        tabRessources[12] = new WoodPlanks();
        tabRessources[11] = new Pick();
    }

    public static void prepareOutils() {
        tabOutils[0] = new MainOutils();
        tabOutils[1] = new PiocheBois();
        tabOutils[2] = new PiochePierre();
        tabOutils[3] = new PiocheIron();
        tabOutils[4] = new PiocheDiamond();
        tabOutils[5] = new PelleBois();
        tabOutils[6] = new PellePierre();
        tabOutils[7] = new PelleIron();
        tabOutils[8] = new PelleDiamond();
        tabOutils[9] = new HacheBois();
        tabOutils[10] = new HachePierre();
        tabOutils[11] = new HacheIron();
        tabOutils[12] = new HacheDiamond();
    }

   
    /**
     * Create a scaled up version of the original icon, to have a MineCraft
     * effect.
     * 
     * @param imageName
     *            the name of the texture file.
     * @return an ImageIcon scaled up to 80x80.
     */
    public static ImageIcon scaled(String imageName) {
        try {
            return new ImageIcon(ImageIO.read(MineUtils.class.getResource(imageName)).getScaledInstance(80, 80,
                    Image.SCALE_DEFAULT));
        } catch (IOException e) {
            return new ImageIcon();
        }
    }

    /**
     * Create a JButton without borders, to be used typically in a
     * {@see GridLayout}.
     * 
     * @param icon
     *            the ImageIcon to be seen on the button.
     * @return a button displaying icon, with no borders.
     */
    public static JButton noBorderButton(ImageIcon icon) {
        JButton button = new JButton(icon);
        button.setBorder(BorderFactory.createEmptyBorder());
        return button;
    }

    /**
     * Create a JToggleButton without borders, to be used typically in a
     * {@see GridLayout}.
     * 
     * @param icon1
     *            the ImageIcon to be seen first on the button.
     * @param icon2
     *            the ImageIcon to be seen once the button is pushed.
     * @return a button displaying icon, with no borders.
     */
    public static JToggleButton toggleNoBorderButton(ImageIcon icon1, ImageIcon icon2) {
        JToggleButton button = new JToggleButton(icon1);
        button.setBorder(BorderFactory.createEmptyBorder());
        button.setSelectedIcon(icon2);
        return button;
    }

    /**
     * Create a JScrollPane which is incremented by 1/4 of a tile when scrolling
     * once.
     * 
     * @param comp
     *            a component to be decorated with scrollbars.
     * @return a JScrollPane with scroll speed adaptated to tiles.
     */
    public static JScrollPane scrollPane(JComponent comp) {
        JScrollPane scroller = new JScrollPane(comp);
        scroller.getVerticalScrollBar().setUnitIncrement(20);
        scroller.getHorizontalScrollBar().setUnitIncrement(20);
        return scroller;
    }

    /**
     * Create a new scaled up version of the original icon, over an already
     * scaled image (e.g. STONE).
     * 
     * @param background
     *            a scaled up background image
     * @param imageName
     *            the new image to put on top of the background.
     * @return an image consisting of imageName with the given background.
     */
    public static ImageIcon overlay(ImageIcon background, String imageName) {
        try {
            Image foreground = ImageIO.read(MineUtils.class.getResource(imageName)).getScaledInstance(80, 80,
                    Image.SCALE_DEFAULT);
            BufferedImage merged = new BufferedImage(80, 80, BufferedImage.TYPE_INT_ARGB);
            Graphics g = merged.getGraphics();
            g.drawImage(background.getImage(), 0, 0, null);
            g.drawImage(foreground, 0, 0, null);
            return new ImageIcon(merged);
        } catch (IOException e) {
            return new ImageIcon();
        }
    }

}
