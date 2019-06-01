/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**
 *
 * @author luoze
 */
@MessageDriven(activationConfig = {
    @ActivationConfigProperty(propertyName = "destinationLookup", propertyValue = "newDest")
    ,
        @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue")
})
public class HelloMessageBean implements MessageListener {
    
    public HelloMessageBean() {
    }
    
    @Override
    public void onMessage(Message message) {
        TextMessage text = (TextMessage) message;
        if(text!=null){
            try {
                System.out.println(text.getText());
            } catch (JMSException ex) {
                Logger.getLogger(HelloMessageBean.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}
