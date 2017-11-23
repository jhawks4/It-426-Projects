/*
* Joshua Hawks
* 11/23/2017
* Launcher.java
* Exports the data as a java object to a data file.
*/

package io.exporting;

import io.IExporter;
import model.CarPart;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Collection;

/**
 * This class is used to export a collection as a java object to a data file.
 *
 * @author Joshua Hawks
 * @version 1.0
 */
public class JavaExporter implements IExporter{

    //Fields for file writing and checking.
    private Collection<CarPart> parts;
    private int initialSize;
    private int currentSize;
    private File file = new File("data/parts.dat");
    private FileOutputStream fileOutputer;
    private ObjectOutputStream outputObject;
    private Object[] partObjects;

    /**
     * Constructor for java export.
     *
     * @param parts The collection of parts to be exported.
     * @param initialSize The size of the collection prior to any
     *                    additional data being inserted to the collection.
     * @param currentSize The current size of the collection.
     */
    public JavaExporter(Collection<CarPart> parts, int initialSize, int currentSize){
        this.parts = parts;
        this.initialSize = initialSize;
        this.currentSize = currentSize;
    }

    /**
     * Checks to see if any changes have been made to the collection and if so, then
     * calls a method to export the collection.
     *
     * @return True if the current size is greater than the initial size of the collection.
     */
    public boolean exportParts() {

        if(currentSize == initialSize){
            return false;
        }

        exportJava();

        return true;
    }

    //Method for exporting the collection.
    private void exportJava(){
        try {

            //The file to write to.
            fileOutputer = new FileOutputStream(file);

            //Object to write data to file.
            outputObject = new ObjectOutputStream(fileOutputer);

            //Collection made into an array.
            partObjects = parts.toArray();

            //Loops through array to write into file.
            for (int i = 0; i < currentSize; i++){
                outputObject.writeObject(partObjects[i]);
            }

        }catch (IOException exception){
            System.out.println(exception.getMessage());
        }
    }
}
