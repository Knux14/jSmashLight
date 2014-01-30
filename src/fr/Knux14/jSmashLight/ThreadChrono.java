package fr.Knux14.jSmashLight;

import java.util.concurrent.TimeUnit;

import javax.swing.JLabel;

import fr.Knux14.jSmashLight.Gui.GamePanel;
import fr.Knux14.jSmashLight.Gui.Panel;
import fr.Knux14.jSmashLight.Gui.TopPanel;

public class ThreadChrono extends Thread {

	private GamePanel game;
	private long start;
	
	public long ms = 0, secondes = 0, minutes = 0, heures = 0;
	
	public ThreadChrono(GamePanel game) {
		this.game = game;
	}

	public void run() {
		start = System.nanoTime();
		while (game.running) {
			ms = (System.nanoTime() - start);
		    ms /= 1000000L;
			while (ms > 1000) {
				secondes ++;
				ms -= 1000;
			}
			
			while (secondes > 60) {
				minutes ++;
				secondes -= 60;
			}
			while (minutes > 60) {
				heures++;
				minutes -= 60;
			}
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {}
			updateCounters();
		}
	}
	
	public void updateCounters() {
		game.top.remainslab.setText("Coups restant: " + game.remaining);
		game.top.timelab.setText("Temps: " + heures + ":" + minutes + ":" + secondes + ":" + ms);
	}
	
}