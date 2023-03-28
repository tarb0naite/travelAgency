package lt.viko.eif.ktarbonaite.travelagency.message;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

public class MessageReceiver1 {
    private static final String QUEUE_NAME = "MY_QUEUE";

    public static void main(String[] args) throws JMSException {
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(ActiveMQConnectionFactory.DEFAULT_BROKER_URL);
        Connection connection = connectionFactory.createConnection();
        connection.start();
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        Destination destination = session.createQueue(QUEUE_NAME);
        MessageConsumer consumer = session.createConsumer(destination);

        Message message = consumer.receive();
        if (message instanceof TextMessage) {
            TextMessage textMessage = (TextMessage) message;
            System.out.println("Received message " +
                    textMessage.getText() + " from " + QUEUE_NAME);
        }

        connection.close();
    }
}