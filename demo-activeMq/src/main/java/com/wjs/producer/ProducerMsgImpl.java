package com.wjs.producer;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * Created by 341039 on 2017/5/4.
 */
public class ProducerMsgImpl implements IProducer {

    private ActiveMQConnectionFactory mqConnectionFactory=null;
    protected static String brokerURL = "tcp://192.168.135.128:61616";
    private Connection mqConnection=null;
    private Session mqSession=null;
    public void init() {
        mqConnectionFactory=new ActiveMQConnectionFactory(
                ActiveMQConnectionFactory.DEFAULT_USER,
                ActiveMQConnectionFactory.DEFAULT_PASSWORD,
                brokerURL);
        try {
            mqConnection= mqConnectionFactory.createConnection();
            mqConnection.start();
            mqSession=mqConnection.createSession(true,Session.AUTO_ACKNOWLEDGE);
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }

    public void producerMsg() {
        MessageProducer messageProducer;
        try {
            //创建队列名
            Destination destination=mqSession.createQueue("helloworld");
            messageProducer = mqSession.createProducer(destination);
            TextMessage message=null;
            for (int i=0;i<100;i++){
                message = mqSession.createTextMessage("这是这"+i+"个消息activemq");
                messageProducer.send(message);
            }
            mqSession.commit();
        } catch (JMSException e) {
            e.printStackTrace();
        }finally {
            try {
                mqSession.close();
            } catch (JMSException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        ProducerMsgImpl producerMsg=new ProducerMsgImpl();
        producerMsg.init();
        producerMsg.producerMsg();
    }

}
