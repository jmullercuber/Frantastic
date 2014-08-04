package code.control;

import java.util.ArrayList;
import code.*;

/**
 * Write a description of class Repeat here.
 * 
 * @author Joey Muller
 * @version May 14th, 2014
 */
public class Repeat extends code.Control
{
    /**
     * Default constructor
     */
    public Repeat()
    {
        super( /*new ArrayList <Stack> (),*/ new Messenger[] {null}  );
    }
    
    public String act() {
        double limit = 3;
        
        // Error handeling for different parameter types
        Messenger param = this.getParameterList()[0];
        if (param != null) {
            Object r = param.returns();
            if (r instanceof Double) {
                limit = ((Double) r).doubleValue();
            }
        }
        
        
        for (int i=0; i<limit; i++) {
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
    
    public String getName() { return "Repeat"; }
}
