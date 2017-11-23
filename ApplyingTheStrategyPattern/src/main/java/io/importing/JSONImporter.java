/*
* Joshua Hawks
* 11/17/2017
* JSONEImporter.java
* This file contains code for importing a json file.
*/

package io.importing;

import com.google.gson.*;
import io.IImporter;

import model.CarPart;
import model.PartsDatabase;

import java.io.*;
import java.util.ArrayList;

/**
 * Class for importing a json file.
 *
 * @author Joshua Hawks
 * @version 1.0
 */
public class JSONImporter implements IImporter {

    //Fields for importing from a json file.
    private File file = new File("data/parts.json");
    private FileReader fileReader;
    private Reader reader;
    private Gson gson;
    private ArrayList<CarPart> parts = new ArrayList<>();
    private PartsDatabase dataCopy;

    /**
     * Constructor for importing json.
     *
     * @param data Used to pass in a copy of the PartsDatabase object.
     */
    public JSONImporter(PartsDatabase data) {
        dataCopy = data;
    }

    /**
     * Imports a json file.
     *
     * @return True if file exists and it has data.
     */
    public boolean importParts() {

        if (!file.exists() || file.length() == 0) {
            return false;
        }

        //Method call for importing json data.
        myparts();

        return true;
    }

    //Method to import the json data as a java object.
    private void myparts() {
        try {

            //gson object for importing the file and providing the information in a readable format.
            gson = new GsonBuilder().setPrettyPrinting().create();

            //Reads the json file.
            BufferedReader reader = new BufferedReader(new FileReader(file));

            //Array for holding the data that is in the file.
            CarPart[] part = gson.fromJson(reader, CarPart[].class);

            //Prints data and stores data into database object.
            for (CarPart parts : part) {
                System.out.println(parts);
                dataCopy.addPart(parts);
            }

        } catch (IOException exception) {
            System.out.println(exception.getMessage());
        }
    }
}
