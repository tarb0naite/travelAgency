
import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;


public class MyMessageSender {
    private static final String QUEUE_NAME = "MY_QUEUE";

    private Connection connection;
    private MessageProducer producer;
    private Session session;



    public MyMessageSender() throws JMSException {
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(ActiveMQConnectionFactory.DEFAULT_BROKER_URL);
        this.connection = connectionFactory.createConnection();
        this.connection.start();

        this.session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        Destination destination = this.session.createQueue(QUEUE_NAME);
        this.producer = session.createProducer(destination);

    }
    public void sendMessage(String xmlString) throws JMSException {
        TextMessage message = this.session.createTextMessage(xmlString);
        producer.send(message);
        System.out.println("Sending the message" + message.getText() + "to the" + QUEUE_NAME);
    }

    public void close() throws  JMSException {
        this.connection.close();
    }
}
