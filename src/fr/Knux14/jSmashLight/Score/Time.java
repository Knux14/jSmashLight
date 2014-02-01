package fr.Knux14.jSmashLight.Score;

import java.io.Serializable;

public class Time implements Serializable {

	private static final long serialVersionUID = 4677778376086309537L;
	private long totalMS = 0;
	private int heures = 0, minutes = 0, secondes = 0;
	private long ms = 0;
	
	public Time (long ms) {
		actualiser (ms);
	}
	
	public void actualiser (long ms) {
		this.totalMS = ms;
		this.ms = ms;
		while (ms >= 1000) {
			secondes ++;
			ms -= 1000;
		}
		while (secondes >= 60) {
			minutes++;
			secondes -= 60;
		}
		while (minutes >= 60) {
			heures++;
			minutes -= 60;
		}
	}
	
	public int getHeures () {
		return heures;
	}
	
	public int getMinutes () {
		return minutes;
	}
	
	public int getSeconds() {
		return secondes;
	}
	
	public long getMs() {
		return ms;
	}
	
	public long getTotalMS() {
		return totalMS;
	}
	
	public String getTime() {
		return heures + ":" + minutes +":" + secondes + ":" + ms;
	}
}