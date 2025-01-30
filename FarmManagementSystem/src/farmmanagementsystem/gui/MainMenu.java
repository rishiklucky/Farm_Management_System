/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

 /*
 * MainWindow.java
 *
 * Created on Nov 22, 2013, 5:06:14 AM
 */
package farmmanagementsystem.gui;

import farmmanagementsystem.FarmManagementSystem;
import farmmanagementsystem.gui.view.ViewClaims;
import farmmanagementsystem.gui.view.ViewExpenses;
import farmmanagementsystem.gui.view.ViewLogRecord;
import farmmanagementsystem.gui.view.ViewSalary;
import farmmanagementsystem.model.User;
import farmmanagementsystem.util.LookAndFeels;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Admin
 */
public class MainMenu extends javax.swing.JFrame {

    /**
     * Creates new form MainFrame
     */
    public MainMenu() {
        initComponents();
        new LookAndFeels(this, 3);
        setLocationRelativeTo(null);
//        setExtendedState(MAXIMIZED_BOTH);
    }

    public User user;

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel6 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jToolBar1 = new javax.swing.JToolBar();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        jButtonSwitchUser = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Farm Management System");

        jPanel6.setLayout(new java.awt.BorderLayout());
        getContentPane().add(jPanel6, java.awt.BorderLayout.CENTER);

        jPanel7.setLayout(new java.awt.BorderLayout());

