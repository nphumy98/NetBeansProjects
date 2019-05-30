/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.rmiguessnumber;

/**
 *
 * @author MY PHU NGUYEN
 */
import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GuessNumberServer implements GuessNumberGame{
    
    private int number;
    
    public GuessNumberServer(String message) throws RemoteException{
        System.out.println(message);
    }
    
    public int checkNumber(int guessNumber, int correctNumber) throws RemoteException {
        System.out.println("The number: "+guessNumber+": from Client has been checked");
        System.out.println("The correct number is: "+correctNumber);
        if (correctNumber== guessNumber)
        {
            System.out.println("The Client's Guess is corrected");
            return 0;
        }
        else if (guessNumber<correctNumber)
        {
            System.out.println("The Client's Guess is too low");
            return -1;
        }
        else
        {
            System.out.println("The Client's Guess is too high");
        }
        return 1;
    }

    public int generateRandomNumber() throws RemoteException {
        System.out.println("A random number between 1 and 99 inclusive has been generated");
        Random rd= new Random();
        this.number = rd.nextInt(99)+1;
        System.out.println("A number has been generated: "+this.number);
        return this.number;
    }
    
    public static void main(String [] args) throws RemoteException{
        System.out.println("In the Main Method of RMIServer...");
        GuessNumberServer remoteObject = new GuessNumberServer("Guess Number Server");
        System.out.println("RMIServer Object is created...");
        try{
            System.out.println("RMIServer: Creating the UnicasteRemoteObject...");
            GuessNumberGame stub = (GuessNumberGame) UnicastRemoteObject.exportObject(remoteObject, 0);
            System.out.println("RMIServer: Creating the Registry...");
            Registry registry = LocateRegistry.getRegistry();
            System.out.println("RMIServer: Registring the Remote object with name GuessGame...");
            registry.rebind("GuessGame", stub);
            System.out.println("Remote Object is bound with RMI Registry...");
            try{
                String []bindings = Naming.list("localhost");
                for(String name : bindings){
                    System.out.println(name);
                }
            }catch(MalformedURLException e){
                System.err.println("Unable to see names: " + e);
            }
        }catch(RemoteException e){
            System.err.println("Unable to bind to registry." + e);
        }
    }   
}