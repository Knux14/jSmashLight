package fr.Knux14.jSmashLight.Gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

import javax.swing.JPanel;

import fr.Knux14.jSmashLight.Main;
import fr.Knux14.jSmashLight.ThreadMissclick;

public class Case extends JPanel implements MouseListener {

	private static final long serialVersionUID = 2559244312929589502L;
	public int state = 0;
	private GamePanel game;
	private int id;
	
	public Case (int id, GamePanel game) {
		this.setId(id);
		addMouseListener(this);
		this.game = game;
	}
	
	public Case getCase() {
		Random r = new Random();
		Case temp;
		do {
			temp = game.caseList.get(r.nextInt(game.caseList.size()));
		} while (temp.getId() == game.oldCase1);
		return temp;
	}
	
	public void change() {
		if (game.remaining == 1) {
			game.end();
		} else {
			setCase(0);
			game.caseList.get(game.oldCase1).setCase(2);
			Case c = getCase();
			game.oldCase1 = c.id;
			c.setCase(1);
			game.remaining--;
		}
	}
	
	public void setCase(int state) {
		this.state = state;
		repaint();
	}
	
	@Override
	public void paintComponent (Graphics g) {
		super.paintComponent(g);
		if (state == 0) {
			g.drawImage(Main.case_1, 0, 0, getWidth(), getHeight(), null);
		} else if (state == 1) {
			g.drawImage(Main.case_2, 0, 0, getWidth(), getHeight(), null);
		} else if (state == 2) {
			g.drawImage(Main.case_3, 0, 0, getWidth(), getHeight(), null);
		}
		if (!game.canClick) {
			g.setColor(new Color (249, 255, 143, 150));
			g.fillRect(0, 0, getWidth(), getHeight());
		}
	}

	@Override
	public void mouseClicked(MouseEvent arg0) { }

	@Override
	public void mouseEntered(MouseEvent arg0) {
		if (game.canClick){
			if (state == 2) {
				if (Main.gamemode.equals("slide")){
					change();
				}
			}
		}
	}

	@Override
	public void mouseExited(MouseEvent arg0) { }

	@Override
	public void mousePressed(MouseEvent arg0) { 
		if (game.canClick) {
			if (state == 2) {
				if (Main.gamemode.equals("click")){
					change();
				}
			} else {
				ThreadMissclick tmc = new ThreadMissclick(game);
				tmc.start();
			}
		}
	}

	@Override
	public void mouseReleased(MouseEvent arg0) { }

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
}
