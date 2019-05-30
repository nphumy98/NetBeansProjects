/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package socketprogramming2.pkg4;

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
        // TODO code application logic here
        QuoteService aQuoteService= new QuoteService();
        
        ServerSocket serSocket= new ServerSocket(9999);
        System.out.println("Started listening to 9999");
        
        while(true)
                {
                    System.out.println("Waiting for client...");
                    Socket sock= serSocket.accept();
                    
                    InputStream in= sock.getInputStream();
                    OutputStream out= sock.getOutputStream();
                    
                    System.out.println("Waiting for request for production information from the Client");
                    byte requestClient[]= new byte[100];
                    in.read(requestClient);
                    
                    String product= new String(requestClient).trim();
                    System.out.println("Received product name..."+ product);
                    
                    String price= aQuoteService.getQuote(product);
                    if (price==null) {
                        price="Invalid product";
                    }
                    
                    out.write(price.getBytes());
                    
                    System.out.println("Response sent");
                    sock.close();
                }
        
    }
    
}
