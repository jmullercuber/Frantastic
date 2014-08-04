package customJPanels;

import javax.swing.JLabel;
import java.awt.BorderLayout;

import transfers2.*;

public class LibraryPanel extends customJPanel {
    public LibraryPanel( Painter painter ) {
        super(300, 500);
        
        JLabel name = new JLabel("Library");
        Host_Draggable_Element main = new Host_Draggable_Element();
        this.add( name, BorderLayout.NORTH );
        this.add( main, BorderLayout.CENTER );
        //this.setResizable(false);
        
        
        
        // Add elements
        
        // Basic Control Structures
        main.add( new Control_Element(new code.control.Cbontrol()) );
        main.add( new Control_Element(new code.control.Repeat()) );
        main.add( new Control_Element(new code.control.For()) );
        main.add( new Control_Element(new code.control.If()) );
        
        // Output
        main.add( new Stack_Element(new code.output.Say("Hello World")) );
        main.add( new Stack_Element(new code.output.SayParam()) );
        
        // Lindenmayer
        main.add( new Control_Element(new code.Lindenmayer.createLindenmayerSystem( painter )) );
        main.add( new Stack_Element(new code.Lindenmayer.lindenmayerRule()) );
        main.add( new Stack_Element(new code.Lindenmayer.lindenmayerRule()) );
        main.add( new Stack_Element(new code.Lindenmayer.generate( painter )) );
        
        // Constants
            // Numbers
        Stack_Element containerNums = new Stack_Element(new code.operators.MessageContainer(5, "Numbers"));
            containerNums.setParameterAt( 0, new Messenger_Element(new code.constants.DUB_CONST(0)) );
            containerNums.setParameterAt( 1, new Messenger_Element(new code.constants.DUB_CONST(1)) );
            containerNums.setParameterAt( 2, new Messenger_Element(new code.constants.DUB_CONST(2)) );
            containerNums.setParameterAt( 3, new Messenger_Element(new code.constants.DUB_CONST(3)) );
            containerNums.setParameterAt( 4, new Messenger_Element(new code.constants.DUB_CONST(10)) );
        main.add( containerNums );
        
            // Boolean
        Stack_Element containerBools = new Stack_Element(new code.operators.MessageContainer(2, "Booleans"));
            containerBools.setParameterAt( 0, new Messenger_Element(new code.constants.BOOL_CONST(true)) );
            containerBools.setParameterAt( 1, new Messenger_Element(new code.constants.BOOL_CONST(false)) );
        main.add( containerBools );
        
        // Operators
            // Math
        Stack_Element containerMath = new Stack_Element(new code.operators.MessageContainer(8, "Math"));
            containerMath.setParameterAt( 0, new Messenger_Element(new code.operators.Add()) );
            containerMath.setParameterAt( 1, new Messenger_Element(new code.operators.Minus()) );
            containerMath.setParameterAt( 2, new Messenger_Element(new code.operators.Times()) );
            containerMath.setParameterAt( 3, new Messenger_Element(new code.operators.Divide()) );
            containerMath.setParameterAt( 3, new Messenger_Element(new code.operators.Mod()) );
            containerMath.setParameterAt( 4, new Messenger_Element(new code.operators.Exponent()) );
            containerMath.setParameterAt( 5, new Messenger_Element(new code.operators.LessThan()) );
            containerMath.setParameterAt( 6, new Messenger_Element(new code.operators.GreaterThan()) );
            containerMath.setParameterAt( 7, new Messenger_Element(new code.operators.EqualTo()) );
        main.add( containerMath );
        
            // Boolean
        Stack_Element containerBolOps = new Stack_Element(new code.operators.MessageContainer(3, "Booleans"));
            containerBolOps.setParameterAt( 0, new Messenger_Element(new code.operators.And()) );
            containerBolOps.setParameterAt( 1, new Messenger_Element(new code.operators.Or()) );
            containerBolOps.setParameterAt( 2, new Messenger_Element(new code.operators.XOr()) );
        main.add( containerBolOps );
        
        // Variables
        Stack_Element containerVars = new Stack_Element(new code.operators.MessageContainer(6, "Variables"));
            containerVars.setParameterAt( 0, new Messenger_Element(new code.variables.Assignment()) );
            containerVars.setParameterAt( 1, new Messenger_Element(code.variables.Variable.newVariable("i")) );
            containerVars.setParameterAt( 2, new Messenger_Element(code.variables.Variable.newVariable("j")) );
            containerVars.setParameterAt( 3, new Messenger_Element(code.variables.Variable.newVariable("x")) );
            containerVars.setParameterAt( 4, new Messenger_Element(code.variables.Variable.newVariable("y")) );
            containerVars.setParameterAt( 5, new Messenger_Element(code.variables.Variable.newVariable("z")) );
        main.add( containerVars );
        
        
        Stack_Element containerIVars = new Stack_Element(new code.operators.MessageContainer(6, "I Variables"));
            containerIVars.setParameterAt( 0, new Messenger_Element(new code.variables.Assignment()) );
            containerIVars.setParameterAt( 1, new Messenger_Element(code.variables.Variable.newVariable("i")) );
            containerIVars.setParameterAt( 2, new Messenger_Element(code.variables.Variable.newVariable("i")) );
            containerIVars.setParameterAt( 3, new Messenger_Element(code.variables.Variable.newVariable("i")) );
            containerIVars.setParameterAt( 4, new Messenger_Element(code.variables.Variable.newVariable("i")) );
            containerIVars.setParameterAt( 5, new Messenger_Element(code.variables.Variable.newVariable("i")) );
        main.add( containerIVars );
    }
}