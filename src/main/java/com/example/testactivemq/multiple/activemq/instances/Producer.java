package com.example.testactivemq.multiple.activemq.instances;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Producer {

    @Autowired
    private JmsTemplate jmsTemplate;

    @Autowired
    @Qualifier("jmsTemplate2")
    private JmsTemplate jmsTemplate2;

    @RequestMapping(value = "/send/message/{message}")
    public String sendMessage(@PathVariable String message) {
        send(message);
        return message + " sent successfully";
    }

    public void send(String msg) {
        this.jmsTemplate.convertAndSend(ActiveMQConfigurationForJmsCamelRouteConsumeAndForward.LOCAL_Q, msg);
//        this.jmsTemplate2.convertAndSend(ActiveMQConfigurationForJmsCamelRouteConsumeAndForward.REMOTE_Q, msg);
    }

//    @Override
//    public void run(String... args) throws Exception {
//        send("Sample message");
//    }


}
