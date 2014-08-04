package code.operators;

import code.*;

/**
 * Holds a given set of messenger blocks.
 * Nessecary because they can't be in the Library otherwise (Messenger_Element vs Stack_Element).
 * 
 * @author Joey Muller
 * @version May 18th, 2014
 */
public class MessageContainer extends Stack
{
    private String containerName;
    
    /**
     * Default Constructor
     */
    public MessageContainer( int count )
    {
        this( count, "Container" );
    }
    
    /**
     * Constructor for objects of class MessageContainer
     */
    public MessageContainer( int count, String containerLabel )
    {
        super( new Messenger[count] );
        containerName = containerLabel;
    }
    
    public Object act() { return null; }
    
    public String getName() { return containerName; }
}
