
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class frmCustomerSearch extends javax.swing.JFrame {

    Connection con;
    Statement stm;
    ResultSet rst,rst2;
    private String Value;
    
    public frmCustomerSearch() throws SQLException{
        initComponents();
        getContentPane().setBackground(newColor.getColor());
        pnlSupplier.setBackground(newColor.getColor());
        
        con = MyConnectivity.getSQLConnection();
        stm=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
        System.out.println("Statement for insert Created");
        Querry();
        CloseMinimise.addFrameObject(this);
    }

     private void Querry() throws SQLException{
        DefaultTableModel tblmodel = (DefaultTableModel)tblCustomer.getModel();
        rst=stm.executeQuery("Select * from customer;");
        tblmodel.setRowCount(0);
        while(rst.next()) {
            Object[] row = new Object[]{rst.getLong(1),rst.getString(2)+" "+rst.getString(3),rst.getLong(4),rst.getString(5),rst.getString(6),rst.getString(7),rst.getLong(8),rst.getLong(9),rst.getString(10),rst.getLong(11),rst.getString(12)};
            tblmodel.addRow(row);
            tblCustomer.setModel(tblmodel);
        }
    }
     
    void clear() throws SQLException{
       cmbSelect.setSelectedIndex(0);
       txtSearch.setText("");
       Querry();
    }
     
    private void addTextField() throws SQLException{
        rst2=stm.executeQuery("select * from customer where s_no="+Value+";");
        rst2.next();
        lblNAME.setText("Name : "+rst2.getString(2)+" "+rst2.getString(3));
        lblEmailID.setText("Email_ID : "+rst2.getString(5));
        lblPhoneNo.setText("Phone No : "+rst2.getLong(4));
        lblPayLeft.setText("Pay Left : "+rst2.getLong(9));
        lblGST.setText("GST : "+rst2.getString(12));
        lblAdhaar.setText("Adhaar : "+rst2.getLong(11));
        lblArea.setText("Area : "+rst2.getString(6));
        lblCity.setText("City  : "+rst2.getString(7));
    }
     
     
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnMin = new javax.swing.JButton();
        btnCross = new javax.swing.JButton();
        pnlSupplier = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblCustomer = new javax.swing.JTable();
        lblNAME = new javax.swing.JLabel();
        lblEmailID = new javax.swing.JLabel();
        lblPayLeft = new javax.swing.JLabel();
        lblPhoneNo = new javax.swing.JLabel();
        lblGST = new javax.swing.JLabel();
        btnSearch = new javax.swing.JButton();
        cmbSelect = new javax.swing.JComboBox<>();
        txtSearch = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        lblArea = new javax.swing.JLabel();
        lblAdhaar = new javax.swing.JLabel();
        lblCity = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        btnMin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/minFinalAllall.png"))); // NOI18N
        btnMin.setPreferredSize(new java.awt.Dimension(30, 19));
        btnMin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMinActionPerformed(evt);
            }
        });

        btnCross.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/crossFinallALl.png"))); // NOI18N
        btnCross.setPreferredSize(new java.awt.Dimension(30, 19));
        btnCross.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrossActionPerformed(evt);
            }
        });

        pnlSupplier.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "CUSTOMERS", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Times New Roman", 1, 18))); // NOI18N

        tblCustomer.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        tblCustomer.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "S_NO", "Customer", "Phone No", "Email ID", "Area", "City", "Pincode", "Pay Left", "PAN", "Adhaar No", "GST No"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblCustomer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblCustomerMouseClicked(evt);
            }
        });
        tblCustomer.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tblCustomerKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(tblCustomer);

        javax.swing.GroupLayout pnlSupplierLayout = new javax.swing.GroupLayout(pnlSupplier);
        pnlSupplier.setLayout(pnlSupplierLayout);
        pnlSupplierLayout.setHorizontalGroup(
            pnlSupplierLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        pnlSupplierLayout.setVerticalGroup(
            pnlSupplierLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 297, Short.MAX_VALUE)
        );

        lblNAME.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N

        lblEmailID.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N

        lblPayLeft.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N

        lblPhoneNo.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N

        lblGST.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N

        btnSearch.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnSearch.setText("Search");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        cmbSelect.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--Choose Field--", "CLIENT_FIRSTNAME", "CLIENT_LASTName", "Phone_NO", "Email_ID", "AREA", "CITY", "PIN_CODE", "PAY_LEFT", "PAN", "ADHAAR_NO", "GST_NO" }));
        cmbSelect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbSelectActionPerformed(evt);
            }
        });

        jButton1.setText("...");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        lblArea.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N

        lblAdhaar.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N

        lblCity.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlSupplier, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnMin, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCross, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(cmbSelect, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 150, Short.MAX_VALUE)
                        .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 520, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(124, 124, 124))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblEmailID, javax.swing.GroupLayout.DEFAULT_SIZE, 256, Short.MAX_VALUE)
                            .addComponent(lblNAME, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblPhoneNo, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lblArea, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblPayLeft, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblGST, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblCity, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblAdhaar, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnMin, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCross, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbSelect, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                .addComponent(pnlSupplier, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblNAME, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblEmailID, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnSearch, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblPhoneNo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblArea, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblGST, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblPayLeft, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblAdhaar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblCity, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)))))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnCrossActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrossActionPerformed
        dispose();
        try {
            frmCustomer frmCus = new frmCustomer();
            frmCus.setVisible(true);
        } 
        catch (SQLException ex) {
            Logger.getLogger(frmHome.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }//GEN-LAST:event_btnCrossActionPerformed

    private void btnMinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMinActionPerformed
        CloseMinimise.minimise(this);
    }//GEN-LAST:event_btnMinActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        if(txtSearch.getText().trim().isEmpty() || cmbSelect.getSelectedItem().equals("--Choose Field--"))
            JOptionPane.showMessageDialog(null, "Please Select The Column And Fill The Field First");
        else {
            try {
                rst=stm.executeQuery("select * from customer where "+cmbSelect.getSelectedItem().toString()+" like '"+txtSearch.getText()+"%' ;");
                DefaultTableModel tblmodel = (DefaultTableModel)tblCustomer.getModel();
                tblmodel.setRowCount(0);
                
                if(!rst.next()) {
                   JOptionPane.showMessageDialog(null, "No Record Found For Your Search");
                    clear();
                }
                else {
                    rst.beforeFirst();
                    while(rst.next()) {
                        Object[] row = new Object[]{rst.getLong(1),rst.getString(2)+" "+rst.getString(3),rst.getLong(4),rst.getString(5),rst.getString(6),rst.getString(7),rst.getLong(8),rst.getLong(9),rst.getString(10),rst.getLong(11),rst.getString(12)};
                        tblmodel.addRow(row);
                        tblCustomer.setModel(tblmodel);
                    }
                }
            } 
            catch (SQLException ex) {
                Logger.getLogger(frmSupplierSearch.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnSearchActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            clear();
        } 
        catch (SQLException ex) {
            Logger.getLogger(frmSupplierSearch.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void cmbSelectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbSelectActionPerformed
        
    }//GEN-LAST:event_cmbSelectActionPerformed

    private void tblCustomerKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblCustomerKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_UP || evt.getKeyCode()==KeyEvent.VK_DOWN) {
            try {
              int i=tblCustomer.getSelectedRow();
              Value=tblCustomer.getValueAt(i,0).toString();
              addTextField();
            }
            catch (SQLException ex) {
                Logger.getLogger(frmModifySupplier.class.getName()).log(Level.SEVERE, null, ex);
            }  
        }
    }//GEN-LAST:event_tblCustomerKeyPressed

    private void tblCustomerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblCustomerMouseClicked
        try {
              int i=tblCustomer.getSelectedRow();
              Value=tblCustomer.getValueAt(i,0).toString();
              addTextField();
            }
            catch (SQLException ex) {
                Logger.getLogger(frmModifySupplier.class.getName()).log(Level.SEVERE, null, ex);
            } 
    }//GEN-LAST:event_tblCustomerMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(frmSupplier.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmSupplier.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmSupplier.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmSupplier.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new frmCustomerSearch().setVisible(true);
                } 
                catch (SQLException ex) {
                    Logger.getLogger(frmCustomer.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCross;
    private javax.swing.JButton btnMin;
    private javax.swing.JButton btnSearch;
    private javax.swing.JComboBox<String> cmbSelect;
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblAdhaar;
    private javax.swing.JLabel lblArea;
    private javax.swing.JLabel lblCity;
    private javax.swing.JLabel lblEmailID;
    private javax.swing.JLabel lblGST;
    private javax.swing.JLabel lblNAME;
    private javax.swing.JLabel lblPayLeft;
    private javax.swing.JLabel lblPhoneNo;
    private javax.swing.JPanel pnlSupplier;
    private javax.swing.JTable tblCustomer;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables

    
}
