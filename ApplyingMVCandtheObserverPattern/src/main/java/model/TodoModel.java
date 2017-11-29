/*
* Joshua Hawks
* 11/23/17
* TodoModel.java
* The database for the application.
*/

package model;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;
import java.util.ArrayList;
import java.util.Observable;

/**
 * Database class to hold information to be read from or add to json file.
 *
 * @author Joshua Hawks
 * @version 1.0
 */
public class TodoModel extends Observable{

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
    private static class SingletonHelper{
        private static final TodoModel MODEL = new TodoModel();
    }

    /**
     * Instance method to get a single instance of the TodoModel class.
     *
     * @return Returns a single instance of the Todomodel class.
     */
    public static TodoModel getInstance(){
        return SingletonHelper.MODEL;
    }

    //write to file
    public void writeJSON(Todo task){

        try{

            tasks.add(task);
            jsonWriter = new FileWriter(FILE);

            gson.toJson(tasks, jsonWriter);

            jsonWriter.close();

        }catch (IOException exception){
            System.out.println(exception.getMessage());
        }
    }


    //read from file
    public void readJSON(){
        try {

            if(FILE.length() > 0){
                jsonReader = new BufferedReader(new FileReader(FILE));

                taskList = gson.fromJson(jsonReader, Todo[].class);

                for (Todo task : taskList) {
                    System.out.println(task);
                    tasks.add(task);
                }
            }

        }catch (IOException exception){
            System.out.println(exception.getMessage());
        }
    }

    public int getSize(){
        return tasks.size();
    }

    public ArrayList<Todo> getTasks() {
        return tasks;
    }

    //update task

    //delete task

}
