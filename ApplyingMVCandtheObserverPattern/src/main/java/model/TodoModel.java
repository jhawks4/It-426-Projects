/*
* Joshua Hawks
* 11/23/17
* TodoModel.java
* The database for the application.
*/

package model;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import exception.ExistingRecordException;

import java.io.*;
import java.util.ArrayList;
import java.util.Observable;

/**
 * Database class to hold information to be read from or add to json file.
 *
 * @author Joshua Hawks
 * @version 1.0
 */
public class TodoModel extends Observable {

    //Holds tasks.
    private ArrayList<Todo> tasks;

    private final File FILE = new File("tasks/task.json");
    private FileWriter jsonWriter;
    private Gson gson = new GsonBuilder().setPrettyPrinting().create();
    private BufferedReader jsonReader;
    private Todo[] taskList;

    //Private for singleton
    private TodoModel() {
        tasks = new ArrayList<>();
    }

    //Helper class to ensure that there is thread safety with singleton.
    private static class SingletonHelper {
        private static final TodoModel MODEL = new TodoModel();
    }

    /**
     * Instance method to get a single instance of the TodoModel class.
     *
     * @return Returns a single instance of the Todomodel class.
     */
    public static TodoModel getInstance() {
        return SingletonHelper.MODEL;
    }


    /**
     * Writes a task to the list.
     *
     * @param task The task to be added to the list.
     * @throws ExistingRecordException Exception to make sure the UUID is always unique.
     */
    public void writeJSON(Todo task) throws ExistingRecordException {

        try {

            if (tasks.size() > 0) {
                for (Todo todo : tasks) {
                    if (todo.getId().equals(task.getId())) {
                        throw new ExistingRecordException("Id already exists");
                    }
                }
            }

            tasks.add(task);
            jsonWriter = new FileWriter(FILE);

            gson.toJson(tasks, jsonWriter);

            jsonWriter.close();

            this.setChanged();
            this.notifyObservers();

        } catch (IOException exception) {
            System.out.println(exception.getMessage());
        }
    }


    /**
     * Reads the JSON file to retrieve the list.
     */
    public void readJSON() {
        try {

            if (FILE.length() > 0) {
                jsonReader = new BufferedReader(new FileReader(FILE));

                taskList = gson.fromJson(jsonReader, Todo[].class);

                for (Todo task : taskList) {
                    tasks.add(task);
                }
            }

        } catch (IOException exception) {
            System.out.println(exception.getMessage());
        }
    }

    /**
     * Gets the current size of the list.
     *
     * @return Returns an integer value of the current size of the list.
     */
    public int getSize() {
        return tasks.size();
    }

    /**
     * Gets the list.
     *
     * @return Returns a list.
     */
    public ArrayList<Todo> getTasks() {
        return tasks;
    }

    /**
     * Removes a task from the list.
     *
     * @param id The UUID to search to delete.
     */
    public void remove(String id) {

        try {
            String UUID;
            for (int i = 0; i < tasks.size(); i++) {
                UUID = "" + tasks.get(i).getId();

                if (id.equals(UUID)) {
                    tasks.remove(i);
                    jsonWriter = new FileWriter(FILE);

                    gson.toJson(tasks, jsonWriter);

                    jsonWriter.close();

                    this.setChanged();
                    this.notifyObservers();
                }
            }
        } catch (IOException exception) {
            System.out.println(exception.getMessage());
        }
    }

    /**
     * Loops to look for the original message in the list of tasks and then updates with
     * the new updated task messsage.
     *
     * @param originalMessage The original message to be searched for.
     * @param updatedMessage  The updated message to replace the found original message.
     */
    public void update(String originalMessage, String updatedMessage) {
        for (Todo task : tasks) {
            if (task.getMessage() == originalMessage) {
                task.setMessage(updatedMessage);
            }
        }
    }

}
