package code.operators;


/**
 * Determines if the first number is equal to the second
 * 
 * @author Joey Muller
 * @version May 18th, 2014
 */
public class EqualTo extends Binary_Math_Operator
{
    public Boolean operate( Double d1, Double d2)
    {
        // This is the only implemntsation where I actually consider that d1 and d2 are Doubles, not doubles
        return d1.equals(d2);
    }
    
    public String getName() {
        return "==";
    }
}