package customJPanels;

import javax.swing.JPanel;
import java.awt.Dimension;

public abstract class customJPanel extends JPanel {
    private int width, height;
    
    public customJPanel( int w, int h ) {
        super();
        
        width = w;
        height = h;
    }

    public Dimension getPreferredSize(){
        return new Dimension(width, height);
    }
    
    public void setPreferredSize( Dimension d ) {
        width = (int) d.getWidth();
        height = (int) d.getHeight();
        super.setPreferredSize( getPreferredSize() );
    }
}