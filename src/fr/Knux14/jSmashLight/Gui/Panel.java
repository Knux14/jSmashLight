package fr.Knux14.jSmashLight.Gui;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JPanel;

import fr.Knux14.jSmashLight.Main;

public class Panel extends JPanel {

	private static final long serialVersionUID = 9109392102093195371L;
	private static ArrayList<Panel> panelList = new ArrayList<>();
	Container parent;
	protected ArrayList<Button> btList;
	Panel mainmenu;
	
	public Panel (Dimension d, Container container, final Panel mainmenu) {
		setLayout(null);
		this.parent = container;
		this.mainmenu = mainmenu;
		setSize(d);
		setPreferredSize(d);
		btList = new ArrayList<>();
		panelList.add(this);
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(Main.backgrd, 0, 0, getWidth(), getHeight(), null);
	}

	public void changePanel(Panel newPan)
	{
		Container c = getParent();
		c.add(newPan);
		c.remove(this);
		c.revalidate();
		newPan.repaint();
		for (Button b : newPan.btList) {
			b.repaint();
		}
	}
	
	public void initButtons() {
		for (Button b : btList) {
			add(b);
		}
	}
	
	public static void refreshAll() {
		for (Panel p : panelList) {
			p.repaint();
		}
	}
	
}
