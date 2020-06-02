package com.example.testactivemq.secondjmsclients;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.jms.Message;

@RestController
public class consumer2 {

    @Autowired
    JmsTemplate jmsTemplate;
    @Autowired
    MessageConverter messageConverter;

    @GetMapping(value = "/consume2")
    public String receiveMessage()
    {
        try
        {
            /*
             * Here we receive the message.
             */
            System.out.println("consuming queue2 messages ... ");
            Message message = jmsTemplate.receive();
            String response = (String) messageConverter.fromMessage(message);
            return response;

        }
        catch (Exception exe)
        {
            exe.printStackTrace();
        }

        return null;
    }
}
