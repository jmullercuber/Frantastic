//---------------------------------------------------
//---------------------Java Stuff--------------------
//---------------------------------------------------
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import java.awt.*;
import javax.swing.BorderFactory;
//---------------------------------------------------
//--------------------My own code--------------------
//---------------------------------------------------
import customJPanels.*;
//---------------------------------------------------
//------------------Event Listeners------------------
//---------------------------------------------------
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;

/**
 * Write a description of class Workspace here.
 * 
 * @author Joey Muller
 * @version June 8th, 2014
 */
public class Workspace extends JFrame
{
    // instance variables - replace the example below with your own
    private static int count = 1;

    /**
     * Constructor for Workspaces
     */
    public Workspace( Painter painter )
    {
        super("Frantastic Workspace - " + Workspace.count);
        Workspace.count++;
        
        // Add components
        customJPanels.StackPanel stackSpace = new customJPanels.StackPanel(painter, false, 25);
            stackSpace.setPreferredSize( new Dimension(500, 600) );
        this.add( /*new JScrollPane( */stackSpace/* )*/ );
        
        // Show yourself!
        this.setIconImage(
            Toolkit.getDefaultToolkit().getImage(getClass().getClassLoader().getResource("resources/SerpinskiTriangles.png"))
        );
        
        this.setVisible(true);
        this.setSize(new Dimension(505, 600));
    }
}
