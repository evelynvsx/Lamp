import ecs100.*;
import java.awt.Color;

/** Exercise for WGC 13DT
 * Name: Evelyn
 * Email: salimev@wgc.school.nz
 * Date: 31/03/22
 */

/** Exercise for defining objects.
 *  This program contains methods for testing Lamp objects.
 *  It is all written for you, but you need to read it to see 
 *  what the Lamp class should do.
 */

public class ObjectsExercise {
    // Make an array of lamps
    private final int STARTX = 75;
    private final int YPOS = 100;
    private final int MAXLAMPS = 5;
    
    private Lamp[] lamps = new Lamp[MAXLAMPS];
    
    /**
     * Select object based on where the user clicks
     */
    private void doMouse(String action, double x, double y) {
        if (action.equals("clicked")) {
            //check the location of the x and y against location of lamp
            for (Lamp lamp : lamps) {
                if ((x >= lamp.getLeft()) && (x <= lamp.getRight()) &&
                (y >= lamp.getTop()) && (y <= lamp.getBottom())) {
                    lamp.changeColor();
                }
            }
        }
    }
    

    /** Makes several Lamp objects */
    public void createLamps() {
    }   

    /** Manages the Lamp objects */
    public void manageLamps(String action, double x, double y) {

    }   


    public void clear() {

    }

    // Main
    /** Create a new ObjectExercise object and setup the interface */
    public static void main(String[] args) {

    }

}
