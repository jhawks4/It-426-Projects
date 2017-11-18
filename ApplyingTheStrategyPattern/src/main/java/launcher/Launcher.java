/*
* Joshua Hawks
* 11/17/2017
* Launcher.java
* This file contains code to run our application.
*/

package launcher;

import gui.PartsDatabaseUI;
import javafx.application.Application;

public class Launcher
{
    public static void main(String[] args)
    {
        Application.launch(PartsDatabaseUI.class, args);
    }
}
