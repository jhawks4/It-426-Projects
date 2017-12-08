/*
 * Joshua Hawks
 * 12/07/2017
 * RectangleAdapter.java
 * An adapter for the Rectangle class.
 */

package adapters;

import drawing.IShape;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import shapes.Rectangle;

/**
 * This class is an adapter for the Rectangle class and allows it to become and IShape object.
 *
 * @author Joshua Hawks
 * @version 1.0
 */
public class RectangleAdapter implements IShape{

    private Rectangle rectangle;
    private IShape shape;

    /**
     * Constructor that the application uses to make the default shape.
     * @param x The x coordinate.
     * @param y The y coordinate.
     */
    public RectangleAdapter(double x, double y){
        rectangle = new Rectangle(x, y, 50, 50, 1, Color.BLACK, false);
    }

    //Constructor used for updating the shape.
    private RectangleAdapter(double x, double y, double thickness, Color color, boolean fill){
        rectangle = new Rectangle(x, y, 50, 50, thickness, color, fill);
    }

    /**
     * A method for setting the thickness of the shape.
     *
     * @param value The size that the thickness should be.
     * @return Returns a new updated shape.
     */
    @Override
    public IShape setThickness(double value) {
        shape = new RectangleAdapter(getX(), getY(), value, getColor(), getFilled());
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
        shape = new RectangleAdapter(getX(), getY(), getThickness(), value, getFilled());
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
        shape = new RectangleAdapter(getX(), getY(), getThickness(), getColor(), value);
        return shape;
    }

    /**
     * A method for getting the x coordinate value.
     *
     * @return Returns a double that is the x coordinate.
     */
    @Override
    public double getX() {
        return rectangle.getX();
    }

    /**
     * A method for getting the y coordinate value.
     *
     * @return Returns a double that is the y coordinate.
     */
    @Override
    public double getY() {
        return rectangle.getY();
    }

    /**
     * A method for getting the thickness value.
     *
     * @return Returns a double that is thickness value.
     */
    @Override
    public double getThickness() {
        return rectangle.getThickness();
    }

    /**
     * A method for getting the color value.
     *
     * @return Returns a Color value.
     */
    @Override
    public Color getColor() {
        return rectangle.getColor();
    }

    /**
     * A method to check if the shape needs to be filled or not.
     *
     * @return If true the shape is filled.
     */
    @Override
    public boolean getFilled() {
        return rectangle.isFill();
    }

    /**
     * A method for drawing the actual shape.
     *
     * @param graphics An object that is used to draw to the canvas.
     */
    @Override
    public void drawShape(GraphicsContext graphics) {

        //Provides the color for the shape
        graphics.setStroke(getColor());
        graphics.setFill(getColor());

        //Provides the thickness for the shape.
        graphics.setLineWidth(getThickness());

        //Draws the shape
        if(getFilled()){
            graphics.fillRect(getX(), getY(), 100, 50);
        }else {
            graphics.strokeRect(getX(), getY(), 100, 50);
        }
    }
}
