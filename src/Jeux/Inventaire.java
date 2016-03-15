package Jeux;

import java.util.ArrayList;
import java.util.LinkedList;

import javax.swing.JComponent;
import javax.swing.JPanel;

import Bloc.RessourceContainer;

public class Inventaire extends JPanel{
	private LinkedList<RessourceContainer> inv=new LinkedList<RessourceContainer>();

	public LinkedList<RessourceContainer> getinv() {
		return inv;
	}
}
