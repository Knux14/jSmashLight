package fr.Knux14.jSmashLight.Gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JPanel;

import fr.Knux14.jSmashLight.Main;
import fr.Knux14.jSmashLight.ThreadChrono;
import fr.Knux14.jSmashLight.ThreadMissclick;

public class GamePanel extends Panel implements MouseListener {

	private static final long serialVersionUID = -1010103893984671971L;
	private Panel main;
	private Dimension dim;
	public TopPanel top;
	private CenterPanel center;
	public boolean running;
	public int remaining = 100, errors = 0;
	public boolean canClick = true;
	public ArrayList<Case> caseList;
	public int oldCase1, oldCase2;
	public ThreadChrono tc;
	
	public GamePanel(Dimension d, Container container, final Panel mainmenu) {
		super(d, container, mainmenu);
		setLayout(new BorderLayout());
		this.main = mainmenu;
		this.dim = d;
		caseList = new ArrayList<>();
		for (int i = 0; i < Main.size * Main.size; i ++) {
			caseList.add(new Case(i, this));
		}
		
		remaining = Main.defaultRemaining;
		Random r = new Random();
		int random1 = r.nextInt(caseList.size());
		Case c1 = caseList.get(random1);
		int random2 = r.nextInt(caseList.size());
		while (random1 == random2) random2 = r.nextInt(caseList.size());
		Case c2 = caseList.get(r.nextInt(caseList.size()));

 		c1.setCase(1);
 		oldCase1 = c1.getId();
 		c2.setCase(2);
 		oldCase2 = c2.getId();

		top = new TopPanel(this);
		center = new CenterPanel(this);
		add(top, BorderLayout.NORTH);
		add(center, BorderLayout.CENTER);
		addMouseListener(this);
		running = true;
		tc = new ThreadChrono(this);
		tc.start();
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(Main.backgrd, 0, 0, null);
	}

	public void repaintTop() {
		top.repaint();
	}
	
	public void repaintCenter() {
		center.repaint();
	}

	public void end() {
		running = false;
		//tc.timer.stop();
		changePanel(new GameWin(dim, getParent(), main, this));
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		ThreadMissclick tmc = new ThreadMissclick(this);
		tmc.start();
	}

	@Override
	public void mouseEntered(MouseEvent e) {}

	@Override
	public void mouseExited(MouseEvent e) {}

	@Override
	public void mousePressed(MouseEvent e) {}

	@Override
	public void mouseReleased(MouseEvent e) {}
	
}


class CenterPanel extends JPanel {

	private static final long serialVersionUID = -3092778894123177157L;
	GamePanel gp;
	GridLayout lay;
	
	public CenterPanel(GamePanel gamePanel) {
		gp = gamePanel;
		lay = new GridLayout(Main.size, Main.size);
		setLayout(lay);
		lay.setHgap(10);
		lay.setVgap(10);
		for (Case c : gp.caseList) {
			add(c);
		}
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(Main.backgrd, 0, 0, null);
		if (!gp.canClick){
			g.setColor(new Color (249, 255, 143, 150));
			g.fillRect(0, 0, getWidth(), getHeight());
		} 
	}
}