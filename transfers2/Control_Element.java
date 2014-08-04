package transfers2;

import java.awt.*;

import code.*;

/**
 * Class Control_Element - class hosting Control Code Blocks
 * 
 * @author Joey Muller
 * @version May 13th, 2014
 */

public class Control_Element extends Stack_Element {
    public Control_Element(Control c, boolean draggable, int w) {
        super(c, draggable, w);
        
        // DnD
        new StackDropTargetListImp(this);
        
        for (int i=0; i<c.getSubBlocks().size(); i++) {
            Stack code = c.getSubBlocks().get(i);
            Stack_Element childElement;
            
            if (code instanceof Control) {
                childElement = new Control_Element((Control) code);
            }
            else {
                childElement = new Stack_Element(code);
            }
            
            this.add( childElement );
        }
    }
    
    public Control_Element(Control c) {
        this(c, true);
    }
    
    public Control_Element(Control c, boolean draggable) {
        this(c, true, 100);
    }
    
    public Control getCode() {
        return (Control) super.getCode();
    }
    
    public Component add( Component comp ) {
        super.add(comp);
        if (comp instanceof Stack_Element) {
            this.getCode().getSubBlocks().add( ((Stack_Element) comp ).getCode() );
        }
        return comp;
    }
    
    public void remove( Component comp ) {
        super.remove(comp);
        if (comp instanceof Stack_Element) {
            this.getCode().getSubBlocks().remove(
                this.getCode().getSubBlocks().indexOf(   ((Stack_Element) comp ).getCode()   )
            );
        }
    }
}