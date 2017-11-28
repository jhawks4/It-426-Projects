/*
* Joshua Hawks
* 11/23/17
* TodoView.java
* The gui for the application.
*/

package view;

import javafx.application.Application;
import javafx.stage.Stage;
import model.TodoModel;

import java.util.Observable;
import java.util.Observer;

public class TodoView extends Application implements Observer{


    @Override
    public void start(Stage stage) {

        stage.setTitle("Task List");
        stage.show();

    }

    @Override
    public void update(Observable o, Object arg) {
        System.out.println("You have added a task.");
    }
}
