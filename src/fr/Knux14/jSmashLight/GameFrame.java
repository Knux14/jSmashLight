package fr.Knux14.jSmashLight;

import java.awt.Color;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import javax.swing.JFrame;
import javax.swing.JLabel;

import fr.Knux14.jSmashLight.Gui.Button;
import fr.Knux14.jSmashLight.Gui.GamePanel;
import fr.Knux14.jSmashLight.Gui.OptionPanel;
import fr.Knux14.jSmashLight.Gui.Panel;
import fr.Knux14.jSmashLight.Gui.PanelHighscores;

public class GameFrame extends JFrame {

	private static final long serialVersionUID = -2313721093529685401L;

	public GameFrame() {
		setSize(500, 600);
		setTitle("jSmashLights");
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
	
	public MainMenuPanel(final Dimension d) {
		super(d, null, null);
		final MainMenuPanel instance = this;
		
		btList.add(new Button("Jouer", new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				GamePanel gamepan = new GamePanel(d, getParent(), instance);
				changePanel(gamepan);
			}
			
		}, new Point(getWidth() / 2 - 100, posYlogo + ySizeLogo + 50 + (Main.button_1.getHeight() + 20)- 80)));
		
		btList.add(new Button("Options", new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
					changePanel(new OptionPanel(d, getParent(), instance));
			}
			
		}, new Point(getWidth() / 2 - 100, posYlogo + ySizeLogo + 50 + (Main.button_1.getHeight() + 20))));
		
		btList.add(new Button("Scores", new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				PanelHighscores score = new PanelHighscores(d, getParent(), instance);
				score.updateScore();
				changePanel(score);
			}
			
		}, new Point(getWidth() / 2 - 100, posYlogo + ySizeLogo + 50 + (Main.button_1.getHeight() + 20) * 2)));
		
		btList.add(new Button("Quitter", new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
			
		}, new Point (getWidth() / 2 - 100, posYlogo + ySizeLogo + 50 + (Main.button_1.getHeight() + 20) * 3)));
		JLabel lab = new JLabel("http://feedtheknux.url.ph/");
		lab.setLocation(10, 555);
		lab.setSize(200, 10);
		lab.setFont(Main.font.deriveFont(12f));
		lab.setForeground(Color.white);
		lab.addMouseListener(new MouseListener() {
			@Override
			public void mouseReleased(MouseEvent arg0) { }
			@Override
			public void mousePressed(MouseEvent arg0) { }
			@Override
			public void mouseExited(MouseEvent arg0) { }
			@Override
			public void mouseEntered(MouseEvent arg0) { }
			
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try {
					Desktop.getDesktop().browse(new URI("http://feedtheknux.url.ph/"));
				} catch (IOException | URISyntaxException e) {
					e.printStackTrace();
				}
			}
		});
		add(lab);
		
		JLabel lab2 = new JLabel("Infos");
		lab2.setLocation(getWidth() - 50, 555);
		lab2.setSize(80, 10);
		lab2.setFont(Main.font.deriveFont(12f));
		lab2.setForeground(Color.white);
		lab2.addMouseListener(new MouseListener() {
			@Override
			public void mouseReleased(MouseEvent arg0) { }
			@Override
			public void mousePressed(MouseEvent arg0) { }
			@Override
			public void mouseExited(MouseEvent arg0) { }
			@Override
			public void mouseEntered(MouseEvent arg0) { }
			
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try {
					Desktop.getDesktop().browse(new URI("http://feedtheknux.url.ph/jsl.html"));
				} catch (IOException | URISyntaxException e) {
					e.printStackTrace();
				}
			}
		});
		add(lab2);
		initButtons();
		repaint();
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.black);
		g.drawRect(0, 0, getWidth(), getHeight());
		g.drawImage(Main.logo, (getWidth() / 2) - (xSizeLogo /2), posYlogo, xSizeLogo, ySizeLogo, null);
		g.setColor(new Color(135, 135, 135));
		String title = "Version 2.0 - Rewritten", website = "http://feedtheknux.url.ph/";
		FontMetrics fm = g.getFontMetrics();
		int x = (getWidth() - fm.stringWidth(title)) / 2, x2 = (getWidth() - fm.stringWidth(title)) / 2;
		g.drawString(title, 10, 550);
		//g.drawString(website, 10, 565);
		
	}
	
}