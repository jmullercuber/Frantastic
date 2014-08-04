package customJPanels;

//---------------------------------------------------
//----------------------Painter----------------------
//---------------------------------------------------
import java.awt.Graphics;
import java.awt.Graphics2D;

import myMath.Vector2D;
import mode.Mode;
//import Mode;
//---------------------------------------------------
//------------------Event Listeners------------------
//---------------------------------------------------
import events.Zoomer;
import events.Shifter;

import javax.swing.JTextField;
import java.awt.Dimension;

public class Painter extends customJPanel { //Component {
    private Mode[] modes;
    private int currentModeIndex;
    private Zoomer zoomer;
    private Shifter shifter;
    
    public Painter( int w, int h, Mode[] mlist ) {
        super(w, h);
        
        modes = mlist;
        currentModeIndex = 0;
        
        zoomer = new Zoomer(modes, this);
        shifter = new Shifter(modes, this);
        addMouseWheelListener (zoomer);
        JTextField typingArea = new JTextField("Click here and use arrow keys to shift:", 20);
        typingArea.setEditable(false);
        typingArea.addKeyListener(shifter);
        this.add(typingArea);
    }
    
    public void setMode( int index ) throws ArrayIndexOutOfBoundsException {
        if ( index < 0 || modes.length <= index) {
            throw new ArrayIndexOutOfBoundsException();
        }
        currentModeIndex = index;
        zoomer.setModeIndex(currentModeIndex);
        //shifter.setModeIndex(currentModeIndex);
    }

    public void paint( Graphics g ) {
        //modes[currentModeIndex].translate( new Vector2D(-100,0) );
        
        
        
        
        super.paint(g);
        Graphics2D g2 = (Graphics2D) g;
        modes[currentModeIndex].setWidthHeight( new Vector2D( getWidth(), getHeight() ) );
        modes[currentModeIndex].resetGrid( g2 );
        g2.scale(1, -1);
        
        
        modes[currentModeIndex].draw( g2 );
    }
    
    public Mode getCurrentMode() {
        return modes[currentModeIndex];
    }
}