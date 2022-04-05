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
    //set the colour of the lamp
    private Color color;            //color of the lamp
    private Color currentColor = Color.black;   //set colour of bulb to black since it is off on the start
    
    //the lamps
    private Lamp myLamp;
    private Lamp yrLamp;
    
    // Make an array of lamps
    private final int STARTX = 75;
    private final int YPOS = 100;
    private final int MAXLAMPS = 5;
    
    private Lamp[] lampBed = new Lamp[MAXLAMPS];    //array of lamps
    
    /** Makes several Lamp objects */
    public void createLamps() {
        UI.clearPanes();
        
        myLamp = new Lamp(-100, -100, 80, 80/4, currentColor);
        myLamp.draw();
        yrLamp = new Lamp(-200, -200, 80, 80/4, currentColor);
        yrLamp.draw();
        
        for (int i = 0; i < MAXLAMPS; i++) {
            //set every flower to a random colour
            Color col = UI.setColor(Color.black);
            lampBed[i] = new Lamp(STARTX*(i+1), YPOS, 10, 50, col); //Create the flower object put in array
        }
        
        //draw each flower
        for (Lamp lamp : lampBed) {
            lamp.draw();
        }
    }   

    /** Manages the Lamp objects */
    public void manageLamps(String action, double x, double y) {
        if (action.equals("released")) {
            if (myLamp == null || yrLamp == null) {
                UI. printMessage("Press Lamps button first to create some lamps");
                return;     //the lamps haven't been constructed yet
            }
            if (myLamp.onBulb(x,y)) {
                myLamp.changeColor();
                myLamp.draw();
            }
            else if (myLamp.onStem(x,y)) {
                myLamp.turnOff();
                myLamp.draw();
            }
            else if (yrLamp.onBulb(x,y)) {
                yrLamp.changeColor();
                yrLamp.draw();
            }
            else if (yrLamp.onStem(x,y)) {
                yrLamp.turnOff();
                yrLamp.draw();
            }
        }
    }   

    public void clear() {
        UI.clearPanes();
        myLamp = null;
        yrLamp = null;
    }

    // Main
    /** Create a new ObjectExercise object and setup the interface */
    public static void main(String[] args) {
        UI.initialise();
        UI.addButton("Quit", UI::quit);
        
        ObjectsExercise obj = new ObjectsExercise();
        
        //Add Buttons
        UI.addButton("Lamps", obj::createLamps);
        UI.addButton("Clear", obj::clear);
        
        //Setup mouse
        UI.setMouseListener(obj::manageLamps);
    }

}
