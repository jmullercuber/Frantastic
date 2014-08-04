package fractals;

import java.util.ArrayList;

/**
 * Escape-time fractals, stores equation and such
 * 
 * @author Joey Muller
 * @version March 20th 2014
 */
public class EscapeTimeSequence implements Fractal
{
    // instance variables
    private int generations;

    /**
     * Constructor for objects of class LindenmayerSystem
     * Option to pre-generate
     */
    public EscapeTimeSequence()
    {
        // initialise instance variables
        generations = 0;
    }
    
    public float sample(double xsam, double ysam) {
        //scaled x coordinate of pixel (scaled to lie in the Mandelbrot X scale (-2.5, 1))
        double x0 = xsam*(3.5/990)-0.75;
        // scaled y coordinate of pixel (scaled to lie in the Mandelbrot Y scale (-1, 1))
        double y0 = ysam*(2.0/680);
        double x = 0.0,
               y = 0.0;
        int iteration = 0,
            max_iteration = 1000;
        while ( x*x + y*y < 2*2  &&  iteration < max_iteration ) {
            double xtemp = x*x - y*y + x0;
            y = 2*x*y + y0;
            x = xtemp;
            iteration = iteration + 1;
        }
        return (float) iteration/1500;
    }
    
    /**
     * Evolve the string once
     */
    public void generate()
    {
    }
    
    /**
     * Evolves the string multiple times
     * 
     * @param  i   How many times to call generate
     */
    public void generate(int max)
    {
        for (int i=0; i<max; i++) {
            generate();
        }
    }
    
    public int getGeneration() {
        return generations;
    }
}
