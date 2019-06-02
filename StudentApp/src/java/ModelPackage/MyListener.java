/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModelPackage;

/**
 *
 * @author MY PHU NGUYEN
 */
import ServletPackage.AppServlet;
import static java.lang.System.out;
import javax.jms.*;  
public class MyListener implements MessageListener {  
  
    public void onMessage(Message m) {  
        try{  
        TextMessage msg=(TextMessage)m;  
        AppServlet.message=msg.getText();
        System.out.println(AppServlet.message);
        }catch(JMSException e){System.out.println(e);}  
    }  
}
