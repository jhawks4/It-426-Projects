/*
* Joshua Hawks
* 10/06/2017
* Calculator.java
* This file contains code for the calculator GUI.
*
*/
package ui;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import java.io.File;

/**
 * This class represents the calculator GUI.
 *
 * @author Joshua Hawks
 * @version 1.0
 */
public class CalculatorUI extends Application {

    private static final int BUTTON_SPACING = 10; //Constant variable that is used for spacing buttons and textfield.
    private static final int ENTER = 13;          //Constant variable for the index holding the enter button.
    private static final int ZERO = 12;           //Constant variable for the index holding the number zero button.
    private static final int DIVIDE_SYMBOL = 14;  //Constant variable for the index holding the division symbol button.

    //A string array that provides the text for the buttons.
    private static final String[] BUTTON_NAMES = {"7", "8", "9", "+", "4", "5", "6",
                                                 "-", "1", "2", "3", "*", "0", "Enter",
                                                 "/"};

    /**
     * This method is used to set the scene and display that scene.
     *
     * @param stage This parameter is used to pass in a Stage object that is used to set the Scene Object and display it.
     */
    @Override
    public void start(Stage stage) {

        //A try catch block to ensure that if we fail to get our CSS files, then it displays an error in the console.
        try{

            //Initializing a scene object.
            Scene myScene = calculatorLayout();

            //Adding CSS nodes into the scene.
            myScene.getStylesheets()
                    .addAll(new File("src/css/calculatorCSS.css").toURI().toURL().toString(),
                                            "https://fonts.googleapis.com/css?family=Pangolin");

            //Sets the title of the application window.
            stage.setTitle("Calculator");

            //Sets the cene object that will be displayed.
            stage.setScene(myScene);

            //Displays the scene object.
            stage.show();

        }catch (Exception fileException){

            //Error message.
            System.out.println("This is the error: " + fileException.getMessage());
        }

    }

    /**
     * This method is used to create the calculator layout.
     *
     * @return The method returns a scene object
     */
    //Provides the layout for the scene object.
    public Scene calculatorLayout(){

        //Initializing button array that will be used to hold the calculator buttons.
        Button[] calculatorButtons;

        //Instantiating Vbox, Hboxes, GridPane, and TextField objects.
        VBox vBox = new VBox();
        HBox calculatorScreen = new HBox();
        HBox bottomCalculatorControls = new HBox();
        GridPane calculatorControls = new GridPane();
        TextField screen = new TextField();

        //Sets alignment for buttons and textfield.
        screen.setAlignment(Pos.CENTER_RIGHT);
        vBox.setAlignment(Pos.CENTER);
        calculatorControls.setAlignment(Pos.CENTER);
        bottomCalculatorControls.setAlignment(Pos.CENTER);
        calculatorScreen.setAlignment(Pos.CENTER);

        //Sets the spacing between buttons and textfield.
        vBox.setSpacing(BUTTON_SPACING);
        calculatorControls.setVgap(BUTTON_SPACING);
        calculatorControls.setHgap(BUTTON_SPACING);
        bottomCalculatorControls.setSpacing(BUTTON_SPACING);

        //Calls method that provides buttons to button array.
        calculatorButtons = makeButtons(BUTTON_NAMES, BUTTON_NAMES.length);

        //Sets the id of the button.
        calculatorButtons[ENTER].setId("enterButton");

        //Hbox that is used to format the location of the bottom three buttons.
        bottomCalculatorControls.getChildren().addAll(calculatorButtons[ZERO],
                                                      calculatorButtons[ENTER],
                                                      calculatorButtons[DIVIDE_SYMBOL]);

        //Calls a method for adding upper buttons of the calculator to the gridpane.
        addingFirstTwelveUpperButtons(calculatorControls, calculatorButtons);

        //Adds the Hbox that will hold the textfield to the gridpane.
        calculatorControls.add(calculatorScreen, 0, 4);

        //Adds the textfield to the Hbox.
        calculatorScreen.getChildren().add(screen);

        //Adds the gridpane and two Hboxes to the Vbox.
        vBox.getChildren().addAll(calculatorControls, bottomCalculatorControls, calculatorScreen);

        return new Scene(vBox, 260, 230);
    }

    //A method that returns an array of buttons.
    private Button[] makeButtons(String[] buttons, int size){

        //Temporary button array.
        Button[] tempButtons = new Button[size];

        //Used to make new buttons with the correct names.
        for (int i = 0; i < size; i++){
            tempButtons[i] = new Button(buttons[i]);
        }

        return tempButtons;
    }

    //Method for adding buttons to the gridpane.
    private void addingFirstTwelveUpperButtons(GridPane controlButtonGrid, Button[] controlButtons){

        //Used as the index for button array that is passed into the method.
        int initialIndex = 0;

        //Adds each button to the correct position in the gridpane.
        for (int row = 0; row <= 2; row++){
            for (int column = 0; column <= 3; column++){
                controlButtonGrid.add(controlButtons[initialIndex], column, row);
                initialIndex++;
            }
        }
    }
}
