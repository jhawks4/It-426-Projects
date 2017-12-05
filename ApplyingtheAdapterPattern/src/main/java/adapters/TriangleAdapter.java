package adapters;

import drawing.IShape;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import shapes.Triangle;

public class TriangleAdapter implements IShape{

     Triangle triangle;
     IShape actualTriangle;

     TriangleAdapter(double x, double y, double width, double length, double thickness, Color color, boolean fill){
         triangle = new Triangle(x, y, width, length, thickness, color, fill);
     }

    @Override
    public IShape setThickness(double value) {
        return null;
    }

    @Override
    public IShape setColor(Color value) {
        return null;
    }

    @Override
    public IShape setFilled(boolean value) {
        return null;
    }

    @Override
    public double getX() {
        return triangle.getX();
    }

    @Override
    public double getY() {
        return triangle.getY();
    }

    @Override
    public double getThickness() {
        return triangle.getThickness();
    }

    @Override
    public Color getColor() {
        return triangle.getColor();
    }

    @Override
    public boolean getFilled() {
        return triangle.isFill();
    }

    @Override
    public void drawShape(GraphicsContext graphics) {

    }
}
