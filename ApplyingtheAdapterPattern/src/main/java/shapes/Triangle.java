/*
 * Joshua Hawks
 * 12/07/2017
 * Triangle.java
 * This file contains code for making a triangle.
 */

package shapes;

import javafx.scene.paint.Color;

/**
 * A class for drawing a triangle.
 *
 * @author Josh Archer
 * @version 1.0
 */
public class Triangle extends Rectangle {
    /**
     * A constructor for making a triangle.
     *
     * @param x         The x coordinate.
     * @param y         The y coordinate.
     * @param width     The base of the triangle.
     * @param length    The height of the triangle.
     * @param thickness The thickness of the triangle border.
     * @param color     The color of the triangle.
     * @param fill      A boolean for if the triangle needs to be filled or not.
     */
    //triangles are defined according to their bounding box
    public Triangle(double x, double y, double width, double length, double thickness, Color color, boolean fill) {
        super(x, y, width, length, thickness, color, fill);
    }
}
