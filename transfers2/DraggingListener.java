package transfers2;

import java.awt.*;
import java.awt.dnd.*;

import code.*;

public class DraggingListener implements DragGestureListener {
    public void dragGestureRecognized(DragGestureEvent event) {
        Cursor cursor = null;
        Draggable_Element element = (Draggable_Element) event.getComponent();
        
        if (event.getDragAction() == DnDConstants.ACTION_MOVE) {
            cursor = DragSource.DefaultMoveDrop;
        }
        
        event.startDrag(cursor, new Transferable_DE(element));
    }
}