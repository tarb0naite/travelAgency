/*
package lt.viko.eif.ktarbonaite.travelagency;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;
import lt.viko.eif.ktarbonaite.travelagency.model.*;

import javax.print.attribute.standard.Destination;
import javax.swing.text.Document;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class Main {
    public static void main(String[] args) throws JAXBException, IOException {


        Transport transport1 = new Transport("Plane");
        Accommodation accommodation1 = new Accommodation("The name of Hotel");
        Trip trip1 = new Trip(Type.SUMMER, 100, transport1, "Iceland", accommodation1);
        Offer offer1 = new Offer("Tenerife", 200, trip1);
        Account account1 = new Account("userName1", "Password", offer1, trip1);

        JAXBContext context = JAXBContext.newInstance(Account.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty("jaxb.formatted.output", Boolean.TRUE);
        marshaller.marshal(account1, new File("account.xml"));


        StringWriter stringWriter = new StringWriter();
        context.createMarshaller().marshal(account1, stringWriter);
        String xmlString = stringWriter.toString();
        //marshaller.marshal(account1, System.out);
        System.out.println(xmlString);


        Unmarshaller unmarshaller = context.createUnmarshaller();
        Path path = Path.of("account.xml");
        String xmlContent = Files.readString(path);
        //System.out.println(xmlContent);
        StringReader reader = new StringReader(xmlContent);
        Account account = (Account) unmarshaller.unmarshal(reader);
        System.out.println(account);


    }

}

 */
