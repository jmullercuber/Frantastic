//---------------------------------------------------
//---------------------Java Stuff--------------------
//---------------------------------------------------
import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;
import java.lang.Math;
//---------------------------------------------------
//--------------------My own code--------------------
//---------------------------------------------------
import customJPanels.*;
import mode.*;
//---------------------------------------------------
//------------------Event Listeners------------------
//---------------------------------------------------
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;

/**
 * FrantasticDriver - Starts the program.
 * 
 * @author Joey Muller 
 * @version February 27th, 2014
 */

public class FrantasticDriver extends JFrame {
    // instance variables
    private int currentModesIndex;
    private customJPanels.Painter painter;
    
    public FrantasticDriver( final customJPanels.Painter painter ) {
        // Refer to super's constructor
        super("Frantastic");
        
        this.painter = painter;
        currentModesIndex = 0;
        
        // Create the menu bar
        JMenuBar menubar = new JMenuBar();
            // Create JMenu Mode
            JMenu menuMode = new JMenu("Mode");
                // Add stuff to JMenu Mode
                JMenuItem menuItemModePen = new JMenuItem("Pen");
                menuItemModePen.addMouseListener (
                    new MouseAdapter() {
                        public void mousePressed(MouseEvent event) {
                            painter.setMode(0);
                            painter.repaint();
                        }
                    }
                );
                menuMode.add( menuItemModePen );
                
                JMenuItem menuItemModePoint = new JMenuItem("Point");
                menuItemModePoint.addMouseListener (
                    new MouseAdapter() {
                        public void mousePressed(MouseEvent event) {
                            painter.setMode(1);
                            painter.repaint();
                        }
                    }
                );
                menuMode.add( menuItemModePoint );
            menubar.add(menuMode);
            // Create menuWorkspace
            JMenu menuWorkspace = new JMenu("Workspace");
                // Add stuff to menuWorkspace
                JMenuItem menuItemNewWorkSpaceWindow = new JMenuItem("New Workspace Window");
                menuItemNewWorkSpaceWindow.addMouseListener (
                    new MouseAdapter() {
                        public void mousePressed(MouseEvent event) {
                            // Create a new Workspace, using the current Painter
                            new Workspace( painter );
                        }
                    }
                );
                menuWorkspace.add( menuItemNewWorkSpaceWindow );
            menubar.add(menuWorkspace);
        this.setJMenuBar(menubar);
        
        // Add components
        this.add( new JScrollPane( new customJPanels.Instructions() ), BorderLayout.NORTH );
        this.add( new JScrollPane( new customJPanels.StackPanel( painter, true ) ), BorderLayout.WEST );
        this.add( /*new JScrollPane*/( painter ), BorderLayout.CENTER );
        this.add( new JScrollPane( new customJPanels.LibraryPanel( painter ) ), BorderLayout.EAST );
        
        // Show yourself!
        this.setIconImage(
            Toolkit.getDefaultToolkit().getImage(getClass().getClassLoader().getResource("resources/SerpinskiTriangles.png"))
        );
        
        this.setVisible(true);
        this.setSize(new Dimension(1000, 600));
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
    }
    
    public static void mainPen() {
        main(new String[] {"pen"});
    }
    public static void mainPoint() {
        main(new String[] {"point"});
    }
    public static void main() { main(new String[0]); }
    public static void main(String[] args) {
        customJPanels.Painter myPainter;
        
        Mode penMode = new mode.Pen();
            // Initialize the fractals
            //penMode.setFractal( new fastDragon15() );
            //penMode.setFractal( new LSystemKochCurve(7) );
        Mode pointMode = new mode.Point();
        
        Mode[] modeList = new Mode[] {
            penMode,
            pointMode
        };
        
        //drawingMode.scale(5);
        
        
        myPainter = new customJPanels.Painter( 990, 680, modeList );
        FrantasticDriver me = new FrantasticDriver( myPainter );
        
        if (args.length > 0) {
            if (args[0].equals("pen")) {
                me.getPainter().setMode(0);
                me.getPainter().repaint();
            }
            else if (args[0].equals("point")) {
                me.getPainter().setMode(1);
                me.getPainter().repaint();
            }
        }
    }
    
    public customJPanels.Painter getPainter() {
        return painter;
    }
}