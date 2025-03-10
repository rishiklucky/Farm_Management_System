/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * ViewExpenses.java
 *
 * Created on Dec 6, 2013, 6:31:01 AM
 */

package farmmanagementsystem.gui.view;


import farmmanagementsystem.db.DBQuery;
import farmmanagementsystem.gui.add.AddExpense;
import farmmanagementsystem.gui.update.UpdateExpense;
import farmmanagementsystem.model.Expenses;
import farmmanagementsystem.model.Location;
import farmmanagementsystem.model.User;
import farmmanagementsystem.util.LookAndFeels;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ADMIN
 */
public class ViewExpenses extends javax.swing.JDialog {

    /** Creates new form ViewExpenses */
    public ViewExpenses(farmmanagementsystem.gui.MainMenu parent, boolean modal) {
        super(parent, modal);
        initComponents();
        new LookAndFeels(this, 3);
        setLocationRelativeTo(null);
        loadLocationList();
        jListLoc.setSelectedIndex(0);
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

        jScrollPane1 = new javax.swing.JScrollPane();
        jListLoc = new javax.swing.JList();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabelLOCATION = new javax.swing.JLabel();
        jButtonNEW = new javax.swing.JButton();
        jButtonUPDATE = new javax.swing.JButton();
        jButtonREMOVE = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("EXPENSES");

        jListLoc.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jListLoc.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                jListLocValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(jListLoc);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Date Encoded", "Reference", "Amount", "Gross Profit ID"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Double.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(jTable1);

        jLabelLOCATION.setText("jLabel1");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 537, Short.MAX_VALUE)
                    .addComponent(jLabelLOCATION))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelLOCATION)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 286, Short.MAX_VALUE))
        );

        jButtonNEW.setText("NEW EXPENSES");
        jButtonNEW.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNEWActionPerformed(evt);
            }
        });

        jButtonUPDATE.setText("UPDATE EXPENSE");
        jButtonUPDATE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonUPDATEActionPerformed(evt);
            }
        });

        jButtonREMOVE.setText("REMOVE EXPENSE");
        jButtonREMOVE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonREMOVEActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButtonNEW)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonUPDATE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonREMOVE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonNEW)
                    .addComponent(jButtonUPDATE)
                    .addComponent(jButtonREMOVE))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jListLocValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_jListLocValueChanged
        jLabelLOCATION.setText(jListLoc.getSelectedValue().toString());
        int id = locList.get(jListLoc.getSelectedIndex()).getLoc_id();
        loadTable(id);
    }//GEN-LAST:event_jListLocValueChanged

    private void jButtonUPDATEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonUPDATEActionPerformed
        if(jTable1.getSelectedRow() <0){
            JOptionPane.showMessageDialog(null, "NO SELECTED ITEM", "EMPTY SELECTION", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int ndx = jTable1.getSelectedRow();
        
        if(expList.get(ndx).getGp_id() != 0){
            JOptionPane.showMessageDialog(null, "EXPENSES ALREADY POSTED", "RESTRICTION", JOptionPane.ERROR_MESSAGE);
            return;
        }
        UpdateExpense ue = new UpdateExpense(null, true);
        ue.user=user;
        ue.setExpenses(expList.get(ndx).getReference());
        ue.setVisible(true);

        if(ue.submit){
            loadTable(locList.get(jListLoc.getSelectedIndex()).getLoc_id());
            jTable1.setRowSelectionInterval(ndx, ndx);
        }
    }//GEN-LAST:event_jButtonUPDATEActionPerformed

    private void jButtonREMOVEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonREMOVEActionPerformed
        if(jTable1.getSelectedRow() <0){
            JOptionPane.showMessageDialog(null, "NO SELECTED ITEM", "EMPTY SELECTION", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int ndx = jTable1.getSelectedRow();

        if(expList.get(ndx).getGp_id() != 0){
            JOptionPane.showMessageDialog(null, "EXPENSES ALREADY POSTED", "RESTRICTION", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if(confirm("REMOVE SELECTED ITEM?")){            
            ArrayList<Expenses> tmp = DBQuery.getExpensesByRef(expList.get(ndx).getReference());
            for(Expenses e:tmp){
                DBQuery.deleteExpenses(e.getExp_id());
            }
            expList.remove(ndx);
            DefaultTableModel tbl = (DefaultTableModel) jTable1.getModel();
            tbl.removeRow(ndx);
            jTable1.updateUI();
            JOptionPane.showMessageDialog(null, "ITEM HAS BEEN REMOVED", "UPDATE", JOptionPane.INFORMATION_MESSAGE);
            DBQuery.insertLog(user.getUser_id(), "REMOVE EXPENSE [Ref No: "+expList.get(ndx).getReference()+"]");
        }
    }//GEN-LAST:event_jButtonREMOVEActionPerformed

    private void jButtonNEWActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNEWActionPerformed
        AddExpense ae = new AddExpense(null, true);
        ae.user = user;
        ae.setVisible(true);
        if(ae.submit){
            int ndx = jTable1.getRowCount()-1;
            loadTable(locList.get(jListLoc.getSelectedIndex()).getLoc_id());
            jTable1.setRowSelectionInterval(ndx, ndx);
        }
    }//GEN-LAST:event_jButtonNEWActionPerformed

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ViewExpenses dialog = new ViewExpenses(new farmmanagementsystem.gui.MainMenu(), true);
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
    private javax.swing.JButton jButtonNEW;
    private javax.swing.JButton jButtonREMOVE;
    private javax.swing.JButton jButtonUPDATE;
    private javax.swing.JLabel jLabelLOCATION;
    private javax.swing.JList jListLoc;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables

    private ArrayList<Expenses> expList;
    private ArrayList<Location> locList;
    private void loadLocationList(){
        DefaultListModel<String> items = new DefaultListModel();
        locList = DBQuery.getLocation();

        for(Location l:locList){
            items.addElement("["+l.getLoc_id()+"] "+l.getAddress());
        }
        jListLoc.setModel(items);
    }

    private void loadTable(int loc_id){
        expList = new ArrayList<>();
        ArrayList<String>groupByRef = DBQuery.getExpensesRef(loc_id);
        for(String s:groupByRef){
            ArrayList<Expenses> tmp =DBQuery.getExpensesByRef(s);
            double val = 0;
            for(Expenses e:tmp){
                val += e.getAmount();
            }
            Expenses ex = new Expenses();
            ex.setAmount(val);
            ex.setDate(tmp.get(0).getDate());
            ex.setGp_id(tmp.get(0).getGp_id());
            ex.setReference(s);
            expList.add(ex);
        }        
        DefaultTableModel tbl = (DefaultTableModel) jTable1.getModel();
        tbl.setRowCount(0);
        for(Expenses e:expList){
            tbl.addRow(new Object[]{String.format("%1$tb %1$te, %1$tY", e.getDate()),e.getReference(),e.getAmount(),(e.getGp_id()==0)?"":e.getGp_id()});
        }
    }

    private boolean confirm(String confirmMessage){
        int ans = JOptionPane.showConfirmDialog(this, confirmMessage, "CONFIRMATION", JOptionPane.YES_NO_OPTION);
        return (ans == JOptionPane.YES_OPTION);
    }
}
