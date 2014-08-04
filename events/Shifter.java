package events;

import myMath.Vector2D;
import mode.Mode;
import customJPanels.Painter;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * For arrow key translations.
 * Used, for example to shift a Mode's gridposition around
 * 
 * @author Joey Muller
 * @version May 8th, 2014
 */
public class Shifter extends Listen implements KeyListener {
    private boolean[] keys;
    
    public Shifter(Mode[] m, Painter p) {
        super(m, p);
        // [Left, Right, Up, Down]
        keys = new boolean[] {
            false,
            false,
            false,
            false
        };
    }
    
    public void keyPressed(KeyEvent event) {
        // Figure out what's in
        if (event.getKeyCode() == KeyEvent.VK_LEFT) {
            keys[0] = true;
        }
        if (event.getKeyCode() == KeyEvent.VK_RIGHT) {
            keys[1] = true;
        }
        if (event.getKeyCode() == KeyEvent.VK_UP) {
            keys[2] = true;
        }
        if (event.getKeyCode() == KeyEvent.VK_DOWN) {
            keys[3] = true;
        }
        
        translate();
    }
    
    public void keyReleased(KeyEvent event) {
        if (event.getKeyCode() == KeyEvent.VK_LEFT) {
            keys[0] = false;
        }
        if (event.getKeyCode() == KeyEvent.VK_RIGHT) {
            keys[1] = false;
        }
        if (event.getKeyCode() == KeyEvent.VK_UP) {
            keys[2] = false;
        }
        if (event.getKeyCode() == KeyEvent.VK_DOWN) {
            keys[3] = false;
        }
    }
    
    public void keyTyped(KeyEvent event) {}
    
    public void translate() {
        Vector2D transform = new Vector2D();
        
        // Determine translate coordinates
        // Pressing up makes the camera go up, not the fractal (anymore)
        if (keys[0]) { transform.Plus( new Vector2D(1, 0) ); }
        if (keys[1]) { transform.Plus( new Vector2D(-1, 0) ); }
        if (keys[2]) { transform.Plus( new Vector2D(0, -1) ); }
        if (keys[3]) { transform.Plus( new Vector2D(0, 1) ); }
        
        transform.Scale(3/getCurrentMode().getScale());
        getCurrentMode().translate( transform );
        getPainter().repaint();
    }
}
