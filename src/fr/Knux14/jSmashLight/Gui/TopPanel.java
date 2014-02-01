package fr.Knux14.jSmashLight.Gui;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JPanel;

import fr.Knux14.jSmashLight.Main;

public class TopPanel extends JPanel {

	private static final long serialVersionUID = -8837127881810200854L;
	GamePanel gp;
	public JLabel timelab, remainslab;
	
	public TopPanel(final GamePanel gamePanel) {
		Dimension d = new Dimension(500, 80);
		setSize(d);
		setPreferredSize(d);
		setBackground(new Color(135, 135, 135));
		setLayout(null);
		this.gp = gamePanel;
		timelab = new JLabel("Time:");
		timelab.setLocation(20, 20);
		timelab.setSize(200, 20);	
		timelab.setFont(Main.font.deriveFont(15f));
		timelab.setForeground(Color.white);
		timelab.setBackground(new Color(0, 0, 0, 0));
		add(timelab);
		
		remainslab = new JLabel("Remains: " + gamePanel.remaining);
		remainslab.setLocation(20, 40);
		remainslab.setSize(200, 20);	
		remainslab.setFont(Main.font.deriveFont(15f));
		remainslab.setForeground(Color.white);
		remainslab.setBackground(new Color(0, 0, 0, 0));
		add(remainslab);
		
	}
	
}


