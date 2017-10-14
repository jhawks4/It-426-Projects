/*
* Joshua Hawks
* 10/06/2017
* Calculator.java
* This file contains code for the calculator GUI.
*
*/
package ui;

import calculator.Calculator;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.stage.Stage;


/**
 * This class represents the calculator GUI.
 *
 * @author Joshua Hawks
 * @version 1.0
 */
public class CalculatorUI extends Application {

    private static final int BUTTON_SPACING = 10; //Constant variable that is used for spacing buttons and textfield.

    //Constants for my number keys.
    private enum NumberButtons {
        ONE("1", 1.0, 8), TWO("2", 2.0, 9), THREE("3", 3.0, 10), FOUR("4", 4.0, 4), FIVE("5", 5.0, 5),
        SIX("6", 6.0, 6), SEVEN("7", 7.0, 0), EIGHT("8", 8.0, 1), NINE("9", 9.0, 2), ZERO("0", 0.0, 12);

        private double value;
        private String keyName;
        private int keyGridLocation;

        NumberButtons(String keyName, double value, int keyGridLocation){

            this.keyName = keyName;
            this.value = value;
            this.keyGridLocation = keyGridLocation;
        }
    }

    //Constants for my operator keys.
    private enum OperatorButtons{

        PLUS("+", 3), MINUS("-", 7), MULTIPLY("*", 11), ENTER("Enter", 13),
        CLEAR("Clear", 14), DIVIDE("/", 15), SQUARED("x^2", 16),
        CUBED("x^3", 17), POWER("x^y", 18), PERCENTAGE("%", 19);

        private String keyName;
        private int keyGridLocation;

        OperatorButtons(String keyName, int keyGridLocation){
            this.keyName = keyName;
            this.keyGridLocation = keyGridLocation;
        }

    }

    //Provides a way to manipulate the event handler using arrays.
    private class SetOnActionIndex {
        private final int index;

        private SetOnActionIndex(int index){
            this.index = index;
        }

        //Gets the index for the arrays in the event handler.
        public int getIndex(){
            return index;
        }
    }

    //A controller to do the calculations for the calculator.
    private Calculator controller = new Calculator();

    /**
     * This method is used to set the scene and display that scene.
     *
     * @param stage This parameter is used to pass in a Stage object that is used to set the Scene Object and display it.
     */
    @Override
    public void start(Stage stage) {

        //Initializing a scene object.
        Scene myScene = calculatorLayout();

        //Adding CSS nodes into the scene.
        myScene.getStylesheets()
                .addAll("css/calculatorCSS.css",
                        "https://fonts.googleapis.com/css?family=Pangolin");

        //Sets the title of the application window.
        stage.setTitle("Calculator");

        //Sets the scene object that will be displayed.
        stage.setScene(myScene);

        //Displays the scene object.
        stage.show();

    }

    //Provides the layout for the scene object.
    private Scene calculatorLayout(){

        //Initializing button array that will be used to hold the calculator buttons.
        Button[] calculatorButtons;
        TextField screen = new TextField();

        //Instantiating Vbox, Hboxes, GridPane, and TextField objects.
        VBox vBox = new VBox();
        HBox calculatorScreen = new HBox();
        GridPane calculatorControls = new GridPane();

        //Sets alignment for buttons and textfield.
        screen.setAlignment(Pos.CENTER_RIGHT);
        vBox.setAlignment(Pos.CENTER);
        calculatorControls.setAlignment(Pos.CENTER);
        calculatorScreen.setAlignment(Pos.CENTER);

        //Sets the spacing between buttons and textfield.
        vBox.setSpacing(BUTTON_SPACING);
        calculatorControls.setVgap(BUTTON_SPACING);
        calculatorControls.setHgap(BUTTON_SPACING);

        //Calls method that provides buttons to button array.
        calculatorButtons = makeButtons(NumberButtons.values(), NumberButtons.values().length,
                OperatorButtons.values(), OperatorButtons.values().length, screen);

        //Calls a method for adding upper buttons of the calculator to the gridpane.
        addingFirstTwelveUpperButtons(calculatorControls, calculatorButtons);

        //Adds the Hbox that will hold the textfield to the gridpane.
        calculatorControls.add(calculatorScreen, 0, 4);

        //Adds the textfield to the Hbox.
        calculatorScreen.getChildren().add(screen);

        //buttonAction(calculatorButtons, screen);


        //Adds the gridpane and two Hboxes to the Vbox.
        vBox.getChildren().addAll(calculatorControls, calculatorScreen);

        return new Scene(vBox, 330, 300);
    }

