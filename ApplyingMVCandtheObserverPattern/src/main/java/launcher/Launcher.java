/*
* Joshua Hawks
* 11/23/17
* Launcher.java
* Main class to launch application.
*/

package launcher;

import control.TodoController;
import javafx.application.Application;
import model.InitializeJSON;
import view.TodoView;

/**
 * A class to launch the appliation.
 *
 * @author Joshua Hawks
 * @version 1.0
 */
public class Launcher {

    /**
     * Main method to launch the application.
     *
     * @param args Arguments that can be passed into the application when running it from console.
     */
    public static void main(String[] args) {

        InitializeJSON.createJSON();

        Application.launch(TodoView.class, args);
    }
}
