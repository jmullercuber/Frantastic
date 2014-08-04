package code.Lindenmayer;

import code.*;
import fractals.LindenmayerRule;
import fractals.LindenmayerSystem;
import customJPanels.Painter;
import mode.Pen;

import java.lang.Math;
import java.util.ArrayList;

/**
 * Write a description of class newLindenmayerSystem here.
 * 
 * @author Joey Muller
 * @version May 17th, 2014 (Scratch Day)
 */
public class createLindenmayerSystem extends code.Control
{
    Painter painter;
    /**
     * One-parameter Constructor for objects of class newLindenmayerSystem
     */
    public createLindenmayerSystem( Painter p )
    {
        super( new Messenger[2] );
        this.painter = p;
    }

    public LindenmayerSystem act()
    {
        // param1 - axiom
        String axiom = "";
        Messenger param1 = this.getParameterList()[0];
        if (param1 != null) {
            Object r = param1.returns();
            if (r instanceof String) {
                axiom = (String) r;
            }
        }
        
        // param2 - generate
        int generate = 1;
        Messenger param2 = this.getParameterList()[1];
        if (param2 != null) {
            Object r = param2.returns();
            // Don't worry, it works in Java6 or something
            if (r instanceof Double) {
                generate = (int) (((Double)r).doubleValue());
            }
            else if (r instanceof Integer) {
                generate = (Integer) r;
            }
        }
        
        // create
        LindenmayerSystem lsystem = new LindenmayerSystem(axiom, exec(), generate);
        if (painter.getCurrentMode() instanceof mode.Pen) {
            painter.getCurrentMode().setFractal( lsystem );
        }
        return lsystem;
    }
    
    public ArrayList<LindenmayerRule> exec() {
        ArrayList<LindenmayerRule> ls = new ArrayList<LindenmayerRule>();
        for (Stack c : this.getSubBlocks()) {
            if (c instanceof lindenmayerRule) {
                ls.add( ((lindenmayerRule)c).act() );
            }
            // Don't do anything blocks that shouldn't be in here
        }
        return ls;
    }
    
    public String getName() { return "Create a Lindenmayer System"; }
}
