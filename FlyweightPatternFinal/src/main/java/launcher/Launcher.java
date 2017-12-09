/*
 * Nicholas Perez and Joshua Hawks
 * 12/09/2017
 * Launcher.java
 * The main application launcher.
 */

package launcher;

import ui.UI;

import static javafx.application.Application.launch;

public class Launcher {
    public static void main(String[] args) {
        launch(UI.class, args);
    }
}
