package sk.stuba.fei.oop.generated;


import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class ImportXml {
    private Document document;



    public  ImportXml(String absolutePath) {
        try {
            InputStream resource = new FileInputStream(absolutePath);
            JAXBContext context = JAXBContext.newInstance(Document.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();

            document = (Document) unmarshaller.unmarshal(resource);

        } catch (JAXBException e) {

        } catch (FileNotFoundException e) {

        }

    }
    public  Document getDocument(){
        return document;
    }

}


