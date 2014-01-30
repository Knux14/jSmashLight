package fr.Knux14.jSmashLight;

import fr.Knux14.jSmashLight.Gui.GamePanel;

public class ThreadMissclick extends Thread {

	public GamePanel gp;
	
	public ThreadMissclick (GamePanel gp) {
		this.gp = gp;
	}
	
	@Override
	public void run() {
		gp.canClick = false;
		gp.repaintCenter();
		try { sleep(1000); } catch (InterruptedException e) {}
		gp.canClick = true;
		gp.repaintCenter();
	}
	
}
