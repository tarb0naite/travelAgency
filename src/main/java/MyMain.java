import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;
import lt.viko.eif.ktarbonaite.travelagency.HibernateApp;
import lt.viko.eif.ktarbonaite.travelagency.model.*;

import javax.jms.JMSException;
import java.io.File;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.nio.file.Files;
import java.nio.file.Path;

public class MyMain {
    public static void main (String[] args) throws JAXBException, IOException{



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
       // System.out.println(xmlString);


        Unmarshaller unmarshaller = context.createUnmarshaller();
        Path path = Path.of("account.xml");
        String xmlContent = Files.readString(path);
        //System.out.println(xmlContent);
        StringReader reader = new StringReader(xmlContent);
        Account account = (Account) unmarshaller.unmarshal(reader);
        //System.out.println(account);



        MyMessageSender sender = null;
        try{
            sender = new MyMessageSender();
            sender.sendMessage(xmlString);
        }catch(JMSException e){
            System.out.println(e.getMessage());
        }
        finally{
            try{
                sender.close();

            }catch(JMSException e){
                System.out.println(e.getMessage());
            }
        }
        MyMessageReceiver receiver = null;
        try{
            receiver =new MyMessageReceiver();
            receiver.receiveMessage();

        }catch (JMSException e){
            System.out.println(e.getMessage());
        }finally {
            try {
                receiver.close();
            }catch (JMSException e){
                System.out.println(e.getMessage());
            }
        }
    }



}
