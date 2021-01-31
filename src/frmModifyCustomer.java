import java.awt.Toolkit;
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


public class frmModifyCustomer extends javax.swing.JFrame {

    Connection con;
    Statement stm;
    ResultSet rst,rst2;
    String Value="";
    
    public frmModifyCustomer() throws SQLException {
        
        try {
            initComponents();
        }
        catch(java.lang.IllegalArgumentException e) {
            
        }
        txtFirstName.requestFocus();
        getContentPane().setBackground(newColor.getColor());
        pnlButtons.setBackground(newColor.getColor());
        pnlCustomer.setBackground(newColor.getColor());
        
        con = MyConnectivity.getSQLConnection();
        stm=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
        System.out.println("Statement for insert Created");
        Querry();  
        CloseMinimise.addFrameObject(this);
    }

    private void Querry() throws SQLException{
        DefaultTableModel tblmodel = (DefaultTableModel)tblCustomer.getModel();
        int i=stm.executeUpdate("alter table CUSTOMER drop column s_no;");
        int j=stm.executeUpdate("alter table CUSTOMER add column S_No int(6) not null unique auto_increment first;");
        rst=stm.executeQuery("Select * from CUSTOMER;");
        tblmodel.setRowCount(0);
        while(rst.next()) {
            Object[] row = new Object[]{rst.getLong(1),rst.getString(2)+" "+rst.getString(3),rst.getLong(4),rst.getString(5),rst.getString(6),rst.getString(7),rst.getLong(8),rst.getLong(9),rst.getString(10),rst.getLong(11),rst.getString(12)};
            tblmodel.addRow(row);
            tblCustomer.setModel(tblmodel);
        }    
    }
    
    void addTextField() throws SQLException{
        rst2=stm.executeQuery("select * from CUSTOMER where s_no="+Value+";");
        rst2.next();
        txtFirstName.setText(rst2.getString(2));
        txtLastName.setText(rst2.getString(3));
        txtPhone_No.setText(""+rst2.getLong(4));
        txtE_Mail.setText(rst2.getString(5));
        txtArea.setText(rst2.getString(6));
        txtCity.setText(rst2.getString(7));
        txtPin_Code.setText(""+rst2.getLong(8));
        txtPayLeft.setText(""+rst2.getLong(9));
        txtPAN.setText(""+rst2.getString(10));
        txtAdhaar_No.setText(""+rst2.getLong(11));
        txtGST.setText(""+rst2.getString(12));
    }
    
