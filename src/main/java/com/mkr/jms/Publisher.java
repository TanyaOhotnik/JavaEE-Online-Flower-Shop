package com.mkr.jms;

import javax.annotation.Resource;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.jms.*;

/**
 * Created by Tanya Ohotnik on 19.11.2016.
 */
@ManagedBean(name = "publisher")
@RequestScoped
public class Publisher {
    @Resource(lookup = "jms/flowersConnectionFactory")
    private TopicConnectionFactory connectionFactory;
    @Resource(lookup = "jms/flowersResource")
    private Topic topic;
    TopicConnection connection;

    public Publisher() {

    }

    public void sent() {

        try {
            Destination dest = (Destination) topic;
             connection = connectionFactory.createTopicConnection();
            connection.start();
            TopicSession session = connection.createTopicSession(false, TopicSession.AUTO_ACKNOWLEDGE);
            MessageProducer producer = session.createProducer(dest);
            TopicPublisher publisher = session.createPublisher(topic);

            TextMessage message = session.createTextMessage("go");
//            producer.send(message);
            publisher.publish(message);



        } catch (JMSException e) {

        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (JMSException e) {
                }
            }
        }
    }
}
