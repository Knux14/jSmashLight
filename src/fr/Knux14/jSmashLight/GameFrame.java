package fr.Knux14.jSmashLight;

import java.awt.Color;
import java.awt.Dimension;
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
		setResizable(false);
		add(new MainMenuPanel(getSize()));
	}
	
}

class MainMenuPanel extends Panel {

	private static final long serialVersionUID = 8505092482254750780L;
	Button[] bt = new Button[4];
	int posYlogo = 10;
	int xSizeLogo = Main.logo.getWidth() / 2, ySizeLogo = Main.logo.getHeight() / 2;

	public MainMenuPanel(Dimension d) {
		super(d, null);
		bt[0] = new Button("Jouer", new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
								
			}
			
		});
		
		bt[1] = new Button("Options", new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
								
			}
			
		});
		
		bt[2] = new Button("Scores", new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
								
			}
			
		});
		
		bt[3] = new Button("Quitter", new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
			
		});
		setLayout(null);
		
		for (int i = 0; i < bt.length; i++) {
			bt[i].setLocation(getWidth() / 2 - bt[i].getWidth() / 2, posYlogo + ySizeLogo + 50 + (Main.button_1.getHeight() + 20)  * i);
			add(bt[i]);
		}
	}
	
	public void changePanel(JPanel newPan)
	{
		getParent().remove(this);
		getParent().add(new Panel(this.getSize(), this));
	}
	
	@Override
	public void paintComponent(Graphics g) {
		g.setColor(Color.black);
		g.drawRect(0, 0, getWidth(), getHeight());
		g.drawImage(Main.backgrd, 0, 0, null);
		g.drawImage(Main.logo, (getWidth() / 2) - (xSizeLogo /2), posYlogo, xSizeLogo, ySizeLogo, null);
	}
	
}