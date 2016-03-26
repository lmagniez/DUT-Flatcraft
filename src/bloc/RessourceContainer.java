package bloc;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JToggleButton;
import javax.swing.TransferHandler;

import jeux.Prototype;
import run.MineUtils;

public class RessourceContainer extends JToggleButton implements Prototype {

    protected int id;
    private int quantity;
    private Ressource ressource;
    private static int ID = 0;

    public RessourceContainer(int quantity, Ressource r) {

        this.id = ID;
        ID += 1;

        this.setSize(new Dimension(100, 100));

        this.quantity = quantity;
        this.ressource = r;
        if (r != null)
            this.setIcon(r.image);
        this.setBorder(BorderFactory.createEmptyBorder());

    }

    @Override
    protected void paintComponent(Graphics g) {
        int qty = this.quantity;
        if (qty > 0) {
            super.paintComponent(g);
            Rectangle rect = g.getClipBounds();
            g.setColor(Color.YELLOW);
            g.fillOval(rect.x + rect.width - 30, rect.y + rect.height - 30, 30, 30);
            g.setColor(Color.BLACK);
            g.setFont(g.getFont().deriveFont(Font.BOLD, g.getFont().getSize()));
            if (qty < 10) {
                g.drawString(String.valueOf(qty), rect.x + rect.width - 17, rect.y + rect.height - 10);
            } else {
                g.drawString(String.valueOf(qty), rect.x + rect.width - 21, rect.y + rect.height - 10);
            }

        }
        if (this.isSelected()) {
            Rectangle rect = g.getClipBounds();
            g.setColor(Color.BLUE);
            g.fillOval(rect.x + rect.width - 20, rect.y, 10, 10);
        }
    }

    @Override
    public DataFlavor[] getTransferDataFlavors() {
        return new DataFlavor[] { MineUtils.MINE_FLAVOR };
    }

    @Override
    public boolean isDataFlavorSupported(DataFlavor flavor) {
        return MineUtils.MINE_FLAVOR.equals(flavor);
    }

    @Override
    public Object getTransferData(DataFlavor flavor) throws UnsupportedFlavorException, IOException {
        return this;
    }

    @Override
    public Prototype clone() {
        RessourceContainer r = new RessourceContainer(this.quantity, this.ressource);
        return r;
    }

    public TransferHandler createTransfertFrom() {
        return new TransferHandler() {

            private static final long serialVersionUID = 1L;

            @Override
            public int getSourceActions(JComponent c) {
                return COPY;
            }

            @Override
            protected Transferable createTransferable(JComponent c) {
                return (Transferable) c;
            }

            @Override
            protected void exportDone(JComponent source, Transferable data, int action) {

            }

        };
    }

    public Ressource getRessource() {
        return ressource;
    }

    public void setRessource(Ressource r) {
        this.ressource = r;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getID() {
        return this.id;
    }

}
