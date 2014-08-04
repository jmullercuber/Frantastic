package code.variables;

import code.*;
import java.util.ArrayList;

/**
 * Represents a variable, named as a String. Value is stored as Object
 * 
 * @author Joey Muller
 * @version May 20th, 2014
 */
public class Variable extends Messenger
{
    // class variables
    private static ArrayList<Variable> existingVars = new ArrayList<Variable> ();
   
    // instance variables
    private String name;
    private Object value;
    
    /**
     * This is the way other objects make Variables
     * (Not sub classes though, that's why constructors are protected)
     */
    public static Variable newVariable( String n, Object v ) {
        // a name of "" is special, so create a new one anyway
        if (n.equals("")) {
            return new Variable(n, v);
        }
        // determine if this the proposed variable is unique
        for (Variable var: existingVars){
            // if match found
            if (var.getName().equals(n)) {
                // return that one
                return var;
            }
        }
        
        // otherwise, if you get here, then make a unique one
        return new Variable(n,v);
    }
    
    public static Variable newVariable( String n ) {
        return newVariable(n, new Boolean(false));
    }
    
    /**
     * Constructor for objects of class Variable
     */
    protected Variable( String n, Object v )
    {
        super( new Messenger[0] );
        // initialise instance variables
        this.name = n;
        this.value = v;
        existingVars.add(this);
    }
    
    /**
     * By default, variables will be Booleans
     */
    protected Variable( String n )
    {
        this(n, new Boolean(false));
    }

    public Object returns()
    {
        return value;
    }
    
    public void setValue( Object v ) {
        value = v;
    }
    
    public String getName() {
        return name;
    }
}
