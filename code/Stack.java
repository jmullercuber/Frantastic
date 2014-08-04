package code;

import java.awt.Color;

/**
 * Abstract class Stack - write a description of the class here
 * 
 * @author Joey Muller
 * @version April 10th, 2014
 */
public abstract class Stack extends CodeBlock
{
    public Stack( code.Messenger[] m ) {
        super(m);
    }
    
    // interesting methods
    public abstract Object act();
    
    public void alterDesign( transfers2.Draggable_Element d ) {
        d.setBackground(Color.RED);
    }
}
