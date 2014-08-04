package transfers2;

import javax.swing.JTextField;

import code.variables.input.*;
import events.UpdateParameters;

/**
 * Allows you to text by default in a Message_Holder
 * IS a block, meaning it can be dragged. However, should not cause problems
 * 
 * @author Joey Muller aka Desufnoc Eht. (left to right read)
 * @version May 22nd, 2014
 */
public class MessengerTextBox extends Messenger_Element
{
    private JTextField typeHere;
    private Message_Holder host;
    
    /**
     * Constructor for objects of class MessengerTextBox
     */
    public MessengerTextBox(Message_Holder newHost, String s)
    {
        super( new TextBox() );
        host = newHost;
        typeHere = new JTextField(5);
        typeHere.addKeyListener( new UpdateParameters(this) );
        add(typeHere);
        type(s);
    }
    
    public MessengerTextBox(Message_Holder newHost)
    {
        this(newHost, "");
    }
    
    public void setHost(Message_Holder newHost) {
        host = newHost;
    }
    
    public void updateTheParametersList(){
        if (host != null) {
            host.updateTheParametersList();
        }
    }
    
    // Used so that you can progmatically type
    public void type( String s ) {
        typeHere.setText(s);
    }
    
    public TextBox getCode() {
        // Quick, update before we let other people see what's inside
        ((TextBox) super.getCode()).setValue(typeHere.getText());
        return (TextBox) super.getCode();
    }
}
