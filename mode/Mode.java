package mode;

import java.util.ArrayList;
import java.awt.*;

import myMath.Vector2D;
import fractals.Fractal;
/**
 * Abstract class Mode - Related Pen and Point
 * 
 * @author Joey Muller
 * @version February 27th, 2014
 */
public abstract class Mode
{
    // Instance variables
    private Color currentColor;
    private float colorChange = 0f;
    private Vector2D gridposition;
    private Vector2D translations;
    private Vector2D widthheight;
    private double doScale;
    
    /**
     * Default Constructor for objects of parent class Mode
     */
    public Mode()
    {
        this( new Vector2D(), new Vector2D(990, 680) );
    }
    
    public Mode(Vector2D gp, Vector2D wh) {
        currentColor = Color.BLACK;
        
        gridposition = gp;
        translations = new Vector2D();
        widthheight = wh;
        doScale = 1;
    }
    
    public Color getColor() {
        return currentColor;
    }
    
    public void setHue(float h) {
        currentColor = Color.getHSBColor( colorChange=h, .8f, .8f);
    }
    
    public void incrementColor() {
        currentColor = Color.getHSBColor( colorChange+=0.00002f, .8f, .8f);
    }
    
    public Vector2D getGridPosition() {
        return gridposition;
    }
    
    public void setGridPosition( Vector2D gp ) {
        gridposition = gp;
    }
    
    public void translate( Vector2D t ) {
        translations.Plus(t);
    }
    
    public Vector2D getWidthHeight() {
        return widthheight;
    }
    
    public void setWidthHeight( Vector2D wh ) {
        widthheight = wh;
    }
    
    public double getScale() {
        return doScale;
    }
    
    public void reset() {
        currentColor = Color.BLACK;
        colorChange = 0f;
        gridposition = new Vector2D(translations.getX(), translations.getY());
    }
    
    public abstract Fractal getFractal();
    
    public abstract void setFractal( Fractal newFractal );
    
    public abstract void resetGrid( Graphics2D g2 );
    
    public abstract void draw( Graphics2D g2 );
    
    public void scale(double i) {
        doScale *= i;
    }
}