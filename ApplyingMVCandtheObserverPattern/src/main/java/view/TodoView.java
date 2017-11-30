/*
* Joshua Hawks
* 11/23/17
* TodoView.java
* The gui for the application.
*/

package view;

import control.TodoController;
import exception.ExistingRecordException;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;

import java.util.Observable;
import java.util.Observer;

/**
 * The UI for the application.
 *
 * @author Joshua Hawks
 * @version 1.0
 */
public class TodoView extends Application implements Observer {

    private TodoController controller = new TodoController();
    private Stage sceneSetter;

    //Inner class to event handling indexing.
    private class MyIndexCounter {
        private final int index;

        /**
         * Constructor for index.
         *
         * @param index Value used to increment the index.
         */
        public MyIndexCounter(int index) {
            this.index = index;
        }

        /**
         * Gets the index.
         *
         * @return Returns an integer that is used as an index for event handling.
         */
        public int getIndex() {
            return index;
        }
    }

    /**
     * Method for starting the application.
     *
     * @param stage A parameter for stage object.
     */
    @Override
    public void start(Stage stage) {

        sceneSetter = stage;

        stage.setTitle("Task List");
        stage.setScene(home());
        stage.show();
    }

    /**
     * Observer method to update the observer of any updates.
     *
     * @param o   The list of observers.
     * @param arg Arguments to be utilized if any.
     */
    @Override
    public void update(Observable o, Object arg) {
        System.out.println("You have made changes to your task list.");
    }

    //The starting scene for the application.
    private Scene home() {

        //Loads list.
        controller.loadList();

        VBox main = mainVbox();

        main.setAlignment(Pos.CENTER);

        Text title = new Text("Welcome");
        title.setId("homeTitle");

        Text numberOfUnfinishedTasks = new Text("You have " +
                controller.getSize() +
                " unfinished tasks");

        numberOfUnfinishedTasks.setId("homeText");

        //Button to go to the next scene.
        Button viewTasks = new Button("View");
        viewTasks.getStyleClass().add("viewButton");

        Image image = new Image("images/tasks.png", 100, 100,
                false, false);

        ImageView viewer = new ImageView();
        viewer.setImage(image);

        viewTasks.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                controller.addObservers(new TodoView());
                sceneSetter.setScene(taskView());
            }
        });

        main.getChildren().addAll(title, numberOfUnfinishedTasks, viewTasks, viewer);

        return returningScene(main);
    }

    //Template for the main Vbox in each scene.
    private VBox mainVbox() {
        VBox main = new VBox();
        main.setPadding(new Insets(20));
        main.setSpacing(10);
        main.getStylesheets().add("css/uiStyle.css");
        return main;
    }

    //Helper method for making the titles and assigning the css class.
    private Text titleMaker(String name) {
        Text title = new Text(name);
        title.getStyleClass().add("sceneTitle");

        return title;
    }

    //Helper method for returning the scene.
    private Scene returningScene(VBox main) {
        return new Scene(main, 300, 300);
    }

    //The main task scene.
    private Scene taskView() {
        VBox main = mainVbox();

        Text title = titleMaker("Tasks");

        HBox header = new HBox();
        header.setSpacing(150);

        //Used to display the tasks as checkbox objects.
        CheckBox[] taskList = new CheckBox[controller.getSize()];

        //Goes to the scene for adding actual tasks to the list.
        Button addTask = new Button("+");
        addTask.setId("addingTask");

        addTask.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                sceneSetter.setScene(addTask());
            }
        });

        header.getChildren().addAll(title, addTask);

        main.getChildren().add(header);

        HBox[] taskHolders = new HBox[controller.getSize()];
        Hyperlink[] edits = new Hyperlink[controller.getSize()];
        VBox[] rightTaskHolder = new VBox[controller.getSize()];
        VBox[] leftTaskHolder = new VBox[controller.getSize()];

        //Used to display message when no tasks are available or the tasks.
        if (controller.getSize() == 0) {
            Text noTasks = new Text("There are no tasks currently. " +
                    "Add a task by clicking the + button above");
            noTasks.setId("taskText");

            TextFlow wrapper = new TextFlow(noTasks);

            main.getChildren().add(wrapper);
        } else {

            for (int i = 0; i < controller.getSize(); i++) {
                MyIndexCounter index = new MyIndexCounter(i);
                taskList[i] = new CheckBox();
                taskList[i].setText(controller.getList().get(i).getMessage());
                taskList[i].setId("" + controller.getList().get(i).getId());
                taskList[i].setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        controller.removeTask(taskList[index.getIndex()].getId());
                        sceneSetter.setScene(taskView());
                    }
                });

                //Clickable link to update the message of the task.
                edits[i] = new Hyperlink("Edit");
                edits[i].setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        sceneSetter.setScene(updateTask(taskList[index.getIndex()].getText(),
                                taskList[index.getIndex()].getId()));
                    }
                });

                taskHolders[i] = new HBox();
                rightTaskHolder[i] = new VBox();
                leftTaskHolder[i] = new VBox();

                leftTaskHolder[i].setAlignment(Pos.CENTER_RIGHT);

                rightTaskHolder[i].getChildren().add(edits[i]);
                leftTaskHolder[i].getChildren().add(taskList[i]);

                taskHolders[i].getChildren().addAll(leftTaskHolder[i], rightTaskHolder[i]);

                main.getChildren().add(taskHolders[i]);
            }
        }

        return returningScene(main);
    }

    //used to update a current available task.
    private Scene updateTask(String message, String id) {
        VBox main = mainVbox();

        Text title = titleMaker("Update Task Message");

        TextArea messageBox = new TextArea();
        messageBox.setText(message);

        //Button for adding the updated task to the list.
        Button submit = new Button("Finish");
        submit.setId("submitButton");

        submit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                controller.updateTask(id, messageBox.getText());
                sceneSetter.setScene(taskView());
            }
        });

        main.getChildren().addAll(title, messageBox, submit);

        return returningScene(main);
    }

    //Scene for adding the task.
    private Scene addTask() {
        VBox main = mainVbox();

        Text title = titleMaker("Add New Task");

        TextArea messageBox = new TextArea();

        //Button for adding the new task to the list.
        Button submit = new Button("Finish");
        submit.setId("submitButton");

        submit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                try {
                    controller.addTask(messageBox.getText());
                    sceneSetter.setScene(taskView());
                } catch (ExistingRecordException exception) {
                    System.out.println(exception.getMessage());
                }

            }
        });

        main.getChildren().addAll(title, messageBox, submit);

        return returningScene(main);
    }
}
