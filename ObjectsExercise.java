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
    private int colour = 0;         
    private Color currentColor = Color.black;   //set colour of bulb to black since it is off on the start
   
    // Make an array of lamps
    private final int STARTX = 75;
    private final int YPOS = 200;
    private final int MAXLAMPS = 3;
    
    private Lamp[] lampBed = new Lamp[MAXLAMPS];    //array of lamps
    
    /**
     * Constructor for objects of Lamp Class
     */
    public ObjectsExercise() {
        UI.initialise();
        UI.addButton("Create lamps", this::createLamps);
        UI.addButton("Random colour change", this::randomChange);
        UI.addButton("Quit", UI::quit);
        
        //Setup mouse
        UI.setMouseListener(this::doMouse);
    }
    
    /**
     * Create lamps
     */
    public void createLamps() {
        //set up the lamp pos
        for (int i = 0; i < MAXLAMPS; i++) {
            //set the lamp colour to black since it is turned off
            Color offColor = Color.black;
            UI.setColor(Color.black);
            
            //create the lamp object and put it in array
            //lampBed[i] = new Lamp(lampBed[i].getSize()*(i+1), YPOS);
            lampBed[0] = new Lamp(100, 100);
            lampBed[1]= new Lamp(200,100);
            lampBed[2] = new Lamp(300,100);
            
        }
        
        //draw each lamp
        for (Lamp lamp : lampBed) {
            lamp.draw();
        }
    }
    
    /**
     * Randomly changes the colour of the lamps in the array
     */
    public void randomChange() {
        for (int i = 0; i < 10; i++) {
            //choose a random lamp
            int randomLamp = (int) (Math.random() * MAXLAMPS); 
            
            //Make the lamp change color
            lampBed[randomLamp].changeColor();
        }
    }
    
    /** Manages the Lamp objects */
    public void doMouse(String action, double x, double y) {
        if (action.equals("clicked") && colour == 0) {
            UI.setColor(Color.black);
            
            //check the location of the x and y against location of the lamp
            for (Lamp lamp: lampBed) {
                if ((x >= lamp.getLeft()) && (x <= lamp.getRight()) &&
                (y >= lamp.getTop()) && (y <= lamp.getBottom())) {
                    lamp.changeColor();
                }
            }
        }
        
        else if (action.equals("released")){
            if (lampBed[0] == null  || lampBed[1] == null || lampBed[2] == null) {
                UI.printMessage("Press the 'Create Lamps' button first to create lamps");
                return;
            }
        }
        
        else if (action.equals("clicked") && colour != 0) {
            UI.setColor(this.currentColor);
            
            //check the location of the x and y against location of the lamp
            for (Lamp lamp: lampBed) {
                if ((x >= lamp.getLeft()) && (x <= lamp.getRight()) &&
                (y >= lamp.getTop()) && (y <= lamp.getBottom())) {
                    lamp.changeColor();
                }
            }
        }
    }   
   
    /**
     * Color changer
     */
    public void addColour() {
        colour += 1;    //add 1 to the colour so that everytime it is clicked, the colour will change
        if (colour == 0) {
            UI.setColor(Color.black);
        }
        else if (colour != 0) {
            this.currentColor = Color.getHSBColor((float)(Math.random()), 1.0f, 1.0f);
        }
    }
}
