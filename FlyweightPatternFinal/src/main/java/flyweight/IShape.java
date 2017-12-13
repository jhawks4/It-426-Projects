/*
 * Nicholas Perez and Joshua Hawks
 * 12/11/2017
 * IShape.java
 * An interface for the flyweight pattern.
 */

package flyweight;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

/**
 * An interface that contains the flyweight pattern intrinsic state methods.
 * @author Nicholas Perez & Joshua Hawks
 * @version 1.0
 */
public interface IShape{

    /**
     * Gets the color of the shape.
     *
     * @return Returns the current color of the shape.
     */
    Color getColor();

    /**
     * Gets the x coordinate of the shape.
     *
     * @return Returns the current x coordinate of the shape.
     */
    double getX();

    /**
     * Gets the y coordinate of the shape.
     *
     * @return Returns the current y coordinate of the shape.
     */
    double getY();

    /**
     * Sets the current x coordinate with a new x coordinate.
     *
     * @param xCoordinate A new x coordinate.
     */
    void setX(int xCoordinate);

    /**
     * Sets the current y coordinate with a new y coordinate.
     *
     * @param yCoordinate A new y coordinate.
     */
    void setY(int yCoordinate);

    /**
     * A method used to draw the shape on the canvas.
     *
     * @param graphics A paramter that is used to draw the actual shape on the canvas.
     */
    void draw(GraphicsContext graphics);

}
