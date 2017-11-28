package model;

import java.io.File;
import java.io.IOException;

public class InitializeJSON {

    private final static File FILE = new File("tasks/task.json");
    private final static File DIRECTORY = new File("tasks");

    public final static void createJSON(){
        try {

            if (DIRECTORY.mkdir()){
                System.out.println("Directory created.");
            }else {
                System.out.println("Directory exists.");
            }

            if (FILE.createNewFile()){
                System.out.println("File created.");
            }else {
                System.out.println("File exists.");
            }

        }catch (IOException exception){
            System.out.println(exception.getMessage());
        }
    }
}
