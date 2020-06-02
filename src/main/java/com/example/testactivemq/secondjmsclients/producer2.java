package com.example.testactivemq.secondjmsclients;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.ObjectMessage;
import javax.jms.Session;

@RestController
public class producer2 {



    @Autowired
    JmsTemplate jmsTemplate;

    @GetMapping(value = "/produce2/{message}")
    public String sendMessage(@PathVariable String message)
    {
        MSGCreator msgCreator = new MSGCreator();
        msgCreator.setMessage(message);
        jmsTemplate.send(msgCreator);
        return message;
//       jmsTemplate.send(new MessageCreator()
//        {
//            Message objectMessage;
//            public Message createMessage(Session session) throws JMSException
//            {
//                objectMessage = session.createObjectMessage(message);
//                System.out.println("message : "+ objectMessage);
//                return objectMessage;
//            }
//        });

//       return "Message Sent to queue "+jmsTemplate.getDefaultDestinationName() + " Successfully";
    }

    public class MSGCreator implements MessageCreator{

        private String message;

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        @Override
        public Message createMessage(Session session) throws JMSException {
            return session.createObjectMessage(message);
        }
    }
}
