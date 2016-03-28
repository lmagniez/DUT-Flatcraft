package jeux;

import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

import outils.ToolInstance;
import run.MineUtils;

public class Outils extends JPanel {

    public Outils() {
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setVisible(true);
    }

    void Initialize() {
        this.add(new ToolInstance(MineUtils.tabOutils[0]));
        this.add(new ToolInstance(MineUtils.tabOutils[1]));
        this.add(new ToolInstance(MineUtils.tabOutils[2]));
    }
}
