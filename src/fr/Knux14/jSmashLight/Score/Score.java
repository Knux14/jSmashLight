package fr.Knux14.jSmashLight.Score;

import java.io.Serializable;

public class Score  implements Serializable {

    private static final long serialVersionUID = 4802478874549396808L;
    private Time t;
    private String name;
    private String clickmode;
    private int errors;
    private int size;
    
    public Score(String name, String clickmode, Time t, int size, int errors) {
        this.t = t;
        this.clickmode = clickmode;
        this.name = name;
        this.size = size;
        this.errors = errors;
    }
    
    public Time getTime() {
    	if (t != null)
    		return t;
    	else
    		return new Time(999999);
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
    
    public String getClickMode() {
    	return clickmode;
    }
    
}