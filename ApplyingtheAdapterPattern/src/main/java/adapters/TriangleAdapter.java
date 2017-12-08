/*
 * Joshua Hawks
 * 12/07/2017
 * TriangleAdapter.java
 * An adapter for the Triangle class.
 */

package adapters;

import drawing.IShape;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import shapes.Triangle;

/**
 * This class is an adapter for the Triangle class and allows it to become and IShape object.
 *
 * @author Joshua Hawks
 * @version 1.0
 */
public class TriangleAdapter implements IShape {

    private static final int WIDTH_OR_HEIGHT = 50;
    private Triangle triangle;
    private IShape shape;

    /**
     * Constructor that the application uses to make the default shape.
     *
     * @param x The x coordinate.
     * @param y The y coordinate.
     */
    public TriangleAdapter(double x, double y) {
        triangle = new Triangle(x, y, WIDTH_OR_HEIGHT, WIDTH_OR_HEIGHT, 1, Color.BLACK, false);
    }

    //Constructor used for updating the shape.
    private TriangleAdapter(double x, double y, double thickness, Color color, boolean fill) {
        triangle = new Triangle(x, y, WIDTH_OR_HEIGHT, WIDTH_OR_HEIGHT, thickness, color, fill);
    }

    /**
     * A method for setting the thickness of the shape.
     *
     * @param value The size that the thickness should be.
     * @return Returns a new updated shape.
     */
    @Override
    public IShape setThickness(double value) {
        shape = new TriangleAdapter(getX(), getY(), value, getColor(), getFilled());
        return shape;
    }

    /**
     * A method for setting the color of the shape.
     *
     * @param value The color value that the shape should be.
     * @return Returns a new updated shape.
     */
    @Override
    public IShape setColor(Color value) {
        shape = new TriangleAdapter(getX(), getY(), getThickness(), value, getFilled());
        return shape;
    }

    /**
     * A method for setting whether the shape should be filled or not.
     *
     * @param value A boolean that is used to set whether the shape should be filled or not.
     * @return Returns a new updated shape.
     */
    @Override
    public IShape setFilled(boolean value) {
        shape = new TriangleAdapter(getX(), getY(), getThickness(), getColor(), value);
        return shape;
    }

    /**
     * A method for getting the x coordinate value.
     *
     * @return Returns a double that is the x coordinate.
     */
    @Override
    public double getX() {
        return triangle.getX();
    }

    /**
     * A method for getting the y coordinate value.
     *
     * @return Returns a double that is the y coordinate.
     */
    @Override
    public double getY() {
        return triangle.getY();
    }

    /**
     * A method for getting the thickness value.
     *
     * @return Returns a double that is thickness value.
     */
    @Override
    public double getThickness() {
        return triangle.getThickness();
    }

    /**
     * A method for getting the color value.
     *
     * @return Returns a Color value.
     */
    @Override
    public Color getColor() {
        return triangle.getColor();
    }

    /**
     * A method to check if the shape needs to be filled or not.
     *
     * @return If true the shape is filled.
     */
    @Override
    public boolean getFilled() {
        return triangle.isFill();
    }

    /**
     * A method for drawing the actual shape.
     *
     * @param graphics An object that is used to draw to the canvas.
     */
    @Override
    public void drawShape(GraphicsContext graphics) {

        //Coordinates for the shape.
        double[] xCoordinates = {getX(), getX() + 30, getX() + 60};
        double[] yCoordinates = {getY(), getY() - 30, getY()};

        //Provides the color for the shape
        graphics.setStroke(getColor());
        graphics.setFill(getColor());

        //Provides the thickness for the shape.
        graphics.setLineWidth(getThickness());

        //Draws the shape
        if (getFilled()) {
            graphics.fillPolygon(xCoordinates, yCoordinates, 3);
        } else {
            graphics.strokePolygon(xCoordinates, yCoordinates, 3);
        }
    }
}
