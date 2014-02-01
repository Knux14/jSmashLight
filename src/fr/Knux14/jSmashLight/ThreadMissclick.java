package fr.Knux14.jSmashLight;

import fr.Knux14.jSmashLight.Gui.Case;
import fr.Knux14.jSmashLight.Gui.GamePanel;
import fr.Knux14.jSmashLight.Gui.Panel;

public class ThreadMissclick extends Thread {

	public GamePanel gp;
	
	public ThreadMissclick (GamePanel gp) {
		this.gp = gp;
	}
	
	@Override
	public void run() {
		gp.canClick = false;
		Panel.refreshAll();
		for (Case c : gp.caseList) {
			c.repaint();
		}
		try { sleep(1000); } catch (InterruptedException e) {}
		gp.errors++;
		gp.canClick = true;
		Panel.refreshAll();
		for (Case c : gp.caseList) {
			c.repaint();
		}
	}
	
}
