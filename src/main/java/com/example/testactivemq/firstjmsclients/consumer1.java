package com.example.testactivemq.firstjmsclients;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.jms.*;

@RestController
public class consumer1 {

    private static String url = ActiveMQConnection.DEFAULT_BROKER_URL;
    private static String queueName = "MESSAGE_QUEUE";


    @GetMapping(value = "/consume")
    public String consumeMessage() throws JMSException {

        ConnectionFactory connectionFactory  = new ActiveMQConnectionFactory(url);
        Connection connection = connectionFactory.createConnection();
        connection.start();
        Session session = connection.createSession(false , Session.AUTO_ACKNOWLEDGE);
        Destination destination = session.createQueue(queueName);

        MessageConsumer consumer = session.createConsumer(destination);
        Message message = consumer.receive();

        connection.close();
        return "Consumed message usccessfullt : "+message;
    }
}