    void clear() {
        txtFirstName.setText("");
        txtLastName.setText("");
        txtPhone_No.setText("");
        txtE_Mail.setText("");
        txtArea.setText("");
        txtCity.setText("");
        txtPin_Code.setText("");
        txtPayLeft.setText("");
        txtPAN.setText("");
        txtAdhaar_No.setText("");
        txtGST.setText("");
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
        tblCustomer = new javax.swing.JTable();
        pnlButtons = new javax.swing.JPanel();
        btnAdd = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnModify = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();
        txtPhone_No = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtE_Mail = new javax.swing.JTextField();
        txtArea = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtCity = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtPin_Code = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtPayLeft = new javax.swing.JTextField();
        txtPAN = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtAdhaar_No = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtFirstName = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtLastName = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txtGST = new javax.swing.JTextField();

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
        pnlCustomer.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "CUSTOMERS", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Times New Roman", 1, 18))); // NOI18N

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

        pnlButtons.setBackground(new java.awt.Color(93, 140, 160));
        pnlButtons.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Buttons", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 14))); // NOI18N

        btnAdd.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnAdd.setText("Add");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnDelete.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnModify.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnModify.setText("Modify");
        btnModify.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModifyActionPerformed(evt);
            }
        });

        btnClear.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnClear.setText("Clear");
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlButtonsLayout = new javax.swing.GroupLayout(pnlButtons);
        pnlButtons.setLayout(pnlButtonsLayout);
        pnlButtonsLayout.setHorizontalGroup(
            pnlButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlButtonsLayout.createSequentialGroup()
                .addGroup(pnlButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAdd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnDelete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnModify, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnClear, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        pnlButtonsLayout.setVerticalGroup(
            pnlButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlButtonsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnAdd)
                .addGap(18, 18, 18)
                .addComponent(btnModify)
                .addGap(18, 18, 18)
                .addComponent(btnDelete)
                .addGap(18, 18, 18)
                .addComponent(btnClear)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        txtPhone_No.setBackground(new java.awt.Color(240, 240, 240));
        txtPhone_No.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPhone_NoKeyTyped(evt);
            }
        });

        jLabel2.setText("Phone No.");

        jLabel3.setText("E-mail ID");

        txtE_Mail.setBackground(new java.awt.Color(240, 240, 240));
        txtE_Mail.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtE_MailKeyTyped(evt);
            }
        });

        txtArea.setBackground(new java.awt.Color(240, 240, 240));

        jLabel4.setText("Area");

        txtCity.setBackground(new java.awt.Color(240, 240, 240));
        txtCity.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCityKeyTyped(evt);
            }
        });

        jLabel5.setText("City");

        txtPin_Code.setBackground(new java.awt.Color(240, 240, 240));
        txtPin_Code.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPin_CodeKeyTyped(evt);
            }
        });

        jLabel6.setText("Pin Code");

        jLabel7.setText("Pay Left");

        txtPayLeft.setEditable(false);
        txtPayLeft.setBackground(new java.awt.Color(240, 240, 240));
        txtPayLeft.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPayLeftActionPerformed(evt);
            }
        });

        txtPAN.setBackground(new java.awt.Color(240, 240, 240));
        txtPAN.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPANKeyTyped(evt);
            }
        });

        jLabel8.setText("PAN");

        txtAdhaar_No.setBackground(new java.awt.Color(240, 240, 240));
        txtAdhaar_No.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtAdhaar_NoKeyTyped(evt);
            }
        });

        jLabel9.setText("Adhar No.");

        txtFirstName.setBackground(new java.awt.Color(240, 240, 240));
        txtFirstName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtFirstNameKeyTyped(evt);
            }
        });

        jLabel10.setText("Customer First Name");

        txtLastName.setBackground(new java.awt.Color(240, 240, 240));
        txtLastName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtLastNameKeyTyped(evt);
            }
        });

        jLabel11.setText("Customer Last Name");

        jLabel12.setText("GST No.");

        txtGST.setBackground(new java.awt.Color(240, 240, 240));
        txtGST.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtGSTKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlCustomer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(pnlButtons, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtE_Mail))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtArea, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addGap(28, 28, 28)
                                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtGST, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 184, Short.MAX_VALUE)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtAdhaar_No, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 79, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 5, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtPAN, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(txtPin_Code, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(18, 18, 18)
                                            .addComponent(btnMinCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(btnCrossCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(txtPayLeft, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(212, 212, 212)))))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtPhone_No, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(27, 27, 27)
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtLastName, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtCity, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtPin_Code)
                                    .addComponent(txtFirstName)
                                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtLastName))
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtPhone_No, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtCity, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtPAN, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(26, 26, 26)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtAdhaar_No, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtGST, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtE_Mail, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(btnMinCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnCrossCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtArea, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtPayLeft, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(pnlButtons, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(22, 22, 22)))
                .addComponent(pnlCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnCrossCustomerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrossCustomerActionPerformed
        try {
            dispose();
            frmCustomer frm=new frmCustomer();
            frm.setVisible(true);
        } 
        catch (SQLException ex) {
            Logger.getLogger(frmModifyCustomer.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_btnCrossCustomerActionPerformed

    private void btnMinCustomerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMinCustomerActionPerformed
        CloseMinimise.minimise(this);
    }//GEN-LAST:event_btnMinCustomerActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        try {
            if(txtFirstName.getText().trim().isEmpty() || txtLastName.getText().trim().isEmpty() || txtAdhaar_No.getText().trim().isEmpty() || txtArea.getText().trim().isEmpty() || txtCity.getText().trim().isEmpty() || txtE_Mail.getText().trim().isEmpty() || txtGST.getText().trim().isEmpty() || txtPAN.getText().trim().isEmpty() || txtPhone_No.getText().trim().isEmpty() || txtPin_Code.getText().trim().isEmpty()) {
                Toolkit.getDefaultToolkit().beep();
                JOptionPane.showMessageDialog(null, "Do Not Leave Any Field Empty");
            }
            else {
                String payleft=""+0;
                int i=stm.executeUpdate("insert into CUSTOMER (client_firstname,client_lastname,phone_no,email_id,area,city,pin_code,PAY_LEFT,pan,adhaar_no,gst_no) values('"+txtFirstName.getText()+"','"+txtLastName.getText()+"',"+txtPhone_No.getText()+",'"+txtE_Mail.getText()+"','"+txtArea.getText()+"','"+txtCity.getText()+"',"+txtPin_Code.getText()+","+payleft+",'"+txtPAN.getText()+"',"+txtAdhaar_No.getText()+",'"+txtGST.getText()+"');");
                if(i>=1) {
                    JOptionPane.showMessageDialog(null,"Record Succesfully Added","Addition",JOptionPane.INFORMATION_MESSAGE);
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

    private void tblCustomerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblCustomerMouseClicked
        try {
            int i=tblCustomer.getSelectedRow();
            Value=tblCustomer.getValueAt(i,0).toString();
            addTextField();
        }
        catch (SQLException ex) {
            Logger.getLogger(frmModifyCustomer.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_tblCustomerMouseClicked

    private void tblCustomerKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblCustomerKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_UP || evt.getKeyCode()==KeyEvent.VK_DOWN) {
            try {
              int i=tblCustomer.getSelectedRow();
              Value=tblCustomer.getValueAt(i,0).toString();
              addTextField();
            }
            catch (SQLException ex) {
                Logger.getLogger(frmModifyCustomer.class.getName()).log(Level.SEVERE, null, ex);
            }  
        }
            
    }//GEN-LAST:event_tblCustomerKeyPressed

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
                    int i =stm.executeUpdate("delete from CUSTOMER where s_no="+Value+";");
                    if(i>=1) 
                        JOptionPane.showMessageDialog(null,"Deleted Successfully","Deletion",JOptionPane.ERROR_MESSAGE);
                    Querry();
                    clear();
                    addInDatabase();
                }
            }
            catch(SQLException e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
            catch(IndexOutOfBoundsException e) {
                
            }
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnModifyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModifyActionPerformed
        if(Value.trim().isEmpty() || Value==null) {
            JOptionPane.showMessageDialog(null, "Select Row First");
        }
        else {
            try {
                int i=stm.executeUpdate("update CUSTOMER set client_firstname = '"+txtFirstName.getText()+"',client_lastname = '"+txtLastName.getText()+"',phone_no = "+txtPhone_No.getText()+",email_id = '"+txtE_Mail.getText()+"',area = '"+txtArea.getText()+"',city = '"+txtCity.getText()+"',pin_code = "+txtPin_Code.getText()+",PAY_LEFT = "+txtPayLeft.getText()+",PAN = '"+txtPAN.getText()+"',ADHAAR_NO = "+txtAdhaar_No.getText()+",GST_NO = '"+txtGST.getText()+"' where s_no="+Value+";");
                if(i>=1) {
                    JOptionPane.showMessageDialog(null,"Record Updated");
                    Querry();
                    clear();
                    addInDatabase();
                }
            }
            catch(SQLException e) {
                
            }
            
        }
    }//GEN-LAST:event_btnModifyActionPerformed

    private void txtPhone_NoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPhone_NoKeyTyped
        if(txtPhone_No.getText().length()>=10)
            evt.consume();
        if(!(evt.getKeyChar()>= KeyEvent.VK_0 && evt.getKeyChar()<=KeyEvent.VK_9)){
            evt.consume();
        }
    }//GEN-LAST:event_txtPhone_NoKeyTyped

    private void txtGSTKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtGSTKeyTyped
        if(txtGST.getText().length()>=16)
            evt.consume();
    }//GEN-LAST:event_txtGSTKeyTyped

    private void txtPANKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPANKeyTyped
        if(txtPAN.getText().length()>=10)
            evt.consume();
    }//GEN-LAST:event_txtPANKeyTyped

    private void txtAdhaar_NoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAdhaar_NoKeyTyped
        if(txtAdhaar_No.getText().length()>=16)
            evt.consume();
        if(!(evt.getKeyChar()>= KeyEvent.VK_0 && evt.getKeyChar()<=KeyEvent.VK_9)){
            evt.consume();
        }
    }//GEN-LAST:event_txtAdhaar_NoKeyTyped

    private void txtPayLeftActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPayLeftActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPayLeftActionPerformed

    private void txtPin_CodeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPin_CodeKeyTyped
        if(txtPin_Code.getText().length()>=6)
            evt.consume();
        if(!(evt.getKeyChar()>= KeyEvent.VK_0 && evt.getKeyChar()<=KeyEvent.VK_9)){
            evt.consume();
        }
    }//GEN-LAST:event_txtPin_CodeKeyTyped

    private void txtFirstNameKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFirstNameKeyTyped
        if(txtFirstName.getText().length()>=18)
            evt.consume();
        if((evt.getKeyChar()>= KeyEvent.VK_0 && evt.getKeyChar()<=KeyEvent.VK_9)){
            evt.consume();
        }
    }//GEN-LAST:event_txtFirstNameKeyTyped

    private void txtLastNameKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtLastNameKeyTyped
        if(txtLastName.getText().length()>=18)
            evt.consume();
        if((evt.getKeyChar()>= KeyEvent.VK_0 && evt.getKeyChar()<=KeyEvent.VK_9)){
            evt.consume();
        }
    }//GEN-LAST:event_txtLastNameKeyTyped

    private void txtCityKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCityKeyTyped
        if(txtCity.getText().length()>=18)
            evt.consume();
        if((evt.getKeyChar()>= KeyEvent.VK_0 && evt.getKeyChar()<=KeyEvent.VK_9)){
            evt.consume();
        }
    }//GEN-LAST:event_txtCityKeyTyped

    private void txtE_MailKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtE_MailKeyTyped
       if(txtE_Mail.getText().length()>=30)
            evt.consume();
        if(evt.getKeyChar()>=65 && evt.getKeyChar()<=91 || evt.getKeyChar()==KeyEvent.VK_SPACE)
            evt.consume();
    }//GEN-LAST:event_txtE_MailKeyTyped

    
    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new frmModifyCustomer().setVisible(true);
                } 
                catch (SQLException ex) {
                    Logger.getLogger(frmModifyCustomer.class.getName()).log(Level.SEVERE, null, ex);
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
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel pnlButtons;
    private javax.swing.JPanel pnlCustomer;
    private javax.swing.JTable tblCustomer;
    private javax.swing.JTextField txtAdhaar_No;
    private javax.swing.JTextField txtArea;
    private javax.swing.JTextField txtCity;
    private javax.swing.JTextField txtE_Mail;
    private javax.swing.JTextField txtFirstName;
    private javax.swing.JTextField txtGST;
    private javax.swing.JTextField txtLastName;
    private javax.swing.JTextField txtPAN;
    private javax.swing.JTextField txtPayLeft;
    private javax.swing.JTextField txtPhone_No;
    private javax.swing.JTextField txtPin_Code;
    // End of variables declaration//GEN-END:variables
}
