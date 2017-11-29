/*
* Joshua Hawks
* 11/23/17
* TodoView.java
* The gui for the application.
*/

package view;

import control.TodoController;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;

import java.util.Observable;
import java.util.Observer;

public class TodoView extends Application implements Observer{

    private TodoController controller = new TodoController();
    private Stage sceneSetter;

    @Override
    public void start(Stage stage) {

        sceneSetter = stage;
        stage.setTitle("Task List");
        stage.setScene(home());
        stage.show();

    }

    @Override
    public void update(Observable o, Object arg) {
        System.out.println("You have added a task.");
    }

    private Scene home(){

        controller.loadList();

        VBox main = new VBox();
        main.setAlignment(Pos.CENTER);

        Text title = new Text("Welcome");

        Text numberOfUnfinishedTasks = new Text("You have " +
                                                controller.getSize() +
                                                " unfinished tasks");

        Button viewTasks = new Button("View");

        viewTasks.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
               sceneSetter.setScene(taskView());
            }
        });

        main.getChildren().addAll(title, numberOfUnfinishedTasks, viewTasks);

        return returningScene(main);
    }
    

    private Scene returningScene(VBox main){
        return new Scene(main, 250, 250);
    }

    private Scene taskView(){
        VBox main = new VBox();
        Text title = new Text("Tasks");
        main.setPadding(new Insets(20));
        main.setSpacing(10);

        HBox header = new HBox();
        header.setSpacing(20);

        Button addTask = new Button("+");

        header.getChildren().addAll(title, addTask);

        main.getChildren().add(header);

        if(controller.getSize() == 0){
            Text noTasks = new Text("There are no tasks currently. " +
                                    "Add a task by clicking the + button above");

            TextFlow wrapper = new TextFlow(noTasks);

            main.getChildren().add(wrapper);
        }else {

        }

        TitledPane t1 = new TitledPane("T1", new Button("B1"));

        main.getChildren().add(t1);

        return returningScene(main);
    }

}
