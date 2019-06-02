/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package applicationclient1;

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
public class Main {
    public static void main(String[] args) { 
                try{  
            //1) Create and start connection  
            InitialContext ctx=new InitialContext();  
            QueueConnectionFactory f=(QueueConnectionFactory)ctx.lookup("myQueueConnectionFactory");  
            QueueConnection con=f.createQueueConnection();  
            con.start();  
            //2) create Queue session  
            QueueSession ses=con.createQueueSession(false, Session.AUTO_ACKNOWLEDGE);  
            //3) get the Queue object  
            Queue t=(Queue)ctx.lookup("myQueue");  
            //4)create QueueReceiver  
            QueueReceiver receiver=ses.createReceiver(t);  
              
            //5) create listener object  
            MyListener listener=new MyListener();  
              
            //6) register the listener object with receiver  
            receiver.setMessageListener(listener);  
              
            System.out.println("Receiver1 is ready, waiting for messages...");  
            System.out.println("press Ctrl+c to shutdown...");  
            while(true){                  
                Thread.sleep(1000);  
            }  
        }catch(Exception e){System.out.println(e);}  
    } 
//        InitialContext initialContext= null;
//        Connection connection=null;
//        try
//        {
//                initialContext= new InitialContext();
//                ConnectionFactory cf= (ConnectionFactory) initialContext.lookup("myQueueConnectionFactory");
//                connection= cf.createConnection();
//                Session session = connection.createSession();
//                Queue queue=(Queue) initialContext.lookup("myQueue");
//
//                MessageProducer producer= session.createProducer(queue);
//                TextMessage message= session.createTextMessage("I am the creator of my destiny");
//                producer.send(message);
//                System.out.println("Message Sent:"+ message.getText());
//
//
//                MessageConsumer consumer=session.createConsumer(queue);
//                connection.start();
//                TextMessage messageReceived= (TextMessage) consumer.receive(5000);
//                System.out.println("Message Received:"+ messageReceived.getText());
//        }
//        catch (Exception e)
//        {
//                e.printStackTrace();
//        } 
//        finally
//        {
//            if (initialContext!=null)
//            {
//                    try {
//                            initialContext.close();
//                    } catch (NamingException e) {
//                            // TODO Auto-generated catch block
//                            e.printStackTrace();
//                    }
//            }
//
//            if (connection!=null)
//            {
//                try {
//                        connection.close();
//                } catch (JMSException e) {
//                        // TODO Auto-generated catch block
//                        e.printStackTrace();
//                }
//             }
//        }
    
    		
}

