/**
 * @(#)ExitListener.java
 *
 *
 * @author AzaShem
 * @version 1.00 2008/1/14
 */
package farmmanagementsystem.util;

import java.awt.event.*;

/** A listener that you attach to the top-level Frame or JFrame of
 *  your application, so quitting the frame exits the application.
 *  1998-99 Marty Hall, http://www.apl.jhu.edu/~hall/java/
 */

public class ExitListener extends WindowAdapter {
  public void windowClosing(WindowEvent event) {
   new javax.swing.JFrame().setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
  }
}
