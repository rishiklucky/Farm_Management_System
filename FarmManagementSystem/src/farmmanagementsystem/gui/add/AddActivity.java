/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * AddActivity.java
 *
 * Created on Nov 19, 2013, 4:00:24 AM
 */

package farmmanagementsystem.gui.add;


import farmmanagementsystem.db.DBQuery;
import farmmanagementsystem.gui.SelectEmployee;
import farmmanagementsystem.model.Activity;
import farmmanagementsystem.model.Employee;
import farmmanagementsystem.model.Location;
import farmmanagementsystem.model.User;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

/**
 *
 * @author Administrator
 */
public class AddActivity extends javax.swing.JDialog {

    /** Creates new form AddActivity */
    public AddActivity(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        jComboBoxLocation.setModel(new DefaultComboBoxModel(DBQuery.getLocation().toArray()));
        jComboBoxLocation.setSelectedIndex(0);
        jLabelMaintenancePerson.setText(((Location)jComboBoxLocation.getSelectedItem()).getCareTaker().getName());
        jLabelLocationAddress.setText(((Location)jComboBoxLocation.getSelectedItem()).getAddress());
        generatedID = DBQuery.generateActID();
        jLabelAct_id.setText(generatedID+"");
        list = new ArrayList<>();
    }
    private int generatedID;
    private ArrayList<Employee> list;

    public User user;
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel5 = new javax.swing.JLabel();
        jLabelAct_id = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jComboBoxLocation = new javax.swing.JComboBox();
        jLabelLocationAddress = new javax.swing.JLabel();
        jLabelMaintenancePerson = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jFormattedTextFieldShare = new javax.swing.JFormattedTextField();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jListEmpList = new javax.swing.JList();
        jLabel8 = new javax.swing.JLabel();
        jButtonAddEmp = new javax.swing.JButton();
        jButtonRemoveEmp = new javax.swing.JButton();
        jButtonSAVE = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        dateChooserCombo1 = new datechooser.beans.DateChooserCombo();
        jLabel9 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("NEW ACTIVITY");

        jLabel5.setText("Activity ID:");

        jLabelAct_id.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabelAct_id.setForeground(new java.awt.Color(204, 0, 0));
        jLabelAct_id.setText("101");

        jLabel1.setText("Location ID:");

