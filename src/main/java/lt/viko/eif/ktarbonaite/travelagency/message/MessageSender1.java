package lt.viko.eif.ktarbonaite.travelagency.message;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

public class MessageSender1 {
    private static final String QUEUE_NAME = "MY_QUEUE";

    public static void main(String[] args) throws JMSException {
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(ActiveMQConnectionFactory.DEFAULT_BROKER_URL);
        Connection connection = connectionFactory.createConnection();
        connection.start();
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        Destination destination = session.createQueue(QUEUE_NAME);
        MessageProducer producer = session.createProducer(destination);
        TextMessage message = session.createTextMessage("Hello"); // siusti xml. bandyti su marshallingu? ir receiver'e unmarshalinti?

        producer.send(message);
        System.out.println("Sending message " + message.getText() + " to the " + QUEUE_NAME);
        connection.close();
    }
}
