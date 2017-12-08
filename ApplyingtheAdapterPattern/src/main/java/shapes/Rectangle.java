/*
 * Joshua Hawks
 * 12/07/2017
 * Rectangle.java
 * This file contains code for drawing a rectangle.
 */

package shapes;

import javafx.scene.paint.Color;

/**
 * A class that can draw a rectangle.
 *
 * @author Josh Archer
 * @version 1.0
 */
public class Rectangle extends Shape {
    private double width;
    private double height;

    /**
     * A constructor for making a rectangle.
     *
     * @param x         The x coordinate.
     * @param y         The y coordinate.
     * @param width     The base of the rectangle.
     * @param height    The height of the rectangle.
     * @param thickness The thickness of the rectangle border.
     * @param color     The color of the rectangle.
     * @param fill      A boolean for if the rectangle needs to be filled or not.
     */
    public Rectangle(double x, double y, double width, double height, double thickness, Color color, boolean fill) {
        super(x, y, thickness, color, fill);

        this.width = width;
        this.height = height;
    }

    /**
     * Gets the width of the rectangle.
     *
     * @return Returns a double that is the width of the rectangle.
     */
    public double getWidth() {
        return width;
    }

    /**
     * Gets the height of the rectangle.
     *
     * @return Returns a double that ist he height of the rectangle.
     */
    public double getHeight() {
        return height;
    }

    /**
     * A toString method for providing the values of the rectangle in a readable manner.
     *
     * @return Returns a string that has the values of the rectangle.
     */
    public String toString() {
        return "Rectangle [width=" + width + ", height=" + height + " " + super.toString() + "]";
    }
}
