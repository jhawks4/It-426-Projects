/*
 * Joshua Hawks
 * 12/07/2017
 * Launcher.java
 * This file launches the application.
 */

package launchers;

import javafx.application.Application;
import ui.UI;

/**
 * The is the Launcher and it launches the application.
 *
 * @author Joshua Hawks
 * @version 1.0
 */
public class Launcher {

    /**
     * This is the main method.
     *
     * @param args Parameters passed into the application when launching the application.
     */
    public static void main(String[] args) {
        Application.launch(UI.class, args);
    }
}
