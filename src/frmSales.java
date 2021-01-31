import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;

public class frmSales extends javax.swing.JFrame {

    Connection con;
    Statement stm;
    ResultSet rstc, rstc2, rstm, rstm2, rstqty, rstbill, rstprca,rstPayLeft;
    int billno,tqty;
    double amount,price;
    String category;
    double totalamt = 0;
    int pay;
    boolean check = false,create=false;
    
    public frmSales() throws SQLException {
        initComponents();
        CloseMinimise.addFrameObject(this);
        getContentPane().setBackground(newColor.getColor());
        cmbCustomer.setEditable(true);
        cmbProduct.setEditable(true);
        Date date = new Date();
        SimpleDateFormat dateform = new SimpleDateFormat("yyyy-MM-dd  EEEE  HH:mm:ss");
        
        Timer tim = new Timer(0, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Date dat = new Date();
                String dt = dateform.format(dat);
                lblDate.setText(dt);
            }
        });
        tim.start();
        
        con = MyConnectivity.getSQLConnection();
        stm = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
        System.out.println("Statement for insert Created");

        rstbill=stm.executeQuery("select bill_no from sale");
        
        if(rstbill.last())
            billno=rstbill.getInt(1)+1;
        else
            billno=1;
        
        rstc2 = stm.executeQuery("select CLIENT_FIRSTNAME,CLIENT_LASTNAME from CUSTOMER;");
        DefaultComboBoxModel<String> model = (DefaultComboBoxModel<String>) cmbCustomer.getModel();
        model.removeAllElements();
        
        while (rstc2.next()) {
            model.addElement(rstc2.getString(1) + " " + rstc2.getString(2));
            cmbCustomer.setModel(model);
        }
        
        rstm2 = stm.executeQuery("select P_NAME from stock;");
        DefaultComboBoxModel<String> modelm = (DefaultComboBoxModel<String>) cmbProduct.getModel();
        modelm.removeAllElements();
        
        while (rstm2.next()) {
            modelm.addElement(rstm2.getString(1));
            cmbProduct.setModel(modelm);
        }
        
        final JTextField textfieldm = (JTextField) cmbProduct.getEditor().getEditorComponent();
        textfieldm.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent ke) {
                SwingUtilities.invokeLater(new Runnable() {
                    public void run() {
                        if (!textfieldm.getText().isEmpty()) {
                            cmbMedicineWhere(textfieldm.getText());
                        } else {
                            cmbMedicine(textfieldm.getText());
                        }
                    }
                }); 
            }
        });
        
        final JTextField textfieldc = (JTextField) cmbCustomer.getEditor().getEditorComponent();
        textfieldc.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent ke) {
                SwingUtilities.invokeLater(new Runnable() {
                    public void run() {
                        if (!textfieldc.getText().isEmpty()) {
                            cmbCustomerWhere(textfieldc.getText());
                        } else {
                            cmbCustomer(textfieldc.getText());
                        }
                    }
                });    
            }
        });
    }
    
    void cmbCustomerWhere(String str) {
        if (!cmbCustomer.isPopupVisible()) {
            cmbCustomer.showPopup();
            System.out.println("Pop");
        }
        try {
            rstc = stm.executeQuery("select CLIENT_FIRSTNAME,CLIENT_LASTNAME from CUSTOMER where CLIENT_FIRSTNAME like '" + str + "%';");
            DefaultComboBoxModel<String> model = (DefaultComboBoxModel<String>) cmbCustomer.getModel();
            model.removeAllElements();
            
            while (rstc.next()) {
                model.addElement(rstc.getString(1) + " " + rstc.getString(2));
                cmbCustomer.setModel(model);
            }
            JTextField textfieldc = (JTextField) cmbCustomer.getEditor().getEditorComponent();
            textfieldc.setText(str);
        } 
        catch (SQLException ex) {
            Logger.getLogger(frmSales.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    void cmbCustomer(String str) {
        if (!cmbCustomer.isPopupVisible()) {
            cmbCustomer.showPopup();
        }
        try {
            rstc = stm.executeQuery("select CLIENT_FIRSTNAME,CLIENT_LASTNAME from CUSTOMER;");
            DefaultComboBoxModel<String> model = (DefaultComboBoxModel<String>) cmbCustomer.getModel();
            model.removeAllElements();
            
            while (rstc.next()) {
                model.addElement(rstc.getString(1) + " " + rstc.getString(2));
                cmbCustomer.setModel(model);
            }
            JTextField textfieldc = (JTextField) cmbCustomer.getEditor().getEditorComponent();
            textfieldc.setText(str);
        } 
        catch (SQLException ex) {
            Logger.getLogger(frmSales.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    void cmbMedicineWhere(String str) {
        if (!cmbProduct.isPopupVisible()) {
            cmbProduct.showPopup();
            System.out.println("Pop");
        }
        try {
            rstm = stm.executeQuery("select P_NAME from stock where P_NAME like '" + str + "%';");
            DefaultComboBoxModel<String> model = (DefaultComboBoxModel<String>) cmbProduct.getModel();
            model.removeAllElements();
            
            while (rstm.next()) {
                model.addElement(rstm.getString(1));
                cmbProduct.setModel(model);
            }
            JTextField textfield = (JTextField) cmbProduct.getEditor().getEditorComponent();
            textfield.setText(str);
        } 
        catch (SQLException ex) {
            Logger.getLogger(frmSales.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    void cmbMedicine(String str) {
        if (!cmbProduct.isPopupVisible()) {
            cmbProduct.showPopup();
        }
        try {
            rstm = stm.executeQuery("select P_NAME from stock;");
            DefaultComboBoxModel<String> model = (DefaultComboBoxModel<String>) cmbProduct.getModel();
            model.removeAllElements();
            
            while (rstm.next()) {
                model.addElement(rstm.getString(1));
                cmbProduct.setModel(model);
            }
            JTextField textfield = (JTextField) cmbProduct.getEditor().getEditorComponent();
            textfield.setText(str);
        } 
        catch (SQLException ex) {
            Logger.getLogger(frmSales.class.getName()).log(Level.SEVERE, null, ex);
        }
        
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

        cmbCustomer = new javax.swing.JComboBox<String>();
        lblDate = new javax.swing.JLabel();
        btnMin = new javax.swing.JButton();
        btnCross = new javax.swing.JButton();
        cmbProduct = new javax.swing.JComboBox<String>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblMain = new javax.swing.JTable();
        btnInvoive = new javax.swing.JButton();
        btnAddItem = new javax.swing.JButton();
        lblBillNo = new javax.swing.JLabel();
        lblAMT = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        txtQTY = new javax.swing.JTextField();
        btnCreate = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txtPay = new javax.swing.JTextField();
        btnCHeck = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        cmbCustomer.setMaximumRowCount(1000);
        cmbCustomer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbCustomerActionPerformed(evt);
            }
        });

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

        cmbProduct.setMaximumRowCount(1000);
        cmbProduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbProductActionPerformed(evt);
            }
        });

        tblMain.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "S_NO", "Prod_Name", "Price", "Qty", "Category", "Amount"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblMain);

        btnInvoive.setText("INVOICE");
        btnInvoive.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInvoiveActionPerformed(evt);
            }
        });

        btnAddItem.setText("ADD ITEM");
        btnAddItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddItemActionPerformed(evt);
            }
        });

        lblAMT.setText("TOTAL AMOUNT : ");

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/bagOriginal.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        txtQTY.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtQTYActionPerformed(evt);
            }
        });

        btnCreate.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        btnCreate.setText("Create");
        btnCreate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jLabel1.setText("Pay Amount");

        txtPay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPayActionPerformed(evt);
            }
        });

        btnCHeck.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        btnCHeck.setText("Check");
        btnCHeck.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCHeckActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 771, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addComponent(cmbCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cmbProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(51, 51, 51)
                            .addComponent(txtQTY, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(4, 4, 4)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblAMT, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtPay, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(84, 84, 84)
                        .addComponent(btnCHeck, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(109, 109, 109)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnAddItem, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(btnCreate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnInvoive, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(20, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(layout.createSequentialGroup()
                .addComponent(lblDate, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(141, 141, 141)
                .addComponent(lblBillNo, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnMin, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCross, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(lblBillNo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblDate, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE)
                    .addComponent(btnMin, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCross, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cmbCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmbProduct, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtQTY, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblAMT, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1)
                            .addComponent(txtPay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnAddItem)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnInvoive)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnCreate)
                            .addComponent(btnCHeck))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void cmbCustomerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbCustomerActionPerformed

    }//GEN-LAST:event_cmbCustomerActionPerformed

    private void btnMinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMinActionPerformed
        CloseMinimise.minimise(this);
    }//GEN-LAST:event_btnMinActionPerformed

    private void btnCrossActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrossActionPerformed
        dispose();
    }//GEN-LAST:event_btnCrossActionPerformed

    private void cmbProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbProductActionPerformed
        
    }//GEN-LAST:event_cmbProductActionPerformed

    private void btnInvoiveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInvoiveActionPerformed
        if(create==false){
            JOptionPane.showMessageDialog(null, "Please Click Create First");
        }
        else {
            try {
                String name=cmbCustomer.getSelectedItem().toString();
                String first=name.substring(0, name.indexOf(" "));
                String last=name.substring(name.indexOf(" ")+1,name.length());
                ResultSet rst = stm.executeQuery("select GST_NO from customer where CLIENT_FIRSTNAME = '"+first+"' AND CLIENT_LASTNAME = '"+last+"';");
                rst.next();
                String gst=rst.getString(1);
                
                HashMap<String , Object> param = new HashMap<String , Object>();

                param.put("Customername","Customer Name: "+cmbCustomer.getSelectedItem());
                param.put("BillNo",billno);
                param.put("total",""+totalamt+"Rs");
                param.put("Paid",""+pay+"Rs");
                param.put("gst",gst);

                InputStream stream=getClass().getResourceAsStream("/Libraries/Report/Bill.jrxml");
                JasperReport jr = JasperCompileManager.compileReport(stream);
                JasperPrint jp=JasperFillManager.fillReport(jr, param, con);
                JasperViewer.viewReport(jp, false);
            } 
            catch (JRException ex) {
                Logger.getLogger(frmSales.class.getName()).log(Level.SEVERE, null, ex);
            } 
            catch (SQLException ex) {
                Logger.getLogger(frmSales.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
    }//GEN-LAST:event_btnInvoiveActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            rstqty = stm.executeQuery("select qty from stock where p_name = '" + cmbProduct.getSelectedItem() + "';");
            rstqty.next();
            tqty=rstqty.getInt(1);
            txtQTY.setText(""+tqty);
        } 
        catch (SQLException e) {
            
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnAddItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddItemActionPerformed
        int qty=Integer.parseInt(txtQTY.getText());
        int sno;
        if(tblMain.getRowCount()!=0) 
            sno=(Integer.parseInt(tblMain.getValueAt((tblMain.getRowCount()-1),0).toString()))+1;
        else 
            sno=1;
        if(qty>0 && qty<=tqty) {
            try {
                rstprca=stm.executeQuery("select price,category from stock where P_NAME = '"+cmbProduct.getSelectedItem()+"';");
                rstprca.next();
                price=rstprca.getInt(1);
                category=rstprca.getString(2);
                amount=price*qty;
                DefaultTableModel tblmodel = (DefaultTableModel) tblMain.getModel();
                tblmodel.addRow(new Object[]{sno,cmbProduct.getSelectedItem(),price,qty,category,amount});
                tblMain.setModel(tblmodel);
                int val=stm.executeUpdate("insert into sale values("+billno+",'"+cmbCustomer.getSelectedItem()+"','"+cmbProduct.getSelectedItem()+"','"+category+"',"+price+","+qty+","+amount+",'"+new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date())+"')");
                if(val>=1) {
                    int newqty=tqty-qty;
                    System.out.println("Added");
                    int kal=stm.executeUpdate("update stock set qty="+newqty+" where p_name = '"+cmbProduct.getSelectedItem()+"';");
                }
            } 
            catch (SQLException ex) {
                Logger.getLogger(frmSales.class.getName()).log(Level.SEVERE, null, ex);
            }
            catch(java.lang.NumberFormatException e) {
            
            }
        }
        else {
            JOptionPane.showMessageDialog(null, "Please Enter Valid Quantity");
        }
    }//GEN-LAST:event_btnAddItemActionPerformed

    private void txtQTYActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtQTYActionPerformed

    }//GEN-LAST:event_txtQTYActionPerformed

    private void txtPayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPayActionPerformed

    }//GEN-LAST:event_txtPayActionPerformed

    private void btnCHeckActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCHeckActionPerformed
        check=true;
        for(int i=0;i<tblMain.getRowCount();i++){
            totalamt=totalamt+Double.parseDouble(tblMain.getValueAt(i, 5).toString());
        }
        lblAMT.setText("TOTAL AMOUNT : "+totalamt);
    }//GEN-LAST:event_btnCHeckActionPerformed

    private void btnCreateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateActionPerformed
        if(check==false) {
            JOptionPane.showMessageDialog(null, "Please Click Check First");
        }
        else {
            create=true;
            try {
                String name=cmbCustomer.getSelectedItem().toString();
                String first=name.substring(0, name.indexOf(" "));
                String last=name.substring(name.indexOf(" ")+1,name.length());
                rstPayLeft=stm.executeQuery("select pay_left from customer where CLIENT_FIRSTNAME = '"+first+"' AND CLIENT_LASTNAME = '"+last+"';");
                rstPayLeft.next();
                double payLeftFromCust=rstPayLeft.getDouble(1);
                btnAddItem.setEnabled(false);
                if(txtPay.getText().isEmpty())
                    pay=0;
                else
                    pay=Integer.parseInt(txtPay.getText());
                double left=totalamt-pay;
                double totLeft=left+payLeftFromCust;
                int kal=stm.executeUpdate("update customer set pay_left="+totLeft+" where CLIENT_FIRSTNAME = '"+first+"' AND CLIENT_LASTNAME = '"+last+"';");
                if(kal>=1) {
                    System.out.println("Pay_left Updated");
                    addInDatabase();
                } 
            }
            catch (SQLException ex) {
                Logger.getLogger(frmSales.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnCreateActionPerformed

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
            java.util.logging.Logger.getLogger(frmSales.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmSales.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmSales.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmSales.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new frmSales().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(frmSales.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddItem;
    private javax.swing.JButton btnCHeck;
    private javax.swing.JButton btnCreate;
    private javax.swing.JButton btnCross;
    private javax.swing.JButton btnInvoive;
    private javax.swing.JButton btnMin;
    private javax.swing.JComboBox<String> cmbCustomer;
    private javax.swing.JComboBox<String> cmbProduct;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblAMT;
    private javax.swing.JLabel lblBillNo;
    private javax.swing.JLabel lblDate;
    private javax.swing.JTable tblMain;
    private javax.swing.JTextField txtPay;
    private javax.swing.JTextField txtQTY;
    // End of variables declaration//GEN-END:variables
}
