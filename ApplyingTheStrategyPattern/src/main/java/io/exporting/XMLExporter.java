/*
* Joshua Hawks
* 11/23/2017
* Launcher.java
* This file contains code to run our application.
*/

package io.exporting;

import io.IExporter;
import model.CarPart;
import model.PartsDatabase;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.io.IOException;
import java.util.Collection;

/**
 * Class to export java object data to XML file.
 */
public class XMLExporter implements IExporter {

    private File file = new File("data/parts.xml");
    private PartsDatabase parts;
    private int initialSize;
    private int currentSize;

    /**
     * Constructor for exporting java object data into xml file.
     *
     * @param data        The database.
     * @param initialSize The initial size of the database.
     * @param currentSize The current size the the database.
     */
    public XMLExporter(PartsDatabase data, int initialSize, int currentSize) {
        this.parts = data;
        this.initialSize = initialSize;
        this.currentSize = currentSize;
    }

    /**
     * Exports data to xml file.
     *
     * @return True if the initial size is not the same as the current size.
     */
    public boolean exportParts() {

        if (initialSize == currentSize) {
            return false;
        }

        exportXML();

        return true;
    }

    //Method to export the data into an xml file.
    private void exportXML() {

        try {
            JAXBContext context = JAXBContext.newInstance(PartsDatabase.class);

            //Used to help write to the file.
            Marshaller contextMarshal = context.createMarshaller();

            //Makes the file easier for people to read.
            contextMarshal.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            //Writes to the file.
            contextMarshal.marshal(parts, file);

            //Prints out the data to console in the format that it's written in.
            contextMarshal.marshal(parts, System.out);

        } catch (JAXBException exception) {
            System.out.println("Sorry, you messed up...");
            exception.printStackTrace();
        }
    }
}
