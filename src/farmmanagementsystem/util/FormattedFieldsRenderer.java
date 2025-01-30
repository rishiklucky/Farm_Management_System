/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package farmmanagementsystem.util;

import java.awt.Component;
import javax.swing.JFormattedTextField;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author AzaShem
 */
public class FormattedFieldsRenderer extends DefaultTableCellRenderer {

JFormattedTextField fields = new javax.swing.JFormattedTextField();

  public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,boolean hasFocus, int row, int column) {
   fields.setBorder(null);
   fields.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("Php #,##0.00"))));
   fields.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
   fields.setValue(value);
   return fields;
  }

  
 }
