package fractals;

/**
 * Ready-made Lindermayer System for the Koch Curve
 * Lookslike a snowflake
 * 
 * @author Joey Muller 
 * @version PI Day 2014
 */
public class LSystemKochCurve extends LindenmayerSystem
{
    /**
     * Constructor for objects of class LSystemKochCurve
     * Optional to pre-generate
     */
    public LSystemKochCurve(int i)
    {
        // nothing new...
        super(
            "F",
            new LindenmayerRule("F", "F+F-F-F+F"),
            i
        );
    }
    
    /**
     * Default Constructor
     */
    public LSystemKochCurve()
    {
        this(0);
    }
}
