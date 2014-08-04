package code.operators;


/**
 * Determines if the first number is smaller
 * 
 * @author Joey Muller
 * @version May 18th, 2014
 */
public class LessThan extends Binary_Math_Operator
{
    public Boolean operate( Double d1, Double d2)
    {
        return d1<d2;
    }
    
    public String getName() {
        return "<";
    }
}