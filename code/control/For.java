package code.control;

import java.util.ArrayList;
import code.*;

/**
 * Like the three parameter fors we know
 * 
 * @author Joey Muller
 * @version May 20th, 2014
 */
public class For extends code.Control
{
    /**
     * Default constructor
     */
    public For()
    {
        super( new Messenger[3] );
    }
    
    public String act() {
        // Error handeling for different parameter types
        // within method bodies
        
        // First staement
        double start = 0;
        
        // Keep the usual for-loop structure
        for (ini(); isTrue(); di()) {
            // Don't override exec()
            // act the children
            Object e = exec();
            // unless you get a "return", or "broken"
            if (e.equals("return")){
                return "return";
            }
            if (e.equals("broken")) {
                break;
            }
        }
        
        
        return "";
    }
    
    public String getName() { return "For"; }
    
    private void ini() {
        // Do some initial stuff
        Messenger param1 = this.getParameterList()[0];
        
        if (param1 != null) {
            param1.returns();
        }
    }
    
    private boolean isTrue() {
        // Determine if the loop should continue
        Messenger param2 = this.getParameterList()[1];
        
        if (param2 != null) {
            Object r = param2.returns();
            if (r instanceof Boolean) {
                return (Boolean) r;
            }
        }
        
        // By default (advoiding infinite loops) return false
        return false;
    }
    
    private void di() {
        // Increment or something
        // Don't care what is returned
        Messenger param3 = this.getParameterList()[2];
        
        if (param3 != null) {
            param3.returns();
        }
    }
}
