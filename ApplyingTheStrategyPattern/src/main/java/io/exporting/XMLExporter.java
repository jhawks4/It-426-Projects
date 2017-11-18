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


public class XMLExporter implements IExporter{

    private File file = new File("data/parts.xml");
    private PartsDatabase parts;
    private int initialSize;
    private int currentSize;

    public XMLExporter(PartsDatabase data, int initialSize, int currentSize){
        this.parts = data;
        this.initialSize = initialSize;
        this.currentSize = currentSize;
    }

    public boolean exportParts() {

        if(initialSize == currentSize){
            return false;
        }

        exportXML();

        return true;
    }

    private void exportXML(){

        try {
            JAXBContext context = JAXBContext.newInstance(PartsDatabase.class);
            Marshaller contextMarshal = context.createMarshaller();

            contextMarshal.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            contextMarshal.marshal(parts, file);
            contextMarshal.marshal(parts, System.out);

        }catch (JAXBException exception){
            System.out.println("Sorry, you messed up...");
            exception.printStackTrace();
        }
    }
}
