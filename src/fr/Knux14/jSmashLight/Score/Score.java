package fr.Knux14.jSmashLight.Score;

import java.io.Serializable;

public class Score  implements Serializable {

    private static final long serialVersionUID = 4802478874549396808L;
    private int time;
    private String name;

    public Score(String name, int time) {
        this.time = time;
        this.name = name;
    }
    
    public int getTime() {
        return time;
    }

    public String getName() {
        return name;
    }
    
}