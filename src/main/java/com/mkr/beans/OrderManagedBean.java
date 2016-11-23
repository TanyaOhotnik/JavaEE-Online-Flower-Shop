//package com.mkr.beans;
//
//import javax.annotation.Resource;
//import javax.ejb.EJB;
//import javax.faces.bean.ManagedBean;
//import javax.faces.bean.ManagedProperty;
//import javax.faces.bean.RequestScoped;
//import javax.jms.*;
//import javax.naming.Context;
//import javax.naming.InitialContext;
//import javax.naming.NamingException;
//import java.util.logging.Level;
//import java.util.logging.Logger;
//
///**
// * Created by Tanya Ohotnik on 13.11.2016.
// */
//@ManagedBean(name = "orderMessageManagedBean")
//@RequestScoped
//public class OrderManagedBean {
////    @Resource(mappedName = "jms/flowersConnectionFactoryQueue")
////    private QueueConnectionFactory queueConnectionFactory;
////    @Resource(mappedName = "jms/flowersResource")
////    private Queue queue;
////    public void sendMessage(){
////        try{
//////            Context ctx = new InitialContext();
////        String message = "Salutation generated";
////
////        Connection connection = queueConnectionFactory.createConnection();
////        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
////        MessageProducer messageProducer = (MessageProducer) session.createProducer(queue);
////        TextMessage textMessage = session.createTextMessage();
////        textMessage.setText(message);
////        messageProducer.send(textMessage);
////
////        }catch (JMSException e){
////            Logger.getLogger("SalutationLog").log(Level.WARNING,
////                    "JMSException in SalutationServlet", "JMSException in SalutationServlet");
////        }
////    }
//
////    @EJB
////    private OrderMessageBean mb;
//
//    @ManagedProperty(value = "#{orderMessageBean}")
//    private OrderMessageBean mb;
//
//
//    public String getMessage(){
//        return mb.getOrdersString();
//    }
//
//}
