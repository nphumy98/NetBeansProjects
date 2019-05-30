/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BookStore;

/**
 *
 * @author MY PHU NGUYEN
 */
public class Admin {
    private String adminID;
    private String adminPassword;
    
    //constructor
    public Admin(String adminID, String adminPassword) {
        this.adminID = adminID;
        this.adminPassword = adminPassword;
    }
    
    //getter and setter

    public String getAdminID() {
        return adminID;
    }

    public void setAdminID(String adminID) {
        this.adminID = adminID;
    }

    public String getAdminPassword() {
        return adminPassword;
    }

    public void setAdminPassword(String adminPassword) {
        this.adminPassword = adminPassword;
    }
    
    //toString

    @Override
    public String toString() {
        return "Admin{" + "adminID=" + adminID + ", adminPassword=" + adminPassword + '}';
    }
    
}
