/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package farmmanagementsystem.util;

import java.text.NumberFormat;

/**
 *
 * @author AzaShem
 */
public class StringCurrencyFormat {

   public static String toPesoFormat(double val){
       String symbol = "\u20b1";
            String temp = NumberFormat.getCurrencyInstance().format(val);
            char a[] = temp.toCharArray();
            a[0] = ' ';temp = String.copyValueOf(a);
        return symbol+=temp;
    }

}
