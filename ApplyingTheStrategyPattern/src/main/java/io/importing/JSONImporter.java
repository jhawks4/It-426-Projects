package io.importing;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import io.IImporter;

import model.CarPart;
import model.PartsDatabase;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

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
            Reader reader = new FileReader(file);

            //CarPart part = gson.fromJson(reader, CarPart.class);

            JsonElement json = gson.fromJson(reader, JsonElement.class);
            String jsonString = gson.toJson(json);


            System.out.println(jsonString);

        }catch (IOException exception){
            System.out.println(exception.getMessage());
        }
    }
}
