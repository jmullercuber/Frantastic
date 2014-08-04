package code.output;

import code.*;

/**
 * A block that prints a message to the console
 * 
 * @author Joey Muller
 * @version May 14th, 2014
 */
public class Say extends Stack
{
    // instance variable
    private String saythis;
    
    /**
     * Constructor for objects of class Say
     */
    public Say(String s)
    {
        super( new Messenger[]{} );
        // initialise instance variable
        saythis = s;
    }
    
    public String act()
    {
        System.out.println(saythis);
        return "";
    }
    
    public String getName() { return "Say: " + saythis; }
}
