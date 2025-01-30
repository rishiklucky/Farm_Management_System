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
public class ModifiedLabelRenderer extends DefaultTableCellRenderer {
  JLabel lbl = new JLabel();

  public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
      boolean hasFocus, int row, int column) {
        if(isSelected){
            lbl.setBackground(Color.blue);
            lbl.setForeground(Color.white);
        }else{
            lbl = new JLabel();
        }
        lbl.setOpaque(true);
        lbl.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        String txt = String.format( "%,.2f",value);
        lbl.setText(txt);
      return lbl;
  }
 }



