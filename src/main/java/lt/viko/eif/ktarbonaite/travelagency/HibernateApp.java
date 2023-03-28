package lt.viko.eif.ktarbonaite.travelagency;

import lt.viko.eif.ktarbonaite.travelagency.util.HibernateUtil;
import lt.viko.eif.ktarbonaite.travelagency.model.*;
import lt.viko.eif.ktarbonaite.travelagency.util.JaxbUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class HibernateApp {
    public static void main(String[] args) {

        Accommodation accommodation1 = new Accommodation("HotelName");
        Transport transport1 = new Transport("Plane");
        Trip trip1 = new Trip(Type.SUMMER, 100, transport1, "Iceland", accommodation1);
        Offer offer1 = new Offer("Sout Africa", 200, trip1);
        Account account1 = new Account("Username", "password", offer1, trip1);

        Transaction transaction = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(account1);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            List<Account> accounts = session.createQuery("from Account", Account.class).list();
            accounts.forEach(account -> System.out.println(account));

            System.out.println("-------------------------");
            accounts.forEach(account -> JaxbUtil.convertToXML(account));
            System.in.read();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            //server.shutdown();
        }


    }

}

