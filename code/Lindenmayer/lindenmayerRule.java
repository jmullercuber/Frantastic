package code.Lindenmayer;

import code.*;
import fractals.LindenmayerRule;

/**
 * Creates a new LindenmayerRule for Pen fractals. Should be placed directly within newLindenmayerSystem Codes
 * 
 * @author Joey Muller
 * @version May 17th, 2014 (Scratch Day)
 */
public class lindenmayerRule extends code.Stack
{
    /**
     * Constructor for objects of class newLindenmayerRule
     */
    public lindenmayerRule() {
        super( new Messenger[2] );
    }

    public LindenmayerRule act() {
        if (this.getParameterList()[0] != null && this.getParameterList()[1] != null) {
            if (this.getParameterList()[0].returns() instanceof String && this.getParameterList()[1].returns()  instanceof String) {
                return new LindenmayerRule((String) this.getParameterList()[0].returns(), (String) this.getParameterList()[1].returns());
            }
        }
        
        return new LindenmayerRule();
    }
    
    public String getName() { return "• Add a Lindenmayer Rule"; }
}
