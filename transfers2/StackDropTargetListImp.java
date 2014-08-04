package transfers2;

import java.awt.dnd.*;
import java.awt.datatransfer.*;
import javax.swing.*;

import code.*;

public class StackDropTargetListImp extends DropTargetAdapter implements DropTargetListener {
    private DropTarget dropTarget;
    private Control_Element panel;
    
    public StackDropTargetListImp(Control_Element panel) {
        this.panel = panel;
        
        dropTarget = new DropTarget(
            panel,
            DnDConstants.ACTION_MOVE,
            this,
            true,
            null
        );
    }
    
    public void drop(DropTargetDropEvent event) {
        DataFlavor dataFlavor = new DataFlavor_Code( Stack.class ); //this.panel.getCode().getClass() );
        
        try {
            Transferable tr = event.getTransferable();
            Stack_Element de = (Stack_Element) tr.getTransferData(dataFlavor);
            
            // You can't drag from yourself, or your parent
            if (de == this.panel || this.panel.isGrandparent(panel, de)) {
                event.rejectDrop();
            }
            
            if (
                event.isDataFlavorSupported(dataFlavor)          // If it is a draggable_element
                     // If the target accepts your kind
            ) {
                event.acceptDrop(DnDConstants.ACTION_MOVE);
                
                // Clean up
                JComponent tempParent = (JComponent) de.getParent();
                tempParent.remove(de);
                
                // Add transfered information
                this.panel.add(de);
                
                // Make it all look good
                this.panel.updateSize();
                this.panel.updateChildrenSize();
                
                
                // Fix the old parent
                if (tempParent instanceof Draggable_Element) {
                    ((Draggable_Element)tempParent).updateSize();
                }
                
                tempParent.revalidate();
                tempParent.repaint();
                
                
                // Say everything is okay
                event.dropComplete(true);
                this.panel.validate();
                return;
            }
            
            event.rejectDrop();
        }
        catch (Exception e) {
            //e.printStackTrace();
            event.rejectDrop();
        }
    }
}