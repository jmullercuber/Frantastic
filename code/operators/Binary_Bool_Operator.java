package code.operators;


/**
 * Base class for binary boolean operators
 * 
 * @author Joey Muller
 * @version May 18th, 2014
 */
public abstract class Binary_Bool_Operator extends Binary_Operator
{
    public Boolean returns()
    {
        Object r1 = getParameterList()[0].returns();
        Object r2 = getParameterList()[1].returns();
        
        if (r1 instanceof Boolean && r2 instanceof Boolean) {
            return operate( (Boolean) r1, (Boolean) r2 );
        }
        
        return false;
    }
    
    public abstract Boolean operate( Boolean d1, Boolean d2 );
}
