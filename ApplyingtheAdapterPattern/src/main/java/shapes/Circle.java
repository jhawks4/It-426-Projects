/*
 * Joshua Hawks
 * 12/07/2017
 * Circle.java
 * This file contains code for drawing a circle.
 */

package shapes;

import javafx.scene.paint.Color;

/**
 * A class for drawing a circle.
 *
 * @author Josh Archer
 * @version 1.0
 */
public class Circle extends Shape {
    private double radius;

    /**
     * A constructor for making a circle object.
     *
     * @param radius    The radius of the circle.
     * @param x         The x coordinate of the circle.
     * @param y         The y coordinate of the circle.
     * @param thickness The thickness of the circle.
     * @param color     The color of the circle.
     * @param fill      A boolean for if the circle needs to be filled or not.
     */
    public Circle(double radius, double x, double y, double thickness, Color color, boolean fill) {
        super(x, y, thickness, color, fill);

        this.radius = radius;
    }

    /**
     * A method for getting the raduis of the circle.
     *
     * @return Returns the radius of the circle.
     */
    public double getRadius() {
        return radius;
    }

    /**
     * A string that contains the values of the circle.
     *
     * @return Returns a reable string that contains all the values of the circle object.
     */
    public String toString() {
        return "Circle [radius=" + radius + " " + super.toString() + "]";
    }
}
