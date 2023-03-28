
import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

public class MyMessageReceiver {
    private static final String QUEUE_NAME = "MY_QUEUE";

    private Connection connection;
    private MessageConsumer consumer;
    private Session session;
    private Message message;

    public MyMessageReceiver() throws JMSException {
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(ActiveMQConnectionFactory.DEFAULT_BROKER_URL);
        this.connection = connectionFactory.createConnection();
        this.connection.start();

        this.session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        Destination destination = this.session.createQueue(QUEUE_NAME);
        this.consumer = this.session.createConsumer(destination);

        this.message = consumer.receive();


    }
    public void receiveMessage() throws JMSException {
        TextMessage textMessage = (TextMessage) message;
        System.out.println("Received message" +
                textMessage.getText() + "from" + QUEUE_NAME);
    }
    public void close() throws JMSException {
        this.connection.close();
    }
}


