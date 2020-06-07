package com.example.testactivemq.multiple.activemq.instances;

import org.apache.activemq.ActiveMQSession;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import javax.jms.Session;

@Component
public class Consumer {

    @JmsListener(destination = ActiveMQConfigurationForJmsCamelRouteConsumeAndForward.LOCAL_Q, containerFactory = "jmsListenerContainerFactory2")
    public void receiveQueue(Session session, String text) {
        System.out.println(((ActiveMQSession) session).getConnection().getBrokerInfo());
        System.out.println(text);
    }

//    @JmsListener(destination = ActiveMQConfigurationForJmsCamelRouteConsumeAndForward.LOCAL_Q, containerFactory = "jmsListenerContainerFactory")
//    public void receiveQueue1(Session session, String text) {
//        System.out.println(((ActiveMQSession) session).getConnection().getBrokerInfo());
//        System.out.println(text);
//    }
}