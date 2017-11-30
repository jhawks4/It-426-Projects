/*
* Joshua Hawks
* 11/29/17
* ExistingRecordException.java
* A custom exception to ensure that the UUID doesn't try to put in a duplicate.
*/

package exception;

/**
 * A custom exception class to ensure there are no duplicates.
 *
 * @author Joshua Hawks
 * @version 1.0
 */
public class ExistingRecordException extends Exception {

    /**
     * Constructor to make exception.
     *
     * @param message An exception message.
     */
    public ExistingRecordException(String message) {
        super(message);
    }
}
