package code.Lindenmayer;

import code.*;
import fractals.LindenmayerSystem;
import customJPanels.Painter;
import mode.Pen;


/**
 * Generate the current fractal parameter times (default is 1).
 * So you don't have to keep generateing for long times.
 * 
 * @author Joey Muller 
 * @version June 7th, 2014
 */
public class generate extends code.Stack
{
    // instance variables
    private Painter painter;

    /**
     * Constructor for objects of class generate
     */
    public generate( Painter p )
    {
        super( new Messenger[1] );
        this.painter = p;
    }
    
    /**
     * Generates the current LndenmayerSystem param1 times.
     * If param1 represents a negative number or zero, it generates zero times.
     * If param1 is not a number or null, it generates once
     * 
     * @returns     new generations of the fractal if acclipable. -1 otherwise
     */
    public Integer act()
    {
        // Default value
        int generate = 1;
        
        // Possibly get a different value
        Messenger param = this.getParameterList()[0];
        if (param != null) {
            Object r = param.returns();
            // Don't worry, it works in Java6 or something
            if (r instanceof Double) {
                generate = (int) (((Double)r).doubleValue());
            }
            else if (r instanceof Integer) {
                generate = (Integer) r;
            }
        }
        
        // If okay, generate, and get generations so far
        int generationsSoFar = -1;
        if (painter.getCurrentMode() instanceof mode.Pen) {
            ((mode.Pen) painter.getCurrentMode()).getFractal().generate(generate);
            generationsSoFar = ((mode.Pen) painter.getCurrentMode()).getFractal().getGeneration();
        }
        
        return new Integer(generationsSoFar);
    }
    
    public String getName() {
        return "Generate";
    }
}
