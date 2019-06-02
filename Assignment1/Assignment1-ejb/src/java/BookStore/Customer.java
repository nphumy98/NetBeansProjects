/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BookStore;

import java.util.ArrayList;

/**
 *
 * @author MY PHU NGUYEN
 */
public class Customer {
    private static int customerIDSet=1000;
    private int customerID;
    private String customerName;
     private String password;
    private ArrayList<Book> bookHistory;
    private ArrayList<Book> bookOrder;

    public Customer(int customerID, String customerName, String password, ArrayList<Book> bookHistory, ArrayList<Book> bookOrder) {
        customerIDSet++;
        this.customerID = customerIDSet;
        this.customerName = customerName;
        this.password = password;
        this.bookHistory = bookHistory;
        this.bookOrder = bookOrder;
    }
    
    //getter and setter

    public static int getCustomerIDSet() {
        return customerIDSet;
    }

    public static void setCustomerIDSet(int customerIDSet) {
        Customer.customerIDSet = customerIDSet;
    }

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public ArrayList<Book> getBookHistory() {
        return bookHistory;
    }

    public void setBookHistory(ArrayList<Book> bookHistory) {
        this.bookHistory = bookHistory;
    }

    public ArrayList<Book> getBookOrder() {
        return bookOrder;
    }

    public void setBookOrder(ArrayList<Book> bookOrder) {
        this.bookOrder = bookOrder;
    }
    
    //toString

    @Override
    public String toString() {
        return "Customer{" + "customerID=" + customerID + ", customerName=" + customerName + ", password=" + password + ", bookHistory=" + bookHistory + ", bookOrder=" + bookOrder + '}';
    }
    
}
