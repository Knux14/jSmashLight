package fr.Knux14.jSmashLight.Score;

import java.io.Serializable;
import java.util.concurrent.TimeUnit;

public class Time implements Serializable {

	private static final long serialVersionUID = 4677778376086309537L;
	private long totalMS = 0;
	private long heures = 0, minutes = 0, secondes = 0, ms = 0;
	
	public Time (long ms) {
		actualiser (ms);
	}
	
	public void actualiser (long ms) {
		this.totalMS = ms;
        long convert = totalMS;
        heures = TimeUnit.MILLISECONDS.toHours(convert);
        convert -= TimeUnit.HOURS.toMillis(heures);
        minutes = TimeUnit.MILLISECONDS.toMinutes(convert);
        convert -= TimeUnit.MINUTES.toMillis(minutes);
        secondes = TimeUnit.MILLISECONDS.toSeconds(convert);
        convert -= TimeUnit.SECONDS.toMillis(secondes);
        this.ms = convert;

	}
	
	public long getHeures () {
		return heures;
	}
	
	public long getMinutes () {
		return minutes;
	}
	
	public long getSeconds() {
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
