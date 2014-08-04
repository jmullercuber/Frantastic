package code.output;

import code.*;

/**
 * A block that prints parameter to the console
 * 
 * @author Joey Muller
 * @version May 18th, 2014
 */
public class SayParam extends Stack
{
    /**
     * Constructor for objects of class Say
     */
    public SayParam()
    {
        super( new Messenger[]{null} );
    }
    
    public String act()
    {
        if (getParameterList()[0] != null) {
            System.out.println(getParameterList()[0].returns());
        }
        else {
            // Don't do anything
        }
        return "";
    }
    
    public String getName() { return "Say"; }
}
