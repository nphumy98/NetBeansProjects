/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package socketprogramming;

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
         //Create socket for Client. need to know the ip of server computer (find by ip config in server computer)
         // the port number 9999 is the port number when server is created
         //(APPLY TCP/IP protocol). Client and sever must be connected to each other
    Socket sock= new Socket("172.28.97.118",9999);
    System.out.println("Connected to server");
    
    //create input and ouput stream for Client
    InputStream in = sock.getInputStream();
    OutputStream out = sock.getOutputStream();
    
    //send something to Server
    out.write("Hello from Client...".getBytes());
    
    //read response from Server
    byte[] buffer= new byte[1024];
    in.read(buffer);
    
    //print out response from Server
    System.out.println("Receive from Server."+ new String(buffer).trim());
    
    //close socket
    sock.close();
     }
    
}
