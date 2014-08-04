package transfers2;

import java.awt.*;
import java.awt.dnd.*;
import javax.swing.*;

import code.*;

/**
 * Abstract class Draggable_Element - class about dragging
 * 
 * @author Joey Muller
 * @version February 27th, 2014
 */

public abstract class Draggable_Element extends JPanel {
    private CodeBlock associatedCode;
    private JLabel words;
    private int width = 100;
    private Message_Holder[] holders;
    
    public Draggable_Element(CodeBlock c, boolean draggable, int w) {
        super();
        setOpaque(true);
        setBackground(Color.LIGHT_GRAY);
        setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        this.add( words = new JLabel() );
        associatedCode = c;
        words.setText(c.getName());
        c.alterDesign( this );
        this.width = w;
        
        // Parameters
        Messenger[] params = c.getParameterList();
        holders = new Message_Holder[ c.getParameterList().length ];
        for (int i=0; i<params.length; i++) {
            Messenger_Element elem = null;
            if ( params[i] != null) {
                elem = new Messenger_Element( params[i] );
            } 
            
            Message_Holder placeholder = new Message_Holder(elem, i, c.getParameterList());
            holders[i] = placeholder;
            this.add( placeholder );
        }
        // Fix Size
        setPreferredSize( getPreferredSize() );
        
        // DnD
        if (draggable) {
            DragSource ds = new DragSource();
            ds.createDefaultDragGestureRecognizer(
                this,
                DnDConstants.ACTION_MOVE,
                new DraggingListener()
            );
        }
    }
    
    public Draggable_Element(CodeBlock c, boolean draggable) {
        this(c, draggable, 100);
    }
    
    public Draggable_Element(CodeBlock c) {
        this(c, true);
    }
    
    public boolean setParameterAt( int i, Messenger_Element p) {
        if (0 <= i && i < holders.length) {
            holders[i].add( p );
            return true;
        }
        return false;
    }
    
    // Needed so that I can fill stuff at compile time.
    // Only MessengerTextBoxs should use this...
    public Message_Holder getHolderAt( int i ) {
        // I could make it quietly handle errors...
        return holders[i];
    }
    
    public void setText(String s) {
        words.setText(s);
    }
    
    public int getWidth() {
        return width;
    }
    
    public void setWidth(int w) {
        width = w;
    }
    
    public Dimension getPreferredSize(){
        // find height of children
        int childHeight = 0;
        for (Component c : getComponents()) {
            childHeight += c.getPreferredSize().getHeight() + 5;   // five for border
        }
        
        //return new Dimension(width, 30 + (associatedCode.getOverallBlocks())*50);
        return new Dimension(width, 10 + childHeight);
    }
    
    public int spacing() {
        if (getParent() instanceof Draggable_Element) {
            return ((Draggable_Element) getParent()).spacing();
        }
        else {
            return 10;
        }
    }
    
    public void updateSize() {
        width = (int) getParent().getPreferredSize().getWidth();
        if (getParent() instanceof Draggable_Element) {
            width -= ((Draggable_Element) getParent()).spacing();
        }
        setPreferredSize( getPreferredSize() );
        
        if (getParent() instanceof Draggable_Element) {
            ((Draggable_Element) getParent()).updateSize();
        }
        // Below doesn't do anything right now
        else {
            getParent().setPreferredSize(
                new Dimension(
                    (int) getParent().getPreferredSize().getWidth(),
                    (int) this.getPreferredSize().getHeight()
                )
            );
        }
    }
    
    public void updateChildrenSize() {}
    
    public Component add(Component c) {
        // If you really wanted to use a different method
        if (c instanceof Messenger_Element) {
            // Find the first empty spot, and exit
            int i;
            for (i=0; i<holders.length; i++) {
                if (holders[i] == null) {
                    setParameterAt( i, (Messenger_Element) c );
                    i = holders.length+1;
                }
            }
            // Didn't find an empty spot
            if (i == holders.length) {
                // It failed
                return null;
            }
        }
        /*/ In the contructor, when you add placeholders
         * Not working!!! :*(
        else if (c instanceof Message_Holder) {
            super.add(c);
            ((Message_Holder)c).setWidth( getWidth()-10 );
        }*/
        // So you wanted to append an element
        else {
            super.add(c);
            if (c instanceof Draggable_Element) {
                ((Draggable_Element)c).setWidth( getWidth()-10 );
            }
        }
        return c;
    }
    
    public CodeBlock getCode() {
        return associatedCode;
    }
    
    public boolean isGrandparent(Container me, Container c) {
        // If you're at the end of the line, and still have no parent match
        if (me.getParent() == null) {
            return false;
        }
        
        // There is a match
        if (me.getParent().equals(c)) {
            return true;
        }
        
        // Keep looking!
        return isGrandparent(me.getParent(), c);
    }
}