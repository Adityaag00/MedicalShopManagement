import java.awt.Dimension;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class frmLogin extends javax.swing.JFrame {

    Connection con;
    Statement stm;
    ResultSet rst,rst2;
    char ch;
    int j;
    static String user;
    
    public frmLogin() throws SQLException {
        initComponents();
        setSize(680, 350);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.size().width/2,dim.height/2-this.getSize().height/2);
        
        con=MyConnectivity.getSQLConnection();
        
        stm=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
        System.out.println("Statement Created");
        ch = pwdlogin.getEchoChar();
        
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnexit = new javax.swing.JButton();
        pwdlogin = new javax.swing.JPasswordField();
        jLabel1 = new javax.swing.JLabel();
        txtUser = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        btnLogin = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        LabelBackGround = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(null);

        btnexit.setBackground(new java.awt.Color(0, 0, 0));
        btnexit.setForeground(new java.awt.Color(255, 255, 255));
        btnexit.setText("Exit");
        btnexit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnexitActionPerformed(evt);
            }
        });
        getContentPane().add(btnexit);
        btnexit.setBounds(560, 280, 70, 30);

        pwdlogin.setBackground(new java.awt.Color(255, 255, 204));
        pwdlogin.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        pwdlogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pwdloginActionPerformed(evt);
            }
        });
        getContentPane().add(pwdlogin);
        pwdlogin.setBounds(510, 160, 120, 30);

        jLabel1.setBackground(new java.awt.Color(0, 0, 0));
        jLabel1.setFont(new java.awt.Font("Bookman Old Style", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("User Id");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(350, 110, 90, 30);

        txtUser.setBackground(new java.awt.Color(255, 255, 204));
        txtUser.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        txtUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUserActionPerformed(evt);
            }
        });
        txtUser.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtUserKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtUserKeyTyped(evt);
            }
        });
        getContentPane().add(txtUser);
        txtUser.setBounds(510, 110, 120, 30);

        jLabel2.setBackground(new java.awt.Color(0, 0, 0));
        jLabel2.setFont(new java.awt.Font("Bookman Old Style", 1, 18)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Password");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(350, 160, 100, 30);

        btnLogin.setBackground(new java.awt.Color(0, 0, 0));
        btnLogin.setForeground(new java.awt.Color(255, 255, 255));
        btnLogin.setText("Log In");
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });
        btnLogin.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                btnLoginKeyTyped(evt);
            }
        });
        getContentPane().add(btnLogin);
        btnLogin.setBounds(560, 230, 70, 30);

        jButton5.setBackground(new java.awt.Color(204, 204, 255));
        jButton5.setForeground(new java.awt.Color(255, 255, 255));
        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/wineyelatest.png"))); // NOI18N
        jButton5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jButton5MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jButton5MouseReleased(evt);
            }
        });
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton5);
        jButton5.setBounds(640, 170, 30, 20);

        LabelBackGround.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/ALL.jpg"))); // NOI18N
        LabelBackGround.setOpaque(true);
        getContentPane().add(LabelBackGround);
        LabelBackGround.setBounds(0, -20, 870, 370);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnexitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnexitActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btnexitActionPerformed

    private void pwdloginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pwdloginActionPerformed
        btnLogin.requestFocus();
    }//GEN-LAST:event_pwdloginActionPerformed

    private void txtUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUserActionPerformed
        pwdlogin.requestFocus();
    }//GEN-LAST:event_txtUserActionPerformed

    private void txtUserKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtUserKeyPressed
        
    }//GEN-LAST:event_txtUserKeyPressed

    private void txtUserKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtUserKeyTyped

    }//GEN-LAST:event_txtUserKeyTyped

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
        if(txtUser.getText().trim().isEmpty() || pwdlogin.getText().trim().isEmpty())
            JOptionPane.showMessageDialog(this, "Empty");
        else {
            try {
                String usr = txtUser.getText();
                user=txtUser.getText();
                String pwd=String.valueOf(pwdlogin.getPassword());
                rst=stm.executeQuery("select * from user where BINARY USER_NAME= '"+usr+"' AND PASSWORD = '"+pwd+"' ;");
                rst.last();
                if(rst.getRow()==1) {
                    JOptionPane.showMessageDialog(null, "Login Successfull");
                    frmHome frmt = new frmHome();
                    frmt.setVisible(true);
                    this.dispose();
                    Date date = new Date();
                    SimpleDateFormat dateform = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    String dt = dateform.format(date);
                    int i = stm.executeUpdate("insert into loginlog (lastloginby,date_time) values('"+txtUser.getText()+"','"+dt+"');");
                }
                else {
                    JOptionPane.showMessageDialog(null, "Login ID And Password Incorrect");
                }

            } catch (SQLException ex) {
                Logger.getLogger(frmLogin.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnLoginActionPerformed

    private void btnLoginKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnLoginKeyTyped
       

    }//GEN-LAST:event_btnLoginKeyTyped

    private void jButton5MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton5MousePressed
       pwdlogin.setEchoChar((char)0);
    }//GEN-LAST:event_jButton5MousePressed

    private void jButton5MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton5MouseReleased
        pwdlogin.setEchoChar(ch);
    }//GEN-LAST:event_jButton5MouseReleased

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        
    }//GEN-LAST:event_jButton5ActionPerformed

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
            java.util.logging.Logger.getLogger(frmLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new frmLogin().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(frmLogin.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel LabelBackGround;
    private javax.swing.JButton btnLogin;
    private javax.swing.JButton btnexit;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPasswordField pwdlogin;
    private javax.swing.JTextField txtUser;
    // End of variables declaration//GEN-END:variables
}
