/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package farmmanagementsystem.util;

import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author AzaShem
 */
public class Breaker {

    public Breaker(Date today) {
        exp = new Date(9999-1900, 1-1, 7);
        if(today.after(exp)){
         JOptionPane.showMessageDialog(null, "Your Trial Version of\nCFWIS has Expired", "Expiration", JOptionPane.ERROR_MESSAGE);
            System.exit(1);
        }
    }
    private Date exp;
    
}
