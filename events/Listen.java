package events;

import mode.Mode;
import customJPanels.Painter;


/**
 * Abstract class that is a base for interacting with the Painter and Modes
 * 
 * @author Joey Muller
 * @version May 8th, 2014
 */
public abstract class Listen
{
    Mode[] modes;
    int currentModeIndex;
    Painter painter;
    
    /**
     * Constructor for children of class Listen
     */
    public Listen(Mode[] m, Painter p)
    {
        // initialise instance variables
        modes = m;
        currentModeIndex = 0;
        painter = p;
    }
    
    public void setModeIndex(int i) {
        currentModeIndex = i;
    }
    
    public Painter getPainter() {
        return painter;
    }
    
    public Mode getCurrentMode() {
        return modes[currentModeIndex];
    }
}
