package code.control;

import java.util.ArrayList;
import code.*;

/**
 * Write a description of class Repeat here.
 * 
 * @author Joey Muller
 * @version May 14th, 2014
 */
public class If extends code.Control
{
    /**
     * Default constructor
     */
    public If()
    {
        super( /*new ArrayList <Stack> (),*/ new Messenger[] {null}  );
    }
    
    public String act() {
        boolean doif = true;
        
        // Error handeling for different parameter types
        Messenger param = this.getParameterList()[0];
        if (param != null) {
            Object r = param.returns();
            if (r instanceof Boolean) {
                doif = ((Boolean) r).booleanValue();
            }
        }
        
        
        if (doif) {
            // Don't override exec()
            // act the children
            Object e = exec();
            // unless you get a "return", or "broken"
            // With Ifs, you pass "return" AND "broken" up
            if (e.equals("return")){
                return "return";
            }
            if (e.equals("broken")) {
                return "broken";
            }
        }
        
        
        return "";
    }
    
    public String getName() { return "If"; }
}
