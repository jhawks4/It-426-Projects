/*
 * Joshua Hawks
 * 12/07/2017
 * Shape.java
 * This file contains code for drawing a basic shape.
 */

package shapes;

import javafx.scene.paint.Color;

/**
 * A parent class for drawing basic shapes.
 *
 * @author Josh Archer
 * @version 1.0
 */
public class Shape {
    //location
    private double x;
    private double y;

    //shape drawing settings
    private double thickness;
    private Color color;
    private boolean fill;

    /**
     * A constructor for making a basic shape.
     *
     * @param x         The x coordinate.
     * @param y         The y coordinate.
     * @param thickness The thickness of the shape.
     * @param color     The color of the shape.
     * @param fill      A boolean for if the shape needs to be filled.
     */
    public Shape(double x, double y, double thickness, Color color, boolean fill) {
        this.x = x;
        this.y = y;

        this.thickness = thickness;
        this.color = color;
        this.fill = fill;
    }

    /**
     * Gets the x coordinate of the shape.
     *
     * @return Returns a double that is the x coordinate.
     */
    public double getX() {
        return x;
    }

    /**
     * Gets the y coordinate of the shape.
     * <p>
     * return Returns a double that is the y coordinate.
     */
    public double getY() {
        return y;
    }

    /**
     * Gets the thickness of the shape.
     *
     * @return Returns a double that is the thickness of the shape.
     */
    public double getThickness() {
        return thickness;
    }

    /**
     * Gets the color of the shape.
     *
     * @return Returns a color.
     */
    public Color getColor() {
        return color;
    }

    /**
     * A boolean to check if the shape needs to be filled.
     *
     * @return Returns true if the shape needs to be filled.
     */
    public boolean isFill() {
        return fill;
    }

    /**
     * A toString to provide a readable form for the values in the shape object.
     *
     * @return Returns a readable string that contains the values of the shape object.
     */
    public String toString() {
        return "Shape [x=" + x + ", y=" + y + ", thickness=" + thickness + ", color=" + color + ", fill=" + fill + "]";
    }
}
