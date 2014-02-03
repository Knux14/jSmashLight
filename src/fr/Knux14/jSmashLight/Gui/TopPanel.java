package fr.Knux14.jSmashLight.Gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JPanel;

import fr.Knux14.jSmashLight.Main;

public class TopPanel extends JPanel {

	private static final long serialVersionUID = -8837127881810200854L;
	GamePanel gp;
	public JLabel timelab, remainslab, errorsLab;
	
	public TopPanel(final GamePanel gamePanel) {
		Dimension d = new Dimension(500, 80);
		setSize(d);
		setPreferredSize(d);
		setBackground(new Color(135, 135, 135));
		setLayout(null);
		this.gp = gamePanel;
		timelab = new JLabel("Time:");
		timelab.setLocation(20, 8);
		timelab.setSize(200, 20);	
		timelab.setFont(Main.font.deriveFont(15f));
		timelab.setForeground(Color.white);
		timelab.setBackground(new Color(0, 0, 0, 0));
		add(timelab);
		
		remainslab = new JLabel("Remains: " + gamePanel.remaining);
		remainslab.setLocation(20, 28);
		remainslab.setSize(200, 20);	
		remainslab.setFont(Main.font.deriveFont(15f));
		remainslab.setForeground(Color.white);
		remainslab.setBackground(new Color(0, 0, 0, 0));
		add(remainslab);
		
		errorsLab = new JLabel("Errors: " + gamePanel.errors);
		errorsLab.setLocation(20, 48);
		errorsLab.setSize(200, 20);	
		errorsLab.setFont(Main.font.deriveFont(15f));
		errorsLab.setForeground(Color.white);
		errorsLab.setBackground(new Color(0, 0, 0, 0));
		add(errorsLab);

		add(new Button("Quitter", new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				gamePanel.running = false;
				gamePanel.tc.timer.stop();
				gamePanel.changePanel(gamePanel.mainmenu);
			}		
		}, new Point(280, 5)));
	}
	
}


