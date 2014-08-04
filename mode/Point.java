package mode;

import java.awt.*;
import java.awt.geom.*;

import myMath.Vector2D;
import fractals.*;

/**
 * Point - Methods for creating fractals by ponit-by-point
 * 
 * @author Joey Muller
 * @version March 20th, 2014
 */
public class Point extends Mode
{
    // Instance Variables
    private double drawAmount;
    
    private EscapeTimeSequence fractal;
    
    /**
     * Constructor for objects of class Pen
     */
    public Point()
    {
        // refer to parent class
        super();
        
        // initialise instance variables
        drawAmount = 1;
        fractal = new EscapeTimeSequence();
    }
    
    // Getter, setters, and incrementing methods for some variables
    public EscapeTimeSequence getFractal() {
        return fractal;
    }
    
    public void setFractal( Fractal newFractal ) {
        fractal  =  (EscapeTimeSequence) newFractal;
    }
    
    // Special and overridded methods
    
    
    public void resetGrid( Graphics2D g2 ) {
        g2.translate(getWidthHeight().getX()/2, getWidthHeight().getY()/2);
    }
    
    // Method renders the fractal, passed with the Graphics2D object
    public void draw( Graphics2D g2 ) {
        // Reset the point object
        reset();
        
        drawAmount =  getScale();
        g2.scale(getScale(), getScale());
        
        
        // Nested loops to draw every point on grid
        for (int i=-(int)getWidthHeight().getX()/2; i<getWidthHeight().getX()/2*1; i+=1) {
            for (int j=-(int)getWidthHeight().getY()/2; j<getWidthHeight().getY()/2*1; j+=1) {
                // Figure out the color
                this.setHue( .5f+fractal.sample(
                        (getGridPosition().getX() + i + 1/2) / drawAmount,
                        (getGridPosition().getY() + j + 1/2) / drawAmount
                ) );
                g2.setColor( this.getColor() );
                
                // Draw the point
                g2.draw(
                    new Line2D.Double(
                        (getGridPosition().getX()*1 + i)/drawAmount,
                        (getGridPosition().getY()*1 + j)/drawAmount,
                        (getGridPosition().getX()*1 + i + 1)/drawAmount,
                        (getGridPosition().getY()*1 + j + 1)/drawAmount
                    )
                );
                this.incrementColor();
            }
        }
    }
}