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
public class Supplier {
    private static int supplierID=2000;
    private String supplierName;
    private String password;
    private ArrayList<Book> bookSupplyHistory;
    private ArrayList<Book> bookOffer;
    
    //constructor
    public Supplier(String supplierName, String password, ArrayList<Book> bookSupplyHistory, ArrayList<Book> bookOffer) {
     this.supplierName = supplierName;
     this.password = password;
     this.bookSupplyHistory = bookSupplyHistory;
     this.bookOffer = bookOffer;
    }
    //getter and setter
    public static int getSupplierID() {
        return supplierID;
    }

    public static void setSupplierID(int supplierID) {
        Supplier.supplierID = supplierID;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public ArrayList<Book> getBookSupplyHistory() {
        return bookSupplyHistory;
    }

    public void setBookSupplyHistory(ArrayList<Book> bookSupplyHistory) {
        this.bookSupplyHistory = bookSupplyHistory;
    }

    public ArrayList<Book> getBookOffer() {
        return bookOffer;
    }

    public void setBookOffer(ArrayList<Book> bookOffer) {
        this.bookOffer = bookOffer;
    }

    //toString

    @Override
    public String toString() {
        return "Supplier{" + "supplierName=" + supplierName + ", password=" + password + ", bookSupplyHistory=" + bookSupplyHistory + ", bookOffer=" + bookOffer + '}';
    }
    
}
