package io.exporting;

import io.IExporter;
import model.CarPart;

import java.util.Collection;

public class JavaExporter implements IExporter {

    private Collection<CarPart> parts;
    private int initialSize;
    private int currentSize;

    public JavaExporter(Collection<CarPart> parts, int initialSize){
        this.parts = parts;
        this.initialSize = initialSize;
    }

    public boolean exportParts() {
        currentSize = parts.size();

        if (currentSize == initialSize){
            return false;
        }


        return false;
    }
}
