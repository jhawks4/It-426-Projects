/*
* Joshua Hawks
* 11/17/2017
* JSONEImporter.java
* This file contains code.
*/

package io.importing;

import com.google.gson.*;
import io.IImporter;

import model.CarPart;
import model.PartsDatabase;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collection;

public class JSONImporter implements IImporter{

    private File file = new File("data/parts.json");
    private FileReader fileReader;
    private Reader reader;
    private Gson gson;
    private ArrayList<CarPart> parts = new ArrayList<>();
    private PartsDatabase dataCopy;

    public JSONImporter(PartsDatabase data){
        dataCopy = data;
    }

    public boolean importParts() {

        if (!file.exists() || file.length() == 0){
            return false;
        }

        myparts();

        return true;
    }

    private void myparts(){
        try {
            gson = new GsonBuilder().setPrettyPrinting().create();

            BufferedReader reader = new BufferedReader(new FileReader(file));

            CarPart[] part = gson.fromJson(reader, CarPart[].class);

            for (CarPart parts : part) {
                System.out.println(parts);
                dataCopy.addPart(parts);
            }

        }catch (IOException exception){
            System.out.println(exception.getMessage());
        }
    }
}
