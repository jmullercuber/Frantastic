package transfers2;

import java.awt.*;
import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;

import code.*;

public class Driver extends JFrame
{
    public Driver() {
        super("Draggable Elements Example");
        
        Control_Element a, b, c, d, e;
        
        JPanel contentPane = new JPanel();
        add(contentPane);
        
        JButton execButton = new JButton("Execute");
        contentPane.add(execButton);
        
        final Host_Draggable_Element main = new Host_Draggable_Element();
            main.setText("Main");
        contentPane.add(main);
        
        a = new Control_Element( new code.control.Cbontrol("A") );
            a.setBackground(Color.GREEN);
            a.setText("A");
        main.add( b = new Control_Element( new code.control.Cbontrol("B") ) );
            b.setBackground(Color.RED);
            b.setText("B");
            b.add(a);
        main.add( c = new Control_Element( new code.control.Cbontrol("C") ) );
            c.setBackground(Color.BLUE);
            c.setText("C");
        main.add( d = new Control_Element( new code.control.Cbontrol("D") ) );
            d.setBackground(Color.MAGENTA);
            d.setText("D");
        main.add( e = new Control_Element( new code.control.Cbontrol("E") ) );
            e.setBackground(Color.YELLOW);
            e.setText("E");
        
        
        execButton.addMouseListener (
            new MouseAdapter() {
                public void mousePressed(MouseEvent event) {
                    main.getCode().act();
                }
            }
        );
        
        setVisible(true);
        setSize(new Dimension(1000, 800));
    }
    
    public static void main() {
        new Driver();
    }
}
