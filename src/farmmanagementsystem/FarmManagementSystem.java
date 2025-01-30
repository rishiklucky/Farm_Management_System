/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package farmmanagementsystem;

/**
 *
 * @author Aldrin
 */
import farmmanagementsystem.gui.Login;
import farmmanagementsystem.gui.MainMenu;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author Administrator
 *
 */
public class FarmManagementSystem {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        SplashScreen s = new SplashScreen(null, true);
        s.setVisible(true);
        Login log = new Login(null, true);
        log.setVisible(true);
        if (log.isAccepted) {

            int ans = JOptionPane.showConfirmDialog(null, "TODAY IS \n" + String.format("%1$TA, %1$TB %1$Td, %1$TY\n", new Date()) + "\n"
                    + String.format("%tr\n", new Date()), "DATE VALIDATION", JOptionPane.YES_NO_OPTION);

            if (ans == JOptionPane.NO_OPTION) {
                JOptionPane.showMessageDialog(null, "UPDATE THE SYSTEM TIME AND RUN THE PROGRAM AGAIN.", "MESSAGE", JOptionPane.INFORMATION_MESSAGE);
                System.exit(0);
            }

            if (ans == JOptionPane.YES_OPTION) {
                MainMenu MF = new MainMenu();
                MF.user = log.user;
                MF.setVisible(true);
            }

        }
    }
}