        jComboBoxLocation.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBoxLocation.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBoxLocationItemStateChanged(evt);
            }
        });

        jLabelLocationAddress.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabelLocationAddress.setText("Vintar");

        jLabelMaintenancePerson.setFont(new java.awt.Font("Tahoma", 3, 11)); // NOI18N
        jLabelMaintenancePerson.setText("Juan dela Cruz");

        jLabel4.setText("Maintenance Person:");

        jLabel6.setText("Activity Share:");

        jFormattedTextFieldShare.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));
        jFormattedTextFieldShare.setText("25");
        jFormattedTextFieldShare.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jFormattedTextFieldShareFocusLost(evt);
            }
        });

        jLabel7.setText("%");

        jScrollPane1.setViewportView(jListEmpList);

        jLabel8.setText("Employees:");

        jButtonAddEmp.setText("ADD");
        jButtonAddEmp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddEmpActionPerformed(evt);
            }
        });

        jButtonRemoveEmp.setText("REMOVE");
        jButtonRemoveEmp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRemoveEmpActionPerformed(evt);
            }
        });

        jButtonSAVE.setText("SAVE");
        jButtonSAVE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSAVEActionPerformed(evt);
            }
        });

        jButton4.setText("CANCEL");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        dateChooserCombo1.setFormat(2);
        dateChooserCombo1.setBehavior(datechooser.model.multiple.MultyModelBehavior.SELECT_SINGLE);

        jLabel9.setText("Harvest Date");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jFormattedTextFieldShare, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel7))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabelAct_id, javax.swing.GroupLayout.DEFAULT_SIZE, 201, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jComboBoxLocation, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jLabelMaintenancePerson, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(13, 13, 13)
                                    .addComponent(jLabelLocationAddress, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(dateChooserCombo1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(109, 109, 109)
                .addComponent(jButtonSAVE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(114, 114, 114))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 391, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(76, 76, 76)
                        .addComponent(jScrollPane1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonAddEmp, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonRemoveEmp, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(25, 25, 25))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(dateChooserCombo1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jLabelAct_id, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jComboBoxLocation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabelLocationAddress)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelMaintenancePerson)
                            .addComponent(jLabel4))))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(jFormattedTextFieldShare, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 330, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(jButtonAddEmp)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButtonRemoveEmp)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonSAVE)
                    .addComponent(jButton4))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBoxLocationItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBoxLocationItemStateChanged
        jLabelMaintenancePerson.setText(((Location)jComboBoxLocation.getSelectedItem()).getCareTaker().getName());
        jLabelLocationAddress.setText(((Location)jComboBoxLocation.getSelectedItem()).getAddress());
    }//GEN-LAST:event_jComboBoxLocationItemStateChanged

    private void jButtonAddEmpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddEmpActionPerformed
        SelectEmployee se = new SelectEmployee(null, true);
        se.setOldList(list);
        se.setVisible(true);
        jListEmpList.setListData(list.toArray());
    }//GEN-LAST:event_jButtonAddEmpActionPerformed

    private void jButtonRemoveEmpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRemoveEmpActionPerformed
        if(jListEmpList.getSelectedIndex()<0){
            JOptionPane.showMessageDialog(null, "NO SELECTED ITEM", "EMPTY SELECTION", JOptionPane.ERROR_MESSAGE);
            return;
        }
        List t = jListEmpList.getSelectedValuesList();
        for(int i = 0; i<t.size();i++){
            Employee e = (Employee) t.get(i);
            list.remove(e);
        }
        jListEmpList.setListData(list.toArray());
    }//GEN-LAST:event_jButtonRemoveEmpActionPerformed

    private void jButtonSAVEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSAVEActionPerformed
    
        if(!isValidField()){
            JOptionPane.showMessageDialog(null, "Invalid DATA", "INPUT ERROR", JOptionPane.ERROR_MESSAGE);
            return;
        }
        Activity act = new Activity();
        act.setAct_id(generatedID);
        act.setAct_share(Double.parseDouble(jFormattedTextFieldShare.getText()));
        act.setDate(dateChooserCombo1.getSelectedDate().getTime());
        act.setLocation(((Location)jComboBoxLocation.getSelectedItem()));
        act.setPosted(false);
        if(DBQuery.isExistActivity(act.getLocation().getLoc_id())){
            JOptionPane.showMessageDialog(null, "There is a pending Activity on this Area.\n", "Override Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if(confirm("Register Activity?")){
            DBQuery.addActivity(act);
            for(Employee e:list){
                DBQuery.addWorker(act.getAct_id(), e.getEmp_id());
            }
            JOptionPane.showMessageDialog(null, "SAVED", "SAVED", JOptionPane.INFORMATION_MESSAGE);
            DBQuery.insertLog(user.getUser_id(), "Register Activity [Activity ID: "+act.getAct_id()+"]");
            dispose();
        }
    }//GEN-LAST:event_jButtonSAVEActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        if(confirm("ARE YOU SURE TO CANCEL ACTION?"))
        dispose();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jFormattedTextFieldShareFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jFormattedTextFieldShareFocusLost
        double d = Double.parseDouble(jFormattedTextFieldShare.getText());
        if(d > 40 || d < 0){
            JOptionPane.showMessageDialog(null, "Share:\n MAX:40\n MIN:0", "INVALID SHARE", JOptionPane.ERROR_MESSAGE);
            jFormattedTextFieldShare.setText("0.00");
        }
    }//GEN-LAST:event_jFormattedTextFieldShareFocusLost

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                AddActivity dialog = new AddActivity(new javax.swing.JFrame(), true);
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
    private datechooser.beans.DateChooserCombo dateChooserCombo1;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButtonAddEmp;
    private javax.swing.JButton jButtonRemoveEmp;
    private javax.swing.JButton jButtonSAVE;
    private javax.swing.JComboBox jComboBoxLocation;
    private javax.swing.JFormattedTextField jFormattedTextFieldShare;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelAct_id;
    private javax.swing.JLabel jLabelLocationAddress;
    private javax.swing.JLabel jLabelMaintenancePerson;
    private javax.swing.JList jListEmpList;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables

    private boolean isValidField(){
        if(jFormattedTextFieldShare.getText().isEmpty() || list.isEmpty())
            return false;
        if(dateChooserCombo1.getSelectedDate().getTime().after(new Date())){
            JOptionPane.showMessageDialog(null, "Date Must Not Be Future", "Invalid Entry", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }

    private boolean confirm(String confirmMessage){
        int ans = JOptionPane.showConfirmDialog(this, confirmMessage, "CONFIRMATION", JOptionPane.YES_NO_OPTION);
        return (ans == JOptionPane.YES_OPTION);
    }

}
