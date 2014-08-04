package fractals;

/**
 * A simple replacement rule
 * 
 * @author Joey Muller
 * @version PI Day 2014
 */
public class LindenmayerRule
{
    // instance variables
    private String findThis;
    private String replaceWith;

    /**
     * Constructor for objects of class LindenmayerRule
     */
    public LindenmayerRule(String from, String to)
    {
        // initialise instance variables
        this.findThis = from;
        this.replaceWith = to;
    }
    
    /**
     * Default, and therefore empty, Constructor for LindenmayerRule
     */
    public LindenmayerRule()
    {
        // reference other construcor, but with other variables
        this ("", "");
    } 

    /**
     * What to match
     * 
     * @return     String findThis
     */
    public String lookingForThis()
    {
        return findThis;
    }

    /**
     * What is replaced with
     * 
     * @return     String replaceWith
     */
    public String replacement()
    {
        return replaceWith;
    }
}
