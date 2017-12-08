/*
 * Joshua Hawks
 * 12/07/2017
 * LineAdapter.java
 * An adapter for the Line class.
 */

package adapters;

import drawing.IShape;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import shapes.Line;

import java.util.Random;

/**
 * This class is an adapter for the Line class and allows it to become and IShape object.
 *
 * @author Joshua Hawks
 * @version 1.0
 */
public class LineAdapter implements IShape{

    private static final int DEFAULT_X_OR_Y_COORDINATE = 50;
    private static final int BOUND = 200;
    private Line line;
    private IShape shape;

    /**
     * Constructor that the application uses to make the default shape.
     * @param x The x coordinate.
     * @param y The y coordinate.
     */
    public LineAdapter(double x, double y){
        line = new Line(x, y, x - DEFAULT_X_OR_Y_COORDINATE, y - DEFAULT_X_OR_Y_COORDINATE, 1, Color.BLACK, false);
    }

    //Constructor used for updating the shape.
    private LineAdapter(double x, double y, double thickness, Color color, boolean fill){
        line = new Line(x, y, x - DEFAULT_X_OR_Y_COORDINATE, y - DEFAULT_X_OR_Y_COORDINATE, thickness, color, fill);
    }

    /**
     * A method for setting the thickness of the shape.
     *
     * @param value The size that the thickness should be.
     * @return Returns a new updated shape.
     */
    @Override
    public IShape setThickness(double value) {
        shape = new LineAdapter(getX(), getY(), value, getColor(), getFilled());
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
        shape = new LineAdapter(getX(), getY(), getThickness(), value, getFilled());
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
        shape = new LineAdapter(getX(), getY(), getThickness(), getColor(), value);
        return shape;
    }

    /**
     * A method for getting the x coordinate value.
     *
     * @return Returns a double that is the x coordinate.
     */
    @Override
    public double getX() {
       return line.getX();
    }

    /**
     * A method for getting the y coordinate value.
     *
     * @return Returns a double that is the y coordinate.
     */
    @Override
    public double getY() {
        return line.getY();
    }

    /**
     * A method for getting the thickness value.
     *
     * @return Returns a double that is thickness value.
     */
    @Override
    public double getThickness() {
        return line.getThickness();
    }

    /**
     * A method for getting the color value.
     *
     * @return Returns a Color value.
     */
    @Override
    public Color getColor() {
        return line.getColor();
    }

    /**
     * A method to check if the shape needs to be filled or not.
     *
     * @return If true the shape is filled.
     */
    @Override
    public boolean getFilled() {
        return line.isFill();
    }

    /**
     * A method for drawing the actual shape.
     *
     * @param graphics An object that is used to draw to the canvas.
     */
    @Override
    public void drawShape(GraphicsContext graphics) {
        Random random = new Random();

        //Coordinates for the shape.
        int secondXCoordinate = random.nextInt(BOUND);
        int secondYCoordinate = random.nextInt(BOUND);

        //Provides the color for the shape
        graphics.setStroke(getColor());

        //Provides the thickness for the shape.
        graphics.setLineWidth(getThickness());

        //Draws the shape
        graphics.strokeLine(getX(), getY(), secondXCoordinate, secondYCoordinate);
    }
}
