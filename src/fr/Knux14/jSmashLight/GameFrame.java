package fr.Knux14.jSmashLight;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import fr.Knux14.jSmashLight.Gui.Panel;
import fr.Knux14.jSmashLight.Gui.PanelHighscores;

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
	int posYlogo = 10;
	int xSizeLogo = Main.logo.getWidth() / 2, ySizeLogo = Main.logo.getHeight() / 2;
	PanelHighscores score;
	
	public MainMenuPanel(Dimension d) {
		super(d, null, null);
		score = new PanelHighscores(d, getParent(), this);
		btList.add(new Button("Jouer", new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
								
			}
			
		}));
		
		btList.add(new Button("Options", new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
								
			}
			
		}));
		
		btList.add(new Button("Scores", new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				score.updateScore();
				changePanel(score);
			}
			
		}));
		
		btList.add(new Button("Quitter", new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
			
		}));
		setLayout(null);
		for (int i = 0; i < btList.size(); i++) {
			btList.get(i).setLocation(getWidth() / 2 - btList.get(i).getWidth() / 2, posYlogo + ySizeLogo + 50 + (Main.button_1.getHeight() + 20)  * i);
			add(btList.get(i));
		}
	}

	public void changePanel(Panel newPan)
	{
		Container c = getParent();
		c.add(newPan);
		c.remove(this);
		c.revalidate();
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.black);
		g.drawRect(0, 0, getWidth(), getHeight());
		g.drawImage(Main.logo, (getWidth() / 2) - (xSizeLogo /2), posYlogo, xSizeLogo, ySizeLogo, null);
	}
	
}