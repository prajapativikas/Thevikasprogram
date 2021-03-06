/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slproject;

import java.awt.Image;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

/**
 *
 * @author lenovo
 */
public class Login extends javax.swing.JFrame {

    /**
     * Creates new form Login
     */
    public Login() {
        initComponents();
        //    JFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        //  setExtendedState(MAXIMIZED_BOTH);
        //     setLayout(new GridLayout(5,5,50,10));
        try {
            Image i = ImageIO.read(getClass().getResource("sls_logo.png"));
            setIconImage(i);
        } catch (IOException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        this.setTitle(Config.PRODUCTTITLE + "_" + Config.VERSION + " - Login");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        button1 = new java.awt.Button();
        lblHeading = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        label1 = new java.awt.Label();
        label2 = new java.awt.Label();
        pwd_password = new javax.swing.JPasswordField();
        txt_username = new java.awt.TextField();
        btnSubmit = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        jLabel1.setText("jLabel1");

        button1.setLabel("submit");
        button1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button1ActionPerformed(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("schoolsLENS Inventory System");
        setResizable(false);

        lblHeading.setFont(new java.awt.Font("Times New Roman", 3, 36)); // NOI18N
        lblHeading.setText("schoolsLENS  Inventory System");

        jPanel1.setName(""); // NOI18N

        label1.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        label1.setText("Username");

        label2.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        label2.setText("Password ");

        pwd_password.setToolTipText("enter the password");
        pwd_password.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pwd_passwordActionPerformed(evt);
            }
        });
        pwd_password.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                pwd_passwordKeyPressed(evt);
            }
        });

        txt_username.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_usernameActionPerformed(evt);
            }
        });

        btnSubmit.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnSubmit.setText("Submit");
        btnSubmit.setToolTipText("click to submit");
        btnSubmit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubmitActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnSubmit)
                    .addComponent(pwd_password, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_username, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(40, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_username, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(label2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pwd_password, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addComponent(btnSubmit)
                .addGap(36, 36, 36))
        );

        label2.getAccessibleContext().setAccessibleName("password");

        jLabel3.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        jLabel3.setText("Login");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(149, 149, 149))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(273, 273, 273))))
            .addGroup(layout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addComponent(lblHeading)
                .addGap(0, 59, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(lblHeading, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(27, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txt_usernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_usernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_usernameActionPerformed

    private void button1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button1ActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_button1ActionPerformed

    private void btnSubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubmitActionPerformed
        // TODO add your handling code here:
        try {
            if (txt_username.getText() != null
                    && txt_username.getText().trim().length() > 0 
                    && pwd_password.getPassword() != null 
                    && new String(pwd_password.getPassword()).trim().length() > 0) {
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://" + Config.DBHOST + ":3306/" + Config.SCHEMANAME, Config.DBUSER, Config.DBPASS);
                String pwd = new String(pwd_password.getPassword()).trim();
                String sql = "SELECT user_role, concat(user_f_name, \" \", user_l_name) as fullname "
                        + "FROM user_master where lower(username) = '" + txt_username.getText().trim().toLowerCase() + "' "
                        + "and password = '" + pwd + "' and active = 1";
       //         System.out.println("sql : " + sql);

//            PreparedStatement ps = con.prepareStatement(sql);
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery(sql);

                String user_role = "";
                while (rs.next()) {
                    user_role = rs.getString("user_role").trim();
                //    System.out.println("user_role is " + user_role);
                    Config.currentUserRole = user_role;
                    Config.currentUserFullName = rs.getString("fullname").trim();
                }

                if (user_role != null && user_role.trim().length() > 0) {
                    start_page start = new start_page();
                    start.setVisible(true);
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(this, "Username or password is incorrect", "Incorrect Credentials", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(this, "Username or password can not be left blank", "Blank Credentials", JOptionPane.WARNING_MESSAGE);
            }
        } //      System.out.println("slproject.Login.button1ActionPerformed()"+rs);
        catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Exception", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_btnSubmitActionPerformed

    private void pwd_passwordKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_pwd_passwordKeyPressed
        //JOptionPane.showMessageDialog(this, "evt.isActionKey() : " + evt.isActionKey());
        //System.out.println("key : " + evt.getKeyCode());
        if (evt.getKeyCode() == 10) {
            btnSubmit.doClick();
        }
    }//GEN-LAST:event_pwd_passwordKeyPressed

    private void pwd_passwordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pwd_passwordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pwd_passwordActionPerformed

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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSubmit;
    private java.awt.Button button1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private java.awt.Label label1;
    private java.awt.Label label2;
    private javax.swing.JLabel lblHeading;
    private javax.swing.JPasswordField pwd_password;
    private java.awt.TextField txt_username;
    // End of variables declaration//GEN-END:variables
}
