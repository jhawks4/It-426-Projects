/*
 * Joshua Hawks
 * 12/07/2017
 * CircleAdapter.java
 * An adapter for the Circle class.
 */

package adapters;

import drawing.IShape;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import shapes.Circle;

/**
 * This class is an adapter for the Circle class and allows it to become and IShape object.
 *
 * @author Joshua Hawks
 * @version 1.0
 */
public class CircleAdapter implements IShape{

    private Circle circle;
    private IShape shape;

    /**
     * Constructor that the application uses to make the default shape.
     * @param x The x coordinate.
     * @param y The y coordinate.
     */
    public CircleAdapter(double x, double y){
        circle = new Circle(1, x, y, 1, Color.BLACK, false);
    }

    //Constructor used for updating the shape.
    private CircleAdapter(double x, double y, double thickness, Color color, boolean fill){
        circle = new Circle(1, x, y, thickness, color, fill);
    }

    /**
     * A method for setting the thickness of the shape.
     *
     * @param value The size that the thickness should be.
     * @return Returns a new updated shape.
     */
    @Override
    public IShape setThickness(double value) {
        shape = new CircleAdapter(getX(), getY(), value, getColor(), getFilled());
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
        shape = new CircleAdapter(getX(), getY(), getThickness(), value, getFilled());
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
        shape = new CircleAdapter(getX(), getY(), getThickness(), getColor(), value);
        return shape;
    }

    /**
     * A method for getting the x coordinate value.
     *
     * @return Returns a double that is the x coordinate.
     */
    @Override
    public double getX() {
        return circle.getX();
    }

    /**
     * A method for getting the y coordinate value.
     *
     * @return Returns a double that is the y coordinate.
     */
    @Override
    public double getY() {
        return circle.getY();
    }

    /**
     * A method for getting the thickness value.
     *
     * @return Returns a double that is thickness value.
     */
    @Override
    public double getThickness() {
        return circle.getThickness();
    }

    /**
     * A method for getting the color value.
     *
     * @return Returns a Color value.
     */
    @Override
    public Color getColor() {
        return circle.getColor();
    }

    /**
     * A method to check if the shape needs to be filled or not.
     *
     * @return If true the shape is filled.
     */
    @Override
    public boolean getFilled() {
        return circle.isFill();
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
            graphics.fillOval(getX(), getY(), 50, 50);
        }else {
            graphics.strokeOval(getX(), getY(), 50, 50);
        }
    }
}
