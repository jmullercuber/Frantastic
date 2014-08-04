package customJPanels;

import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;

import java.util.ArrayList;
import transfers2.*;

public class StackPanel extends customJPanel {
    private Host_Draggable_Element main;
    private Painter painter;
    
    public StackPanel(Painter painter) {
        this (painter, false);
    }
    public StackPanel(Painter painter, boolean executeButton, int s) {
        super(300, 500);
        
        this.painter = painter;
        
        main = new Host_Draggable_Element((int) this.getPreferredSize().getWidth(), s);
            main.setText("Add Code Here");
        
        
            
            /*
        Control_Element c;
        code.output.Say say = new code.output.Say("Saying somethin'");
        ArrayList<code.Stack> als = new ArrayList<code.Stack>();
        als.add(say);
        //main.add( c = new Control_Element( new code.control.Repeat(als) ) );
        main.add( c = new Control_Element( new code.control.Repeat() ) );
        c.add( new Stack_Element(say) );
        //main.add( c = new Control_Element( new code.control.Cbontrol("Sayin'") ) );
            */
        
        // Create the Dragon Curve
        Control_Element ls = new Control_Element( new code.Lindenmayer.createLindenmayerSystem(painter) );
            ls.setParameterAt( 0, new MessengerTextBox(ls.getHolderAt(0), "FX") );
            ls.setParameterAt( 1, new MessengerTextBox(ls.getHolderAt(1), "14") );
            Stack_Element rule1 = new Stack_Element( new code.Lindenmayer.lindenmayerRule() );
                rule1.setParameterAt( 0, new MessengerTextBox(rule1.getHolderAt(0), "X") );
                rule1.setParameterAt( 1, new MessengerTextBox(rule1.getHolderAt(1), "X+YF") );
        ls.add( rule1 );
        Stack_Element rule2 = new Stack_Element( new code.Lindenmayer.lindenmayerRule() );
            rule2.setParameterAt( 0, new MessengerTextBox(rule2.getHolderAt(0), "Y") );
            rule2.setParameterAt( 1, new MessengerTextBox(rule2.getHolderAt(1), "FX-Y") );
        ls.add( rule2 );
        main.add( ls );
        
        
        if (executeButton) {
            // Create the Run button
            JButton execButton = new JButton("Execute");
            execButton.addMouseListener (
            new MouseAdapter() {
                public void mousePressed(MouseEvent event) {
                    run();
                }
            }
            );
            // Add it
            this.add( execButton, BorderLayout.NORTH );
        }
        
        
        // Add stuff
        this.add( main/*, BorderLayout.CENTER*/ );
        
        //this.setResizable(false);
    }
    
    public StackPanel(Painter painter, boolean executeButton) {
        this(painter, executeButton, 10);
    }
    
    public void setPreferredSize( Dimension d ) {
        super.setPreferredSize(d);
        this.main.setWidth((int) this.getPreferredSize().getWidth());
    }
    
    public void run() {
        // Check for errors
        //compile();
        
        // if good, then run!
        main.getCode().act();
        
        // Show it!
        painter.repaint();
    }
}