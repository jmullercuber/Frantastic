package code.variables;

import code.*;

/**
 * Assigns the variable parameter on one side to the one on the other
 * 
 * @author Joey Muller
 * @version May 20th, 2014
 */
public class Assignment extends Messenger
{
    // instance variables - replace the example below with your own
    private int x;

    /**
     * Constructor for objects of class Assignment
     */
    public Assignment()
    {
        super( new Messenger[2] );
    }

    public Object returns()
    {
        Messenger thing1 = getParameterList()[0];
        Object r2 = getParameterList()[1].returns();
        
        if (thing1 instanceof Variable && r2 != null) {
            ((Variable) thing1).setValue( r2 );
            return r2;
        }
        else {
            return null;
        }
    }
    
    public String getName() {
        return "=";
    }
}