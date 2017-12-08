/*
 * Joshua Hawks
 * 12/07/2017
 * UI.java
 * This file contains the ui for the application.
 */

package ui;

import adapters.*;
import drawing.IShape;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * A class for displaying the ui and allowing the user to draw shapes.
 *
 * @author Joshua Hawks
 * @version 1.0
 */
public class UI extends Application {

    private static final int APPLICATION_WINDOW_WIDTH = 1000;
    private static final int APPLICATION_WINDOW_HEIGHT = 500;
    private static final int INITIAL_DEFAULT_VALUE = 1;
    private IShape shape;

    /**
     * A method used to display the ui.
     *
     * @param stage A paramtere used to get access to stage methods for displaying the ui.
     */
    @Override
    public void start(Stage stage) {

        stage.setTitle("Doodle Pad");
        stage.setScene(artWindow());
        stage.show();
    }

    //The scene that contains the ui.
    private Scene artWindow() {

        VBox window = new VBox();
        window.setAlignment(Pos.TOP_CENTER);

        //Used to hold all the drawing options.
        ToolBar drawingTools = new ToolBar();
        drawingTools.setPrefWidth(APPLICATION_WINDOW_WIDTH);

        //Used for drawing
        Canvas canvas = new Canvas(APPLICATION_WINDOW_WIDTH, APPLICATION_WINDOW_HEIGHT);

        //Used to do the drawing.
        GraphicsContext graphics = canvas.getGraphicsContext2D();

        //Used for toggling the shapes that are to be drawn
        ToggleGroup shapesButtons = new ToggleGroup();

        //Buttons for the shapes.
        ToggleButton line = new ToggleButton("Line");
        ToggleButton circle = new ToggleButton("Circle");
        ToggleButton rectangle = new ToggleButton("Rectangle");
        ToggleButton triangle = new ToggleButton("Triangle");
        ToggleButton starOfDavid = new ToggleButton("PentagonAdapter");

        //Used for the switch statement to determine which shape to draw.
        Text shapeText = new Text();

        //Grouping the toggle buttons and applying the appropriate string for the shape to be drawn.
        line.setToggleGroup(shapesButtons);
        line.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                shapeText.setText(line.getText());
            }
        });

        circle.setToggleGroup(shapesButtons);
        circle.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                shapeText.setText(circle.getText());
            }
        });

        rectangle.setToggleGroup(shapesButtons);
        rectangle.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                shapeText.setText(rectangle.getText());
            }
        });

        triangle.setToggleGroup(shapesButtons);
        triangle.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                shapeText.setText(triangle.getText());
            }
        });

        starOfDavid.setToggleGroup(shapesButtons);
        starOfDavid.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                shapeText.setText(starOfDavid.getText());
            }
        });

        //Check box for filling a shape.
        CheckBox fill = new CheckBox("fill");

        //A color picker for changing the color of the shape.
        final ColorPicker colorPicker = new ColorPicker(Color.BLACK);
        colorPicker.setPrefWidth(50);

        Label thicknessLabel = new Label("Thickness");

        //Holds the value for the thickness.
        TextField thicknessText = new TextField("1");
        thicknessText.setPrefWidth(30);

        //A slider that can be used to set the thickness of the shape.
        Slider thicknessSlider = new Slider();
        thicknessSlider.setMin(INITIAL_DEFAULT_VALUE);
        thicknessSlider.setMax(10);
        thicknessSlider.setValue(INITIAL_DEFAULT_VALUE);
        thicknessSlider.setShowTickLabels(true);
        thicknessSlider.setPrefWidth(100);

        //Used to change the value in the textfield for the thickness value.
        thicknessSlider.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                thicknessText.setText("" + (int) thicknessSlider.getValue());
            }
        });

        //Used to change the slider if the value in the textfield is changed.
        thicknessText.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (!newValue.isEmpty()) {
                    thicknessSlider.setValue(Double.parseDouble(newValue));
                }
            }
        });

        //Adding the drawing options to the toolbar.
        drawingTools.getItems().addAll(line, circle, rectangle, triangle, starOfDavid, fill,
                colorPicker, thicknessLabel, thicknessText,
                thicknessSlider);

        //Adding the toolbar and canvas to the Vbox.
        window.getChildren().addAll(drawingTools, canvas);

        //Used for drawing onto the canvas when the user clicks on the canvas
        // after making a shape selection.
        canvas.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {

                double xCoordinate = event.getX();
                double yCoordinate = event.getY();

                switch (shapeText.getText()) {
                    case "Line":
                        shape = new LineAdapter(xCoordinate, yCoordinate);
                        break;

                    case "Rectangle":
                        shape = new RectangleAdapter(xCoordinate, yCoordinate);
                        break;

                    case "Circle":
                        shape = new CircleAdapter(xCoordinate, yCoordinate);
                        break;

                    case "Triangle":
                        shape = new TriangleAdapter(xCoordinate, yCoordinate);
                        break;

                    case "PentagonAdapter":
                        shape = new PentagonAdapter(xCoordinate, yCoordinate);
                        break;
                }

                //Ensures that the shape is not null.
                if (shape != null) {
                    shape = shape.setColor(Color.web("" + colorPicker.getValue()))
                            .setThickness(thicknessSlider.getValue())
                            .setFilled(fill.isSelected());
                    shape.drawShape(graphics);
                }
            }
        });

        return new Scene(window, APPLICATION_WINDOW_WIDTH, APPLICATION_WINDOW_HEIGHT);
    }
}
