//package com.mkr.beans;
//
//
//import java.util.logging.Level;
//import javax.ejb.ActivationConfigProperty;
//import javax.ejb.MessageDriven;
//import javax.jms.Message;
//import javax.jms.MessageListener;
//import java.util.logging.Logger;
//import javax.jms.JMSException;
//
///**
// * Created by Tanya Ohotnik on 13.11.2016.
// */
//@MessageDriven(mappedName = "jms/flowersConnectionFactoryQueue", activationConfig = {
//        @ActivationConfigProperty(propertyName = "acknowledgeMode", propertyValue = "Auto-acknowledge"),
//        @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue")
//})
//public class OrderMessageBean implements MessageListener {
//    public OrderMessageBean() {
//    }
//
//    @Override
//    public void onMessage(Message message) {
//        try {
//            String name = message.getStringProperty("name");
//
//            Logger.getLogger("SalutationLog").log(Level.INFO,
//                    "Salutation processed", "Test of log3");
//        } catch (JMSException e) {
//            throw new RuntimeException(e);
//        }
//    }
//}
