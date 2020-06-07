//package com.example.testactivemq.secondjmsclients;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.jms.core.JmsTemplate;
//import org.springframework.stereotype.Component;
//
//import javax.jms.JMSException;
//import javax.jms.Message;
//import javax.jms.MessageListener;
//import javax.jms.TextMessage;
//
//
//// this way creates an asynchronous consumer that consumes the message automatically
//// after it is arrived to the queue.
//@Component
//public class AsynchronousConsumer2 implements MessageListener {
//
//
//    @Override
//    public void onMessage(Message message) {
//        System.out.println("inside onMessage -- listener consumer");
//        System.out.println("message : " + message);
//
//    }
//}
