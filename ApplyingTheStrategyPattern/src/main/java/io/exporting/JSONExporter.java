/*
* Joshua Hawks
* 11/23/2017
* Launcher.java
* This file contains code to run our application.
*/

package io.exporting;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import io.IExporter;
import model.CarPart;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collection;

public class JSONExporter implements IExporter {

    private File file = new File("data/parts.json");
    private FileWriter jsonWriter;
    private Collection<CarPart> parts;
    private int initialSize;
    private int currentSize;

    public JSONExporter(Collection<CarPart> parts, int initialSize, int currentSize) {
        this.parts = parts;
        this.initialSize = initialSize;
        this.currentSize = currentSize;
    }

    public boolean exportParts() {

        if (initialSize == currentSize) {
            return false;
        }

        exportJSON();

        return true;
    }

    private void exportJSON() {
        try {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            jsonWriter = new FileWriter(file);

            String test = gson.toJson(parts);
            System.out.println(test);

            gson.toJson(parts, jsonWriter);

            jsonWriter.close();

        } catch (IOException exception) {
            System.out.println(exception.getMessage());
        }
    }
}
