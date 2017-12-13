/*
 * Nicholas Perez and Joshua Hawks
 * 12/12/2017
 * ShapeFactory.java
 * A factory class for creating the flyweight object.
 */

package flyweight;


import java.util.HashMap;
import java.util.Random;

/**
 * A factory class for making circle objects.
 *
 * @author Nicholas Perez & Joshua Hawks
 * @version 1.0
 */
public class ShapeFactory{

    //HashMap to hold the Circle objects and ensure there is no duplicates.
    private static final HashMap<String, IShape> shapeMap = new HashMap<>();

    /**
     * A static method for making the actual method.
     *
     * @param color A string that is used to help set the color for the circle object.
     * @return Returns an IShape object that is of a Circle type.
     */
    public static IShape getCircle(String color){
        IShape circle = (Circle) shapeMap.get(color);
        Random random = new Random();

        //Adds a circle to the HashMap if the circle doesn't exist or
        //it sets a new x and y coordinate if the object already exists.
        if(circle == null){
            circle = new Circle(color);
            shapeMap.put(color, circle);
        }else{
            circle.setX(random.nextInt(560) + 10);
            circle.setY(random.nextInt(250) + 10);
        }

        return circle;
    }
}
