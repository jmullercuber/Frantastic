package fractals;

import java.util.ArrayList;

/**
 * Write a description of class LindenmayerSystem here.
 * 
 * @author Joey Muller
 * @version Pi Day 2014
 */
public class LindenmayerSystem implements Fractal
{
    // instance variables
    private int generations;
    private String string;
    private ArrayList<LindenmayerRule> rules = new ArrayList<LindenmayerRule>();

    /**
     * Constructor for objects of class LindenmayerSystem
     * Option to pre-generate
     */
    public LindenmayerSystem(String axiom, ArrayList<LindenmayerRule> r, int i)
    {
        // initialise instance variables
        generations = 0;
        string = axiom;
        rules = r;
        
        generate(i);
    }
    
    public LindenmayerSystem(String axiom, ArrayList<LindenmayerRule> r)
    {
        this(axiom, r, 0);
    }
    
    /**
     * Constructor if a single rule
     */
    public LindenmayerSystem(String axiom, final LindenmayerRule r, int i)
    {
        this(
            axiom,
            new ArrayList<LindenmayerRule>(),
            i
        );
        
        // Don't add to the array, (keep it empty), if the rule is not special
        if (!r.lookingForThis().equals("")) {
            addRule(r);
        }
        
        /*// Create ArrayList from single rule
        ArrayList a = new ArrayList<LindenmayerRule>();
        a.add(r);
        
        // initialise instance variables
        generations = 0;
        string = axiom;
        rules = a;
        
        generate(i);*/
    }
    
    public LindenmayerSystem(String axiom, LindenmayerRule r)
    {
        this(axiom, r, 0);
    }
    
    public LindenmayerSystem(String axiom)
    {
        this(axiom, new LindenmayerRule());
    }
    
    /**
     * Default, and therefore empty, constructor
     */
    public LindenmayerSystem()
    {
        this("", new LindenmayerRule());
    }
    
    public String getString() {
        return string;
    }
    
    /**
     * Evolve the string once
     */
    public void generate()
    {
        // Increment generations count
        generations++;
        
        // We will create the new string
        String newString = "";
        
        // Loop that goes through current string, looking for matches
        eachLetter : for (int i=0; i<string.length(); i++) {
            // For every rule...
            for (LindenmayerRule rule : rules) {
                // ... if the rule applies
                if (string.substring(i).startsWith(rule.lookingForThis()) && rule.lookingForThis().length()>0) {
                    // add THAT to the newstring,
                    newString += rule.replacement();
                    
                    // update our position in the string
                    // and go back to eachLetter loop,
                    i += (rule.lookingForThis().length()-1);
                    continue eachLetter;
                }
            }
            // If we get this far, do nothing
            newString += string.charAt(i);
        }
        
        
        // Replace string
        string = newString;
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
    
    public void addRule( LindenmayerRule r ) {
        if (!r.lookingForThis().equals("")) {
            rules.add(r);
        }
    }
    
    public LindenmayerRule removeRule( int i ) {
        return rules.remove(i);
    }
    
    public int getGeneration() {
        return generations;
    }
}
