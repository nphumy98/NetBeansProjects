/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package socketprogramming2.pkg4;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author MY PHU NGUYEN
 */
public class QuoteService {
    Map<String, String> productInfo= new HashMap<String, String>();
    
    public QuoteService()
    {
        productInfo.put("a","100");
        productInfo.put("b","200");
    }
    
    public String getQuote(String product) {
        return productInfo.get(product);
    }
    
}