    //A method that returns an array of buttons.
    private Button[] makeButtons(NumberButtons[] numberButtons, int numberButtonsLength,
                                 OperatorButtons[] operatorButtons, int operatorButtonLength, TextField screen){

        int buttonArrayLength = numberButtonsLength + operatorButtonLength; //Used to set the size of the temp array.
        int indexForOperator = 0; //Index for outer array.

        //Temporary button array.
        Button[] tempButtons = new Button[buttonArrayLength];

        //Used to make new number buttons with the correct names and set their events.
        for(int i = 0; i < numberButtonsLength; i++){
            SetOnActionIndex index = new SetOnActionIndex(i);
            tempButtons[numberButtons[i].keyGridLocation] = new Button(numberButtons[i].keyName);

            //Provides the data to the numerical data to the Calculator class.
            tempButtons[numberButtons[i].keyGridLocation].setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    controller.setTextAndNumericalValue(numberButtons[index.getIndex()].keyName,
                                                           numberButtons[index.getIndex()].value);
                    screen.setText(controller.getInputText());
                }
            });
        }

        //Used to make new operator buttons and set their events.
        for(int i = 0; i < buttonArrayLength; i++){
            if(tempButtons[i] == null){
                SetOnActionIndex index = new SetOnActionIndex(indexForOperator);
                tempButtons[operatorButtons[indexForOperator].keyGridLocation] =
                        new Button(operatorButtons[indexForOperator].keyName);
                tempButtons[operatorButtons[indexForOperator].keyGridLocation].
                        setOnAction(new EventHandler<ActionEvent>() {
                            @Override
                            public void handle(ActionEvent event) {
                                //Provides unique controls to certain operator keys.
                                if(operatorButtons[index.getIndex()].keyName == "Enter"){
                                    controller.enter(controller.getPrimaryNumber(),
                                                     controller.getSecondaryNumber(),
                                                     controller.getOperator());
                                    controller.setAfterEnter(controller.getAnswer());
                                    screen.setText(controller.getInputText());
                                }else if(operatorButtons[index.getIndex()].keyName == "Clear"){
                                    screen.setText(controller.clearScreen());
                                    controller.clearAll();
                                }else if(operatorButtons[index.getIndex()].keyName == "x^2"){
                                    screen.setText(controller.clearScreen());
                                    controller.squared();
                                    controller.setAfterEnter(controller.getAnswer());
                                    screen.setText(controller.getInputText());
                                }else if(operatorButtons[index.getIndex()].keyName == "x^3"){
                                    screen.setText(controller.clearScreen());
                                    controller.cubed();
                                    controller.setAfterEnter(controller.getAnswer());
                                    screen.setText(controller.getInputText());
                                }else if(operatorButtons[index.getIndex()].keyName == "%"){
                                    screen.setText(controller.clearScreen());
                                    controller.percentile();
                                    controller.setAfterEnter(controller.getAnswer());
                                    screen.setText(controller.getInputText());
                                }else{
                                    controller.setOperator(operatorButtons[index.getIndex()].keyName);
                                    screen.setText(controller.clearScreen());
                                }
                            }
                        });
                indexForOperator++;
            }
        }

        return tempButtons;
    }

    //Method for adding buttons to the gridpane.
    private void addingFirstTwelveUpperButtons(GridPane controlButtonGrid, Button[] controlButtons){

        //Used as the index for button array that is passed into the method.
        int initialIndex = 0;

        //Adds each button to the correct position in the gridpane.
        for(int row = 0; row < 5; row++){
            for(int column = 0; column < 4; column++){
                controlButtonGrid.add(controlButtons[initialIndex], column, row);
                initialIndex++;
            }
        }
    }
}
