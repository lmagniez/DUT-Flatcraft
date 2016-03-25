package outils;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;

import jeux.Jeux;
import jeux.MineElement;
import jeux.MineElementInstance;

public class ToolInstance extends JButton implements MineElementInstance, ActionListener {

    private Tool outils;
    private double coef;
    private int vie;
    private boolean select;

    public ToolInstance(Tool t) {
        this.outils = t;
        this.coef = t.getCoef();
        this.vie = t.getVie();
        this.setIcon(t.image);
        this.setBorder(BorderFactory.createEmptyBorder());
        this.select = outils.isSelect();
        this.addActionListener(this);
    }

    @Override
    public MineElement getType() {
        return outils;
    }

    public int getVie() {
        return vie;
    }

    public void setVie(int vie) {
        this.vie = vie;
    }

    @Override
    protected void paintComponent(Graphics g) {
        if (this.getVie() > 0) {
            super.paintComponent(g);
            Rectangle rect = g.getClipBounds();
            g.setColor(Color.GRAY);
            g.fillRect(rect.x + 5, rect.y + 70, 70, 3);
            int vie = (int) (this.vie * 70.0) / this.outils.getVie();

            g.setColor(Color.GREEN);
            g.fillRect(rect.x + 5, rect.y + 70, vie, 3);
        }
        if (this.select) {
            Rectangle rect = g.getClipBounds();
            g.setColor(Color.BLUE);
            g.fillOval(rect.x + rect.width - 20, rect.y, 10, 10);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Component[] components = Jeux.getOutils().getComponents();
        ToolInstance button = (ToolInstance) e.getSource();

        for (int i = 1; i < components.length; i++) {
            ToolInstance tmp = (ToolInstance) Jeux.getOutils().getComponent(i);
            if (tmp.select)
                tmp.select = false;
        }

        button.select = true;
        Jeux.getOutils().revalidate();
        Jeux.getOutils().repaint();
        Jeux.changeCursorTo();
    }

    
    public boolean isSelect() {
        return select;
    }

    public void setSelect(boolean select) {
        this.select = select;
    }

    public double getCoef() {
        return coef;
    }

    public Tool getOutils() {
        return outils;
    }

}
