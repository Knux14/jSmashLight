package fr.Knux14.jSmashLight.Gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

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
		g.setColor(new Color(135, 135, 135));
		g.fillRect(0, 0, getWidth(), getHeight());
		g.setColor(Color.black);
		g.drawString("#" + id + ": " + scr.getName(), 25, 15);
		g.drawString("Temps: " + getStringTime(), 150, 15);
		g.setColor(Color.white);
		g.drawRect(1, 1, getWidth() - 1, getHeight()-1);
	}
	
	public String getStringTime () {
		second = scr.getTime() / 60;
		while (second > 60) {
			second -= 60;
			minutes++;
		}
		while (minutes > 60) {
			minutes -= 60;
			hours++;
		}
		return hours + ":" + minutes + ":" + second;
	}

}
