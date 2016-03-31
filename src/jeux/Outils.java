package jeux;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

import outils.ToolInstance;
import run.MineUtils;

/**
 * Classe Outils 
 * Contient des ToolsInstance
 */
public class Outils extends JPanel {

    public Outils() {
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setVisible(true);
    }

    void Initialize() {
        this.add(new ToolInstance(MineUtils.tabOutils[0]));
    }
}
