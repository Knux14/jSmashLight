package fr.Knux14.jSmashLight;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

import fr.Knux14.jSmashLight.Gui.GamePanel;
import fr.Knux14.jSmashLight.Score.Time;

public class ThreadChrono {

	private GamePanel game;
	private Timer timer;
	
	public long ms;
	public Time time;
	
	public ThreadChrono(GamePanel game) {
		this.game = game;
		time = new Time(0);
		this.timer = new Timer(1, new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				ms++;
			}
			
		});
		timer.start();
	}
	
	public void updateCounters() {
		time.actualiser(ms);
		game.top.remainslab.setText("Coups restant: " + game.remaining);
		game.top.timelab.setText("Temps: " + time.getTime());
		game.top.errorsLab.setText("Erreurs: " + game.errors);
	}
	
	public void stopTimer() {
		timer.stop();
	}
	
}