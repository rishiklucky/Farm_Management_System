/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * ViewSalary.java
 *
 * Created on Nov 21, 2013, 8:31:32 PM
 */

package farmmanagementsystem.gui.view;


import farmmanagementsystem.db.DBQuery;
import farmmanagementsystem.gui.update.UpdateGrossProfit;
import farmmanagementsystem.model.GrossProfit;
import farmmanagementsystem.model.Salary;
import farmmanagementsystem.util.LookAndFeels;
import farmmanagementsystem.util.Print;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.util.Date;

/**
 *
 * @author Administrator
 */
public class ViewSalary extends javax.swing.JDialog {

    /** Creates new form ViewSalary */
    public ViewSalary(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        new LookAndFeels(this, 3);
        setLocationRelativeTo(null);
        loadAllSalary();
    }

    private ArrayList<Salary> list;
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jComboBox1 = new javax.swing.JComboBox();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("VIEW SHARE LOG");

        jTable1.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Employee ID", "Name", "Gross Profit ID", "Location", "Date of Activity", "Amount", "Remarks", "Claim ID"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setRowHeight(25);
        jTable1.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTable1.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jTable1);
        jTable1.getColumnModel().getColumn(0).setMinWidth(80);
        jTable1.getColumnModel().getColumn(0).setPreferredWidth(80);
        jTable1.getColumnModel().getColumn(0).setMaxWidth(80);
        jTable1.getColumnModel().getColumn(1).setPreferredWidth(200);
        jTable1.getColumnModel().getColumn(2).setMinWidth(80);
        jTable1.getColumnModel().getColumn(2).setPreferredWidth(80);
        jTable1.getColumnModel().getColumn(2).setMaxWidth(80);
        jTable1.getColumnModel().getColumn(3).setPreferredWidth(150);
        jTable1.getColumnModel().getColumn(4).setMinWidth(150);
        jTable1.getColumnModel().getColumn(4).setPreferredWidth(150);
        jTable1.getColumnModel().getColumn(4).setMaxWidth(150);
        jTable1.getColumnModel().getColumn(5).setMinWidth(80);
        jTable1.getColumnModel().getColumn(5).setPreferredWidth(80);
        jTable1.getColumnModel().getColumn(5).setMaxWidth(80);
        jTable1.getColumnModel().getColumn(6).setMinWidth(150);
        jTable1.getColumnModel().getColumn(6).setPreferredWidth(150);
        jTable1.getColumnModel().getColumn(6).setMaxWidth(150);
        jTable1.getColumnModel().getColumn(7).setMinWidth(80);
        jTable1.getColumnModel().getColumn(7).setPreferredWidth(80);
        jTable1.getColumnModel().getColumn(7).setMaxWidth(80);

        jButton1.setText("VIEW GROSS PROFIT");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setText("Search");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Employee ID", "Name", "Gross Profit ID", "Location", "Claim ID" }));

        jButton2.setText("SEARCH");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("PRINT LOG");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1316, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(32, 32, 32)
                        .addComponent(jButton3)
                        .addGap(61, 61, 61)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton2)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 599, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jLabel1)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2)
                    .addComponent(jButton3))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        search(jComboBox1.getSelectedIndex(), jTextField1.getText());
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if(jTable1.getSelectedRow()<0){
            JOptionPane.showMessageDialog(null, "NO SELECTED ITEM", "EMPTY SELECTION", JOptionPane.ERROR_MESSAGE);
            return;
        }
        int id = Integer.parseInt(jTable1.getValueAt(jTable1.getSelectedRow(), 2)+"");
        GrossProfit g = DBQuery.getGrossProfit(id);
        UpdateGrossProfit UG = new UpdateGrossProfit(null, true);
        UG.viewOnly = true;
        UG.setGrossProfit(g);
        UG.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        printShareLog();
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ViewSalary dialog = new ViewSalary(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables

    private void loadTable(){
        DefaultTableModel tbl = (DefaultTableModel) jTable1.getModel();        
        tbl.setRowCount(0);
        for(Salary s: list){
            String d = String.format("%1$tb %1$td, %1$tY\n",s.getGrossProfit().getActivity().getDate());
            String a = String.format( "%,.2f",s.getAmount());
            tbl.addRow(new Object[]{s.getEmpID(),s.getEmployee().getName(),s.getGp_id(),s.getGrossProfit().getLocation().getAddress(),
                d,a,s.getRemarks(),(s.getClaim_id()==0)?"":s.getClaim_id()});
        }

    }

    private void loadAllSalary(){
        list = DBQuery.getSalary();
        loadTable();
    }

    private void search(int cat,String val){

        list = DBQuery.getSalary();
        if(val.isEmpty()){
            loadTable();
            return;
        }
        ArrayList<Salary> tmp = new ArrayList<>();

        for(Salary s: list){
            switch(cat){
                case 0: if((s.getEmpID()+"").contains(val))
                    tmp.add(s);break;
                case 1: if((s.getEmployee().getName()).toUpperCase().contains(val.toUpperCase()))
                    tmp.add(s);break;
                case 2: if((s.getGp_id()+"").contains(val))
                    tmp.add(s);break;
                case 3: if((s.getGrossProfit().getLocation().getAddress()).toUpperCase().contains(val.toUpperCase()))
                    tmp.add(s);break;
                case 4: if((s.getClaim_id()+"").contains(val))
                    tmp.add(s);break;
            }
        }
        list = tmp;
        loadTable();
    }
 public void printShareLog(){
         Print pp = new Print();
         String header = "(center)(bold)CALVEZ FARM\n"
                      +"(center)(bold)Worker Information System \n\n"
                      +"(center)(bold)"+"SHARE LOG"+"\n\n"
                 +"(center)"+ "As of " +String.format( "%1$TB %1$Td, %1$TY\n", new Date() )+"\n"
           +"(bold)No. of Results:(tab)"+list.size()+"\n";
         header += "NOTE:__________________________________________________________________\n";

         pp.setHeaderText(header);
         pp.showPreview(jTable1,this);
    }
    
}
