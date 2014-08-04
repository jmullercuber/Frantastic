package transfers2;

import java.awt.*;
import java.awt.dnd.*;
import javax.swing.*;

import code.*;

/**
 * Class Host_Draggable_Element - inmovable object, but hosts draggies
 * 
 * @author Joey Muller
 * @version February 27th, 2014
 */

public class Host_Draggable_Element extends Control_Element {
    private int space;
    
    public Host_Draggable_Element(int w, int s) {
        super(new code.control.Cbontrol("Main"), false, w);
        
        this.setBackground(Color.LIGHT_GRAY);
        this.space = s;
        //setWidth(30);
    }
    
    public Host_Draggable_Element(int w) {
        this(w, 10);
    }
    
    public Host_Draggable_Element() {
        this(300);
    }
    
    public int spacing() {
        return space;
    }
    
    /*public Dimension getPreferredSize(){
        return new Dimension((int) getParent().getPreferredSize().getWidth()-10, 100);
    }*/
}