/*
* Joshua Hawks
* 11/23/17
* TodoController.java
* The controller for the application.
*/

package control;

import javafx.scene.Scene;
import model.Todo;
import model.TodoModel;
import view.TodoView;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;

/**
 * Controller class for retrieving the data, adding a new task to the model,
 * and eliminating tasks from the data.
 *
 * @author Joshua Hawks
 * @version 1.0
 */
public class TodoController {

    private TodoModel model;
    private TodoView view;


    //Enter a new task
    public void addTask(String taskMessage){

        model = TodoModel.getInstance();

        model.writeJSON(new Todo(taskMessage));
    }

    //Making task complete by checking checkbox

    //Retrieve list of tasks
    public void loadList(){
        model = TodoModel.getInstance();

        model.readJSON();
    }

    public int getSize(){
        return model.getSize();
    }

    public ArrayList<Todo> getList(){
        return model.getTasks();
    }

}
