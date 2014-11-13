package code;


/**
 * Wraps a single message block into a stack block
 * 
 * @author Joey -- Revived
 * @version November 11th, 2014
 */
public class MessengerStackTransformer extends Stack
{
    /**
     * Constructor for objects of class MessengerStackTransformer
     */
    public MessengerStackTransformer()
    {
       // Just 1 parameter
       super( new Messenger[1] );
    }
    
    @Override
    public Object act()
    {
        // do what the messenger wants
        return getParameterList()[0].returns();
    }
    
    public String getName() {
        // No name, because we're wrapping. Annonymous bro. Unseen. Incognito. Ninja
        return "Wrap:";
    }
}
