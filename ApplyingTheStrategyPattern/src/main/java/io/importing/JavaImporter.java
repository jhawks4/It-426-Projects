package io.importing;

import io.IImporter;
import model.CarPart;
import model.PartsDatabase;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;


public class JavaImporter implements IImporter{
    private File file = new File("data/parts.dat");
    private FileInputStream stream;
    private ObjectInputStream objectReader;
    private ArrayList<CarPart> parts = new ArrayList<>();
    private PartsDatabase dataCopy;


    public JavaImporter(PartsDatabase data){
        dataCopy = data;
    }

    public boolean importParts() {

        if (!file.exists() || file.length() == 0){
            return false;
        }

        myParts();

        return true;
    }

    private void myParts(){
        try{

            stream = new FileInputStream(file);
            objectReader = new ObjectInputStream(stream);

            int index = 0;

            while (objectReader != null){
                CarPart aPart = (CarPart) objectReader.readObject();
                parts.add(aPart);
                dataCopy.addPart(aPart);
                System.out.println(parts.get(index));
                index++;
            }

        }catch (IOException exception) {
            System.out.println(exception.getMessage());
        }catch (ClassNotFoundException exception){
            System.out.println(exception.getCause());
        }
    }
}
