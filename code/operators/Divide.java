package code.operators;


/**
 * Divides the first number by the second
 * 
 * @author Joey Muller
 * @version May 18th, 2014
 */
public class Divide extends Binary_Math_Operator
{
    public Double operate( Double d1, Double d2)
    {
        return d1/d2;
    }
    
    public String getName() {
        return "/";
    }
}
