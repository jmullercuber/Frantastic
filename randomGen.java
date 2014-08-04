import static java.lang.Math.random;

/**
 * Write a description of class randomGen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class randomGen
{
    public static void main() {
        // Create variables
        String[] lib = new String[] {"F", "+", "-"};
        String[] outs = new String[5];
        
        // Fill outs array with random stuff
        for (int k=0; k<outs.length; k++) {
            outs[k] = "";
            for (int i=0; i<(int)(random()*5+1); i++) {
                outs[k] += lib[(int)(random()*3)];
            }
        }
        
        //Display it all
        for (String s : outs) {
            System.out.println(s);
        }
        System.out.println("Generate: " + (int) random()*11);
    }
}
