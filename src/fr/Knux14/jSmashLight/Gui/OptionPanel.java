package fr.Knux14.jSmashLight.Gui;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JComboBox;
import javax.swing.JLabel;

import fr.Knux14.jSmashLight.Main;
import fr.Knux14.jSmashLight.Score.ScoreboardManager;

public class OptionPanel extends Panel {

	private static final long serialVersionUID = -848037696771752296L;
	int posYlogo = 10;
	int xSizeLogo = Main.logo.getWidth() / 2, ySizeLogo = Main.logo.getHeight() / 2;
	String[] str = new String[]{ "Click", "Slide" };
	JComboBox<String> combo1 = new JComboBox<>(str);
	JComboBox<Object> combo2;
	Object[] intlst;
	
	public OptionPanel(Dimension d, Container container, final Panel mainmenu) {
		super(d, container, mainmenu);
		btList.add(new Button("Revenir", new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Main.gamemode = str[combo1.getSelectedIndex()].toLowerCase();
				Main.size     = (int) intlst[combo2.getSelectedIndex()];
				Main.saveConfig();
				changePanel(mainmenu);				
			}
		}, new java.awt.Point(getWidth() / 2 - 100, 600 - 100)));
		
		JLabel lab1 = configure(new JLabel("Clickmode: "), 20, 210);
		JLabel lab2 = configure(new JLabel("Size: "), 20, 270);
		JLabel lab3 = configure(new JLabel("3x3 unlocked after 20 plays, 2x2 after 40"), 20, 240);
		combo1.setLocation(200, 210);
		combo1.setSize(200, 20);
		
		ScoreboardManager scm = new ScoreboardManager();
				
		ArrayList<Integer> intlist = new ArrayList<>();
		intlist.add(5);
		intlist.add(4);
		
		if (scm.getScores().size() >= 20) {
			intlist.add(3);
		}
		
		if (scm.getScores().size() >= 40) {
			intlist.add(2);
		}
		
		intlst = intlist.toArray();
		
		combo2 = new JComboBox<>(intlst);
		combo2.setLocation(200, 270);
		combo2.setSize(200, 20);
		
		// Loading config
		{
			for (int i = 0; i < str.length; i++) {
				if (Main.gamemode.equalsIgnoreCase(str[i])) 
					combo1.setSelectedIndex(i);
			}
			
			for (int i = 0; i < intlst.length; i++) {
				if (Main.size == (int)intlst[i]) 
					combo2.setSelectedIndex(i);
			}
		}
		
		
		add(lab1);
		add(lab2);
		add(lab3);
		add(combo1);
		add(combo2);
		initButtons();
	}

	public JLabel configure(JLabel lab, int posX, int posY) {
		lab.setFont(Main.font.deriveFont(15f));
		lab.setLocation(posX, posY);
		lab.setSize (800, 20);
		lab.setForeground(Color.white);
		lab.setBackground(new Color(0, 0, 0, 0));
		return lab;
	}
	
	@Override
	public void paintComponent (Graphics g) {
		super.paintComponent(g);
		g.drawImage(Main.logo, (getWidth() / 2) - (xSizeLogo /2), posYlogo, xSizeLogo, ySizeLogo, null);
	}
	
	
}
