package fr.Knux14.jSmashLight;

import java.util.concurrent.TimeUnit;

import javax.swing.JLabel;

import fr.Knux14.jSmashLight.Gui.GamePanel;
import fr.Knux14.jSmashLight.Gui.Panel;
import fr.Knux14.jSmashLight.Gui.TopPanel;

public class ThreadChrono extends Thread {

	  long startTime;
	  long ms;
	  long sec;
	  long min;
	  boolean gameRunning;
	  JLabel toUpdate;

	  public ThreadChrono (GamePanel game, TopPanel pan) {
		  this.gameRunning = game.running;
		  this.toUpdate = pan.timelab;
	  }
	  
	  public void run()
	  {
	    startTime = System.nanoTime();
	    sec = 0L;
	    min = 0L;
	    while (gameRunning) {
	      ms = (System.nanoTime() - startTime);
	      ms /= 1000000L;
	      if (ms >= 1000L) {
	        sec += 1L;
	        ms -= 1000L;
	      }
	      if (sec >= 60L) {
	        sec -= 60L;
	        min += 1L;
	      }
	      try {
	        Thread.sleep(100L);
	      }
	      catch (InterruptedException e) {
	        e.printStackTrace();
	      }
	      
	    }
	  }
	}