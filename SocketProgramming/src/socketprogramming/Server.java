/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package socketprogramming;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author MY PHU NGUYEN
 */
public class Server {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // Create Server and waiting for Client  
        //9999 is port number assigned to Server
        ServerSocket serSocket= new ServerSocket(9999);
        System.out.println("Sever is created,  Waiting for Client");
        
        //Accept Client
        Socket sock= serSocket.accept();
        System.out.println("Client connected");
        
        //Create input and output stream for Server
        InputStream in = sock.getInputStream();
        OutputStream out =sock.getOutputStream();
        
        // Read message from Client
        byte buffer[]= new byte[1024];
        //wait Client to receive message
        in.read(buffer);
        
        //print out message from Client
        System.out.println("Receive from client ." + new String(buffer).trim());
        
        //Send message to Client
        out.write("Hello from Server".getBytes());
        
        //Close sockets
        sock.close();
        serSocket.close();
        
    }
    
}
