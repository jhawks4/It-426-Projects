/*
* Joshua Hawks
* 10/06/2017
* Calculator.java
* This file contains code for launching our simple calculator application.
*/
package launcher;

import javafx.application.Application;
import ui.CalculatorUI;

/**
 * This class represents the application launcher.
 *
 * @author Joshua Hawks
 * @version 1.0
 */
public class Launcher {

    /**
     * The main method to the calcultaor application.
     *
     * @param args This parameter provides the application the various arguments that it requires to execute.
     */
    public static void main(String[] args) {

        //Code to launch the CalculatorUI class.
        Application.launch(CalculatorUI.class, args);
    }
}
