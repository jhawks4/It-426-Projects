/*
 * Joshua Hawks
 * 12/07/2017
 * SavedShapes.java
 * This file contains code for saving and updating shape objects.
 */

package drawing;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.List;

/**
 * A class used to hold shapes and update them.
 *
 * @author Josh Archer
 * @version 1.0
 */
public class SavedShapes {
    private List<IShape> shapes;

    /**
     * A basic constructor.
     */
    public SavedShapes() {
        shapes = new ArrayList<>();
    }

    /**
     * Adds a shape to a list.
     *
     * @param shape The shape to be added.
     * @return Returns true if shape is added.
     */
    public boolean add(IShape shape) {
        if (!shapes.contains(shape)) {
            shapes.add(shape);
            return true;
        }
        return false;
    }

    /**
     * A boolean for if a shape is updated.
     *
     * @param shapeToUpdate Shape to be updated.
     * @param thickness     The thickness that needs to be updated.
     * @param color         The color that needs to be updated.
     * @param filled        A boolean for if the shape needs to be filled.
     * @return Returns true if shape was updated.
     */
    public boolean update(IShape shapeToUpdate, double thickness, Color color, boolean filled) {
        //get the shape
        IShape found = null;
        for (IShape shape : shapes) {
            if (shape.equals(shapeToUpdate)) {
                found = shape;
                break;
            }
        }

        //update the shape
        if (found != null) {
            //method chaining
            shapeToUpdate.setThickness(thickness).setColor(color).setFilled(filled);
            return true;
        }

        return false;
    }

    /**
     * Draws the shape.
     *
     * @param graphics Used to draw the shapes onto the canvas.
     */
    public void drawShapes(GraphicsContext graphics) {
        //clear the graphics context
        graphics.setFill(Color.LIGHTGRAY);

        //you may change the width and height here to match your Canvas size
        graphics.fillRect(0, 0, 1000, 1000);

        for (IShape shape : shapes) {
            shape.drawShape(graphics);
        }
    }
}
