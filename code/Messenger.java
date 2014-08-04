package code;

import java.awt.Color;

/**
 * Abstract class Messenger - write a description of the class here
 * 
 * @author Joey Muller
 * @version May 13th, 2014
 */
public abstract class Messenger extends CodeBlock
{
    public Messenger() {
        super();
    }
    
    public Messenger( Messenger[] m ) {
        super(m);
    }
    
    public abstract Object returns();
    
    public void alterDesign( transfers2.Draggable_Element d ) {
        d.setBackground(Color.GREEN);
    }
}
