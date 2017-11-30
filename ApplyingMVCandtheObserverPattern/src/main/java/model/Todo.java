/*
* Joshua Hawks
* 11/23/17
* To do.java
* A simple class for giving the tasks a structure.
*/

package model;

import java.io.Serializable;
import java.util.UUID;

/**
 * The structure used for making the tasks.
 *
 * @author Joshua Hawks
 * @version 1.0
 */
public class Todo implements Serializable {

    private UUID id;
    private String message;

    /**
     * Constructor for making a task.
     *
     * @param message The message the user inputs to know what tasks they are going to do.
     */
    public Todo(String message) {
        id = UUID.randomUUID();
        this.message = message;
    }

    /**
     * Gets the UUID.
     *
     * @return Returns the UUID value.
     */
    public UUID getId() {
        return id;
    }

    /**
     * Gets the task.
     *
     * @return Returns the task string.
     */
    public String getMessage() {
        return message;
    }

    /**
     * Sets the message.
     *
     * @param message The updated message that will replace the original messsage.
     */
    public void setMessage(String message) {
        this.message = message;
    }
}
