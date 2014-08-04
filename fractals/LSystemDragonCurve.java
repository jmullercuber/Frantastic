package fractals;

import java.util.ArrayList;
/**
 * Ready-made Lindermayer System for the Dragon Curve
 * On Gabe's wate rbottle
 * 
 * @author Joey Muller 
 * @version PI Day 2014
 */
public class LSystemDragonCurve extends LindenmayerSystem
{
    /**
     * Constructor for objects of class LSystemKochCurve
     */
    public LSystemDragonCurve(int i)
    {
        // nothing new...
        super(
            "FX",
            new ArrayList<LindenmayerRule>(){{
                add( new LindenmayerRule("X", "X+YF") );
                add( new LindenmayerRule("Y", "FX-Y") );
            }},
            i
        );
    }
    
    /**
     * Default Constructor
     */
    public LSystemDragonCurve()
    {
        this(0);
    }
}