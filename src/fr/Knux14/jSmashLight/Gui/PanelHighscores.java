package fr.Knux14.jSmashLight.Gui;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JList;
import javax.swing.JPanel;

import fr.Knux14.jSmashLight.Main;
import fr.Knux14.jSmashLight.Score.Score;
import fr.Knux14.jSmashLight.Score.ScoreboardManager;

public class PanelHighscores extends Panel{

	private static final long serialVersionUID = -6581227857671773767L;
	int posYlogo = 10;
	int xSizeLogo = Main.logo.getWidth() / 2, ySizeLogo = Main.logo.getHeight() / 2;
	ScoreboardManager sbm;
	JList<JPanel> scorelist;
	ArrayList<Score> scoreList = new ArrayList<>();
	
	public PanelHighscores(Dimension d, Container container, Panel main) {
		super(d, container, main);
		sbm = new ScoreboardManager();
		scorelist = new JList<>();
		scorelist.setCellRenderer(new CellRenderer());
	}

	public void updateScore() {
		scoreList = sbm.getScores();
	}
	
	@Override
	public void paintComponent (Graphics g) {
		super.paintComponent(g);
		g.drawImage(Main.logo, (getWidth() / 2) - (xSizeLogo /2), posYlogo, xSizeLogo, ySizeLogo, null);
		g.setColor(new Color(140, 140, 140));
		g.drawRect(10, posYlogo + ySizeLogo + 10, getWidth() - 20, 100);
	}
	
}
