package jeux;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.TransferHandler;

import bloc.Ressource;
import bloc.RessourceContainer;
import run.MineUtils;

public class TableCraft extends JDialog {

	private JPanel grille;
	private JPanel result;

	public TableCraft(JFrame parent, String titre, boolean modal) {

		super(parent, titre, modal);
		this.setSize(new Dimension(300, 400));
		this.setResizable(false);
		this.setAlwaysOnTop(true);

		prepare();
	}

	public void prepare() {
		grille = new JPanel();
		grille.setLayout(new GridLayout(3, 3));

		result = new JPanel();
		result.setPreferredSize(new Dimension(100, 100));
		result.add(new RessourceContainer(0, null));

		for (int i = 0; i < 9; i++) {
			JPanel jp = new JPanel();

			jp.setPreferredSize(new Dimension(80, 80));
			jp.setSize(new Dimension(100, 100));

			jp.setTransferHandler(this.createTransfertTo());
			grille.add(jp);
		}

		grille.setTransferHandler(this.createTransfertTo());

		this.add(BorderLayout.CENTER, grille);
		this.add(BorderLayout.EAST, result);

		grille.revalidate();
		grille.repaint();

		result.revalidate();
		result.repaint();

		this.pack();

	}

	public void supprimerElement(RessourceContainer r) {

		
		
		System.out.println("SUPPRIMER TABLE");
		RessourceContainer ressource1 = r;
		RessourceContainer ressource2;

		Component[] components = grille.getComponents();
		for (int i = 0; i < components.length; i++) 
		{
			
			
			JPanel p = (JPanel) (grille.getComponent(i));
			if (p.getComponentCount() != 0) {
				ressource2 = (RessourceContainer) (p.getComponent(0));
				System.out.println(ressource1.getID()+" "+ressource2.getID());
				
				if (ressource1.getID()==(ressource2.getID()))// trouvÃ©, on supprime
				{
					System.out.println("TROUVE !!");
					((JPanel) grille.getComponent(i)).removeAll();
					this.revalidate();
					this.repaint();
					return;
				}
			}
		}

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
						comp.addMouseListener(Jeux.mouselistener);
						comp.setTransferHandler(((RessourceContainer) comp).createTransfertFrom());
						
						
						Jeux.getTable().supprimerElement((RessourceContainer) comp);
						/*
						// Il y a déjà une ressource
						if (source.getComponentCount() != 0) {
							RessourceContainer ressource1 = ((RessourceContainer) source.getComponent(0));
							RessourceContainer ressource2 = ((RessourceContainer) comp);

							// même ressource
							if (ressource1.getRessource().getId().equals(ressource2.getRessource().getId())) {
								ressource1.setQuantity(ressource1.getQuantity()+ ressource2.getQuantity());

							}
							
						} else {
							
							source.removeAll();
							source.add(comp);
						}*/
						
						source.add(comp);
						source.revalidate();
						source.repaint();

						Jeux.getInv().supprimerInventaire((RessourceContainer) comp);
						//Jeux.getTable().supprimerElement((RessourceContainer) comp);

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