//package com.mkr.jms;
//
///**
// * Created by Tanya Ohotnik on 22.11.2016.
// */
//
//import javax.jms.JMSException;
//import javax.jms.Message;
//import javax.jms.MessageListener;
//import javax.jms.TextMessage;
//
//public class ExampleMessageListener implements MessageListener
//{
//    @Override
//    public void onMessage(Message message)
//    {
//        TextMessage textMessage = (TextMessage) message;
//        try
//        {
//            System.out.print("Received the following message: ");
//            System.out.println(textMessage.getText());
//            System.out.println();
//        }
//        catch (JMSException e)
//        {
//            e.printStackTrace();
//        }
//    }
//}