package code;

import java.awt.Color;
import java.util.ArrayList;

/**
 * Abstract class Control - write a description of the class here
 * 
 * @author (your name here)
 * @version (version number or date here)
 */
public abstract class Control extends Stack
{
    // instance variables
    private ArrayList <Stack> subBlocks;
    
    /**
     * Default constructor
     */
    public Control()
    {
        this( /*new ArrayList <Stack> (),*/ new Messenger[] {}  );
    }
    
    /**
     * Another Constructor for Control
     */
    /*public Control( ArrayList <Stack> children  )
    {
       this( children, new Messenger[] {}  );
    }*/
    
    /**
     * Yet another Constructor for Control
     */
    /*public Control( Messenger[] m  )
    {
       this( new ArrayList <Stack> (), m  );
    }*/
    
    /**
     * Constructor for objects of class Control
     */
    public Control( /*ArrayList <Stack> children,*/ Messenger[] m  )
    {
        super(m);
        
        // initialise instance variables
        subBlocks = new ArrayList <Stack> ();//children;
    }
    
    public void alterDesign( transfers2.Draggable_Element d ) {
        d.setBackground(Color.ORANGE);
    }
    
    public final ArrayList<Stack> getSubBlocks() {
        return subBlocks;
    }
    
    public final int getOverallBlocks() {
        int sum = 1;
        for (Stack c : subBlocks) {
            sum += c.getOverallBlocks();
        }
        return sum;
    }
    
    // interesting methods
    
    public Object act() {
        return exec();
    }
    
    // By default it does nothing. That way, you can just execute your children in act
    public Object exec() {
        for (Stack c : getSubBlocks()) {
            Object r = c.act();
            
            if (r instanceof String) {
                if (r.equals("return")) {
                    return "return";
                }
                else if (r.equals("break")) {
                    return "broken";
                }
            }
        }
        return "";
    }
}
