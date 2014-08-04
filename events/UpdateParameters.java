package events;

import transfers2.*;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * For detecting a change in a MessengerTextBox,
 * and accordingly updating the under-under-underlying parameter list
 * 
 * 
 * @author Joey Muller
 * @version May 22nd, 2014
 */
public class UpdateParameters implements KeyListener {
    private MessengerTextBox host;
    
    public UpdateParameters(MessengerTextBox newHost) {
        host = newHost;
    }
    
    public void keyPressed(KeyEvent event) { /* do nothing */ }
    
    public void keyReleased(KeyEvent event) {
        host.updateTheParametersList();
    }
    
    public void keyTyped(KeyEvent event) { /* do nothing */ }
}
