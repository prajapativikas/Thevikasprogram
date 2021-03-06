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
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

/**
 *
 * @author sLD20-Admin
 */
public class office_add extends javax.swing.JFrame {

    /**
     * Creates new form office_add
     */
    public office_add() {
        initComponents();
        try {
            Image i = ImageIO.read(getClass().getResource("sls_logo.png"));
            setIconImage(i);
        } catch (IOException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.setTitle(Config.PRODUCTTITLE + "_" + Config.VERSION + " - Add Office (Current User : " + Config.currentUserFullName + ")");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblOfficeName = new javax.swing.JLabel();
        lblOfficeCode = new javax.swing.JLabel();
        btnSubmit = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();
        btnHome = new javax.swing.JButton();
        txtOfficeName = new javax.swing.JTextField();
        txtOffficeCode = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        lblOfficeName.setText("Office Name");

        lblOfficeCode.setText("Office Code");

        btnSubmit.setText("Submit");
        btnSubmit.setToolTipText("Click to add office");
        btnSubmit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubmitActionPerformed(evt);
            }
        });

        btnClear.setText("Clear");
        btnClear.setToolTipText("Click to clear office details");
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });

        btnHome.setText("Home");
        btnHome.setToolTipText("Click to go to home");
        btnHome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHomeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(67, 67, 67)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblOfficeCode)
                    .addComponent(lblOfficeName))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtOfficeName, javax.swing.GroupLayout.DEFAULT_SIZE, 105, Short.MAX_VALUE)
                    .addComponent(txtOffficeCode))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(136, Short.MAX_VALUE)
                .addComponent(btnSubmit)
                .addGap(18, 18, 18)
                .addComponent(btnClear)
                .addGap(18, 18, 18)
                .addComponent(btnHome)
                .addGap(47, 47, 47))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblOfficeName)
                    .addComponent(txtOfficeName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblOfficeCode)
                    .addComponent(txtOffficeCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSubmit)
                    .addComponent(btnClear)
                    .addComponent(btnHome))
                .addContainerGap(43, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnSubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubmitActionPerformed
        // TODO add your handling code here:
        try {
            if (txtOfficeName.getText().trim() != null && txtOfficeName.getText().trim().length() > 0) {
                if (txtOffficeCode.getText().trim() != null && txtOffficeCode.getText().trim().length() > 0) {
                    if (!isOfficeNameExist(txtOfficeName.getText().trim())) {
                        if (!isOfficeCodeExist(txtOffficeCode.getText().trim())) {

                            Class.forName("com.mysql.jdbc.Driver");

                            Connection con = DriverManager.getConnection("jdbc:mysql://" + Config.DBHOST + ":3306/" + Config.SCHEMANAME, Config.DBUSER, Config.DBPASS);
                            Statement st = con.createStatement();

                            // String product = cbProduct.getSelectedItem().toString().trim();
                            String name = txtOfficeName.getText().trim();
                            String code = txtOffficeCode.getText().trim();
                            //  code = getOfficeCodeByName(code);

                            String sql = "insert into office_master(office_code, "
                                    + "office_name) "
                                    + "values(?,?)";
                            System.out.println("query : " + sql);
                            PreparedStatement pre = con.prepareStatement(sql);
                            pre.setString(1, code);
                            pre.setString(2, name);
                            pre.executeUpdate();
                            pre.close();
                            con.close();
                            JOptionPane.showMessageDialog(this, "Office Added Succesfully","Office Added Succesfully",JOptionPane.INFORMATION_MESSAGE);
                            ClearFields();
                        } else {
                            JOptionPane.showMessageDialog(this, "office code already exist."
                                    + "\nPlease enter another office code.","Enter another office code",JOptionPane.WARNING_MESSAGE);
                            txtOffficeCode.requestFocus();
                        }
                    } else {
                        JOptionPane.showMessageDialog(this, "office name already exist."
                                + "\nPlease enter another office name.","Enter another office name",JOptionPane.WARNING_MESSAGE);

                        txtOfficeName.requestFocus();

                    }
                } else {
                    JOptionPane.showMessageDialog(this, "Please enter office code","Enter office code",JOptionPane.WARNING_MESSAGE);
                    txtOffficeCode.requestFocus();
                }

            } else {
                JOptionPane.showMessageDialog(this, "Please enter office name","Enter office name",JOptionPane.WARNING_MESSAGE);
                txtOfficeName.requestFocus();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }//GEN-LAST:event_btnSubmitActionPerformed

    private boolean isOfficeCodeExist(String officeCode) {
        boolean rv = true;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://" + Config.DBHOST + ":3306/" + Config.SCHEMANAME, Config.DBUSER, Config.DBPASS);
            String sql = "SELECT count(*) as total FROM office_master where office_code = '" + officeCode + "'";

            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int counter = rs.getInt("total");
                if (counter <= 0) {
                    rv = false;
                }
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return rv;
    }

//    private String getOfficeCodeByName(String officeName) {
//        String rv = "";
//        try {
//            Class.forName("com.mysql.jdbc.Driver");
//            Connection con = DriverManager.getConnection("jdbc:mysql://" + Config.DBHOST + ":3306/" + Config.SCHEMANAME, Config.DBUSER, Config.DBPASS);
//            String sql = "SELECT office_code FROM office_master where office_name ='" + officeName + "'";
//
//            PreparedStatement ps = con.prepareStatement(sql);
//            ResultSet rs = ps.executeQuery();
//
//            while (rs.next()) {
//                rv = rs.getString("office_code");
//            }
//            con.close();
//        } catch (ClassNotFoundException | SQLException e) {
//            e.printStackTrace();
//        }
//        return rv;
//    }

    private boolean isOfficeNameExist(String officeName) {
        boolean rv = true;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://" + Config.DBHOST + ":3306/" + Config.SCHEMANAME, Config.DBUSER, Config.DBPASS);
            String sql = "SELECT count(*) as total FROM office_master where lower(office_name) = '" + officeName.toLowerCase() + "'";

            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int counter = rs.getInt("total");
                if (counter <= 0) {
                    rv = false;
                }
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return rv;
    }

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        // TODO add your handling code here:
        ClearFields();
    }//GEN-LAST:event_btnClearActionPerformed

    private void btnHomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHomeActionPerformed
        // TODO add your handling code here:
        start_page start = new start_page();
        start.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnHomeActionPerformed
    private void ClearFields() {
        txtOfficeName.setText(null);
        txtOffficeCode.setText(null);
    }

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
            java.util.logging.Logger.getLogger(office_add.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(office_add.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(office_add.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(office_add.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new office_add().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnHome;
    private javax.swing.JButton btnSubmit;
    private javax.swing.JLabel lblOfficeCode;
    private javax.swing.JLabel lblOfficeName;
    private javax.swing.JTextField txtOffficeCode;
    private javax.swing.JTextField txtOfficeName;
    // End of variables declaration//GEN-END:variables
}
