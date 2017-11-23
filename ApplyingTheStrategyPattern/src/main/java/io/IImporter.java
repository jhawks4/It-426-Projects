/*
* Joshua Hawks
* 11/17/2017
* IImporter.java
* This file is the interface for the strategies that will be used for importing the data.
*/

package io;

/**
 * Interface for importing files.
 */
public interface IImporter {

    /**
     * Imports file data to the application.
     *
     * @return True if a file exists.
     */
    boolean importParts();
}
