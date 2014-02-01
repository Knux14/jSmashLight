package fr.Knux14.jSmashLight;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

import fr.Knux14.jSmashLight.Gui.GamePanel;

public class ThreadChrono {

	private GamePanel game;
	private Timer timer;
	
	public int ms = 0, secondes = 0, minutes = 0, heures = 0;
	
	
	public ThreadChrono(GamePanel game) {
		this.game = game;
		this.timer = new Timer(1, new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				ms++;
				if (ms == 1000) {
					ms = 0;
					secondes++;
				}
				if (secondes == 60) {
					secondes = 0;
					minutes++;
				}
				if (minutes == 60) {
					minutes = 0;
					heures ++;
				}
			}
			
		});
		timer.start();
	}
	
	public void updateCounters() {
		game.top.remainslab.setText("Coups restant: " + game.remaining);
		game.top.timelab.setText("Temps: " + heures + ":" + minutes + ":" + secondes + ":" + ms);
		game.top.errorsLab.setText("Erreurs: " + game.errors);
	}

	public int getScore() {
		return ms + secondes * 1000 + minutes * 60000 + heures * 60*60000;
	}
	
}