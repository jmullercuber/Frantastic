package transfers2;

import code.*;

/**
 * Abstract class Draggable_Element - class about dragging
 * 
 * @author Joey Muller
 * @version February 27th, 2014
 */

public class Stack_Element extends Draggable_Element {
    public Stack_Element(Stack c) {
        this(c, true);
    }
    
    public Stack_Element(Stack c, boolean draggable) {
        this(c, draggable, 100);
    }
    
    public Stack_Element(Stack c, boolean draggable, int w) {
        super(c, draggable, w);
    }
    
    public Stack getCode() {
        return (Stack) super.getCode();
    }
}