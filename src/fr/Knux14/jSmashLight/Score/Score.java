package fr.Knux14.jSmashLight.Score;

import java.io.Serializable;

public class Score  implements Serializable {
	private static final long serialVersionUID = 4802478874549396808L;
	private int score;
    private String name;

    public Score(String name, int score) {
        this.score = score;
        this.name = name;
    }
    
    public int getScore() {
        return score;
    }

    public String getName() {
        return name;
    }

}