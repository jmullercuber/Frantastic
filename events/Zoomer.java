package events;

import mode.Mode;
import customJPanels.Painter;

import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

import static java.lang.Math.pow;

/**
 * Controls Scrolling actions
 * 
 * @author Joey Muller
 * @version May 8th, 2014
 */
public class Zoomer extends Listen implements MouseWheelListener {
    public Zoomer (Mode[] m, Painter p) {
        super(m, p);
    }
    
    public void mouseWheelMoved(MouseWheelEvent event) {
        double a = pow(0.75, event.getPreciseWheelRotation());
        getCurrentMode().scale( a );
        getPainter().repaint();
    }
}
