import javax.swing.Timer;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class frmHome extends javax.swing.JFrame {
    static boolean already;
    boolean keyPressed=false;
    
    static diaHiddenPass dia;
    public frmHome() {
        initComponents();
        CloseMinimise.addFrameObject(this);
        newColor.setDefaultColor();
        jTextField1.requestFocus();
        setSize(820, 468);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.size().width/2,dim.height/2-this.getSize().height/2);
        Date date = new Date();
        SimpleDateFormat dateform = new SimpleDateFormat("yyyy-MM-dd  EEEE  HH:mm:ss");
        
        SimpleDateFormat dtform = new SimpleDateFormat("HH");
        String dtx=dtform.format(date);
        Double dt = Double.parseDouble(dtx);
        if(dt<=15)
            lblWish.setText("Good Morning "+frmLogin.user);
        else
            lblWish.setText("Good Evening "+frmLogin.user); 
        
        Timer tim = new Timer(0,new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                Date dat = new Date();
                String dt = dateform.format(dat);
                lblDateTime.setText(dt);
            }
        });
        tim.start();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblDateTime = new javax.swing.JLabel();
        lblWish = new javax.swing.JLabel();
        lblBG = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jMenuBar1 = new javax.swing.JMenuBar();
        menuFile = new javax.swing.JMenu();
        menuitemCust = new javax.swing.JMenuItem();
        menuitemComp = new javax.swing.JMenuItem();
        menuitemMedicine = new javax.swing.JMenuItem();
        menuitemSupp = new javax.swing.JMenuItem();
        menuReport = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        menuLetter = new javax.swing.JMenu();
        menuitemSuppLetter = new javax.swing.JMenuItem();
        menuitemCustLetter = new javax.swing.JMenuItem();
        menuAccount = new javax.swing.JMenu();
        menuitemcreatenewuser = new javax.swing.JMenuItem();
        menuitemchangepwd = new javax.swing.JMenuItem();
        menuSet = new javax.swing.JMenu();
        jMenuItem4 = new javax.swing.JMenuItem();
        menuKey = new javax.swing.JMenu();
        jMenuItem5 = new javax.swing.JMenuItem();
        menuGst = new javax.swing.JMenu();
        jMenuItem6 = new javax.swing.JMenuItem();
        menuQuit = new javax.swing.JMenu();
        jMenuItem7 = new javax.swing.JMenuItem();
        menuGap = new javax.swing.JMenu();
        menuMinimise = new javax.swing.JMenu();
        menuCross = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                formKeyTyped(evt);
            }
        });
        getContentPane().setLayout(null);

        lblDateTime.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        lblDateTime.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblDateTime.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        lblDateTime.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                KeyPressedComm(evt);
            }
        });
        getContentPane().add(lblDateTime);
        lblDateTime.setBounds(500, 400, 320, 30);

        lblWish.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        getContentPane().add(lblWish);
        lblWish.setBounds(0, 410, 300, 30);

        lblBG.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/BackGround.jpg"))); // NOI18N
        lblBG.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblBGMouseClicked(evt);
            }
        });
        lblBG.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                KeyPressedComm(evt);
            }
        });
        getContentPane().add(lblBG);
        lblBG.setBounds(0, 0, 820, 440);

        jTextField1.setEditable(false);
        jTextField1.setText("jTextField1");
        jTextField1.setOpaque(false);
        jTextField1.setPreferredSize(new java.awt.Dimension(1, 1));
        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                KeyPressedComm(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField1KeyTyped(evt);
            }
        });
        getContentPane().add(jTextField1);
        jTextField1.setBounds(80, 60, 80, 1);

        jMenuBar1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        menuFile.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        menuFile.setText("    File");
        menuFile.setFont(new java.awt.Font("Perpetua Titling MT", 1, 14)); // NOI18N
        menuFile.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        menuFile.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        menuFile.setMinimumSize(new java.awt.Dimension(50, 25));
        menuFile.setPreferredSize(new java.awt.Dimension(80, 25));
        menuFile.addMenuKeyListener(new javax.swing.event.MenuKeyListener() {
            public void menuKeyPressed(javax.swing.event.MenuKeyEvent evt) {
                KeyhiddenDia(evt);
            }
            public void menuKeyReleased(javax.swing.event.MenuKeyEvent evt) {
            }
            public void menuKeyTyped(javax.swing.event.MenuKeyEvent evt) {
                shortcut(evt);
            }
        });

        menuitemCust.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        menuitemCust.setText("Customers");
        menuitemCust.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuitemCustActionPerformed(evt);
            }
        });
        menuFile.add(menuitemCust);

        menuitemComp.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        menuitemComp.setText("Company");
        menuitemComp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuitemCompActionPerformed(evt);
            }
        });
        menuFile.add(menuitemComp);

        menuitemMedicine.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        menuitemMedicine.setText("Stock");
        menuitemMedicine.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuitemMedicineActionPerformed(evt);
            }
        });
        menuFile.add(menuitemMedicine);

        menuitemSupp.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        menuitemSupp.setText("Suppliers");
        menuitemSupp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuitemSuppActionPerformed(evt);
            }
        });
        menuFile.add(menuitemSupp);

        jMenuBar1.add(menuFile);

        menuReport.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        menuReport.setText(" REPORT");
        menuReport.setFont(new java.awt.Font("Perpetua Titling MT", 1, 14)); // NOI18N
        menuReport.setPreferredSize(new java.awt.Dimension(80, 25));
        menuReport.addMenuKeyListener(new javax.swing.event.MenuKeyListener() {
            public void menuKeyPressed(javax.swing.event.MenuKeyEvent evt) {
                KeyhiddenDia(evt);
            }
            public void menuKeyReleased(javax.swing.event.MenuKeyEvent evt) {
            }
            public void menuKeyTyped(javax.swing.event.MenuKeyEvent evt) {
                shortcut(evt);
            }
        });

        jMenuItem2.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jMenuItem2.setText("Bill");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        menuReport.add(jMenuItem2);

        jMenuItem3.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jMenuItem3.setText("View Sale");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        menuReport.add(jMenuItem3);

        jMenuItem1.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jMenuItem1.setText("Update Payment");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        menuReport.add(jMenuItem1);

        jMenuBar1.add(menuReport);

        menuLetter.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        menuLetter.setText("  LETTER");
        menuLetter.setFont(new java.awt.Font("Perpetua Titling MT", 1, 14)); // NOI18N
        menuLetter.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        menuLetter.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        menuLetter.setPreferredSize(new java.awt.Dimension(80, 25));
        menuLetter.addMenuKeyListener(new javax.swing.event.MenuKeyListener() {
            public void menuKeyPressed(javax.swing.event.MenuKeyEvent evt) {
                KeyhiddenDia(evt);
            }
            public void menuKeyReleased(javax.swing.event.MenuKeyEvent evt) {
            }
            public void menuKeyTyped(javax.swing.event.MenuKeyEvent evt) {
                shortcut(evt);
            }
        });

        menuitemSuppLetter.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        menuitemSuppLetter.setText("Supplier");
        menuitemSuppLetter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuitemSuppLetterActionPerformed(evt);
            }
        });
        menuLetter.add(menuitemSuppLetter);

        menuitemCustLetter.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        menuitemCustLetter.setText("Customer");
        menuitemCustLetter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuitemCustLetterActionPerformed(evt);
            }
        });
        menuLetter.add(menuitemCustLetter);

        jMenuBar1.add(menuLetter);

        menuAccount.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        menuAccount.setText("ACCOUNT");
        menuAccount.setFont(new java.awt.Font("Perpetua Titling MT", 1, 14)); // NOI18N
        menuAccount.setPreferredSize(new java.awt.Dimension(90, 25));
        menuAccount.addMenuKeyListener(new javax.swing.event.MenuKeyListener() {
            public void menuKeyPressed(javax.swing.event.MenuKeyEvent evt) {
                KeyhiddenDia(evt);
            }
            public void menuKeyReleased(javax.swing.event.MenuKeyEvent evt) {
            }
            public void menuKeyTyped(javax.swing.event.MenuKeyEvent evt) {
                shortcut(evt);
            }
        });

        menuitemcreatenewuser.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        menuitemcreatenewuser.setText("Create New User");
        menuitemcreatenewuser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuitemcreatenewuserActionPerformed(evt);
            }
        });
        menuAccount.add(menuitemcreatenewuser);

        menuitemchangepwd.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        menuitemchangepwd.setText("Change Password");
        menuitemchangepwd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuitemchangepwdActionPerformed(evt);
            }
        });
        menuAccount.add(menuitemchangepwd);

        jMenuBar1.add(menuAccount);

        menuSet.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        menuSet.setText("    SET");
        menuSet.setFont(new java.awt.Font("Perpetua Titling MT", 1, 14)); // NOI18N
        menuSet.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        menuSet.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        menuSet.setPreferredSize(new java.awt.Dimension(80, 25));
        menuSet.addMenuKeyListener(new javax.swing.event.MenuKeyListener() {
            public void menuKeyPressed(javax.swing.event.MenuKeyEvent evt) {
                KeyhiddenDia(evt);
            }
            public void menuKeyReleased(javax.swing.event.MenuKeyEvent evt) {
            }
            public void menuKeyTyped(javax.swing.event.MenuKeyEvent evt) {
                shortcut(evt);
            }
        });

        jMenuItem4.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jMenuItem4.setText("Change Color");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        menuSet.add(jMenuItem4);

        jMenuBar1.add(menuSet);

        menuKey.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        menuKey.setText("    KEY");
        menuKey.setFont(new java.awt.Font("Perpetua Titling MT", 1, 14)); // NOI18N
        menuKey.setPreferredSize(new java.awt.Dimension(80, 25));
        menuKey.addMenuKeyListener(new javax.swing.event.MenuKeyListener() {
            public void menuKeyPressed(javax.swing.event.MenuKeyEvent evt) {
                KeyhiddenDia(evt);
            }
            public void menuKeyReleased(javax.swing.event.MenuKeyEvent evt) {
            }
            public void menuKeyTyped(javax.swing.event.MenuKeyEvent evt) {
                shortcut(evt);
            }
        });
        menuKey.addMenuListener(new javax.swing.event.MenuListener() {
            public void menuCanceled(javax.swing.event.MenuEvent evt) {
            }
            public void menuDeselected(javax.swing.event.MenuEvent evt) {
            }
            public void menuSelected(javax.swing.event.MenuEvent evt) {
                menuKeyMenuSelected(evt);
            }
        });

        jMenuItem5.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jMenuItem5.setText("Key");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        menuKey.add(jMenuItem5);

        jMenuBar1.add(menuKey);

        menuGst.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        menuGst.setText("About");
        menuGst.setFont(new java.awt.Font("Perpetua Titling MT", 1, 14)); // NOI18N
        menuGst.setPreferredSize(new java.awt.Dimension(80, 25));
        menuGst.addMenuKeyListener(new javax.swing.event.MenuKeyListener() {
            public void menuKeyPressed(javax.swing.event.MenuKeyEvent evt) {
                KeyhiddenDia(evt);
            }
            public void menuKeyReleased(javax.swing.event.MenuKeyEvent evt) {
            }
            public void menuKeyTyped(javax.swing.event.MenuKeyEvent evt) {
                shortcut(evt);
            }
        });
        menuGst.addMenuListener(new javax.swing.event.MenuListener() {
            public void menuCanceled(javax.swing.event.MenuEvent evt) {
            }
            public void menuDeselected(javax.swing.event.MenuEvent evt) {
            }
            public void menuSelected(javax.swing.event.MenuEvent evt) {
                menuGstMenuSelected(evt);
            }
        });

        jMenuItem6.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jMenuItem6.setText("About");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        menuGst.add(jMenuItem6);

        jMenuBar1.add(menuGst);

        menuQuit.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        menuQuit.setText("Log Out");
        menuQuit.setFont(new java.awt.Font("Perpetua Titling MT", 1, 14)); // NOI18N
        menuQuit.setPreferredSize(new java.awt.Dimension(80, 25));
        menuQuit.addMenuKeyListener(new javax.swing.event.MenuKeyListener() {
            public void menuKeyPressed(javax.swing.event.MenuKeyEvent evt) {
                KeyhiddenDia(evt);
            }
            public void menuKeyReleased(javax.swing.event.MenuKeyEvent evt) {
            }
            public void menuKeyTyped(javax.swing.event.MenuKeyEvent evt) {
                shortcut(evt);
            }
        });
        menuQuit.addMenuListener(new javax.swing.event.MenuListener() {
            public void menuCanceled(javax.swing.event.MenuEvent evt) {
            }
            public void menuDeselected(javax.swing.event.MenuEvent evt) {
            }
            public void menuSelected(javax.swing.event.MenuEvent evt) {
                menuQuitMenuSelected(evt);
            }
        });

        jMenuItem7.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jMenuItem7.setText("Log Out");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        menuQuit.add(jMenuItem7);

        jMenuBar1.add(menuQuit);

        menuGap.setText("                                    ");
        menuGap.setEnabled(false);
        menuGap.addMenuKeyListener(new javax.swing.event.MenuKeyListener() {
            public void menuKeyPressed(javax.swing.event.MenuKeyEvent evt) {
                KeyhiddenDia(evt);
            }
            public void menuKeyReleased(javax.swing.event.MenuKeyEvent evt) {
            }
            public void menuKeyTyped(javax.swing.event.MenuKeyEvent evt) {
                shortcut(evt);
            }
        });
        jMenuBar1.add(menuGap);

        menuMinimise.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/minFinalAllall.png"))); // NOI18N
        menuMinimise.setPreferredSize(new java.awt.Dimension(30, 19));
        menuMinimise.addMenuKeyListener(new javax.swing.event.MenuKeyListener() {
            public void menuKeyPressed(javax.swing.event.MenuKeyEvent evt) {
                KeyhiddenDia(evt);
            }
            public void menuKeyReleased(javax.swing.event.MenuKeyEvent evt) {
            }
            public void menuKeyTyped(javax.swing.event.MenuKeyEvent evt) {
                shortcut(evt);
            }
        });
        menuMinimise.addMenuListener(new javax.swing.event.MenuListener() {
            public void menuCanceled(javax.swing.event.MenuEvent evt) {
            }
            public void menuDeselected(javax.swing.event.MenuEvent evt) {
            }
            public void menuSelected(javax.swing.event.MenuEvent evt) {
                menuMinimiseMenuSelected(evt);
            }
        });
        jMenuBar1.add(menuMinimise);

        menuCross.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/crossFinallALl.png"))); // NOI18N
        menuCross.setText("           ");
        menuCross.setPreferredSize(new java.awt.Dimension(30, 19));
        menuCross.addMenuKeyListener(new javax.swing.event.MenuKeyListener() {
            public void menuKeyPressed(javax.swing.event.MenuKeyEvent evt) {
                KeyhiddenDia(evt);
            }
            public void menuKeyReleased(javax.swing.event.MenuKeyEvent evt) {
            }
            public void menuKeyTyped(javax.swing.event.MenuKeyEvent evt) {
                shortcut(evt);
            }
        });
        menuCross.addMenuListener(new javax.swing.event.MenuListener() {
            public void menuCanceled(javax.swing.event.MenuEvent evt) {
            }
            public void menuDeselected(javax.swing.event.MenuEvent evt) {
            }
            public void menuSelected(javax.swing.event.MenuEvent evt) {
                menuCrossMenuSelected(evt);
            }
        });
        jMenuBar1.add(menuCross);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void menuMinimiseMenuSelected(javax.swing.event.MenuEvent evt) {//GEN-FIRST:event_menuMinimiseMenuSelected
        CloseMinimise.minimise(this);
    }//GEN-LAST:event_menuMinimiseMenuSelected

    private void menuCrossMenuSelected(javax.swing.event.MenuEvent evt) {//GEN-FIRST:event_menuCrossMenuSelected
        int i = JOptionPane.showConfirmDialog(this,"You Really Want To Exit?","Exit Confirm",JOptionPane.YES_NO_OPTION);
        if(i==JOptionPane.YES_OPTION)
            System.exit(0);
    }//GEN-LAST:event_menuCrossMenuSelected

    private void KeyhiddenDia(javax.swing.event.MenuKeyEvent evt) {//GEN-FIRST:event_KeyhiddenDia
        if(evt.isShiftDown() && evt.getKeyCode() == KeyEvent.VK_Q ){
            if(already==false){
                dia = new diaHiddenPass();
                dia.pack();
                dia.setLocationRelativeTo(this);
                dia.setVisible(true);
                System.out.println("KeyPressed");
                already=true;
                keyPressed=true;
            }
            else {
                
            }
        }
    }//GEN-LAST:event_KeyhiddenDia

    private void KeyPressedComm(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_KeyPressedComm
        if(evt.isShiftDown() && evt.getKeyCode() == KeyEvent.VK_Q ){
            if(already==false){
                dia = new diaHiddenPass();
                dia.pack();
                dia.setLocationRelativeTo(this);
                dia.setVisible(true);
                System.out.println("KeyPressed");
                already=true;
                keyPressed=true;
            }
            else {
                
            }
        }
    }//GEN-LAST:event_KeyPressedComm

    private void menuitemCustActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuitemCustActionPerformed
        try {
            frmCustomer frmCus = new frmCustomer();
            frmCus.setVisible(true);
        } 
        catch (SQLException ex) {
            Logger.getLogger(frmHome.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }//GEN-LAST:event_menuitemCustActionPerformed

    private void menuitemCompActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuitemCompActionPerformed
        try {
            new frmCompany().setVisible(true);
        } 
        catch (SQLException ex) {
            Logger.getLogger(frmHome.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_menuitemCompActionPerformed

    private void menuitemSuppLetterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuitemSuppLetterActionPerformed
        try {
            new frmLetter().setVisible(true);
        } 
        catch (SQLException ex) {
            Logger.getLogger(frmHome.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_menuitemSuppLetterActionPerformed

    private void menuitemSuppActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuitemSuppActionPerformed
        try {
            frmSupplier frmSupp = new frmSupplier();
            frmSupp.setVisible(true);
        } 
        catch (SQLException ex) {
            Logger.getLogger(frmHome.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_menuitemSuppActionPerformed

    private void menuitemcreatenewuserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuitemcreatenewuserActionPerformed
        try {
            new frmCreateNewUser().setVisible(true);
        } 
        catch (SQLException ex) {
            Logger.getLogger(frmHome.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_menuitemcreatenewuserActionPerformed

    private void menuitemMedicineActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuitemMedicineActionPerformed
        try {
            frmStock frm = new frmStock();
            frm.setVisible(true);
        } 
        catch (SQLException ex) {
            Logger.getLogger(frmHome.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_menuitemMedicineActionPerformed

    private void menuitemchangepwdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuitemchangepwdActionPerformed
        try {
            frmChangePassword frm = new frmChangePassword();
            frm.setVisible(true);
        } 
        catch (SQLException ex) {
            Logger.getLogger(frmHome.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_menuitemchangepwdActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        try {
            new frmSales().setVisible(true);
        } 
        catch (SQLException ex) {
            Logger.getLogger(frmHome.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        new frmViewSaleByDate().setVisible(true);
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        new frmColorChooser().setVisible(true);
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        try {
            new frmPayLeft().setVisible(true);
        } 
        catch (SQLException ex) {
            Logger.getLogger(frmHome.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void menuitemCustLetterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuitemCustLetterActionPerformed
        try {
            new frmLetter().setVisible(true);
        } 
        catch (SQLException ex) {
            Logger.getLogger(frmHome.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_menuitemCustLetterActionPerformed

    private void menuKeyMenuSelected(javax.swing.event.MenuEvent evt) {//GEN-FIRST:event_menuKeyMenuSelected
        
    }//GEN-LAST:event_menuKeyMenuSelected

    private void shortcut(javax.swing.event.MenuKeyEvent evt) {//GEN-FIRST:event_shortcut
        
    }//GEN-LAST:event_shortcut

    private void jTextField1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyTyped
        try {
            char c= evt.getKeyChar();
            
            switch(c) {
                case 'P':
                case 'p': new frmChangePassword().setVisible(true);
                          break;
                case 'b':
                case 'B': new frmColorChooser().setVisible(true);
                          break;
                case 'w':
                case 'W': new frmCompany().setVisible(true);
                          break;
                case 'U':
                case 'u': new frmCreateNewUser().setVisible(true);
                          break;
                case 'C':
                case 'c': new frmCustomer().setVisible(true);
                          break;
                case 'r':
                case 'R': new frmCustomerSearch().setVisible(true);
                          break;
                case 'g':
                case 'G': new frmAbout().setVisible(true);
                          break;
                case 'k':
                case 'K': new frmKeys().setVisible(true);
                          break;
                case 'l':
                case 'L': new frmLetter().setVisible(true);
                          break;
                case 'M':
                case 'm': new frmModifyCustomer().setVisible(true);
                          break; 
                case 't':
                case 'T': new frmModifyStock().setVisible(true);
                          break;
                case 'Y':
                case 'y': new frmModifySupplier().setVisible(true);
                          break;
                case 'i':
                case 'I': new frmPayLeft().setVisible(true);
                          break;
                case 'S':
                case 's': new frmSales().setVisible(true);
                          break;
                case 'O':
                case 'o': new frmSearchStock().setVisible(true);
                          break;
                case 'A':
                case 'a': new frmStock().setVisible(true);
                          break;
                case 'D':
                case 'd': new frmSupplier().setVisible(true);
                          break;
                case 'V':
                case 'v': new frmViewSaleByDate().setVisible(true);
                          break; 
                case 'Z':
                case 'z': new frmSupplierSearch().setVisible(true);
                          break;          
            }
        }
        catch (SQLException ex) {
            Logger.getLogger(frmHome.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jTextField1KeyTyped

    private void lblBGMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBGMouseClicked
        
    }//GEN-LAST:event_lblBGMouseClicked

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
       
    }//GEN-LAST:event_formMouseClicked

    private void menuQuitMenuSelected(javax.swing.event.MenuEvent evt) {//GEN-FIRST:event_menuQuitMenuSelected
        
    }//GEN-LAST:event_menuQuitMenuSelected

    private void menuGstMenuSelected(javax.swing.event.MenuEvent evt) {//GEN-FIRST:event_menuGstMenuSelected
        
    }//GEN-LAST:event_menuGstMenuSelected

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        new frmKeys().setVisible(true);
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        new frmAbout().setVisible(true);
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void formKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyTyped
        try {
            char c= evt.getKeyChar();
            
            switch(c) {
                case 'P':
                case 'p': new frmChangePassword().setVisible(true);
                          break;
                case 'b':
                case 'B': new frmColorChooser().setVisible(true);
                          break;
                case 'w':
                case 'W': new frmCompany().setVisible(true);
                          break;
                case 'U':
                case 'u': new frmCreateNewUser().setVisible(true);
                          break;
                case 'C':
                case 'c': new frmCustomer().setVisible(true);
                          break;
                case 'r':
                case 'R': new frmCustomerSearch().setVisible(true);
                          break;
                case 'g':
                case 'G': new frmAbout().setVisible(true);
                          break;
                case 'k':
                case 'K': new frmKeys().setVisible(true);
                          break;
                case 'l':
                case 'L': new frmLetter().setVisible(true);
                          break;
                case 'M':
                case 'm': new frmModifyCustomer().setVisible(true);
                          break; 
                case 't':
                case 'T': new frmModifyStock().setVisible(true);
                          break;
                case 'Y':
                case 'y': new frmModifySupplier().setVisible(true);
                          break;
                case 'i':
                case 'I': new frmPayLeft().setVisible(true);
                          break;
                case 'S':
                case 's': new frmSales().setVisible(true);
                          break;
                case 'O':
                case 'o': new frmSearchStock().setVisible(true);
                          break;
                case 'A':
                case 'a': new frmStock().setVisible(true);
                          break;
                case 'D':
                case 'd': new frmSupplier().setVisible(true);
                          break;
                case 'V':
                case 'v': new frmViewSaleByDate().setVisible(true);
                          break; 
                case 'Z':
                case 'z': new frmSupplierSearch().setVisible(true);
                          break;          
            }
        }
        catch (SQLException ex) {
            Logger.getLogger(frmHome.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_formKeyTyped

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
        int i = JOptionPane.showConfirmDialog(this,"You Really Want To Log Out?","Exit Confirm",JOptionPane.YES_NO_OPTION);
        if(i==JOptionPane.YES_OPTION) {
            try {
                CloseMinimise.closeAll();
                new frmLogin().setVisible(true);
                if(keyPressed==true)
                   dia.dispose();
            } 
            catch (SQLException ex) {
                Logger.getLogger(frmHome.class.getName()).log(Level.SEVERE, null, ex);
             }
        }
    }//GEN-LAST:event_jMenuItem7ActionPerformed

    
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
            java.util.logging.Logger.getLogger(frmHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmHome().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JLabel lblBG;
    private javax.swing.JLabel lblDateTime;
    private javax.swing.JLabel lblWish;
    private javax.swing.JMenu menuAccount;
    private javax.swing.JMenu menuCross;
    private javax.swing.JMenu menuFile;
    private javax.swing.JMenu menuGap;
    private javax.swing.JMenu menuGst;
    private javax.swing.JMenu menuKey;
    private javax.swing.JMenu menuLetter;
    private javax.swing.JMenu menuMinimise;
    private javax.swing.JMenu menuQuit;
    private javax.swing.JMenu menuReport;
    private javax.swing.JMenu menuSet;
    private javax.swing.JMenuItem menuitemComp;
    private javax.swing.JMenuItem menuitemCust;
    private javax.swing.JMenuItem menuitemCustLetter;
    private javax.swing.JMenuItem menuitemMedicine;
    private javax.swing.JMenuItem menuitemSupp;
    private javax.swing.JMenuItem menuitemSuppLetter;
    private javax.swing.JMenuItem menuitemchangepwd;
    private javax.swing.JMenuItem menuitemcreatenewuser;
    // End of variables declaration//GEN-END:variables

}
