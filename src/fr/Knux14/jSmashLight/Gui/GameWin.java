package fr.Knux14.jSmashLight.Gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import fr.Knux14.jSmashLight.Main;

public class GameWin extends Panel {

	private static final long serialVersionUID = 7576214204174364621L;
	JLabel score;
	JTextField pseudo;
	
	public GameWin(Dimension d, Container container, Panel mainmenu, final GamePanel pan) {
		super(d, container, mainmenu);
		setLayout(null);
		score = new JLabel("Votre score est: " + pan.tc.heures + ":" + pan.tc.minutes + ":" + pan.tc.secondes + ":" + pan.tc.ms);
		score.setLocation(50, 220);
		score.setSize(500, 20);
		score.setFont(Main.font.deriveFont(20f));
		score.setForeground(Color.white);
		add(score);
		JPanel pana = new JPanel();
		{
			JLabel a = new JLabel("Nom:  ");
			a.setFont(Main.font.deriveFont(20f));
			a.setForeground(Color.white);
			pseudo = new JTextField();
			pseudo.setFont(Main.font.deriveFont(17f));
			pseudo.setSize(new Dimension(400, 30));
			pana.setLayout(new BorderLayout());
			pana.add(a, BorderLayout.WEST);
			pana.add(pseudo, BorderLayout.CENTER);
			pana.setBackground(new Color(0, 0, 0, 0));
		}
		pana.setLocation(50, 300);
		pana.setSize(250, 30);
		add(pana);
		btList.add(new Button("Annuler", new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				changePanel(pan.mainmenu);
			}
		}, new Point(10, 510)));
		
		btList.add(new Button("Sauvegarder", new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				changePanel(pan.mainmenu);
			}
		}, new Point(220, 510)));
	}

}
