package Bloc;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;

import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JToggleButton;
import javax.swing.TransferHandler;

import Jeux.Prototype;
import Main.MineUtils;

public class RessourceContainer extends JToggleButton implements Prototype {

	private int quantity;
	private Ressource ressource;
	private boolean select = false;

	public RessourceContainer(int quantity, Ressource r) {
		this.setSize(new Dimension(100, 100));

		this.quantity = quantity;
		this.ressource = r;
		if (r != null)
			this.setIcon(r.image);
		this.setBorder(BorderFactory.createEmptyBorder());
		

		
		//this.addMouseListener(mouselistener);
		//this.setTransferHandler(createTransfertFrom());
		
		//this.createTransfertFrom();
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

	protected void paintComponent(Graphics g) {
		int qty = this.quantity;
		if (qty > 0) {
			super.paintComponent(g);
			Rectangle rect = g.getClipBounds();
			g.setColor(Color.YELLOW);
			g.fillOval(rect.x + rect.width - 30, rect.y + rect.height - 30, 30,
					30);
			g.setColor(Color.BLACK);
			g.setFont(g.getFont().deriveFont(Font.BOLD, g.getFont().getSize()));
			if (qty < 10) {
				g.drawString(String.valueOf(qty), rect.x + rect.width - 17,
						rect.y + rect.height - 10);
			} else {
				g.drawString(String.valueOf(qty), rect.x + rect.width - 21,
						rect.y + rect.height - 10);
			}
		}
	}

	public boolean isSelect() {
		return select;
	}

	public void setSelect(boolean s) {
		select = s;
	}
	
    public MouseListener mouselistener = new MouseAdapter() {
        public void mousePressed(MouseEvent me) {
        
        	if ((me.getModifiers() & ActionEvent.CTRL_MASK) == ActionEvent.CTRL_MASK) {
	        	System.out.println("Mouse Listener...");
	        	
	        	
	            JToggleButton comp = (JToggleButton) me.getSource();
	            
	            ((AbstractButton) me.getSource()).setSelected(true);
	            Jeux.Jeux.getInv().afficher();
	            
	            TransferHandler handler = comp.getTransferHandler();
	            
	            
	            
	            System.out.println("comp: "+comp);
	            System.out.println("handler: "+comp.getTransferHandler());
	            
	            handler.exportAsDrag(comp, me, TransferHandler.COPY);
        	}
        	
        	
        	
        }
    };
	
	
	@Override
	public DataFlavor[] getTransferDataFlavors() {
		return new DataFlavor[] { MineUtils.MINE_FLAVOR };
	}

	@Override
	public boolean isDataFlavorSupported(DataFlavor flavor) {
		return MineUtils.MINE_FLAVOR.equals(flavor);
	}

	@Override
	public Object getTransferData(DataFlavor flavor)
			throws UnsupportedFlavorException, IOException {
		return this;
	}

	@Override
	public Prototype clone() {
		RessourceContainer r = new RessourceContainer(this.quantity,
				this.ressource);
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
                return ((Prototype) c).clone();
            }

            @Override
            protected void exportDone(JComponent source, Transferable data, int action) {
                // rien � faire
            }

        };
    }

}
