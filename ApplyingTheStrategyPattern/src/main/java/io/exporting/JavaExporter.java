package io.exporting;

import io.IExporter;
import model.CarPart;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Collection;

public class JavaExporter implements IExporter{

    private Collection<CarPart> parts;
    private int initialSize;
    private int currentSize;
    private File file = new File("data/parts.dat");
    private FileOutputStream fileOutputer;
    private ObjectOutputStream outputObject;
    private Object[] partObjects;

    public JavaExporter(Collection<CarPart> parts, int initialSize, int currentSize){
        this.parts = parts;
        this.initialSize = initialSize;
        this.currentSize = currentSize;
    }

    public boolean exportParts() {

        if(currentSize == initialSize){
            return false;
        }

        exportJava();

        return true;
    }

    private void exportJava(){
        try {
            fileOutputer = new FileOutputStream(file);

            outputObject = new ObjectOutputStream(fileOutputer);

            partObjects = parts.toArray();

            for (int i = 0; i < currentSize; i++){
                outputObject.writeObject(partObjects[i]);
            }

        }catch (IOException exception){
            System.out.println(exception.getMessage());
        }
    }
}
