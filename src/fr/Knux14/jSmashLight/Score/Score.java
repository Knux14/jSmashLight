package fr.Knux14.jSmashLight.Score;

import java.io.Serializable;

public class Score  implements Serializable {

    private static final long serialVersionUID = 4802478874549396808L;
    private int time;
    private String name;
    private int errors;
    private int size;
    
    public Score(String name, int time, int size, int errors) {
        this.time = time;
        this.name = name;
        this.size = size;
        this.errors = errors;
    }
    
    public int getTime() {
        return time;
    }

    public String getName() {
        return name;
    }
    
    public int getSize() {
    	return size;
    }
    
    public int getErrors() {
    	return errors;
    }
    
}