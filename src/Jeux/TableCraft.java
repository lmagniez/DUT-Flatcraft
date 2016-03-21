package Jeux;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;

import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.TransferHandler;
import javax.swing.TransferHandler.TransferSupport;

import Bloc.RessourceContainer;
import Bloc.RessourceReceiver;
import Main.MineUtils;
import Map.ColonneDeRessources;

public class TableCraft extends JDialog {

	   // les donn�es mises � jour par la bo�te de dialogue

	  Integer lEntier = new Integer(0);

	  String leNom;

	 

	  public TableCraft(JFrame parent, String titre, boolean modal) {

	       super(parent,titre, modal);
	       this.setSize(new Dimension(500, 400));
       	   this.setResizable(false);
       	   this.setAlwaysOnTop(true);
	       prepare();
	  }

	  public void prepare()
	  {
		  JPanel p = new JPanel();
		  p.setLayout(new GridLayout(3, 3));
		  
		  RessourceReceiver result= new RessourceReceiver();
		  
		  for(int i=0;i<9;i++){
				JPanel jp= new JPanel();
				jp.add(new RessourceContainer(0,null));
				jp.setTransferHandler(this.createTransfertTo());
				p.add(jp);
		  }
		  this.add(BorderLayout.CENTER, p);
		  this.add(BorderLayout.EAST, result);
		  
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
	                    System.out.println("ok source : "+source);
	                    try {
	                    	System.out.println("ok try");
	                    	System.out.println(support.getTransferable().getTransferData(MineUtils.MINE_FLAVOR));
	                        JComponent comp = (JComponent) support.getTransferable().getTransferData(MineUtils.MINE_FLAVOR);
	                        System.out.println("ok comp: "+comp);
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