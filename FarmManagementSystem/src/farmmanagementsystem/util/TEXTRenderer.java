/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package farmmanagementsystem.util;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author AzaShem
 */
public class TEXTRenderer extends DefaultTableCellRenderer {
JLabel txt =new javax.swing.JLabel();

  public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
      boolean hasFocus, int row, int column) {

      String val = (String) value;
        txt.setText(val);
        txt.setToolTipText("<HTML>"+val.replaceAll("\n", "<br>")+"</HTML>");
        if(isSelected){
            txt.setBackground(new java.awt.Color(51, 153, 255));
            txt.setForeground(new java.awt.Color(255, 255, 255));
            txt.setOpaque(true);
        }else{
            txt.setBackground(Color.WHITE);
            txt.setForeground(Color.BLACK);
            txt.setOpaque(true);
        }
        
    return txt;
  }
 }
