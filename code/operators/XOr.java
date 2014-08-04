package code.operators;


/**
 * Xors two booleans, analogous to Java's ^, or !=
 * 
 * @author Joey Muller
 * @version May 18th, 2014
 */
public class XOr extends Binary_Bool_Operator
{
    public Boolean operate( Boolean d1, Boolean d2)
    {
        return d1!=d2;
    }
    
    public String getName() {
        return "^";
    }
}
