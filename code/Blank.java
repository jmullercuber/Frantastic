package code;

import java.awt.Color;

/**
 * Write a description of class Blank here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Blank extends CodeBlock
{
    private static int count = 0;
    private String id;
    /**
     * Constructor for objects of class Blank
     */
    public Blank(String s)
    {
        super();
        id = s;
    }
    public Blank () {
        super();
        id = "" + ++Blank.count;
    }
    
    public void alterDesign( transfers2.Draggable_Element d ) {
        d.setBackground(Color.GRAY);
    }

    public void act(){
        System.out.println("Blank Code #" + id + " done acting" );
    }
    
    public String getName() { return "Blank"; }
}
