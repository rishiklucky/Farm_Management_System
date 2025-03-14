/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * AddEmployee.java
 *
 * Created on Nov 19, 2013, 3:15:16 AM
 */

package farmmanagementsystem.gui.update;

import farmmanagementsystem.db.DBQuery;
import farmmanagementsystem.gui.UploadImage;
import farmmanagementsystem.model.Employee;
import farmmanagementsystem.model.User;
import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.util.Calendar;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author Administrator
 */
public class UpdateEmployee extends javax.swing.JDialog {

    /** Creates new form AddEmployee */
    public UpdateEmployee(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
    }
    private Employee employee;
    private UploadImage.ImagePackage img;
    public void setEmployee(Employee employee) {
        this.employee = employee;
        setEmployee();
    }

    public User user;

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextFieldName = new javax.swing.JTextField();
        jTextFieldAddress = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextFieldComments = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabelEmp_ID = new javax.swing.JLabel();
        jButtonSave = new javax.swing.JButton();
        jButtonCANCEL = new javax.swing.JButton();
        jComboBoxGender = new javax.swing.JComboBox();
        jLabelAge = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        dateChooserCombo1 = new datechooser.beans.DateChooserCombo();
        jLabel6 = new javax.swing.JLabel();
        jLabelIMG = new javax.swing.JLabel();
        jTextFieldContactNo = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jButtonBrowse = new javax.swing.JButton();
        jCheckBoxDATA = new javax.swing.JCheckBox();
        dateChooserCombo2 = new datechooser.beans.DateChooserCombo();
        jLabel9 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Update Employee");

        jLabel1.setText("Name:");

        jLabel2.setText("Address:");

        jLabel3.setText("Comments:");

        jLabel4.setText("Gender:");

        jLabel5.setText("Employee ID:");

        jLabelEmp_ID.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabelEmp_ID.setForeground(new java.awt.Color(204, 0, 0));
        jLabelEmp_ID.setText("100001");

