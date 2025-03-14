/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


package farmmanagementsystem;

import farmmanagementsystem.util.Breaker;
import farmmanagementsystem.util.LookAndFeels;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JRootPane;
import javax.swing.SwingWorker;

/**
 *
 * @author Aldrin
 */
public class SplashScreen extends javax.swing.JDialog {


    /** Creates new form GUI_LOG_IN */
    public SplashScreen(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        setUndecorated(true);
        getRootPane().setWindowDecorationStyle(JRootPane.NONE);
        initComponents();
        new LookAndFeels(this,3);
        setLocationRelativeTo(null);

    }



    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLayeredPane1 = new javax.swing.JLayeredPane();
        new Breaker(new Date());
        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setOpaque(false);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel4.setText("Loading: Application Module...");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(94, 94, 94)
                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 406, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addContainerGap(202, Short.MAX_VALUE))
        );

        jLayeredPane1.add(jPanel1);
        jPanel1.setBounds(0, 0, 510, 230);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/farmmanagementsystem/images/screen.png"))); // NOI18N
        jLayeredPane1.add(jLabel1);
        jLabel1.setBounds(0, 0, 410, 230);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 398, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        setSize(new java.awt.Dimension(398, 229));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        new Task().execute();
    }//GEN-LAST:event_formWindowOpened

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                SplashScreen dialog = new SplashScreen(null, true);
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
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables

    class Task extends SwingWorker<Void, Void> {
        /*
         * Main task. Executed in background thread.
         */

        @Override
        public Void doInBackground() {
        pause(0.1);
        jLabel4.setText("Loading: Application Module");validate();
        pause(0.1);
        jLabel4.setText("Loading: Application Module.");validate();
        pause(0.1);
        jLabel4.setText("Loading: Application Module..");validate();
        pause(0.1);
        jLabel4.setText("Loading: Application Module...");validate();
        pause(0.1);
        jLabel4.setText("Loading: Application Database");validate();
        pause(0.1);
        jLabel4.setText("Loading: Application Database...");validate();
        pause(0.1);
        jLabel4.setText("Loading: Setting Connection");validate();
        pause(0.1);
        jLabel4.setText("Loading: Setting Connection.");validate();
        pause(0.1);
        jLabel4.setText("Loading: Setting Connection..");validate();
        pause(1);
        jLabel4.setText("Loading: Setting Connection...");validate();
        pause(1);
        jLabel4.setText("Loading: Display Finalization");validate();
        pause(1);
        dispose();
            return null;
        }
        public int id;
    }
    
    public void pause(double s){
        try {
            long t = (long) (s * 1000);
            Thread.sleep(t);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }
}
