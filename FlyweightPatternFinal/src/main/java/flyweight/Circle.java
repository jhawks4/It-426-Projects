/*
 * Nicholas Perez and Joshua Hawks
 * 12/12/2017
 * Circle.java
 * A concrete class for implementing the intrinsic state for the flyweight pattern.
 */

package flyweight;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.util.Random;

/**
 * A concrete class used to give the circle shape its intrinsic and extrinsic states.
 *
 * @author Nicholas Perez & Joshua Hawks
 * @version 1.0
 */
public class Circle implements IShape{

    private static final int MINIMUM_COORDINATE_RANGE = 10;
    private final double CIRCLE_WIDTH_AND_HEIGHT = 5;
    private Random random = new Random();
    private Color color;
    private int xCoordinate, yCoordinate;

    /**
     * A constructor for making the shape.
     *
     * @param color Used to provide the color the shape.
     */
    Circle(String color){
        xCoordinate = random.nextInt(560) + MINIMUM_COORDINATE_RANGE;
        yCoordinate = random.nextInt(250) + MINIMUM_COORDINATE_RANGE;
        colorSwitch(color);
    }

    //Used to assign the color to the shape.
    private void colorSwitch(String color){
        switch(color){
            case "red":
                this.color = Color.web("#ff4747");
                break;

            case "blue":
                this.color = Color.web("#47beff");
                break;

            case "green":
                this.color = Color.web("#96ff47");
                break;

            case "yellow":
                this.color = Color.web("#fff966");
                break;

            case "purple":
                this.color = Color.web("#b966ff");
                break;
        }
    }

    /**
     * Gets the color of the shape.
     *
     * @return Returns the current color of the shape.
     */
    public Color getColor(){
        return color;
    }

    /**
     * Gets the x coordinate of the shape.
     *
     * @return Returns the current x coordinate of the shape.
     */
    public double getX(){
        return xCoordinate;
    }

    /**
     * Gets the y coordinate of the shape.
     *
     * @return Returns the current y coordinate of the shape.
     */
    public double getY(){
        return yCoordinate;
    }

    /**
     * Sets the current x coordinate with a new x coordinate.
     *
     * @param xCoordinate A new x coordinate.
     */
    @Override
    public void setX(int xCoordinate){
        this.xCoordinate = xCoordinate;
    }

    /**
     * Sets the current y coordinate with a new y coordinate.
     *
     * @param yCoordinate A new y coordinate.
     */
    @Override
    public void setY(int yCoordinate){
        this.yCoordinate = yCoordinate;
    }

    /**
     * A method used to draw the shape on the canvas.
     *
     * @param graphics A paramter that is used to draw the actual shape on the canvas.
     */
    public void draw(GraphicsContext graphics){
        graphics.setFill(getColor());
        graphics.fillOval(getX(), getY(), CIRCLE_WIDTH_AND_HEIGHT, CIRCLE_WIDTH_AND_HEIGHT);
    }

}
