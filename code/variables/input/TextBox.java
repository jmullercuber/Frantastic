package code.variables.input;

import code.variables.*;

/**
 * Write a description of class TextBox here.
 * 
 * @author Joey Muller aka The Amazing
 * @version May 22th, 2014
 */
public class TextBox extends Variable
{
    /**
     * Constructor for objects of class TextBox
     */
    public TextBox()
    {
        super("", "");
    }
    
    // Makes it so that the value is only String
    // Should have some error though, instead of quietly going away
    public void setValue( Object v ) {
        if (v instanceof String) {
            super.setValue( (String) v );
        }
        else {
            super.setValue("");
        }
    }
    
    // Change the type it returns
    public Object returns() {
        // If you put in the value via textbox still (or some string) your good
        String r = (String) super.returns();
        
        // Booleans
        if (r.toUpperCase().equals("TRUE") || r.toUpperCase().equals("FALSE")) {
            return new Boolean(r);
        }
        // Maybe it's an Integer
        // Note: I didn't say if Integer.parseInt(r) then return new Integer(r),
        //  because then it would call Integer.parseInt(r) twice (once in the constructor)!
        try {
            //return new Integer(r);
            // sorry, no more ints, now doubles
            return new Double(r);
        }
        catch(Exception e) {}
        // Nope, it's a String
        return r;
    }
    
    // No name
    public String getName() {
        return "";
    }
}
