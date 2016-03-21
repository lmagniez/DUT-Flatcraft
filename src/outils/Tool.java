package outils;

import javax.swing.ImageIcon;

import jeux.MineElement;

public class Tool implements MineElement {
    public ImageIcon image;
    private final int valeurVie;
    private final double coef;
    public int vie;
    public boolean select = false;

    public Tool(ImageIcon image, int valeurVie, double d, boolean s) {
        super();
        this.image = image;
        this.coef = d;
        this.valeurVie = valeurVie;
        this.select = s;
    }

    public double getCoef() {
        return coef;
    }

    public int getVie() {
        return valeurVie;
    }

    public void setVie(int vie) {
        this.vie = vie;
    }

    @Override
    public ToolInstance newInstance() {
        return new ToolInstance(this);
    }

    public boolean isSelect() {
        return select;
    }

    public void setSelect(boolean select) {
        this.select = select;
    }
}
