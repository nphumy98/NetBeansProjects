/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package applicationclient1;

import java.util.HashMap;
import java.util.Map;
import javax.jms.*;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author MY PHU NGUYEN
 */
public class test {
    public static void main(String[] args) throws NamingException {
        	InitialContext initialContext= null;
		Connection connection=null;
		try
		{
			initialContext= new InitialContext();
			ConnectionFactory cf= (ConnectionFactory) initialContext.lookup("myQueueConnectionFactory");
			connection= cf.createConnection();
			Session session = connection.createSession();
			Queue queue=(Queue) initialContext.lookup("myQueue");
			
			MessageProducer producer= session.createProducer(queue);
			TextMessage message= session.createTextMessage("I am the creator of my destiny");
			producer.send(message);
			System.out.println("Message Sent:"+ message.getText());
			
			
			MessageConsumer consumer=session.createConsumer(queue);
			connection.start();
			TextMessage messageReceived= (TextMessage) consumer.receive();
			System.out.println("Message Received:"+ messageReceived.getText());
		}
		catch (Exception e)
		{
			e.printStackTrace();
		} 
		finally
		{
			if (initialContext!=null)
			{
				try {
					initialContext.close();
				} catch (NamingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			if (connection!=null)
			{
				try {
					connection.close();
				} catch (JMSException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
//        InitialContext context = new InitialContext();
//        Queue queue = (Queue) context.lookup("queue/requestQueue");
//        //Queue replyQueue = (Queue) context.lookup("queue/replyQueue");
//
//        try(QueueConnectionFactory cf = new ActiveMQConnectionFactory();
//                        JMSContext jmsContext = cf.createContext()){
//                JMSProducer producer = jmsContext.createProducer();
//                TemporaryQueue replyQueue = jmsContext.createTemporaryQueue();
//                TextMessage message = jmsContext.createTextMessage("Arise Awake and stop not till the goal is reached");
//                message.setJMSReplyTo(replyQueue);
//                producer.send(queue,message);
//
//                Map<String,TextMessage> requestMessages = new HashMap<>();
//                requestMessages.put(message.getJMSMessageID(), message);
//
//                JMSConsumer consumer = jmsContext.createConsumer(queue);
//                TextMessage messageReceived = (TextMessage) consumer.receive();
//                System.out.println(messageReceived.getText());
    }
}
    		

