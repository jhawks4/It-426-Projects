package adapters;

import drawing.IShape;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import shapes.Line;

public class LineAdapter implements IShape{

    Line line;

    public LineAdapter(){

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
       return line.getX();
    }

    @Override
    public double getY() {
        return line.getY();
    }

    @Override
    public double getThickness() {
        return 0;
    }

    @Override
    public Color getColor() {
        return null;
    }

    @Override
    public boolean getFilled() {
        return false;
    }

    @Override
    public void drawShape(GraphicsContext graphics) {

    }
}
