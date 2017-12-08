/*
 * Joshua Hawks
 * 12/07/2017
 * Pentagon.java
 * This file contains code for drawing a pentagon.
 */

package shapes;

import javafx.scene.paint.Color;

/**
 * A class that is used to draw a pentagon.
 *
 * @author Joshua Hawks
 * @version 1.0
 */
public class Pentagon extends Triangle {

    /**
     * A constructor for making a pentagon.
     *
     * @param x         The x coordinate.
     * @param y         The y coordinate.
     * @param width     The base of the pentagon.
     * @param length    The height of the pentagon.
     * @param thickness The thickness of the pentagon border.
     * @param color     The color of the pentagon.
     * @param fill      A boolean for if the pentagon needs to be filled or not.
     */
    public Pentagon(double x, double y, double width, double length, double thickness, Color color, boolean fill) {
        super(x, y, width, length, thickness, color, fill);
    }
}
