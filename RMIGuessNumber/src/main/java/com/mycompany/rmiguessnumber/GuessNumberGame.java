/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.rmiguessnumber;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author MY PHU NGUYEN
 */
public interface GuessNumberGame extends Remote {
    public int checkNumber(int guessNumber, int correctNumber) throws RemoteException;
    public int generateRandomNumber() throws RemoteException;
}
