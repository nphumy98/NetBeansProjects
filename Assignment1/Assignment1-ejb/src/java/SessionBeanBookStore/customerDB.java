/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SessionBeanBookStore;

import BookStore.Customer;
import java.util.ArrayList;
import javax.ejb.Stateless;

/**
 *
 * @author MY PHU NGUYEN
 */
@Stateless
public class customerDB implements customerDBLocal {
    
    private ArrayList<Customer> customerList;
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
