import ecs100.*;
import java.awt.Color;

/** Exercise for WGC 13DT
 * Name: Evelyn
 * Email: salimev@wgc.school.nz
 * Date: 31/03/22
 */

/** A Lamp object represents a table lamp on the graphics pane. A lamp consists of a colored bulb and a stem.
 *   It remembers its current position, its color and whether it is on or off.
 *   Its initial position and its color are set when it is constructed.
 *   The diameter of a bulb should be 80.
 *   The height of the stem should be 80.
 *   The width of the stem should be 20.
 *   It has three methods:
 *     draw(),        which draws the lamp at its current position.
 *     onBulb(x,y),   which reports whether the point(x,y) is on the bulb.
 *     onStem(x,y),   which reports whether the point(x,y) is on the stem.
 *     turnOff(),     which turns the light off.
 *     changeColor(), which turns the light on if it is off; changes its color to a random bright colour if it is already on. 
 */

public class Lamp
{
    // set size and width of the bulb and stem
    public static final double SIZE = 80;  // diameter of the bulb and height of the stem
    public static final double WIDTH = SIZE/4; // width of the stem
    
    //instance variables
    private double lampX = -100;    //x position of the lamp
    private double lampY = -100;    //y position of the lamp
    
    private double bulbX;
    private double bulbY;
      
    private double lampSize; 
    private double lampHeight;
    private double lampWidth;
    
    private Color color;            //color of the lamp
    private Color currentColor = Color.black;   //set colour of bulb to black since it is off on the start
    private int changeColor = 0;
    
    private double left;            //left of the lamp
    private double top;             //top of the lamp
    private double bottom;          //bottom of the lamp
    
    private double leftStem;        //left of the stem
    private double topStem;         //top of the stem
    private double bottomStem;      //bottom of the stem   
    
    /** Constructor: passed the initial position.
     * Initialises the fields
     */
    public Lamp(double x, double y){
        //initialise instance variables
        this.lampX = x;
        this.lampY = y;
        this.lampSize = SIZE;
        this.lampHeight = SIZE;
        
        currentColor = Color.black;
        this.color = currentColor;
        
        //set top, left, and bottom
        this.setTop();
        this.setLeft();
        this.setBottom();
    }
    
    /**
     * Get Left, right, top, bottom
     */
    public double getLeft() {
        return this.left;
    }
    public double getRight() {
        return this.left + this.lampSize;
    }
    public double getTop() {
        return this.top;
    }
    public double getBottom() {
        return this.bottom;
    }
    
    /**
     * Set left, top, bottom
     */
    public void setLeft() {
        this.left = this.lampX - this.lampSize/2.0;
    }
    public void setTop() {
        this.top = this.lampY - this.lampSize/2.0;
    }
    public void setBottom() {
        this.bottom = this.lampY + this.lampHeight;
    }
    
    /**
     * Change the bulb's colour when it is clicked
     */
    public void addColor() {
        //change the colour of the bulb to another bright colour
        // this.currentColor = Color.getHSBColor((float)(Math.random()), 1.0f, 1.0f);
        UI.setColor(this.currentColor);
    }
    
    /**
     * Get size method
     */
    public double getSize() {
        return SIZE;
    }
    
    /**
     * draws the lamp at its current position:
     * - the bulb of the right colour.
     * - the stem darkGrey
     * The height of the stem is the same as the diameter of the bulb
     * The width of the stem is a quater of its height
     */
    public void draw(){
        //draw stem
        Color stemColour = new Color(105, 105, 105);    //put dark grey as the stem colour
        UI.setColor(stemColour);                        //set color of the stem
        UI.setLineWidth(WIDTH);                         //set width of the stem
        UI.drawLine(lampX, lampY, lampX, bottom);       //draw in stem
        
        //draw lamp
        UI.setColor(this.currentColor);                 //set lamp color
        UI.fillOval(left, top, lampSize, lampSize);     //draw lamp
        UI.sleep(500);                                  //wait
    }   
    
    /**
     * Erase a rectangle around the current object
     */
    public void erase() {
        final int BUFFER = 1;
        UI.eraseRect(left, top, lampSize+1, bottom+BUFFER);
    }
    
    /**
     * Checks whether the point (x,y) is on the bulb or the stem
     * (x and y represent the position where the mouse was released)
     */
    public double checkPos(double x, double y, double bulbX, double bulbY) {
        return Math.sqrt((bulbY - y) * (bulbY - y) + (bulbX - x) * (bulbX - x));
    }
    
    /** 
     * Reports whether the point (x,y) is on the bulb.
     * (x and y represent the position where the mouse was released):
     */
    public boolean onBulb(double x, double y) {
        bulbX = left+40;
        bulbY = top +40;
        
        if (checkPos(x, y, bulbX, bulbY) < SIZE) {
            return true;
        }
        else{
            return false;
        }
    }
    
    /**
     * Reports whether the point (x,y) is on the stem.
     * (x and y represent the position where the mouse was released):
     */
    public boolean onStem(double x, double y){
        /*# YOUR CODE HERE */
        if ((x >= left) && (x <= left) && (y >= top+SIZE) && (y <= top+2*SIZE))
        {
            return true;
        }
        else {
            return false;
        }
    }   

    /**
     * Turns the light off.
     * Does not redraw
     */
    public void turnOff(){
        //If the stem is clicked, turn off the lamp 
        Color turnOff = new Color(0,0,0);
        UI.setColor(turnOff);
    }    
    
    /**
     * Make the lamp change Color
     */
    public void changeColor() {
        //Erase the lamp
        this.erase();

        currentColor = Color.getHSBColor((float)(Math.random()), 1.0f, 1.0f);
        UI.setColor(this.currentColor);
        
        this.draw();
    }
}
