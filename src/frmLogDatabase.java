import java.awt.Color;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class frmLogDatabase extends javax.swing.JFrame {
    Connection con;
    Statement stm;
    ResultSet rst,rst2;
    
    public frmLogDatabase() {
        initComponents();
        getContentPane().setBackground(newColor.getColor());
        try { 
            con = MyConnectivity.getSQLConnection();
            stm=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
            System.out.println("Statement for insert Created");
            rst=stm.executeQuery("Select distinct date(DATE_TIME) as date__time from databaselog;");
            while(rst.next()){
                cmbDate.addItem(String.valueOf(rst.getDate("DATE__TIME")));
            }
            rst.close();
            Querry();
        } catch (SQLException ex) {
            Logger.getLogger(frmLoguser.class.getName()).log(Level.SEVERE, null, ex);
        }
        CloseMinimise.addFrameObject(this);
    }
    
    private void Querry() {
        try {
            DefaultTableModel tblmodel = (DefaultTableModel)tbluser.getModel();
            int i=stm.executeUpdate("alter table databaselog drop column s_no;");
            int j=stm.executeUpdate("alter table databaselog add column S_No int(6) not null unique auto_increment first;");
            if(cmbDate.getSelectedItem().equals("Choose Date...")) {
                rst2=stm.executeQuery("select * from databaselog ;");
                tblmodel.setRowCount(0);
                while(rst2.next()) {
                    Object[] row = new Object[]{rst2.getInt(1),rst2.getString(2),new SimpleDateFormat("YYYY-MM-dd HH:mm:ss").format(rst2.getTimestamp(3))};
                    tblmodel.addRow(row);
                    tbluser.setModel(tblmodel);
                }
            }
            else {
                rst2=stm.executeQuery("select * from databaselog where Date(DATE_TIME) ='"+cmbDate.getSelectedItem()+"';");
                tblmodel.setRowCount(0);
                while(rst2.next()) {
                    Object[] row = new Object[]{rst2.getInt(1),rst2.getString(2),new SimpleDateFormat("YYYY-MM-dd HH:mm:ss").format(rst2.getTimestamp(3))};
                    tblmodel.addRow(row);
                    tbluser.setModel(tblmodel);
                }            
            }
            
        } 
        catch (SQLException ex) {
            Logger.getLogger(frmLoguser.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnDel = new javax.swing.JButton();
        cmbDate = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbluser = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        btnDel.setBackground(new java.awt.Color(0, 0, 0));
        btnDel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnDel.setForeground(new java.awt.Color(255, 255, 255));
        btnDel.setText("Delete From Log");
        btnDel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDelActionPerformed(evt);
            }
        });

        cmbDate.setBackground(new java.awt.Color(0, 0, 0));
        cmbDate.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        cmbDate.setForeground(new java.awt.Color(255, 255, 255));
        cmbDate.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Choose Date..." }));
        cmbDate.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbDateItemStateChanged(evt);
            }
        });
        cmbDate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbDateActionPerformed(evt);
            }
        });

        tbluser.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "S_NO", "LAST_MODIFIED_BY", "Date_Time"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tbluser);

        jButton1.setBackground(new java.awt.Color(51, 51, 51));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/crossFinallALl.png"))); // NOI18N
        jButton1.setPreferredSize(new java.awt.Dimension(30, 19));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(51, 51, 51));
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/minFinalAllall.png"))); // NOI18N
        jButton2.setPreferredSize(new java.awt.Dimension(30, 19));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("LOG");
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 565, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnDel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cmbDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(47, 47, 47))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(133, 133, 133)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(2, 2, 2)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(cmbDate)
                        .addGap(1, 1, 1))
                    .addComponent(btnDel, javax.swing.GroupLayout.Alignment.LEADING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 387, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void cmbDateItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbDateItemStateChanged

    }//GEN-LAST:event_cmbDateItemStateChanged

    private void cmbDateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbDateActionPerformed
        Querry();
    }//GEN-LAST:event_cmbDateActionPerformed

    private void btnDelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDelActionPerformed
        try {
            if(cmbDate.getSelectedItem().equals("Choose Date...")) {
                JOptionPane.showMessageDialog(this,"Please Select Date First","ERROR",JOptionPane.ERROR_MESSAGE);
            }
            else {
                int i = stm.executeUpdate("delete from databaselog where Date(Date_Time) ='"+cmbDate.getSelectedItem()+"';");
                if(i>=1) {
                    JOptionPane.showMessageDialog(this,"Deleted Successfully","ERROR",JOptionPane.ERROR_MESSAGE); 
                }
                else {
                    JOptionPane.showMessageDialog(this,"Delete not Successfull","ERROR",JOptionPane.ERROR_MESSAGE);
                }
                Querry();
            }
        }
        catch (SQLException ex) {
            Logger.getLogger(frmLoguser.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_btnDelActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        CloseMinimise.minimise(this);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        CloseMinimise.close(this);
        frmLog frm = new frmLog();
        frm.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Dark Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(frmLogDatabase.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmLogDatabase.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmLogDatabase.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmLogDatabase.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmLogDatabase().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDel;
    private javax.swing.JComboBox<String> cmbDate;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbluser;
    // End of variables declaration//GEN-END:variables
}
