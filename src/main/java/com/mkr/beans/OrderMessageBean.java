//package com.mkr.beans;
//
//
//import com.mkr.entities.Order;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.logging.Level;
//import javax.ejb.ActivationConfigProperty;
//import javax.ejb.MessageDriven;
//import javax.ejb.Remote;
//import javax.ejb.Stateful;
//import javax.faces.bean.ManagedBean;
//import javax.faces.bean.RequestScoped;
//import javax.faces.bean.SessionScoped;
//import javax.jms.Message;
//import javax.jms.MessageListener;
//import java.util.logging.Logger;
//import javax.jms.JMSException;
//import javax.jms.TextMessage;
//
///**
// * Created by Tanya Ohotnik on 13.11.2016.
// */
//@ManagedBean(name = "b")
//@SessionScoped
//@MessageDriven(mappedName = "jms/flowersResource", activationConfig = {
//        @ActivationConfigProperty(propertyName = "acknowledgeMode", propertyValue = "Auto-acknowledge"),
//        @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Topic")
//})
//public class OrderMessageBean implements MessageListener {
//    String ordersString = "some badly";
//    public OrderMessageBean() {
//
//    }
//
//    @Override
//    public void onMessage(Message message) {
//        try {
//            TextMessage textMessage = (TextMessage) message;
//            ordersString =  textMessage.getText();
//            System.out.println(ordersString);
//        } catch (JMSException e) {
//            throw new RuntimeException(e);
//        }
//    }
//
//    public String getOrdersString() {
//        return ordersString;
//    }
//
//    public void setOrdersString(String ordersString) {
//        this.ordersString = ordersString;
//    }
//}
