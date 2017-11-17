package io.importing;

import com.google.gson.Gson;
import io.IImporter;
import model.CarPart;
import model.PartsDatabase;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
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
            gson = new Gson();
            reader = new FileReader(file);
            CarPart aPart = gson.fromJson(reader, CarPart.class);
            parts.add(aPart);
            dataCopy.addPart(aPart);

            for (CarPart parts : parts) {
                System.out.println(parts);
            }

        }catch (IOException exception){
            System.out.println(exception.getMessage());
        }
    }
}
