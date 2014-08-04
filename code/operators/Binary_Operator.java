package code.operators;

import code.*;

/**
 * Abstract class Binary_Operator - Accepts two parameters, and then does something with them
 * 
 * @author (your name here)
 * @version (version number or date here)
 */
public abstract class Binary_Operator extends Messenger
{
    public Binary_Operator() {
        super( new Messenger[2] );
    }
}
