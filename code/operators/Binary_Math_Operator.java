package code.operators;


/**
 * Base class for elementary math operators
 * 
 * @author Joey Muller
 * @version May 18th, 2014
 */
public abstract class Binary_Math_Operator extends Binary_Operator
{
    public Object returns()
    {
        Object r1 = getParameterList()[0].returns();
        Object r2 = getParameterList()[1].returns();
        
        if (r1 instanceof Double && r2 instanceof Double) {
            return operate( (Double) r1, (Double) r2 );
        }
        
        return 1.0;
    }
    
    public abstract Object operate( Double d1, Double d2 );
}
