/*
* Joshua Hawks
* 11/17/2017
* Launcher.java
* This file contains code to run our application.
*/

package launcher;

import gui.PartsDatabaseUI;
import javafx.application.Application;

/**
 * Launches the application.
 *
 * @author Joshua Hawks
 * @version 1.0
 */
public class Launcher {


    /**
     * The main method.
     *
     * @param args Arguments that may be passed into the main method for execution.
     */
    public static void main(String[] args) {

        //Launches the javafx application.
        Application.launch(PartsDatabaseUI.class, args);
    }
}
