/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package farmmanagementsystem.util;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author AzaShem
 */
public class ImageRenderer extends DefaultTableCellRenderer {
  JLabel lbl = new JLabel();

  public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
      boolean hasFocus, int row, int column) {

            docOBJECT d = (docOBJECT) value;
            BufferedImage image;
                image = (BufferedImage)  d.value;            
            image = ComponentHouseResizer.resizeImageWithHint(image, 100, 100);
            lbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
            lbl.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
            lbl.setVerticalAlignment(javax.swing.SwingConstants.TOP);
            lbl.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
            lbl.setPreferredSize(new Dimension(image.getWidth(), image.getHeight()));
            lbl.setSize(new Dimension(image.getWidth(), image.getHeight()));
            lbl.setIcon(new ImageIcon(image));
            lbl.setText(d.name);
            if(isSelected){
                lbl.setBackground(Color.BLUE);
                lbl.setForeground(Color.WHITE);
                lbl.setOpaque(true);
            }else{
                lbl.setBackground(Color.WHITE);
                lbl.setForeground(Color.BLACK);
                lbl.setOpaque(false);
            }

      return lbl;      
  }
  
  public docOBJECT getInstance(Object value, String name){
         return new docOBJECT(value, name);
  }
  public class docOBJECT{

      public Object value;
      public String name;

        public docOBJECT(Object value, String name) {
            this.value = value;
            this.name = name;
        }      
  }
 }



