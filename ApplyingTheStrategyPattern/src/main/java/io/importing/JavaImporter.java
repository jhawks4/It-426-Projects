/*
* Joshua Hawks
* 11/23/2017
* Launcher.java
* This file contains code to run our application.
*/

package io.importing;

import io.IImporter;
import model.CarPart;
import model.PartsDatabase;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

/**
 * Class to import java data from a data file.
 *
 * @author Joshua Hawks
 * @version 1.0
 */
public class JavaImporter implements IImporter {
    private File file = new File("data/parts.dat");
    private FileInputStream stream;
    private ObjectInputStream objectReader;
    private ArrayList<CarPart> parts = new ArrayList<>();
    private PartsDatabase dataCopy;

    /**
     * Constructor for importing java data.
     *
     * @param data A copy of the database.
     */
    public JavaImporter(PartsDatabase data) {
        dataCopy = data;
    }

    /**
     * Imports java data.
     *
     * @return True if the file exists and is not empty.
     */
    public boolean importParts() {

        if (!file.exists() || file.length() == 0) {
            return false;
        }

        myParts();

        return true;
    }

    //Method for importing the java data into the database.
    private void myParts() {
        try {

            //Used to get access to the file.
            stream = new FileInputStream(file);

            //Used to read from the file.
            objectReader = new ObjectInputStream(stream);

            //Used to get access to a specific index number.
            int index = 0;

            //reads through the file and add data to the database.
            while (objectReader != null) {
                CarPart aPart = (CarPart) objectReader.readObject();
                parts.add(aPart);
                dataCopy.addPart(aPart);

                //Used to print the data at that index.
                System.out.println(parts.get(index));
                index++;
            }

        } catch (IOException exception) {
            System.out.println(exception.getMessage());
        } catch (ClassNotFoundException exception) {
            System.out.println(exception.getCause());
        }
    }
}
