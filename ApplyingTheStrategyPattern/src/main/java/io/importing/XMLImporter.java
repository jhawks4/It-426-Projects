/*
* Joshua Hawks
* 11/23/2017
* Launcher.java
* This file contains code to import the data from an XML file.
*/

package io.importing;

import io.IImporter;
import model.CarPart;
import model.PartsDatabase;

import javax.xml.bind.*;
import java.io.File;

/**
 * Class to import xml data into a java object.
 *
 * @author Joshua Hawks
 * @version 1.0
 */
public class XMLImporter implements IImporter {

    private PartsDatabase dataCopy;
    private File file = new File("data/parts.xml");

    /**
     * Constructor for importing xml data.
     *
     * @param data A copy of the database.
     */
    public XMLImporter(PartsDatabase data) {
        dataCopy = data;
    }

    /**
     * Checks to see if the file exists.
     *
     * @return Returns true if the file exists and has data.
     */
    public boolean importParts() {
        if (!file.exists() || file.length() == 0) {
            return false;
        }

        //Method call to import the xml data.
        myParts();

        return true;
    }

    //Method that imports xml data.
    private void myParts() {
        try {

            JAXBContext context = JAXBContext.newInstance(PartsDatabase.class);

            Unmarshaller contextUnmarshaller = context.createUnmarshaller();

            //Deserialize the data from the xml file.
            PartsDatabase partsDatabase = (PartsDatabase) contextUnmarshaller.unmarshal(file);

            //Stores the data into the database.
            for (CarPart part : partsDatabase.getParts()) {
                dataCopy.addPart(part);
            }


        } catch (JAXBException exception) {
            exception.printStackTrace();
        }
    }
}
