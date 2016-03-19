package Bloc;

import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JToggleButton;
import javax.swing.TransferHandler;

import Jeux.Jeux;
import Main.MineUtils;

//Stocke les ressourcesContainer dans la tableCraft
//Renvoie tous les ressourcesContainer quand on ferme TableCraft
public class RessourceReceiver extends JButton {

	
	private RessourceContainer ressource;
	
	public RessourceReceiver()
	{
		this.setSize(new Dimension(100,100));
		createTransfertTo();
	}
	
	public void add(RessourceContainer r)
	{
		//receiver non vide
		if(ressource!=null)
			Jeux.getInv().add(ressource);//On remet dans l'inventaire la ressource actuelle
		this.ressource=r;
			
	}
	
	public void retirer(int quantite)
	{
		//on supprime tout 
		if(ressource.getQuantity()-quantite<=0)
			ressource=null;
		else
			ressource.setQuantity(ressource.getQuantity()-quantite);
	}
	
	 private TransferHandler createTransfertTo() {
	        return new TransferHandler() {

	            @Override
	            public boolean canImport(TransferSupport support) {
	                return support.isDataFlavorSupported(MineUtils.MINE_FLAVOR);
	            }

	            @Override
	            public boolean importData(TransferSupport support) {
	                if (support.isDrop()) {
	                    JPanel source = (JPanel) support.getComponent();
	                    try {
	                        JComponent comp = (JComponent) support.getTransferable().getTransferData(MineUtils.MINE_FLAVOR);
	                        source.removeAll();
	                        source.add(comp);
	                        source.revalidate();
	                        source.repaint();
	                        return true;
	                    } catch (Exception e) {
	                        return false;
	                    }
	                } else {
	                    return false;
	                }
	            }
	        };
	    }
	
	
	
}
