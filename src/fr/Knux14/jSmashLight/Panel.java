package fr.Knux14.jSmashLight;

import java.awt.Dimension;

import javax.swing.JPanel;

public class Panel extends JPanel {

	private static final long serialVersionUID = 9109392102093195371L;
	JPanel parent;
	
	public Panel (Dimension d, JPanel parent) {
		this.parent = parent;
		setSize(d);
		setPreferredSize(d);
	}
	
}
