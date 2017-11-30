/*
* Joshua Hawks
* 11/23/17
* TodoController.java
* The controller for the application.
*/

package control;

import exception.ExistingRecordException;

import model.Todo;
import model.TodoModel;
import view.TodoView;

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

    /**
     * Adds a task to the list.
     *
     * @param taskMessage The task that the user writes to do.
     * @throws ExistingRecordException An exception to ensure that the UUID doesn't insert a duplicate id.
     */
    public void addTask(String taskMessage) throws ExistingRecordException {

        model = TodoModel.getInstance();

        model.writeJSON(new Todo(taskMessage));
    }

    /**
     * Loads the list of tasks.
     */
    public void loadList() {
        model = TodoModel.getInstance();

        model.readJSON();
    }

    /**
     * Get the size of the list.
     *
     * @return Returns an integer value of the size of the list.
     */
    public int getSize() {
        return model.getSize();
    }

    /**
     * Gets the list.
     *
     * @return Returns the list.
     */
    public ArrayList<Todo> getList() {
        return model.getTasks();
    }

    /**
     * Adds an observer to the model.
     *
     * @param observer An observer to be added.
     */
    public void addObservers(TodoView observer) {
        if (model.countObservers() == 0) {
            model.addObserver(observer);
        }
    }

    /**
     * Removes a task from the list.
     *
     * @param id The UUID to compare with.
     */
    public void removeTask(String id) {
        model.remove(id);
    }

    /**
     * Updates a current task message.
     *
     * @param originalMessage The original message string.
     * @param updatedMessage  The updated messsage string.
     */
    public void updateTask(String originalMessage, String updatedMessage) {
        model.update(originalMessage, updatedMessage);
    }

}
