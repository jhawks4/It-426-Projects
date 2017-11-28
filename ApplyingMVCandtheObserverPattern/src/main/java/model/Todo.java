/*
* Joshua Hawks
* 11/23/17
* To do.java
* A simple class for giving the tasks a structure.
*/

package model;

import java.io.Serializable;
import java.util.UUID;

public class Todo implements Serializable{

    private UUID id;
    private String message;

    public Todo(String message){
        id = UUID.randomUUID();
        this.message = message;
    }

    public String toString(){
        return "UUID: " + id + "\nMessage: " + message;
    }
}
