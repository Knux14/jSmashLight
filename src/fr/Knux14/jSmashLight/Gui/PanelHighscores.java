package fr.Knux14.jSmashLight.Gui;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

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

	public PanelHighscores(Dimension d, Container container, Panel main) {
		super(d, container, main);
		sbm = new ScoreboardManager();
		scorelist = new JList<>();      // <== Cette ligne empeche le main menu de s'afficher 
		scorelist.setCellRenderer(new CellRenderer()); 
		scorelist.setBackground(Color.CYAN);
		JScrollPane jsp = new JScrollPane(scorelist);
		jsp.setBackground(Color.green);
		jsp.setLocation(getWidth() / 2 - 100, Main.logo.getHeight() + posYlogo + 10);
		int size = getHeight() - (Main.logo.getHeight() + posYlogo + 30 + Main.button_1.getHeight());
		jsp.setSize(200, size);
		add (jsp);
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
 
	//	scorelist.setModel(listModel);
	}
	
	@Override
	public void paintComponent (Graphics g) {
		super.paintComponent(g);
		g.drawImage(Main.logo, (getWidth() / 2) - (xSizeLogo /2), posYlogo, xSizeLogo, ySizeLogo, null);
	}
	
}
