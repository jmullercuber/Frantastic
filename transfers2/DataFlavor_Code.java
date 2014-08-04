package transfers2;

import java.awt.datatransfer.DataFlavor;
import code.CodeBlock;

/**
 * A DataFlavor, that makes it possible to transfer codeBlocks
 * 
 * @author Joey Muller
 * @version March 24th, 2014
 */
public class DataFlavor_Code extends DataFlavor
{
    private Class myClass;
    /**
     * Constructor for objects of class CodeDataFlavor
     */
    public DataFlavor_Code( Class cls )
    {
        // refer to super's constructor, and nothing more
        super(cls, null);
        myClass = cls;
    }
    
    public Class getCodeClass() {
        return myClass;
    }
}
