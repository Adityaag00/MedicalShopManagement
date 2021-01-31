import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;


public class frmStock extends javax.swing.JFrame {

    Connection con;
    Statement stm;
    ResultSet rst,rst2;
    private String Value;
    
    public frmStock() throws SQLException{
        initComponents();
        CloseMinimise.addFrameObject(this);
        getContentPane().setBackground(newColor.getColor());
        pnlSupplier.setBackground(newColor.getColor());
        Timer tim = new Timer(0,new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                SimpleDateFormat dateform = new SimpleDateFormat("yyyy-MM-dd  EEEE  HH:mm:ss");
                Date dat = new Date();
                String dt = dateform.format(dat);
                lblDate.setText(dt);
            }
        });
        tim.start();
        
        con = MyConnectivity.getSQLConnection();
        stm=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
        System.out.println("Statement for insert Created");
        Querry();  
    }

     private void Querry() throws SQLException{
        DefaultTableModel tblmodel = (DefaultTableModel)tblStock.getModel();
        rst=stm.executeQuery("Select * from stock;");
        tblmodel.setRowCount(0);
        while(rst.next()) {
            Object[] row = new Object[]{rst.getInt(1),rst.getString(2),rst.getString(3),rst.getInt(4),rst.getInt(5),rst.getString(6),rst.getDate(7),rst.getDate(8)};
            tblmodel.addRow(row);
            tblStock.setModel(tblmodel);
        }
    }
     
    private void addTextField() throws SQLException{
        rst2=stm.executeQuery("select * from stock where Product_NO="+Value+";");
        rst2.next();
        lblsno.setText("Product_No "+rst2.getInt(1));
        lbldmfg.setText("Date MFG : "+rst2.getDate(7));
        lbldexp.setText("Date EXP: "+rst2.getDate(8));
        lblP_Name.setText("Product Name : "+rst2.getString(2));
        lblCATEGORY.setText("CATEGORY "+rst2.getString(3));
        lblCompany.setText("Company : "+rst2.getString(6));
        lblqty.setText("Quantity : "+rst2.getInt(4));
        lblPrice.setText("Price  : "+rst2.getInt(5));
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblDate = new javax.swing.JLabel();
        btnMin = new javax.swing.JButton();
        btnCross = new javax.swing.JButton();
        pnlSupplier = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblStock = new javax.swing.JTable();
        btnModify = new javax.swing.JButton();
        lblP_Name = new javax.swing.JLabel();
        lblCompany = new javax.swing.JLabel();
        lblPrice = new javax.swing.JLabel();
        lbldexp = new javax.swing.JLabel();
        lblqty = new javax.swing.JLabel();
        lbldmfg = new javax.swing.JLabel();
        lblCATEGORY = new javax.swing.JLabel();
        lblsno = new javax.swing.JLabel();
        btnModify1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        lblDate.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N

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

        pnlSupplier.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "STOCK", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Times New Roman", 1, 18))); // NOI18N

        tblStock.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        tblStock.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "S_NO", "Product_NAME", "CATEGORY", "QUANTITY", "PRICE", "COMPANY", "DATE MFG", "DATE EXP"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblStock.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblStockMouseClicked(evt);
            }
        });
        tblStock.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tblStockKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tblStock);

        javax.swing.GroupLayout pnlSupplierLayout = new javax.swing.GroupLayout(pnlSupplier);
        pnlSupplier.setLayout(pnlSupplierLayout);
        pnlSupplierLayout.setHorizontalGroup(
            pnlSupplierLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        pnlSupplierLayout.setVerticalGroup(
            pnlSupplierLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 312, Short.MAX_VALUE)
        );

        btnModify.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnModify.setText("MODIFY STOCK");
        btnModify.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModifyActionPerformed(evt);
            }
        });

        lblP_Name.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N

        lblCompany.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N

        lblPrice.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N

        lbldexp.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N

        lblqty.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N

        lbldmfg.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N

        lblCATEGORY.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N

        lblsno.setFont(new java.awt.Font("Times New Roman", 1, 13)); // NOI18N

        btnModify1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnModify1.setText("Search");
        btnModify1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModify1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lbldmfg, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, 12, Short.MAX_VALUE)
                        .addComponent(lblP_Name, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblCATEGORY, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                        .addComponent(lblCompany, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(lblDate, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnMin, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCross, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(pnlSupplier, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(lblsno, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbldexp, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(63, 63, 63)
                        .addComponent(lblqty, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnModify1, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnModify, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblDate, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnMin, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnCross, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlSupplier, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(lblsno, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lbldexp, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(btnModify)
                                    .addComponent(btnModify1))
                                .addGap(2, 2, 2)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, 15, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbldmfg, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblCATEGORY, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblP_Name, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblCompany, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblPrice, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblqty, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnCrossActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrossActionPerformed
        dispose();
    }//GEN-LAST:event_btnCrossActionPerformed

    private void btnMinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMinActionPerformed
        CloseMinimise.minimise(this);
    }//GEN-LAST:event_btnMinActionPerformed

    private void btnModifyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModifyActionPerformed
        try {
            frmModifyStock frm = new frmModifyStock();
            frm.setVisible(true);
            this.dispose();
        } 
        catch (SQLException ex) {
            Logger.getLogger(frmSupplier.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnModifyActionPerformed

    private void tblStockKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblStockKeyReleased
        if(evt.getKeyCode()==KeyEvent.VK_UP || evt.getKeyCode()==KeyEvent.VK_DOWN) {
            try {
              int i=tblStock.getSelectedRow();
              Value=tblStock.getValueAt(i,0).toString();
              addTextField();
            }
            catch (SQLException ex) {
                Logger.getLogger(frmModifySupplier.class.getName()).log(Level.SEVERE, null, ex);
            }  
        }
    }//GEN-LAST:event_tblStockKeyReleased

    private void tblStockMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblStockMouseClicked
        try {
              int i=tblStock.getSelectedRow();
              Value=tblStock.getValueAt(i,0).toString();
              addTextField();
            }
            catch (SQLException ex) {
                Logger.getLogger(frmModifySupplier.class.getName()).log(Level.SEVERE, null, ex);
            }
    }//GEN-LAST:event_tblStockMouseClicked

    private void btnModify1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModify1ActionPerformed
        try {
            frmSearchStock frm = new frmSearchStock();
            frm.setVisible(true);
        } 
        catch (SQLException ex) {
            Logger.getLogger(frmStock.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnModify1ActionPerformed

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
                if ("Dark Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(frmStock.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmStock.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmStock.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmStock.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new frmStock().setVisible(true);
                } 
                catch (SQLException ex) {
                    Logger.getLogger(frmSupplier.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCross;
    private javax.swing.JButton btnMin;
    private javax.swing.JButton btnModify;
    private javax.swing.JButton btnModify1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblCATEGORY;
    private javax.swing.JLabel lblCompany;
    private javax.swing.JLabel lblDate;
    private javax.swing.JLabel lblP_Name;
    private javax.swing.JLabel lblPrice;
    private javax.swing.JLabel lbldexp;
    private javax.swing.JLabel lbldmfg;
    private javax.swing.JLabel lblqty;
    private javax.swing.JLabel lblsno;
    private javax.swing.JPanel pnlSupplier;
    private javax.swing.JTable tblStock;
    // End of variables declaration//GEN-END:variables
}