        jToolBar1.setRollover(true);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/farmmanagementsystem/images/POSITION.png"))); // NOI18N
        jButton1.setText("MANAGE EMPLOYEE");
        jButton1.setFocusable(false);
        jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton1.setMaximumSize(new java.awt.Dimension(125, 153));
        jButton1.setMinimumSize(new java.awt.Dimension(125, 153));
        jButton1.setPreferredSize(new java.awt.Dimension(100, 153));
        jButton1.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/farmmanagementsystem/images/POSITION - Copy.png"))); // NOI18N
        jButton1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton1);

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/farmmanagementsystem/images/new_page.png"))); // NOI18N
        jButton2.setText("MANAGE LOCATION");
        jButton2.setFocusable(false);
        jButton2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton2.setMaximumSize(new java.awt.Dimension(125, 153));
        jButton2.setMinimumSize(new java.awt.Dimension(125, 153));
        jButton2.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/farmmanagementsystem/images/new_page - Copy.png"))); // NOI18N
        jButton2.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton2);

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/farmmanagementsystem/images/TRAVEL.png"))); // NOI18N
        jButton3.setText("MANAGE ACTIVITY");
        jButton3.setFocusable(false);
        jButton3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton3.setMaximumSize(new java.awt.Dimension(125, 153));
        jButton3.setMinimumSize(new java.awt.Dimension(125, 153));
        jButton3.setPreferredSize(new java.awt.Dimension(125, 153));
        jButton3.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/farmmanagementsystem/images/activityPres.png"))); // NOI18N
        jButton3.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton3);

        jButton9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/farmmanagementsystem/images/expenses.png"))); // NOI18N
        jButton9.setText("MANAGE EXPENCES");
        jButton9.setFocusable(false);
        jButton9.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton9.setMaximumSize(new java.awt.Dimension(125, 153));
        jButton9.setMinimumSize(new java.awt.Dimension(125, 153));
        jButton9.setPreferredSize(new java.awt.Dimension(125, 153));
        jButton9.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/farmmanagementsystem/images/expense.png"))); // NOI18N
        jButton9.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton9);

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/farmmanagementsystem/images/Salary.png"))); // NOI18N
        jButton4.setText("MANAGE GROSS PROFIT");
        jButton4.setFocusable(false);
        jButton4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton4.setMaximumSize(new java.awt.Dimension(125, 153));
        jButton4.setMinimumSize(new java.awt.Dimension(125, 153));
        jButton4.setPreferredSize(new java.awt.Dimension(125, 153));
        jButton4.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/farmmanagementsystem/images/Salary - Copy (3).png"))); // NOI18N
        jButton4.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton4);

        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/farmmanagementsystem/images/Salary - Copy (2).png"))); // NOI18N
        jButton6.setText("MANAGE DEDUCTION");
        jButton6.setFocusable(false);
        jButton6.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton6.setMaximumSize(new java.awt.Dimension(125, 153));
        jButton6.setMinimumSize(new java.awt.Dimension(125, 153));
        jButton6.setPreferredSize(new java.awt.Dimension(125, 153));
        jButton6.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/farmmanagementsystem/images/Salary - Copy (2) - Copy.png"))); // NOI18N
        jButton6.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton6);

        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/farmmanagementsystem/images/protection - Copy.png"))); // NOI18N
        jButton7.setText("VIEW WAGE");
        jButton7.setFocusable(false);
        jButton7.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton7.setMaximumSize(new java.awt.Dimension(125, 153));
        jButton7.setMinimumSize(new java.awt.Dimension(125, 153));
        jButton7.setPreferredSize(new java.awt.Dimension(125, 153));
        jButton7.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/farmmanagementsystem/images/protection - Copy - Copy.png"))); // NOI18N
        jButton7.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton7);

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/farmmanagementsystem/images/Salary - Copy.png"))); // NOI18N
        jButton5.setText("SHARES LOG");
        jButton5.setFocusable(false);
        jButton5.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton5.setMaximumSize(new java.awt.Dimension(125, 153));
        jButton5.setMinimumSize(new java.awt.Dimension(125, 153));
        jButton5.setPreferredSize(new java.awt.Dimension(125, 153));
        jButton5.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/farmmanagementsystem/images/Salary - Copy - Copy.png"))); // NOI18N
        jButton5.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton5);

        jButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/farmmanagementsystem/images/lock.png"))); // NOI18N
        jButton8.setText("CHANGE USER PASSWORD");
        jButton8.setFocusable(false);
        jButton8.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton8.setMaximumSize(new java.awt.Dimension(125, 153));
        jButton8.setMinimumSize(new java.awt.Dimension(125, 153));
        jButton8.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/farmmanagementsystem/images/unlock.png"))); // NOI18N
        jButton8.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton8);

        jButton10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/farmmanagementsystem/images/LOG.png"))); // NOI18N
        jButton10.setText("LOGS");
        jButton10.setFocusable(false);
        jButton10.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton10.setMaximumSize(new java.awt.Dimension(125, 153));
        jButton10.setMinimumSize(new java.awt.Dimension(125, 153));
        jButton10.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/farmmanagementsystem/images/LOG CLICK.png"))); // NOI18N
        jButton10.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton10);

        jButton11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/farmmanagementsystem/images/users.png"))); // NOI18N
        jButton11.setText("MANAGE USER");
        jButton11.setFocusable(false);
        jButton11.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton11.setMaximumSize(new java.awt.Dimension(125, 153));
        jButton11.setMinimumSize(new java.awt.Dimension(125, 153));
        jButton11.setPreferredSize(new java.awt.Dimension(125, 153));
        jButton11.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/farmmanagementsystem/images/users_h.png"))); // NOI18N
        jButton11.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton11);

        jButtonSwitchUser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/farmmanagementsystem/images/switch-user.png"))); // NOI18N
        jButtonSwitchUser.setText("SWITCH USER");
        jButtonSwitchUser.setFocusable(false);
        jButtonSwitchUser.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonSwitchUser.setMaximumSize(new java.awt.Dimension(125, 153));
        jButtonSwitchUser.setMinimumSize(new java.awt.Dimension(125, 153));
        jButtonSwitchUser.setPreferredSize(new java.awt.Dimension(125, 153));
        jButtonSwitchUser.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/farmmanagementsystem/images/switch-user.png"))); // NOI18N
        jButtonSwitchUser.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jButtonSwitchUser.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButtonSwitchUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSwitchUserActionPerformed(evt);
            }
        });
        jToolBar1.add(jButtonSwitchUser);

        jPanel7.add(jToolBar1, java.awt.BorderLayout.CENTER);

        getContentPane().add(jPanel7, java.awt.BorderLayout.NORTH);

        jMenu1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/farmmanagementsystem/images/16settings.png"))); // NOI18N
        jMenu1.setText("Farm Management System");

        jMenuItem2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/farmmanagementsystem/images/users_1.png"))); // NOI18N
        jMenuItem2.setText("Switch User");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuItem3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/farmmanagementsystem/images/16close.png"))); // NOI18N
        jMenuItem3.setText("Exit");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem3);

        jMenuBar1.add(jMenu1);

        jMenu2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/farmmanagementsystem/images/16help.png"))); // NOI18N
        jMenu2.setText("Help");

        jMenuItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/farmmanagementsystem/images/16about.png"))); // NOI18N
        jMenuItem1.setText("About");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem1);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        setSize(new java.awt.Dimension(1581, 761));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        ManageEmpoyee ME = new ManageEmpoyee(this, true);
        ME.user = user;
        ME.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        ManageLocation ML = new ManageLocation(this, true);
        ML.user = user;
        ML.setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        ManageActivity MA = new ManageActivity(this, true);
        MA.user = user;
        MA.setVisible(true);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        if (!user.getUserType().contentEquals("Administrator")) {
            JOptionPane.showMessageDialog(null, "FOR ADMINISTRATOR ONLY.", "RESTRICTED AREA", JOptionPane.ERROR_MESSAGE);
            return;
        }
        ManageGrossProfit MG = new ManageGrossProfit(this, true);
        MG.user = user;
        MG.setVisible(true);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        ViewSalary VS = new ViewSalary(this, true);
        VS.setVisible(true);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        if (!user.getUserType().contentEquals("Administrator")) {
            JOptionPane.showMessageDialog(null, "FOR ADMINISTRATOR ONLY.", "RESTRICTED AREA", JOptionPane.ERROR_MESSAGE);
            return;
        }
        ManageDeduction md = new ManageDeduction(this, true);
        md.user = user;
        md.setVisible(true);
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        ViewClaims vc = new ViewClaims(this, true);
        vc.user = user;
        vc.setVisible(true);
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        ChangePassword PW = new ChangePassword(this, true);
        PW.setUser(user);
        PW.setVisible(true);
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        ViewExpenses ve = new ViewExpenses(this, true);
        ve.user = user;
        ve.setVisible(true);
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        try {
            ViewLogRecord V = new ViewLogRecord(this, true);
            V.setVisible(true);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(MainMenu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        if (!user.getUserType().contentEquals("Administrator")) {
            JOptionPane.showMessageDialog(null, "FOR ADMINISTRATOR ONLY.", "RESTRICTED AREA", JOptionPane.ERROR_MESSAGE);
            return;
        }
//        JFrameManageUser MU = new JFrameManageUser();
        ManageUser MU = new ManageUser(this, true);
        MU.setUser_ID(user.getUser_id());
        MU.setVisible(true);
    }//GEN-LAST:event_jButton11ActionPerformed

    private void jButtonSwitchUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSwitchUserActionPerformed
        if (confirm("ARE YOU SURE TO SWITCH USER?")) {
            dispose();
            FarmManagementSystem.main(new String[0]);
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonSwitchUserActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        if (confirm("ARE YOU SURE TO SWITCH USER?")) {
            dispose();
            FarmManagementSystem.main(new String[0]);
        }
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        if (confirm("ARE YOU SURE TO EXIT PROGRAM?")) {
            dispose();
            System.exit(0);
        }
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
       JDialogAbout about = new JDialogAbout(this, true);
       about.setVisible(true);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainMenu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JButton jButtonSwitchUser;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JToolBar jToolBar1;
    // End of variables declaration//GEN-END:variables

    private boolean confirm(String confirmMessage) {
        int ans = JOptionPane.showConfirmDialog(this, confirmMessage, "CONFIRMATION", JOptionPane.YES_NO_OPTION);
        return (ans == JOptionPane.YES_OPTION);
    }

}
