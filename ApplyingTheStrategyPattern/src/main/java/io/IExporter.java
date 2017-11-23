/*
* Joshua Hawks
* 11/17/2017
* IExporter.java
* This file is the interface for the strategies that will export the data.
*/

package io;

/**
 * Interface for exporting data to file.
 */
public interface IExporter {

    /**
     * Exports data if true.
     *
     * @return True if current collection size is larger than the initial size
     * of the collection when the application started or a file was imported.
     */
    boolean exportParts();
}
