import java.awt.Color;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class frmModifyStock extends javax.swing.JFrame {

    Connection con;
    Statement stm;
    ResultSet rst,rst2;
    String Value="";
    
    public frmModifyStock() throws SQLException,java.lang.IllegalArgumentException {
        
        initComponents();
        
        txtP_N.requestFocus();
        getContentPane().setBackground(newColor.getColor());
        jPanel1.setBackground(newColor.getColor());
        pnlCustomer.setBackground(newColor.getColor());
        
        con = MyConnectivity.getSQLConnection();
        stm=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
        System.out.println("Statement for insert Created");
        Querry();  
        CloseMinimise.addFrameObject(this);
    }

    private void Querry() throws SQLException{
        DefaultTableModel tblmodel = (DefaultTableModel)tblStock.getModel();
        int i=stm.executeUpdate("alter table stock drop column Product_NO;");
        int j=stm.executeUpdate("alter table stock add column Product_NO int(6) not null unique auto_increment first;");
        rst=stm.executeQuery("Select * from stock;");
        tblmodel.setRowCount(0);
        while(rst.next()) {
            Object[] row = new Object[]{rst.getInt(1),rst.getString(2),rst.getString(3),rst.getInt(4),rst.getInt(5),rst.getString(6),rst.getDate(7),rst.getDate(8)};
            tblmodel.addRow(row);
            tblStock.setModel(tblmodel);
        }  
    }
    
    void addTextField() throws SQLException{
        rst2=stm.executeQuery("select * from stock where Product_NO="+Value+";");
        rst2.next();
        dtmfg.setDate(rst2.getDate(7));
        dtexp.setDate(rst2.getDate(8));
        txtP_N.setText(rst2.getString(2));
        txtCAT.setText(rst2.getString(3));
        txtComp.setText(rst2.getString(6));
        txtqty.setText(""+rst2.getInt(4));
        txtPr.setText(""+rst2.getInt(5));
    }
    
    void clear() {
        txtP_N.setText("");
        txtPr.setText("");
        txtComp.setText("");
        txtCAT.setText("");
        txtqty.setText("");
        dtmfg.setDate(null);
        dtexp.setDate(null);
        Value="";
    }
    
    void addInDatabase() throws SQLException{
        Date date = new Date();
        SimpleDateFormat dateform = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dt = dateform.format(date);
        int i = stm.executeUpdate("insert into databaselog (LASTMODIFIEDBY,date_time) values('"+frmLogin.user+"','"+dt+"');");
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnMinCustomer = new javax.swing.JButton();
        btnCrossCustomer = new javax.swing.JButton();
        pnlCustomer = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblStock = new javax.swing.JTable();
        txtPr = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtComp = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtCAT = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtP_N = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        btnAdd = new javax.swing.JButton();
        btnModify = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();
        dtmfg = new com.toedter.calendar.JDateChooser();
        dtexp = new com.toedter.calendar.JDateChooser();
        jLabel9 = new javax.swing.JLabel();
        txtqty = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        btnMinCustomer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/minFinalAllall.png"))); // NOI18N
        btnMinCustomer.setPreferredSize(new java.awt.Dimension(30, 19));
        btnMinCustomer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMinCustomerActionPerformed(evt);
            }
        });

        btnCrossCustomer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/crossFinallALl.png"))); // NOI18N
        btnCrossCustomer.setPreferredSize(new java.awt.Dimension(30, 19));
        btnCrossCustomer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrossCustomerActionPerformed(evt);
            }
        });

        pnlCustomer.setBackground(new java.awt.Color(93, 140, 160));
        pnlCustomer.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "STOCK", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Times New Roman", 1, 18))); // NOI18N

        tblStock.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        tblStock.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Product_No", "Product_NAME", "CATEGORY", "QUANTITY", "PRICE", "COMPANY", "DATE MFG", "DATE EXP"
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
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tblStockKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tblStockKeyTyped(evt);
            }
        });
        jScrollPane1.setViewportView(tblStock);

        javax.swing.GroupLayout pnlCustomerLayout = new javax.swing.GroupLayout(pnlCustomer);
        pnlCustomer.setLayout(pnlCustomerLayout);
        pnlCustomerLayout.setHorizontalGroup(
            pnlCustomerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
        );
        pnlCustomerLayout.setVerticalGroup(
            pnlCustomerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 366, Short.MAX_VALUE)
        );

        txtPr.setBackground(new java.awt.Color(240, 240, 240));
        txtPr.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPrKeyTyped(evt);
            }
        });

        jLabel2.setText("Price");

        txtComp.setBackground(new java.awt.Color(240, 240, 240));
        txtComp.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCompKeyTyped(evt);
            }
        });

        jLabel5.setText("Company");

        txtCAT.setBackground(new java.awt.Color(240, 240, 240));
        txtCAT.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCATKeyTyped(evt);
            }
        });

        jLabel6.setText("CATEGORY");

        jLabel8.setText("DATE MFG");

        txtP_N.setBackground(new java.awt.Color(240, 240, 240));
        txtP_N.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtP_NKeyTyped(evt);
            }
        });

        jLabel10.setText("Product_Name");

        jPanel1.setBackground(new java.awt.Color(93, 140, 160));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Options", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 12))); // NOI18N

        btnAdd.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnAdd.setText("Add");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnModify.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnModify.setText("Modify");
        btnModify.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModifyActionPerformed(evt);
            }
        });

        btnDelete.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnClear.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnClear.setText("Clear");
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnAdd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(33, 33, 33)
                .addComponent(btnModify, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(btnDelete, javax.swing.GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE)
                .addGap(30, 30, 30)
                .addComponent(btnClear, javax.swing.GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE)
                .addGap(25, 25, 25))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAdd)
                    .addComponent(btnModify)
                    .addComponent(btnDelete)
                    .addComponent(btnClear))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        dtmfg.setDateFormatString("yyyy-MM-dd");

        dtexp.setDateFormatString("yyyy-MM-dd");

        jLabel9.setText("DATE EXP");

        txtqty.setBackground(new java.awt.Color(240, 240, 240));
        txtqty.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtqtyKeyTyped(evt);
            }
        });

        jLabel3.setText("QUANTITY");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlCustomer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtP_N, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtCAT, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtPr, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnMinCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCrossCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtComp, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(dtmfg, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dtexp, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(64, 64, 64)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtqty, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 100, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE, false)
                            .addComponent(txtP_N)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtCAT)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtPr, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(btnMinCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCrossCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtComp, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(dtmfg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(dtexp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE, false)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtqty, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addComponent(pnlCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnCrossCustomerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrossCustomerActionPerformed
        try {
            dispose();
            frmStock frm=new frmStock();
            frm.setVisible(true);
        } 
        catch (SQLException ex) {
            Logger.getLogger(frmModifySupplier.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_btnCrossCustomerActionPerformed

    private void btnMinCustomerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMinCustomerActionPerformed
        CloseMinimise.minimise(this);
    }//GEN-LAST:event_btnMinCustomerActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        try {
            if(txtCAT.getText().trim().isEmpty() || txtComp.getText().trim().isEmpty() || txtP_N.getText().trim().isEmpty() || txtPr.getText().trim().isEmpty() || txtqty.getText().trim().isEmpty() || dtmfg.getDate()==null || dtexp.getDate()==null) {
                JOptionPane.showMessageDialog(null, "Don Not Leave Any Field Empty");
            }
            else {
                String payleft=""+0;
                int i=stm.executeUpdate("insert into stock (p_name,CATEGORY,QTY,PRICE,COMPANY,DMFG,DEXP) values('"+txtP_N.getText()+"','"+txtCAT.getText()+"',"+txtqty.getText()+","+txtPr.getText()+",'"+txtComp.getText()+"','"+new SimpleDateFormat("YYYY-MM-dd").format(dtmfg.getDate())+"','"+new SimpleDateFormat("YYYY-MM-dd").format(dtexp.getDate())+"');");
                if(i>=1) {
                    JOptionPane.showMessageDialog(null,"Record Added");
                    Querry();
                    clear();
                    addInDatabase();
                }
            } 
        }
        catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,ex.getMessage());
        }
    }//GEN-LAST:event_btnAddActionPerformed

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

    private void tblStockKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblStockKeyPressed
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
    }//GEN-LAST:event_tblStockKeyPressed

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        clear();
    }//GEN-LAST:event_btnClearActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        if(Value.trim().isEmpty() || Value==null) {
            JOptionPane.showMessageDialog(null, "Select Row First");
        }
        else {
            try {
                int l=JOptionPane.showConfirmDialog(null,"You Really Want To Delete","Confirm",JOptionPane.YES_NO_OPTION);
                if(l==JOptionPane.YES_OPTION) {
                    int i =stm.executeUpdate("delete from stock where Product_NO="+Value+";");
                    if(i>=1) 
                        JOptionPane.showMessageDialog(null,"Deleted Successfully");
                    Querry();
                    clear();
                    addInDatabase();
                }
            }
            catch(SQLException e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnModifyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModifyActionPerformed
        if(Value.trim().isEmpty() || Value==null) {
            JOptionPane.showMessageDialog(null, "Select Row First");
        }
        else {
            try {
                int i=stm.executeUpdate("update stock set P_NAME = '"+txtP_N.getText()+"',CATEGORY = '"+txtCAT.getText()+"',QTY = "+txtqty.getText()+",PRICE = "+txtPr.getText()+",COMPANY = '"+txtComp.getText()+"',DMFG = '"+new SimpleDateFormat("YYYY-MM-dd").format(dtmfg.getDate())+"',DEXP = '"+new SimpleDateFormat("YYYY-MM-dd").format(dtexp.getDate())+"' where Product_NO="+Value+";");
                if(i>=1) {
                    JOptionPane.showMessageDialog(null,"Record Updated");
                    Querry();
                    clear();
                    addInDatabase();
                }
                
            }
            catch(SQLException e) {
                JOptionPane.showMessageDialog(null,e.getMessage());
            }
            
        }
    }//GEN-LAST:event_btnModifyActionPerformed

    private void txtPrKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPrKeyTyped
        if(txtPr.getText().length()>=6)
            evt.consume();
        if(!(evt.getKeyChar()>= KeyEvent.VK_0 && evt.getKeyChar()<=KeyEvent.VK_9)){
            evt.consume();
        }
    }//GEN-LAST:event_txtPrKeyTyped

    private void txtCATKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCATKeyTyped
        if(txtCAT.getText().length()>=8)
            evt.consume();
        if((evt.getKeyChar()>= KeyEvent.VK_0 && evt.getKeyChar()<=KeyEvent.VK_9)){
            evt.consume();
        }
    }//GEN-LAST:event_txtCATKeyTyped

    private void txtP_NKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtP_NKeyTyped
        if(txtP_N.getText().length()>=8)
            evt.consume();
        if((evt.getKeyChar()>= KeyEvent.VK_0 && evt.getKeyChar()<=KeyEvent.VK_9)){
            evt.consume();
        }
    }//GEN-LAST:event_txtP_NKeyTyped

    private void txtCompKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCompKeyTyped
        if(txtComp.getText().length()>=8)
            evt.consume();
        if((evt.getKeyChar()>= KeyEvent.VK_0 && evt.getKeyChar()<=KeyEvent.VK_9)){
            evt.consume();
        }
    }//GEN-LAST:event_txtCompKeyTyped

    private void tblStockKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblStockKeyTyped
        
    }//GEN-LAST:event_tblStockKeyTyped

    private void txtqtyKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtqtyKeyTyped
        if(txtqty.getText().length()>=8)
            evt.consume();
        if(!(evt.getKeyChar()>= KeyEvent.VK_0 && evt.getKeyChar()<=KeyEvent.VK_9)){
            evt.consume();
        }
    }//GEN-LAST:event_txtqtyKeyTyped

    
    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new frmModifyStock().setVisible(true);
                } 
                catch (SQLException ex) {
                    Logger.getLogger(frmModifyStock.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnCrossCustomer;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnMinCustomer;
    private javax.swing.JButton btnModify;
    private com.toedter.calendar.JDateChooser dtexp;
    private com.toedter.calendar.JDateChooser dtmfg;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel pnlCustomer;
    private javax.swing.JTable tblStock;
    private javax.swing.JTextField txtCAT;
    private javax.swing.JTextField txtComp;
    private javax.swing.JTextField txtP_N;
    private javax.swing.JTextField txtPr;
    private javax.swing.JTextField txtqty;
    // End of variables declaration//GEN-END:variables
}
