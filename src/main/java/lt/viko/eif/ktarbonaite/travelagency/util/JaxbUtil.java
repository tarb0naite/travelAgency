package lt.viko.eif.ktarbonaite.travelagency.util;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import lt.viko.eif.ktarbonaite.travelagency.model.Account;

public class JaxbUtil {
    public static void convertToXML(Account account){
        try{
            JAXBContext context = JAXBContext.newInstance(Account.class);
            Marshaller marshaller = context.createMarshaller();

            marshaller.setProperty("jaxb.formatted.output", Boolean.TRUE);
            marshaller.marshal(account, System.out);
        }catch(JAXBException e){
            throw new RuntimeException(e);
        }

    }
}
