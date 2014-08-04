package code.operators;

import java.lang.Math;

/**
 * Exponentiates the first number by the second
 * 
 * @author Joey Muller
 * @version May 18th, 2014
 */
public class Exponent extends Binary_Math_Operator
{
    public Double operate( Double d1, Double d2)
    {
        return Math.pow(d1,d2);
    }
    
    public String getName() {
        return "pow";
    }
}
