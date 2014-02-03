package fr.Knux14.jSmashLight.Gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

import fr.Knux14.jSmashLight.Main;
import fr.Knux14.jSmashLight.Score.Score;

public class PanelScore extends JPanel {

	private static final long serialVersionUID = -5666562988989443821L;
	Score scr;
	int id;
	int hours, minutes, second;

	public PanelScore (int id, Score score) {
		setSize(200, 30);
		setPreferredSize(new Dimension(200, 30));
		setBackground(new Color(135, 135, 135));
		this.scr = score;
		this.id = id;
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		if (scr.getErrors() == 0){
			g.setColor(new Color(135, 135, 135));
		} else {
			g.setColor(new Color(100, 100, 100));
		}
		g.fillRect(0, 0, getWidth(), getHeight());
		g.setColor(Color.black);
		g.setFont(Main.font.deriveFont(10f));
		g.drawString("#" + id + ": " + scr.getName(), 25, 13);
		g.drawString("Temps: " + scr.getTime().getTime(), 150, 13);
		g.drawString(scr.getSize() + "x" + scr.getSize() + " / " + scr.getClickMode(), 25, 27);
		g.drawString("Erreurs: " + (scr.getErrors() == 0 ? "Perfect!" : scr.getErrors()), 150, 27);
		g.setColor(Color.white);
		g.drawRect(1, 1, getWidth() - 1, getHeight()-1);
	}

}
