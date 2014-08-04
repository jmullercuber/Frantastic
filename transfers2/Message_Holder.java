package transfers2;

import java.awt.*;
import java.awt.dnd.*;
import javax.swing.*;

import code.*;

/**
 * That white space around where you can find messenger elements
 * 
 * @author Joey Muller
 * @version February 27th, 2014
 */

public class Message_Holder extends JPanel {
    private int index;
    private Messenger_Element child;
    private Messenger[] paramList;
    private int width = 100;
    
    public Message_Holder(Messenger_Element c, int i, Messenger[] mr) {
        super();
        setOpaque(true);
        setBackground(Color.WHITE);
        setBorder(BorderFactory.createLineBorder(Color.BLACK));
        index = i;
        child = c;
        paramList = mr;
        
        
        // By default, you can type
        //child shall never be null
        if (getChild() == null) {
            child = new MessengerTextBox(this);
            ((MessengerTextBox) child).setHost(this);
        }
        
        // add( getChild() );
        super.add( getChild() );
        getChild().setWidth( getWidth()-10 );
        updateTheParametersList();
        
        
        // DnD
        new MessengerDropTargetListImp(this);
    }
    
    public int getWidth() {
        return width;
    }
    
    public void setWidth(int w) {
        width = w;
    }
    
    public int getIndex() {
        return index;
    }
    
    public Messenger_Element getChild() {
        return child;
    }
    
    public void setChild( Messenger_Element c ) {
        child = c;
    }
    
    public Dimension getPreferredSize(){
        if (child == null) {
            return new Dimension(width, 30);
        }
        else {
            // find height of children
            int childHeight = (int)getChild().getSize().getHeight();
            return new Dimension(width, childHeight);
        }
    }
    
    public void updateSize() {
        setPreferredSize( getPreferredSize() );
        
        if (getParent() instanceof Draggable_Element) {
            ((Draggable_Element) getParent()).updateSize();
        }
    }
    
    public void updateChildrenSize() {}
    
    public Component add( Component comp ) {
        // You should ONLY be able to add Messenger_Elements to Message_Holders
        // and you should only add when there is not another  element present
        if (comp instanceof Messenger_Element) {
            // Remove the current child
            Messenger_Element oldKid = getChild();
            setChild(null);
            remove( oldKid );
            
            super.add(comp);
            ((Draggable_Element)comp).setWidth( getWidth()-10 );
            this.setChild( (Messenger_Element) comp );
            if (getChild() instanceof MessengerTextBox) {
                ((MessengerTextBox) getChild()).setHost(this);
            }
            updateTheParametersList();
            return comp;
        }
        return null;
    }
    
    public void remove( Component comp ) {
        super.remove(comp);
        if (comp.equals(getChild())) {
            if (getChild() instanceof MessengerTextBox) {
                ((MessengerTextBox) getChild()).setHost(null);
            }
            Messenger_Element newKid = new MessengerTextBox(this);
            add( newKid );
            this.setChild( newKid );
            updateTheParametersList();
        }
    }
    
    public void updateTheParametersList() {
        paramList[this.index] = getChild().getCode();
    }
}