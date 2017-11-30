/*
* Joshua Hawks
* 11/29/17
* initializeJSON.java
* Sets the json file.
*/

package model;

import java.io.File;
import java.io.IOException;

/**
 * A class to ensure the directory and file exist when the program runs.
 *
 * @author Joshua Hawks
 * @version 1.0
 */
public class InitializeJSON {

    private final static File FILE = new File("tasks/task.json");
    private final static File DIRECTORY = new File("tasks");

    /**
     * Static method for making the directory and json file.
     */
    public final static void createJSON() {
        try {

            //Makes the directory.
            if (DIRECTORY.mkdir()) {
                System.out.println("Directory created.");
            } else {
                System.out.println("Directory exists.");
            }

            //Makes the JSON file.
            if (FILE.createNewFile()) {
                System.out.println("File created.");
            } else {
                System.out.println("File exists.");
            }

        } catch (IOException exception) {
            System.out.println(exception.getMessage());
        }
    }
}
