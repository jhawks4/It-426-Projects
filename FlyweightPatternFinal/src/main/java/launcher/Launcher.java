/*
 * Nicholas Perez and Joshua Hawks
 * 12/09/2017
 * Launcher.java
 * The main application launcher.
 */

package launcher;

import ui.UI;

import static javafx.application.Application.launch;

/**
 * Class for running the application.
 * @author Nicholas Perez & Joshua Hawks
 * @version 1.0
 */
public class Launcher{
    /**
     * Main method that runs the application.
     * @param args Parameters that can be passed in at the start of a Java program.
     */
    public static void main(String[] args){
        launch(UI.class, args);
    }
}
