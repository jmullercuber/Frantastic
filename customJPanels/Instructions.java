package customJPanels;

import javax.swing.JTextArea;

public class Instructions extends customJPanel {
    public Instructions() {
        super(800, 150);
        
        JTextArea textArea = new JTextArea(
            "Welcome to Frantastic. This program has had many possible names: " +
            "Fractal Generator, Fractalastic, Joey's Fractal Creator... " +
            "But Frantastic was litteraly the first thing that came to mind. " +
            "Therefore, the name is natural, it's real, and a-okay. " +
            "But enough about the name, you may be saying, What is Frantastic? " +
            "It is an interactive fractal creator. And fractals? " +
            "A fractal is a cool piece of *ART*, made with math. " +
            "So basically, you're making art on the computer. " +
            "There are infinite possibilities of fractals, and this program helps you make a few. " +
            "The idea is that you combine statements (codes), which provide the instructions on how to make a fractal. " +
            "You're still reading, gosh! To get into the specific, the screen is divided in 3 parts: Stack Panel, Display, and Library. " +
            "The Display is where the fractals appear. A text box inside there must also be selected for translations on the grid to work. " +
            "Translate the grid with arrow keys. Use the middle-mouse button or equivalent to zoom in and out. " +
            "On the right is the Library, containing all the different \"code blocks\" you can use. " +
            "Drag blocks onto the Stack Panel to form programs. These programs are the instructions on how to create a fractal. " +
            "There are 3 types of blocks: Stack, Control, and Messenger. " +
            "Stack blocks preform. " +
            "Instructions go here. Instructions go here. " +
            "Instructions go here. Instructions go here. "
        );
        textArea.setSize(1000, 300);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setEditable(false);
        textArea.setBackground(java.awt.Color.LIGHT_GRAY);
        
        this.add(textArea);
    }
}