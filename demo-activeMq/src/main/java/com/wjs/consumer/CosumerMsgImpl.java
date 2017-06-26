package com.wjs.consumer;

import org.apache.activemq.ActiveMQConnectionFactory;
import javax.jms.*;

/**
 * Created by 341039 on 2017/5/4.
 */
public class CosumerMsgImpl implements IConsumer {
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
            mqSession=mqConnection.createSession(false,Session.AUTO_ACKNOWLEDGE);
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }

    public void consumerMsg() {

       MessageConsumer messageConsumer;
        try {
            //创建队列名
            Destination destination=mqSession.createQueue("helloworld");
            messageConsumer = mqSession.createConsumer(destination);
            TextMessage message=null;
            while (true){
               message= (TextMessage) messageConsumer.receive(10000);
                if (message!=null){
                    System.out.println("接收的activeMq消息："+message.getText());
                }else{
                    break;
                }
            }

        } catch (JMSException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        CosumerMsgImpl cosumerMsg=new CosumerMsgImpl();
        cosumerMsg.init();
        cosumerMsg.consumerMsg();
    }
}
