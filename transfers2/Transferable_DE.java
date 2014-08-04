package transfers2;

import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;

import code.*;

/**
 * Transferable for CodeBlocks, tells <b>what</b> to transfer.
 * Pretty much a wrapper class in my situation
 * 
 * Shoutout to MadProgrammer @stackoverflow.com Followed their example with a couple of these classes
 * http://stackoverflow.com/questions/11201734/java-how-to-drag-and-drop-jpanel-with-its-components
 * 
 * @author Joey Muller
 * @version March 24th, 2014
 */
public class Transferable_DE implements Transferable
{
    // instance variables - replace the example below with your own
    private Draggable_Element dragElem;
    
    /**
     * Constructor for objects of class Transferable_Code
     */
    public Transferable_DE( Draggable_Element de )
    {
        // initialise instance variables
        dragElem = de;
    }
    
    public boolean isDataFlavorSupported(DataFlavor flavorInQuestion) {
        // If it's not even a DataFlavor_Code
        if (!(flavorInQuestion instanceof DataFlavor_Code)) {
            // We don't support it
            // In the future, should change to accept text, or HTML though
            return false;
        }
        
        // For all of my validFlavors
        for ( DataFlavor validFlavor : getTransferDataFlavors()) {
            if (((DataFlavor_Code)flavorInQuestion).getCodeClass().equals(((DataFlavor_Code)validFlavor).getCodeClass())) {
                return true;
            }
            /*
            // If the class that flavorInQuestion holds is a child of any known parents
            Class knownParent = ((DataFlavor_Code) validFlavor).getCodeClass();
            Class unknown = ((DataFlavor_Code) flavorInQuestion).getCodeClass();
            if ( knownParent.isAssignableFrom(unknown) ) {
                // Then, yah, of course it's supported
                return true;
            }*/
        }
        // If not, then it's not
        return false;
    }
    
    /**
     * Returns an array of DataFlavor objects indicating the flavors the data can be provided in. The array should be ordered according to preference for providing the data (from most richly descriptive to least descriptive).
     */
    public DataFlavor[] getTransferDataFlavors() {
        // Declare an array with my DataFlavor_Code
        // Fill it with new DataFlavors, corresponding to the accepting list
        // As a side note. I really find the naming DataFlavor sooo appropriate and humorous.
        
        DataFlavor[] dfs;
        
        if (dragElem.getCode() instanceof Control){
            dfs = new DataFlavor[] {
                new DataFlavor_Code( code.Control.class ),
                new DataFlavor_Code( code.Stack.class )
            };
        }
        else if (dragElem.getCode() instanceof Stack){
            dfs = new DataFlavor[] {
                new DataFlavor_Code( code.Stack.class )
            };
        }
        else if (dragElem.getCode() instanceof Messenger){
            dfs = new DataFlavor[] {
                new DataFlavor_Code( code.Messenger.class )
            };
        }
        else {
            dfs = new DataFlavor[] {};
        }
        
        return dfs;
    }
    
    public Object getTransferData(DataFlavor flavor) throws UnsupportedFlavorException {
        if ( !isDataFlavorSupported(flavor) ) {
            throw new UnsupportedFlavorException(flavor);
        }
        // (Because we only go in one flavor, vanilla!)
        if (((DataFlavor_Code)flavor).getCodeClass().equals(code.Control.class)) {
            return (Control_Element) dragElem;
        }
        else if (((DataFlavor_Code)flavor).getCodeClass().equals(code.Stack.class)) {
            return (Stack_Element) dragElem;
        }
        else if (((DataFlavor_Code)flavor).getCodeClass().equals(code.Messenger.class)) {
            return (Messenger_Element) dragElem;
        }
        else {
            return null;
        }
    }
}
