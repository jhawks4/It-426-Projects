package io.importing;

import io.IImporter;
import model.CarPart;
import model.PartsDatabase;

import javax.xml.bind.*;
import java.io.File;

public class XMLImporter implements IImporter{

    private PartsDatabase dataCopy;
    private File file = new File("data/parts.xml");

    public XMLImporter(PartsDatabase data){
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
        try {

            JAXBContext context = JAXBContext.newInstance(PartsDatabase.class);

            Unmarshaller contextUnmarshaller = context.createUnmarshaller();

             //Issues with unmarshalling
            CarPart carPart = (CarPart) contextUnmarshaller.unmarshal(file);

        }catch (JAXBException exception){
            exception.printStackTrace();
        }
    }
}
