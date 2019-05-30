/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package socketprogramming2.pkg4;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 *
 * @author MY PHU NGUYEN
 */
public class Client {
    public static void main(String[] args) throws IOException {
    Socket sock= new Socket("172.28.97.118",9999);
    
    System.out.println("Connected to the server");
    
    String product="a";
    
    InputStream in = sock.getInputStream();
    OutputStream out= sock.getOutputStream();
    System.out.println("Sending product information");
    out.write(product.getBytes());
    
    System.out.println("Product information sent to Sever");
    byte[] reponseSever= new byte[100];
    in.read(reponseSever);
    
    String strReponse= new String(reponseSever).trim();
    System.out.println("Obtained reponse from Sever "+strReponse);
    
    sock.close(); 
    
    }
}
