package jeux;

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

import bloc.RessourceContainer;
import run.MineUtils;
import map.ColonneDeRessources;

public class TableCraft extends JDialog {
	 

	  public TableCraft(JFrame parent, String titre, boolean modal) {

	       super(parent,titre, modal);
	       this.setSize(new Dimension(300, 400));
       	   this.setResizable(false);
       	   this.setAlwaysOnTop(true);
	       prepare();
	  }

	  public void prepare()
	  {
		  JPanel p = new JPanel();
		  p.setLayout(new GridLayout(3, 3));
		  
		  
		  JPanel result= new JPanel();
		  result.setPreferredSize(new Dimension(100,100));
		  result.add(new RessourceContainer(0,null));
		  
		  for(int i=0;i<9;i++){
				JPanel jp= new JPanel();

				jp.setPreferredSize(new Dimension(80,80));
				jp.setSize(new Dimension(100,100));

				jp.setTransferHandler(this.createTransfertTo());
				p.add(jp);
		  }
		  
		  p.setTransferHandler(this.createTransfertTo());
			
		  this.add(BorderLayout.CENTER, p);
		  this.add(BorderLayout.EAST, result);
		  
		  p.revalidate();
		  p.repaint();
		  
		  result.revalidate();
		  result.repaint();
		 
		  
		  this.pack();
		  
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
	                    	e.printStackTrace();
	                        return false;
	                    }
	                } else {
	                    return false;
	                }
	            }
	        };
	    }
	  

	 

}