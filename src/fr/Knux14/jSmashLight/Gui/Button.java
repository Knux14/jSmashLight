package fr.Knux14.jSmashLight.Gui;

import java.awt.Color;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

import fr.Knux14.jSmashLight.Main;

public class Button extends JPanel implements MouseListener {

	private static final long serialVersionUID = 2856490418850100776L;
	private String title;
	private ActionListener action;
	private BufferedImage img;
	private boolean isClic;
	
	public Button(String title, ActionListener act, Point point) {
		this.setSize(Main.button_1.getWidth(), Main.button_1.getHeight());
		this.title = title;
		this.action = act;
		img = Main.button_1;
		isClic = false;
		addMouseListener(this);
		setBackground(new Color(0f, 0f, 0f, 0f));
		setLocation(point);
	}
	
	
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(img, 0, 0, getWidth(), getHeight(), null);
		g.setFont(Main.font.deriveFont(24f));
		g.setColor(Color.white);
		FontMetrics fm = g.getFontMetrics();
		int x = (getWidth() - fm.stringWidth(title)) / 2;
		int y = (fm.getAscent() + (getHeight() - (fm.getAscent() + fm.getDescent())) / 2);
		g.drawString(title, x, y);
	}



	@Override
	public void mouseClicked(MouseEvent arg0) {
		img = Main.button_3;
		action.actionPerformed(null);
		Panel.refreshAll();
		repaint();
	}



	@Override
	public void mouseEntered(MouseEvent arg0) {
		if (isClic){
			img = Main.button_3;
		} else {
			img = Main.button_2;
		}
		Panel.refreshAll();
		repaint();
	}



	@Override
	public void mouseExited(MouseEvent arg0) {
		img = Main.button_1;
		Panel.refreshAll();
		repaint();
	}



	@Override
	public void mousePressed(MouseEvent arg0) {
		img = Main.button_3;		
		isClic = true;
		Panel.refreshAll();
		repaint();
	}



	@Override
	public void mouseReleased(MouseEvent arg0) {
		if (isIn(arg0)) {
			img = Main.button_2; 
		} else {
			img = Main.button_1;
		}
		isClic = false;
		Panel.refreshAll();
		repaint();
	}
	
	private boolean isIn (MouseEvent e) {
		Point ScreenLoca = getLocationOnScreen();				
		Point EventLoca = e.getLocationOnScreen();
		if (EventLoca.x > ScreenLoca.x && EventLoca.x < (ScreenLoca.x + getWidth())){
			if (EventLoca.y > ScreenLoca.y && EventLoca.y < (ScreenLoca.y + getHeight())){
				return true;
			}
		}			
		return false;
	}
	
}
