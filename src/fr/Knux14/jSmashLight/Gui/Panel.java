package fr.Knux14.jSmashLight.Gui;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JPanel;

import fr.Knux14.jSmashLight.Button;
import fr.Knux14.jSmashLight.Main;

public class Panel extends JPanel {

	private static final long serialVersionUID = 9109392102093195371L;
	Container parent;
	protected ArrayList<Button> btList;
	Panel mainmenu;
	
	public Panel (Dimension d, Container container, Panel mainmenu) {
		this.parent = container;
		this.mainmenu = mainmenu;
		setSize(d);
		setPreferredSize(d);
		btList = new ArrayList<>();
	}
	
	public void paintComponent(Graphics g) {
		g.drawImage(Main.backgrd, 0, 0, null);
	}
	
}
