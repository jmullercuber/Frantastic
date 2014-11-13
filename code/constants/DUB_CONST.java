package code.constants;


/**
 * Represents an int, the value given as a paramter at complie-time
 * 
 * @author Joey Muller
 * @version May 16th, 2014
 */
public class DUB_CONST extends code.Messenger
{
    private double constant;
    
    /**
     * Constructor for objects of class DUB_CONST
     */
    public DUB_CONST( double i ) {
        constant = i;
    }
    
    public Double returns() {
        return new Double(constant);
    }
    
    public String getName() { return constant + ""; }
}
