package code.operators;


/**
 * Determines if the first number is bigger
 * 
 * @author Joey Muller
 * @version May 18th, 2014
 */
public class GreaterThan extends Binary_Math_Operator
{
    public Boolean operate( Double d1, Double d2)
    {
        return d1>d2;
    }
    
    public String getName() {
        return ">";
    }
}