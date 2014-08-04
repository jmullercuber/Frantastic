package code.control;

/**
 * Analogous to one giant curly brace pair, Used for main host elements
 * 
 * @author Joey Muller 
 * @version May 13th, 2014
 */
public class Cbontrol extends code.Control
{
    private static int count = 0;
    private String id;
    /**
     * Constructor for objects of class Blank
     */
    public Cbontrol(String s)
    {
        super();
        id = s;
    }
    public Cbontrol() {
        this("" + ++Cbontrol.count);
    }
    
    public String act(){
        //System.out.println("Cbontrol Code #" + id + " done acting" );
        return (String) exec();
    }
    
    public String getName() { return "Cbontrol"; }
}