        jButtonSave.setText("SAVE");
        jButtonSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSaveActionPerformed(evt);
            }
        });

        jButtonCANCEL.setText("CANCEL");
        jButtonCANCEL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCANCELActionPerformed(evt);
            }
        });

        jComboBoxGender.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Male", "Female" }));

        jLabelAge.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabelAge.setText("Age:");

        jLabel7.setText("Age:");

        dateChooserCombo1.setNothingAllowed(false);
        dateChooserCombo1.setBehavior(datechooser.model.multiple.MultyModelBehavior.SELECT_SINGLE);
        dateChooserCombo1.addSelectionChangedListener(new datechooser.events.SelectionChangedListener() {
            public void onSelectionChange(datechooser.events.SelectionChangedEvent evt) {
                dateChooserCombo1OnSelectionChange(evt);
            }
        });

        jLabel6.setText("Date of Birth:");

        jLabelIMG.setIcon(new javax.swing.ImageIcon(getClass().getResource("/farmmanagementsystem/images/POSITION.png"))); // NOI18N
        jLabelIMG.setBorder(new javax.swing.border.MatteBorder(null));

        jLabel8.setText("Contact No:");

        jButtonBrowse.setText("Browse>>");
        jButtonBrowse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBrowseActionPerformed(evt);
            }
        });

        jCheckBoxDATA.setText("NO DATA");
        jCheckBoxDATA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxDATAActionPerformed(evt);
            }
        });

        jLabel9.setText("Employment Date");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelEmp_ID)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 127, Short.MAX_VALUE)
                        .addComponent(jButtonBrowse)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelIMG))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldComments, javax.swing.GroupLayout.DEFAULT_SIZE, 404, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFieldName, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 406, Short.MAX_VALUE)
                            .addComponent(jTextFieldAddress, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 406, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jComboBoxGender, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(dateChooserCombo2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                            .addComponent(jLabel8))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(dateChooserCombo1, javax.swing.GroupLayout.DEFAULT_SIZE, 239, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabelAge)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jCheckBoxDATA)
                                .addGap(37, 37, 37))
                            .addComponent(jTextFieldContactNo, javax.swing.GroupLayout.DEFAULT_SIZE, 405, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(350, Short.MAX_VALUE)
                        .addComponent(jButtonSave)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonCANCEL)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabelEmp_ID, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabelIMG, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonBrowse))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextFieldName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextFieldAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4)
                        .addComponent(jComboBoxGender, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel9))
                    .addComponent(dateChooserCombo2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(dateChooserCombo1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel7)
                        .addComponent(jLabelAge)
                        .addComponent(jCheckBoxDATA)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldContactNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldComments, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonSave)
                    .addComponent(jButtonCANCEL))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonCANCELActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCANCELActionPerformed
    if(confirm("ARE YOU SURE TO CANCEL ACTION?")) {
            dispose();
        }
    }//GEN-LAST:event_jButtonCANCELActionPerformed

    private boolean img_isChanged = false;
    private void jButtonSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSaveActionPerformed
       if(!isValidFields()){
           JOptionPane.showMessageDialog(null, "Incomplete Data", "ERROR", JOptionPane.ERROR_MESSAGE);
           return;
       }
       if(img == null){
          if(!confirm("NO IMAGE...\n PROCEED ANYWAY?")) {
               return;
           }
       }
       Employee e = new Employee();
       e.setEmp_id(employee.getEmp_id());
       e.setAddress(jTextFieldAddress.getText());
       e.setComments(jTextFieldComments.getText());
       e.setGender(jComboBoxGender.getSelectedItem()+"");
       e.setName(jTextFieldName.getText());
       e.sethDate(dateChooserCombo2.getSelectedDate().getTime());
       if(!jCheckBoxDATA.isSelected()) {
            e.setbDate(dateChooserCombo1.getSelectedDate().getTime());
        }
       else {
            e.setbDate(new Date(0, 0, 1));
        }
       e.setContactNo(jTextFieldContactNo.getText());
       
       if(e.getAge()<15 && !jCheckBoxDATA.isSelected()){
        JOptionPane.showMessageDialog(null, "Employee must be 15 years old and above", "INVALID AGE", JOptionPane.ERROR_MESSAGE);
           return;
       }else if(jCheckBoxDATA.isSelected()){
           if(!confirm("NO DATA FOR BIRTHDATE..\n PROCEED ANYWAY?")) {
               return;
           }
       }
       if(e.equals(employee) && !img_isChanged){
          JOptionPane.showMessageDialog(null, "NO CHANGES", "UPDATE ERROR", JOptionPane.ERROR_MESSAGE);
           return;
       }
       if(DBQuery.isExistName(e.getName()) && !e.getName().equalsIgnoreCase(employee.getName())){
        JOptionPane.showMessageDialog(null, "Name already exist", "DUPLICATION ERROR", JOptionPane.ERROR_MESSAGE);
           return;
       }
       if(confirm("Update Employee?")){
       DBQuery.updateEmployee(e);
       if(img != null) {
               DBQuery.updateProfileImage(employee.getEmp_id(), img.getThumbnail());
           }
       JOptionPane.showMessageDialog(null, "SAVED", "SAVED", JOptionPane.INFORMATION_MESSAGE);
       DBQuery.insertLog(user.getUser_id(), "Update Employee [Employee ID: "+e.getEmp_id()+"]");
       dispose();
        }
    }//GEN-LAST:event_jButtonSaveActionPerformed

    private void dateChooserCombo1OnSelectionChange(datechooser.events.SelectionChangedEvent evt) {//GEN-FIRST:event_dateChooserCombo1OnSelectionChange
        Employee e =new Employee();
        e.setbDate(dateChooserCombo1.getSelectedDate().getTime());
        jLabelAge.setText(e.getAge()+" years old");
}//GEN-LAST:event_dateChooserCombo1OnSelectionChange

    private void jButtonBrowseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBrowseActionPerformed
        UploadImage uploader = new UploadImage(null, true);
        uploader.setVisible(true);
        UploadImage.ImagePackage tmp = uploader.getSelectedImage();
        if(tmp != null){
            img = tmp;
            img_isChanged = true;
            jLabelIMG.setPreferredSize(new Dimension(img.getThumbnail().getWidth(),img.getThumbnail().getHeight()));
            jLabelIMG.setSize(new Dimension(img.getThumbnail().getWidth(),img.getThumbnail().getHeight()));
            jLabelIMG.setIcon(new ImageIcon(img.getThumbnail()));
        } else if(img == null) {
            jLabelIMG.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cfwis/RESOURCES/POSITION.png")));
        }
    }//GEN-LAST:event_jButtonBrowseActionPerformed

    private void jCheckBoxDATAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxDATAActionPerformed
        dateChooserCombo1.setVisible(!jCheckBoxDATA.isSelected());
        jLabelAge.setVisible(!jCheckBoxDATA.isSelected());
        jLabel7.setVisible(!jCheckBoxDATA.isSelected());
}//GEN-LAST:event_jCheckBoxDATAActionPerformed

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                UpdateEmployee dialog = new UpdateEmployee(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
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
    private datechooser.beans.DateChooserCombo dateChooserCombo2;
    private javax.swing.JButton jButtonBrowse;
    private javax.swing.JButton jButtonCANCEL;
    private javax.swing.JButton jButtonSave;
    private javax.swing.JCheckBox jCheckBoxDATA;
    private javax.swing.JComboBox jComboBoxGender;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelAge;
    private javax.swing.JLabel jLabelEmp_ID;
    private javax.swing.JLabel jLabelIMG;
    private javax.swing.JTextField jTextFieldAddress;
    private javax.swing.JTextField jTextFieldComments;
    private javax.swing.JTextField jTextFieldContactNo;
    private javax.swing.JTextField jTextFieldName;
    // End of variables declaration//GEN-END:variables

    private void setEmployee(){
        jLabelEmp_ID.setText(employee.getEmp_id()+"");
        jTextFieldName.setText(employee.getName());
        jTextFieldAddress.setText(employee.getAddress());
        jComboBoxGender.setSelectedItem(employee.getGender());
        jTextFieldComments.setText(employee.getComments());
        if(employee.getbDate().getYear()!=0){
            Calendar c = Calendar.getInstance();
            c.setTime(employee.getbDate());
            dateChooserCombo1.setSelectedDate(c);
            dateChooserCombo1.setFormat(2);
        }else{
            jCheckBoxDATA.setSelected(true);
            dateChooserCombo1.setVisible(false);
            jLabelAge.setVisible(false);
            jLabel7.setVisible(false);            
        }
        jTextFieldContactNo.setText(employee.getContactNo());
        BufferedImage Emp_Img = DBQuery.getProfileImage(employee.getEmp_id());
        if(Emp_Img != null){
        jLabelIMG.setPreferredSize(new Dimension(Emp_Img.getWidth(),Emp_Img.getHeight()));
        jLabelIMG.setSize(new Dimension(Emp_Img.getWidth(),Emp_Img.getHeight()));
        jLabelIMG.setIcon(new ImageIcon(Emp_Img));
        img = new UploadImage().getNewImagePackage();
        img.setThumbnail(Emp_Img);
        }else {
            jLabelIMG.setIcon(new javax.swing.ImageIcon(getClass().getResource("/farmmanagementsystem/images/POSITION.png")));
        }
    }


    private boolean isValidFields(){
        if(jTextFieldAddress.getText().isEmpty() || jTextFieldName.getText().isEmpty())
            return false;
        return true;
    }
    private boolean confirm(String confirmMessage){
        int ans = JOptionPane.showConfirmDialog(this, confirmMessage, "CONFIRMATION", JOptionPane.YES_NO_OPTION);
        return (ans == JOptionPane.YES_OPTION);
    }

}
