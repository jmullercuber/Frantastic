package code.constants;


/**
 * Represents a boolean, the value given at compile time.
 * 
 * @author Joey Muller
 * @version May 18th, 2014
 */
public class BOOL_CONST extends code.Messenger
{
    private boolean constant;
    
    /**
     * Constructor for objects of class BOOL_CONST
     */
    public BOOL_CONST( boolean b )
    {
        // initialise instance variables
        constant = b;
    }
    
    public Boolean returns() {
        return new Boolean(constant);
    }
    
    public String getName() {
        String r = (constant + "");
        return r.substring(0,1).toUpperCase() + r.substring(1);
    }
}
