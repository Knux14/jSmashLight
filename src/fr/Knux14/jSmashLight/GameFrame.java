package fr.Knux14.jSmashLight;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class GameFrame extends JFrame {

	private static final long serialVersionUID = -2313721093529685401L;

	public GameFrame() {
		setSize(500, 600);
		setTitle("jSmashLight");
		setLocationRelativeTo(null);
		setDefaultCloseOperation(3);
		setVisible(true);
		add(new MainMenuPanel());
	}
	
}

class MainMenuPanel extends JPanel {

	private static final long serialVersionUID = 8505092482254750780L;
	Button play, options, exit;
	
	public MainMenuPanel() {
		play = new Button("Jouer", new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
								
			}
			
		});
		
		options = new Button("Options", new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
								
			}
			
		});
		
		exit = new Button("Quitter", new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
			
		});
	}
	
	@Override
	public void paintComponent(Graphics g) {
		g.setColor(Color.black);
		g.drawRect(0, 0, getWidth(), getHeight());
		g.drawImage(Main.backgrd, 0, 0, null);
	}
	
}