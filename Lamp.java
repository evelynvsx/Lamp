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
    
    private int lampSize; 
    private int lampHeight;
    
    private Color color;            //color of the lamp
    private Color currentColor = Color.black;   //set colour of bulb to black since it is off on the start
    
    private double left;            //left of the lamp
    private double top;             //top of the lamp
    private double bottom;          //bottom of the lamp

    /** Constructor: passed the initial position.
     * Initialises the fields
     */
    public Lamp(double x, double y, int size, int stem, Color col){
        //initialise instance variables
        this.lampX = x;
        this.lampY = y;
        this.lampSize = size;
        this.lampHeight = stem;
        this.color = col;
        
        //set top, left, and bottom
        this.setTop();
        this.setLeft();
        this.setBottom();
    }
    
    /**
     * Get Left
     */
    public double getLeft() {
        return this.left;
    }
    
    /**
     * Get Right
     */
    public double getRight() {
        return this.left + this.lampSize;
    }
    
    /**
     * Get Top
     */
    public double getTop() {
        return this.top;
    }
    
    /**
     * Get Bottom
     */
    public double getBottom() {
        return this.bottom;
    }
    
    /**
     * Set left
     */
    public void setLeft() {
        this.left = this.lampX - this.lampSize/2.0;
    }
    
    /**
     * Set top
     */
    public void setTop() {
        this.top = this.lampY - this.lampSize/2.0;
    }
    
    /**
     * Set Bottom
     */
    public void setBottom() {
        this.bottom = this.lampY + this.lampHeight;
    }
    
    /**
     * Change the bulb's colour when it is clicked
     */
    public void clickBulb() {
        //change the colour of the bulb to another bright colour
        this.currentColor = Color.getHSBColor((float)(Math.random()), 1.0f, 1.0f);
        UI.setColor(this.currentColor);
    }
    
    /**
     * draws the lamp at its current position:
     * - the bulb of the right colour.
     * - the stem darkGrey
     * The height of the stem is the same as the diameter of the bulb
     * The width of the stem is a quater of its height
     */
    public void draw(){
        Color stemColour = new Color(105, 105, 105);    //put dark grey as the stem colour
        UI.setColor(stemColour);                        //set color of the stem
        UI.setLineWidth(2);                             //set width of the stem
        UI.drawLine(lampX, lampY, lampX, bottom);       //draw in stem
        
        //draw lamp
        UI.setColor(this.color);                        //set lamp color
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
     * Reports whether the point (x,y) is on the bulb.
     * (x and y represent the position where the mouse was released):
     */
    //public boolean onBulb(double x, double y){
        // an easy approximation is to pretend it is the enclosing rectangle.
        // It is nicer to do a little bit of geometry and get it right
        /*# YOUR CODE HERE */
        
    //}   

    /**
     * Reports whether the point (x,y) is on the stem.
     * (x and y represent the position where the mouse was released):
     */
    //public boolean onStem(double x, double y){
        /*# YOUR CODE HERE */
 
    //}   

    /**
     * Turns the light off.
     * Does not redraw
     */
    //public void turnOff(){
        /*# YOUR CODE HERE */
        
    //}   

    /** changeColor method (no parameters):
     * Turns the light on (if it is off)
     * Changes its color to a random bright colour (if it is already on).
     * Does not redraw
     */
    public void changeColor(){
        //Erase the flower
        this.erase();
        
        //set the position of the lamp
        this.setTop();
        this.setLeft();
        
        //changes color of bulb when its clicked
        this.clickBulb();
    }   
}
