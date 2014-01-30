package fr.Knux14.jSmashLight.Gui;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;

import fr.Knux14.jSmashLight.Main;

public class Case extends JPanel implements MouseListener {

	private static final long serialVersionUID = 2559244312929589502L;
	public int state = 0;
	private GamePanel game;
	
	public Case (GamePanel game, int state) {
		Dimension dim = new Dimension(64, 64);
		setSize(dim);
		setPreferredSize(dim);
		this.state = state;
		addMouseListener(this);
		this.game = game;
	}
	
	public void change() {
		
	}
	
	public void setCase(int state) {
		this.state = state;
		repaint();
	}
	
	@Override
	public void paintComponent (Graphics g) {
		switch(state) {
		case 1:
			g.drawImage(Main.case_2, 0, 0, null);
		case 2:
			g.drawImage(Main.case_3, 0, 0, null);
		default:
			g.drawImage(Main.case_1, 0, 0, null);
		}
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		if (Main.gamemode.equals("click")){
			change();
		}
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		if (Main.gamemode.equals("slide")){
			change();
		}
	}

	@Override
	public void mouseExited(MouseEvent arg0) { }

	@Override
	public void mousePressed(MouseEvent arg0) { }

	@Override
	public void mouseReleased(MouseEvent arg0) { }
	
}
