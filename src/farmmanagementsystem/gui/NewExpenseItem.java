/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * NewExpenseItem.java
 *
 * Created on Dec 10, 2013, 12:36:33 AM
 */

package farmmanagementsystem.gui;

import farmmanagementsystem.util.LookAndFeels;
import javax.swing.JOptionPane;

/**
 *
 * @author Admin
 */
public class NewExpenseItem extends javax.swing.JDialog {

    /** Creates new form NewExpenseItem */
    public NewExpenseItem(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        new LookAndFeels(this, 3);
    }

    public String remarks;
    public double amount;
    public boolean submit = false;

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButtonSUBMIT = new javax.swing.JButton();
        jButtonCANCEL = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jTextFieldRemark = new javax.swing.JTextField();
        jFormattedTextFieldAmount = new javax.swing.JFormattedTextField();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("NEW ITEM");
        setResizable(false);

        jButtonSUBMIT.setText("SUBMIT");
        jButtonSUBMIT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSUBMITActionPerformed(evt);
            }
        });

        jButtonCANCEL.setText("CANCEL");
        jButtonCANCEL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCANCELActionPerformed(evt);
            }
        });

        jLabel1.setText("REMARKS");

        jFormattedTextFieldAmount.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#,##0.00"))));
        jFormattedTextFieldAmount.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        jLabel2.setText("AMOUNT");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jTextFieldRemark, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jFormattedTextFieldAmount, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButtonSUBMIT)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonCANCEL)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldRemark, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jFormattedTextFieldAmount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonSUBMIT)
                    .addComponent(jButtonCANCEL))
                .addContainerGap(31, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonCANCELActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCANCELActionPerformed
        if(confirm("CANCEL?"))
            dispose();
    }//GEN-LAST:event_jButtonCANCELActionPerformed

    private void jButtonSUBMITActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSUBMITActionPerformed
        double tmp;
        try {
            tmp = Double.parseDouble(jFormattedTextFieldAmount.getText().replace(",", ""));
        } catch (NumberFormatException numberFormatException) {
            tmp = 0.00;
        }
        System.out.println(tmp);

        if(jTextFieldRemark.getText().isEmpty() || tmp <= 0){
            JOptionPane.showMessageDialog(null, "INVALID ITEM", "FIELD ERROR", JOptionPane.ERROR_MESSAGE);
            return;
        }
        amount = tmp;
        remarks = jTextFieldRemark.getText();
        if(confirm("SUBMIT EXPENSE ITEM?")){
            submit = true;
            dispose();
        }
    }//GEN-LAST:event_jButtonSUBMITActionPerformed

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                NewExpenseItem dialog = new NewExpenseItem(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCANCEL;
    private javax.swing.JButton jButtonSUBMIT;
    private javax.swing.JFormattedTextField jFormattedTextFieldAmount;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField jTextFieldRemark;
    // End of variables declaration//GEN-END:variables

    private boolean confirm(String confirmMessage){
        int ans = JOptionPane.showConfirmDialog(this, confirmMessage, "CONFIRMATION", JOptionPane.YES_NO_OPTION);
        return (ans == JOptionPane.YES_OPTION);
    }

}
