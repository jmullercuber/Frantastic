package code;

import java.util.ArrayList;

/**
 * Abstract class that represents a program segment
 * 
 * @author Joey Muller 
 * @version March 24th, 2014
 */
public abstract class CodeBlock
{
    // instance variables
    private Messenger[] parameters;

    /**
     * Default constructor
     */
    public CodeBlock( )
    {
        this( new Messenger[]{} );
    }
    
    public CodeBlock( Messenger[] m )
    {
        // initialise instance variables
        parameters = m;
    }
    
    public abstract String getName();
    
    public abstract void alterDesign( transfers2.Draggable_Element d );
    
    public int getOverallBlocks() {
        return 1;
    }
    
    public Messenger[] getParameterList() {
        return parameters;
    }
    
    public final boolean isFull() {
        // If it has children, OR shouldn't have child elements at all.
        // No, more than that
        //return subBlocks.size()>0 || accepts.size()==0;
        return true;
    }
    
    /*public final boolean doesAccept( CodeBlock candidateCode ) {
        // Look at everything we accept...
        for (Class someValidClass : accepts) {
            // and if candidateCode is an example of one in the list...
            if ( someValidClass.isInstance(candidateCode) ) {
                // then stop looking, and say "Yes, you're accepted!"
                return true;
            }
            // Otherwise, the search continues
        }
        // If we've gone through everything, and nothing matches,
        // then determine that candidateCode is not valid and say "Sorry, better luck some where else."
        return false;
    }*/
}
