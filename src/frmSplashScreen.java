import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Timer;

public class frmSplashScreen extends javax.swing.JFrame {
    Timer tim1,tim2,tim3,tim4;
    Random rnd = new Random();
    int i = rnd.nextInt(60),j=0,k=rnd.nextInt(300),l=rnd.nextInt(80),m=rnd.nextInt(20);
    
    public frmSplashScreen() throws InterruptedException, SQLException, ClassNotFoundException {
        initComponents();
        new AddInDatabse();
        progSplash.setMinimum(0);
        progSplash.setMaximum(100);
        
        System.out.println(i+" "+k+" "+l+" "+m);
        
        Color bgcolor=Color.decode("#1cccb9");
        getContentPane().setBackground(bgcolor);
        
        tim1 = new Timer(i,new ActionListener(){
            public void actionPerformed(ActionEvent e) {
              j++;
              progSplash.setValue(j);
              lblText.setText(""+j+"%");
              lblSplashText.setText("Loading Packages...");
              if(j==22) {
                  tim1.stop();
                  tim2.start();
                  lblSplashText.setText("Loading Modules...");
                  System.out.println("tim2 Started");
              }
            }
        });
        tim2 = new Timer(k,new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                j++;
                lblText.setText(""+j+"%");
                progSplash.setValue(j);
                if(j==45) {
                    tim2.stop();
                    tim3.start();
                    lblSplashText.setText("Starting Up...");
                    System.out.println("tim3 Started");
                }
            }
        });
        tim3 = new Timer(l,new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                j++;
                lblText.setText(""+j+"%");
                progSplash.setValue(j);
                if(j==75) {
                    tim3.stop();
                    tim4.start();
                    lblSplashText.setText("Creating Frame...");
                    System.out.println("tim4 Started");
                }
            }
        });
        tim4 = new Timer(m,new ActionListener(){
            public void actionPerformed(ActionEvent e)  {
                j++;
                lblText.setText(""+j+"%");
                progSplash.setValue(j);
                lblSplashText.setText("Just A Sec..");
                if(j==100) {
                    tim4.stop();
                    Dispose();
                    frmLogin frm;
                    try {
                        frm = new frmLogin();
                        frm.setVisible(true);
                    } catch (SQLException ex) {
                        Logger.getLogger(frmSplashScreen.class.getName()).log(Level.SEVERE, null, ex);
                    }
                   
                }
            }
        });
        tim1.start();
    }
    void Dispose() {
        CloseMinimise.close(this);
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblSplash = new javax.swing.JLabel();
        lblSplashText = new javax.swing.JLabel();
        progSplash = new javax.swing.JProgressBar();
        lblText = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 102, 102));
        setUndecorated(true);
        setResizable(false);

        lblSplash.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/SpalshPhoto.jpg"))); // NOI18N

        lblSplashText.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N

        progSplash.setBackground(new java.awt.Color(255, 255, 255));
        progSplash.setForeground(new java.awt.Color(0, 102, 102));
        progSplash.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);

        lblText.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        lblText.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblText.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        lblText.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblSplash, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblText, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblSplashText, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addComponent(progSplash, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(lblSplash, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblText, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(progSplash, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblSplashText, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(frmSplashScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmSplashScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmSplashScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmSplashScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new frmSplashScreen().setVisible(true);
                } 
                catch (InterruptedException ex) {
                    Logger.getLogger(frmSplashScreen.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(frmSplashScreen.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(frmSplashScreen.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lblSplash;
    private javax.swing.JLabel lblSplashText;
    private javax.swing.JLabel lblText;
    private javax.swing.JProgressBar progSplash;
    // End of variables declaration//GEN-END:variables
}
