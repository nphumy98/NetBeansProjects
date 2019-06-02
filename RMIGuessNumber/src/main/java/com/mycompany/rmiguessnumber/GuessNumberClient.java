/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.rmiguessnumber;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;
/**
 *
 * @author MY PHU NGUYEN
 */
public class GuessNumberClient {
        public static void main(String [] args){
        try{
            Registry registry = LocateRegistry.getRegistry();
            System.out.println("Registry is created...");
            GuessNumberGame remoteProxy = (GuessNumberGame)registry.lookup("GuessGame");
            int correctNumber=remoteProxy.generateRandomNumber();
            int checkAnswer=-1;
            do
            {
                System.out.println("Please guess the number: ");
                Scanner input = new Scanner(System.in);
                int guessNumber = input.nextInt();        
                checkAnswer= remoteProxy.checkNumber(guessNumber,correctNumber);
                if (checkAnswer==0)
                {
                    System.out.println("Congratulation, your answer is correct ");
                }
                else if (checkAnswer==-1)
                {
                    System.out.println("Guess again, your answer is too low ");
                }
                else
                {
                    System.out.println("Guess again, your answer is too high ");
                }
            }while (checkAnswer!=0);
        }catch (RemoteException e){
            System.err.println("Unable to use registry: " + e);
        }catch (NotBoundException e){
            System.err.println("Guess Number Game not currently bound: " + e);
        }catch(ClassCastException e){
            System.err.println("Class Cast Exception: " + e);
        }
    }
}
