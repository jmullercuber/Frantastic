package myMath;

/**
 * Write a description of class Vector2D here.
 * 
 * @author Joey Muller
 * @version March 5th, 2014
 */
public class Vector2D
{
    // Instance Variables
    private double x, y;

    /**
     * Default constructor
     */
    public Vector2D() {
       this(0, 0);
    }

    /**
     * Constructor for objects of class Vector2D
     */
    public Vector2D(double newX, double newY) {
        x = newX;
        y = newY;
    }
    
    public double getX() {
        return this.x;
    }
    
    public double getY() {
        return this.y;
    }
    
    public void setX( double newX ) {
        this.x = newX;
    }
    
    public void setY( double newY ) {
        this.y = newY;
    }
    
    public void Plus( Vector2D v ) {
        this.x += v.getX();
        this.y += v.getY();
    }
    
    public void Scale( double c ) {
        this.x *= c;
        this.y *= c;
    }
    
    public Vector2D Multiply( double c ) {
        Vector2D v = new Vector2D(this.x, this.y);
        v.Scale(c);
        return v;
    }
}