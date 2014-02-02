package fr.Knux14.jSmashLight.Score;

import java.io.Serializable;
import java.util.concurrent.TimeUnit;

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
        heures = (int)TimeUnit.MILLISECONDS.toHours(totalMS);
        totalMS -= TimeUnit.HOURS.toMillis(totalMS);
        minutes = (int)TimeUnit.MILLISECONDS.toMinutes(totalMS);
        totalMS -= TimeUnit.MINUTES.toMillis(minutes);
        secondes = (int)TimeUnit.MILLISECONDS.toSeconds(totalMS);
		ms = (int)(totalMS - TimeUnit.SECONDS.toMillis(secondes));
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
		return String.format("%d:%d:%d:%d", heures, minutes, secondes, ms);
	}
}
