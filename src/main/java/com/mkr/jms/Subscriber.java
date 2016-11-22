package com.mkr.jms;

import javax.annotation.Resource;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.jms.*;

/**
 * Created by Tanya Ohotnik on 19.11.2016.
 */
@ManagedBean(name = "subscriber")
@RequestScoped
public class Subscriber {
    @Resource(lookup = "jms/flowersConnectionFactory")
    private TopicConnectionFactory connectionFactory;
    @Resource(lookup = "jms/flowersResource")
    private Topic topic;
    TopicConnection connection;
    Message message;



    public String receive() {

        try {
            Destination dest = (Destination) topic;
            connection = connectionFactory.createTopicConnection();
            connection.start();
            TopicSession session = connection.createTopicSession(false, TopicSession.AUTO_ACKNOWLEDGE);

//            MessageConsumer consumer = session.createConsumer(dest);
//          message = consumer.receive();
            TopicSubscriber subscriber =
                    session.createSubscriber(topic);
            message = subscriber.receive();
            TextMessage textMessage = (TextMessage) message;
           return  textMessage.getText( );

        } catch (JMSException e) {
            return "error";
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (JMSException e) {
                }

            }
        }
//        return "error2";
    }

//    @Override
//    public void onMessage(Message message) {
//        try {
//            TextMessage textMessage = (TextMessage) message;
//            String text = textMessage.getText( );
//
//        } catch (JMSException jmse){ jmse.printStackTrace( ); }
//    }
}
