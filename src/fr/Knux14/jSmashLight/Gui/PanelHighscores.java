package fr.Knux14.jSmashLight.Gui;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import fr.Knux14.jSmashLight.Button;
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
	ArrayList<PanelScore> scoreListPan = new ArrayList<>();

	public PanelHighscores(Dimension d, Container container, final Panel main) {
		super(d, container, main);
		setLayout(null);
		sbm = new ScoreboardManager();
		scorelist = new JList<>();    
		scorelist.setCellRenderer(new CellRenderer()); 
		JScrollPane jsp = new JScrollPane(scorelist);
		jsp.setLocation(getWidth() / 2 - 150, 200);
		int size = getHeight() - (315);
		jsp.setSize(300, size);
		add (jsp);
		scorelist.setBackground(new Color(135, 135, 135, 0));
		scorelist.setBorder(BorderFactory.createEmptyBorder());
		jsp.setBackground(new Color(135, 135, 135, 0));
		jsp.setBorder(BorderFactory.createEmptyBorder());
		btList.add(new Button("Revenir", new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				changePanel(main);				
			}
		}));
		for (int i = 0; i < btList.size(); i++) {
			btList.get(i).setLocation(getWidth() / 2 - btList.get(i).getWidth() / 2, 600 - 100);
			System.out.println(btList.get(i).getLocation().x + " " + btList.get(i).getLocation().y);
			add(btList.get(i));
		}
	}

	public void updateScore() {
		scoreList = sbm.getScores();
		for (int i = 0; i < scoreList.size(); i++) {
			PanelScore panel = new PanelScore (i+1, scoreList.get(i));
			scoreListPan.add(panel);
		}
		DefaultListModel<JPanel> listModel = new DefaultListModel<>();
		int size = scoreListPan.size();
		for(int index=0; index<size; index++)
		{
     			listModel.addElement(scoreListPan.get(index));
		}
 
		scorelist.setModel(listModel);
	}
	
	@Override
	public void paintComponent (Graphics g) {
		super.paintComponent(g);
		g.drawImage(Main.logo, (getWidth() / 2) - (xSizeLogo /2), posYlogo, xSizeLogo, ySizeLogo, null);
	}
	
}
