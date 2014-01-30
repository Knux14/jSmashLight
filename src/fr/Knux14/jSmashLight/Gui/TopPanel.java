package fr.Knux14.jSmashLight.Gui;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JPanel;

import fr.Knux14.jSmashLight.Main;

public class TopPanel extends JPanel {

	GamePanel gp;
	public JLabel timelab;
	
	public TopPanel(GamePanel gamePanel) {
		Dimension d = new Dimension(500, 80);
		setSize(d);
		setPreferredSize(d);
		setBackground(new Color(135, 135, 135, 135));
		setLayout(null);
		this.gp = gamePanel;
		timelab = new JLabel("Time:");
		timelab.setLocation(20, 20);
		timelab.setSize(200, 20);	
		timelab.setFont(Main.font.deriveFont(15f));
		timelab.setForeground(Color.white);
		add(timelab);
	}
}


