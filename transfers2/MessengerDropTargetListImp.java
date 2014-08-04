package transfers2;

import java.awt.dnd.*;
import java.awt.datatransfer.*;
import javax.swing.*;

import code.*;

public class MessengerDropTargetListImp extends DropTargetAdapter implements DropTargetListener {
    private DropTarget dropTarget;
    private Message_Holder panel;
    
    public MessengerDropTargetListImp(Message_Holder panel) {
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
        DataFlavor dataFlavor = new DataFlavor_Code( Messenger.class ); //this.panel.getCode().getClass() );
        
        try {
            Transferable tr = event.getTransferable();
            Messenger_Element de = (Messenger_Element) tr.getTransferData(dataFlavor);
            
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
                
                
                // Fix the old Host
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