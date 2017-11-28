/*
* Joshua Hawks
* 11/23/17
* TodoController.java
* The controller for the application.
*/

package control;

import model.Todo;
import model.TodoModel;

import java.io.File;
import java.io.FileWriter;

/**
 * Controller class for retrieving the data, adding a new task to the model,
 * and eliminating tasks from the data.
 *
 * @author Joshua Hawks
 * @version 1.0
 */
public class TodoController {

    private TodoModel model;


    //Enter a new task
    public void addTask(String taskMessage){

        model = TodoModel.getInstance();

        model.writeJSON(new Todo(taskMessage));
    }

    //Making task complete by checking checkbox

    //Retrieve list of tasks
    public void getList(){
        model = TodoModel.getInstance();

        model.readJSON();
    }
}
