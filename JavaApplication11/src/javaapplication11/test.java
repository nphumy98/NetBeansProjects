/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication11;

/**
 *
 * @author MY PHU NGUYEN
 */
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.naming.*;  
import javax.jms.*;  

/**
 *
 * @author MY PHU NGUYEN
 */
public class test {
    public static void main(String[] args) { 
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
                TextMessage messageReceived= (TextMessage) consumer.receive(5000);
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
    }
    		
}

