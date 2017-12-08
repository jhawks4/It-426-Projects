/*
 * Joshua Hawks
 * 12/07/2017
 * PentagonAdapter.java
 * An adapter for the Pentagon class.
 */

package adapters;

import drawing.IShape;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import shapes.Pentagon;

/**
 * This class is an adapter for the Pentagon class and allows it to become and IShape object.
 *
 * @author Joshua Hawks
 * @version 1.0
 */
public class PentagonAdapter implements IShape{

    private static final int DEFUALT_WIDTH_OR_HEIGHT = 50;
    private static final int PENTAGON_POINTS = 5;
    private Pentagon pentagon;
    private IShape shape;

    /**
     * Constructor that the application uses to make the default shape.
     * @param x The x coordinate.
     * @param y The y coordinate.
     */
    public PentagonAdapter(double x, double y){
        pentagon = new Pentagon(x, y, DEFUALT_WIDTH_OR_HEIGHT, DEFUALT_WIDTH_OR_HEIGHT, 1, Color.BLACK, false);
    }

    //Constructor used for updating the shape.
    private PentagonAdapter(double x, double y, double thickness, Color color, boolean fill){
        pentagon = new Pentagon(x, y, DEFUALT_WIDTH_OR_HEIGHT, DEFUALT_WIDTH_OR_HEIGHT, thickness, color, fill);
    }

    /**
     * A method for setting the thickness of the shape.
     *
     * @param value The size that the thickness should be.
     * @return Returns a new updated shape.
     */
    @Override
    public IShape setThickness(double value) {
        shape = new PentagonAdapter(getX(), getY(), value, getColor(), getFilled());
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
        shape = new PentagonAdapter(getX(), getY(), getThickness(), value, getFilled());
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
        shape = new PentagonAdapter(getX(), getY(), getThickness(), getColor(), value);
        return shape;
    }

    /**
     * A method for getting the x coordinate value.
     *
     * @return Returns a double that is the x coordinate.
     */
    @Override
    public double getX() {
        return pentagon.getX();
    }

    /**
     * A method for getting the y coordinate value.
     *
     * @return Returns a double that is the y coordinate.
     */
    @Override
    public double getY() {
        return pentagon.getY();
    }

    /**
     * A method for getting the thickness value.
     *
     * @return Returns a double that is thickness value.
     */
    @Override
    public double getThickness() {
        return pentagon.getThickness();
    }

    /**
     * A method for getting the color value.
     *
     * @return Returns a Color value.
     */
    @Override
    public Color getColor() {
        return pentagon.getColor();
    }

    /**
     * A method to check if the shape needs to be filled or not.
     *
     * @return If true the shape is filled.
     */
    @Override
    public boolean getFilled() {
        return pentagon.isFill();
    }

    /**
     * A method for drawing the actual shape.
     *
     * @param graphics An object that is used to draw to the canvas.
     */
    @Override
    public void drawShape(GraphicsContext graphics) {

        //Coordinates for the shape.
        double[] upperTriangleXCoordinates = {getX(), getX() + 30, getX() + 60, getX() + 60, getX()};
        double[] upperTriangleYCoordinates = {getY(), getY() - 30, getY(), getY() + DEFUALT_WIDTH_OR_HEIGHT, getY() + DEFUALT_WIDTH_OR_HEIGHT};

        //Provides the color for the shape
        graphics.setStroke(getColor());
        graphics.setFill(getColor());

        //Provides the thickness for the shape.
        graphics.setLineWidth(getThickness());

        //Draws the shape
        if(getFilled()){
            graphics.fillPolygon(upperTriangleXCoordinates, upperTriangleYCoordinates, PENTAGON_POINTS);
        }else {
            graphics.strokePolygon(upperTriangleXCoordinates, upperTriangleYCoordinates, PENTAGON_POINTS);
        }
    }
}
