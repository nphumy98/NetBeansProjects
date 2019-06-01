/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import javax.annotation.Resource;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.jms.JMSConnectionFactory;
import javax.jms.JMSContext;
import javax.jms.Queue;

/**
 *
 * @author luoze
 */
@Named(value = "helloControl")
@Dependent
public class HelloControl {

    @Resource(mappedName = "newDest")
    private Queue newDest;
    private String name;
    @Inject
    @JMSConnectionFactory("java:comp/DefaultJMSConnectionFactory")
    private JMSContext context;

    /**
     * Creates a new instance of HelloControl
     */
    public HelloControl() {
    }

    private void sendJMSMessageToNewDest(String messageData) {
        context.createProducer().send(newDest, messageData);
    }
    
    public void send(){
            this.sendJMSMessageToNewDest("??");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
}
