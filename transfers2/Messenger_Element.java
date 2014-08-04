package transfers2;

import code.*;

/**
 * Abstract class Draggable_Element - class about dragging
 * 
 * @author Joey Muller
 * @version February 27th, 2014
 */

public class Messenger_Element extends Draggable_Element {
    public Messenger_Element(Messenger c) {
        super(c);
    }
    
    public Messenger getCode() {
        return (Messenger) super.getCode();
    }
}