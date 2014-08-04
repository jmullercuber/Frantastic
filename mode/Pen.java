package mode;

import java.awt.*;
import java.awt.geom.*;

import myMath.Vector2D;
import fractals.Fractal;
import fractals.LindenmayerSystem;

/**
 * Pen - Methods for creating fractals by pen
 * 
 * @author Joey Muller
 * @version March 7th, 2014
 */
public class Pen extends Mode
{
    // Instance Variables
    private double drawAmount;
    private double angle;   // degrees
    
    private LindenmayerSystem fractal;
    
    /**
     * Constructor for objects of class Pen
     */
    public Pen()
    {
        // refer to parent class
        super();
        
        // initialise instance variables
        drawAmount = 2;
        angle = 0;
        fractal = new LindenmayerSystem();
    }
    
    // Getter, setters, and incrementing methods for some variables
    public double getDrawAmount() {
        return drawAmount;
    }
    
    public void setDrawAmount( double a ) {
        drawAmount = a;
    }
    
    public double getAngle() {
        return angle;
    }
    
    public void setAngle( double a ) {
        angle = a;
        while (a >= 360) {
            a-= 360;
        }
        while (a <= 0) {
            a = 360 - a;
        }
        angle %= 360;
    }
    
    // Turn allows the Pen to rotate, and continue drawing in another direction
    public void turn( double a ) {
        angle += a;
        while (a >= 360) {
            a-= 360;
        }
        while (a <= 0) {
            a = 360 - a;
        }
        angle %= 360;
    }
    
    //Reset puts certain attributes to their original values to make draw() work
    public void reset() {
        super.reset();
        angle = 0;
    }
    
    public LindenmayerSystem getFractal() {
        return fractal;
    }
    
    public void setFractal( Fractal newFractal ) {
        fractal  = (LindenmayerSystem) newFractal;
    }
    
    // Special and overridded methods
    
    public void resetGrid( Graphics2D g2 ) {
        g2.translate(getWidthHeight().getX()/2, getWidthHeight().getY()/2);
    }
    
    // Method renders the fractal, passed with the Graphics2D object
    public void draw( Graphics2D g2 ) {
        // Prepare the state of the pen
        reset();
        
        g2.scale(getScale(), getScale());
        //g2.draw(new Ellipse2D.Double(-2, -2, 4, 4));
        
        // new variables
        String fractalEncrypted = fractal.getString();
        Vector2D oldPosition = new Vector2D( getGridPosition().getX(), getGridPosition().getY() );
        
        
        // do stuff now!
        // for every letter...
        for (int i=0; i<fractalEncrypted.length(); i++) {
            this.incrementColor();
            g2.setColor( this.getColor() );
            
            String next = fractalEncrypted.substring(i, i+1);
            // ... figure out what it is
            // and do the corresponding action
            // if it is on the list
            switch (next) {
                case "F":
                    // Figure out the new position
                    this.getGridPosition().Plus( new Vector2D(
                            drawAmount * Math.cos( Math.toRadians(this.getAngle()) ),
                            drawAmount * Math.sin( Math.toRadians(this.getAngle()) )
                    ) );
                    
                    // Draw the new line between old and new
                    g2.draw(new Line2D.Double(
                        oldPosition.getX(),
                        oldPosition.getY(),
                        this.getGridPosition().getX(),
                        this.getGridPosition().getY()
                    ));
                    
                    // Update position
                    oldPosition.setX( this.getGridPosition().getX() );
                    oldPosition.setY( this.getGridPosition().getY() );
                    break;
                case "+":
                    this.turn(90);
                    break;
                case "-":
                    this.turn(-90);
                    break;
            }
        }
    }
}