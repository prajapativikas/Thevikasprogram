
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slproject;

import java.awt.HeadlessException;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author sLD20-Admin
 */
public class user_add extends javax.swing.JFrame {

    /**
     * Creates new form user_add
     */
    File selectedBulkCSVFile = null;

    public user_add() {
        initComponents();
        try {
            Image i = ImageIO.read(getClass().getResource("sls_logo.png"));
            setIconImage(i);
        } catch (IOException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.setTitle(Config.PRODUCTTITLE + "_" + Config.VERSION + " - Add User (Current User : " + Config.currentUserFullName + ")");
        fetchOffice();

        btnBulkSubmit.setEnabled(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        lblEmpCode = new javax.swing.JLabel();
        txtempcode = new javax.swing.JTextField();
        lblFirst_Name = new javax.swing.JLabel();
        txtFirst_name = new javax.swing.JTextField();
        lblLast_name = new javax.swing.JLabel();
        txtLastname = new javax.swing.JTextField();
        lblContactNo = new javax.swing.JLabel();
        txtContactNo = new javax.swing.JTextField();
        lblOffice = new javax.swing.JLabel();
        lblUser_rolr = new javax.swing.JLabel();
        txtUserrole = new javax.swing.JTextField();
        lblUse_Name = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtUsername = new javax.swing.JTextField();
        cbOffice = new javax.swing.JComboBox();
        btnSubmitUser = new javax.swing.JButton();
        btnClearUser = new javax.swing.JButton();
        btnHome = new javax.swing.JButton();
        txtPassword = new javax.swing.JPasswordField();
        lblBulkHeading = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        btnSelectBulkCSV = new javax.swing.JButton();
        btnBulkSubmit = new javax.swing.JButton();
        lblSelectedCSVPath = new javax.swing.JLabel();
        btnCSVFields = new javax.swing.JButton();

        jLabel3.setText("jLabel3");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        lblEmpCode.setText("Employee Code");

        lblFirst_Name.setText("First Name");

        lblLast_name.setText("Last Name");

        lblContactNo.setText("Contact No.");

        lblOffice.setText("Office");

        lblUser_rolr.setText("User Role");

        lblUse_Name.setText("Username");

        jLabel7.setText("Password");

        cbOffice.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Select Office" }));
        cbOffice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbOfficeActionPerformed(evt);
            }
        });

        btnSubmitUser.setText("Submit");
        btnSubmitUser.setToolTipText("click to submit");
        btnSubmitUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubmitUserActionPerformed(evt);
            }
        });

        btnClearUser.setText("Clear");
        btnClearUser.setToolTipText("click to clear");
        btnClearUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearUserActionPerformed(evt);
            }
        });

        btnHome.setText("Home");
        btnHome.setToolTipText("Click to go to home");
        btnHome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHomeActionPerformed(evt);
            }
        });

        lblBulkHeading.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblBulkHeading.setText("Bulk Entry (From CSV)");

        jLabel1.setText("Select CSV File");

        btnSelectBulkCSV.setText("Select CSV");
        btnSelectBulkCSV.setToolTipText("Select CSV file for users");
        btnSelectBulkCSV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSelectBulkCSVActionPerformed(evt);
            }
        });

        btnBulkSubmit.setText("Submit");
        btnBulkSubmit.setToolTipText("Add users from selected CSV file");
        btnBulkSubmit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBulkSubmitActionPerformed(evt);
            }
        });

        btnCSVFields.setText("CSV Fields");
        btnCSVFields.setToolTipText("Fields required in CSV");
        btnCSVFields.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCSVFieldsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(163, 163, 163)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblBulkHeading)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnSubmitUser)
                                .addGap(18, 18, 18)
                                .addComponent(btnClearUser)
                                .addGap(18, 18, 18)
                                .addComponent(btnHome))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblSelectedCSVPath, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblFirst_Name)
                                    .addComponent(lblLast_name)
                                    .addComponent(lblContactNo)
                                    .addComponent(lblEmpCode, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel1))
                                .addGap(9, 9, 9)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(txtempcode)
                                            .addComponent(txtFirst_name)
                                            .addComponent(txtLastname)
                                            .addComponent(txtContactNo, javax.swing.GroupLayout.DEFAULT_SIZE, 86, Short.MAX_VALUE))
                                        .addGap(64, 64, 64)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(lblUser_rolr, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(lblOffice, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(lblUse_Name, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(txtUserrole, javax.swing.GroupLayout.DEFAULT_SIZE, 99, Short.MAX_VALUE)
                                                .addComponent(txtUsername)
                                                .addComponent(txtPassword))
                                            .addComponent(cbOffice, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(btnSelectBulkCSV)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnBulkSubmit)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnCSVFields)))))))
                .addContainerGap(79, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblEmpCode)
                    .addComponent(txtempcode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblOffice)
                    .addComponent(cbOffice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblFirst_Name)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtFirst_name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblUser_rolr)
                        .addComponent(txtUserrole, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblLast_name)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtLastname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblUse_Name)
                        .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblContactNo)
                    .addComponent(txtContactNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel7)
                        .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSubmitUser)
                    .addComponent(btnClearUser)
                    .addComponent(btnHome))
                .addGap(18, 18, 18)
                .addComponent(lblBulkHeading)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(btnSelectBulkCSV)
                    .addComponent(btnBulkSubmit)
                    .addComponent(btnCSVFields))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblSelectedCSVPath, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnSubmitUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubmitUserActionPerformed
        // TODO add your handling code here:
        try {
            if (txtempcode.getText() != null && txtempcode.getText().trim().length() > 0) {
                if (txtFirst_name.getText() != null && txtFirst_name.getText().trim().length() > 0) {
                    if (txtLastname.getText() != null && txtLastname.getText().trim().length() > 0) {
//                        if (txtContactNo.getText() != null && txtContactNo.getText().trim().length() == 10) {
                        if (cbOffice.getSelectedIndex() != 0) {
//                                if (txtUserrole.getText() != null && txtUserrole.getText().trim().length() > 0) {
//                                    if (txtUsername.getText() != null && txtUsername.getText().trim().length() > 0) {
//                                        if (txtPassword.getPassword() != null && new String(txtPassword.getPassword()).trim().length() > 0) {
                            if (!isEmpCodeExist(txtempcode.getText().trim())) {
//                                                if (!isUsernameExist(txtUsername.getText().trim())) {
                                Class.forName("com.mysql.jdbc.Driver");

                                Connection con = DriverManager.getConnection("jdbc:mysql://" + Config.DBHOST + ":3306/" + Config.SCHEMANAME, Config.DBUSER, Config.DBPASS);
                                Statement st = con.createStatement();
                                String Employee_Code = txtempcode.getText().trim();
                                String First_Name = txtFirst_name.getText().trim();
                                String Last_Name = txtLastname.getText().trim();
                                String Contact_No = txtContactNo.getText().trim();
                                String Office = cbOffice.getSelectedItem().toString().trim();
                                String User_Role = txtUserrole.getText().trim();
                                String Username = txtUsername.getText().trim();
                                String Password = new String(txtPassword.getPassword()).trim();

                                Office = getOfficeCodeByName(Office);

                                String sql = "insert into user_master(emp_code,user_f_name,user_l_name,"
                                        + "user_contact,office_code,user_role,username,password,active) "
                                        + "values(?,?,?,?,?,?,?,?,?)";
                                System.out.println("query : " + sql);
                                PreparedStatement pre = con.prepareStatement(sql);
                                pre.setString(1, Employee_Code);
                                pre.setString(2, First_Name);
                                pre.setString(3, Last_Name);
                                pre.setString(4, Contact_No);
                                pre.setString(5, Office);
                                pre.setString(6, User_Role);
                                pre.setString(7, Username);
                                pre.setString(8, Password);
                                pre.setInt(9, 1);
                                pre.executeUpdate();

                                pre.close();
                                con.close();
                                JOptionPane.showMessageDialog(this, "User Added Succesfully","User Added Succesfully",JOptionPane.INFORMATION_MESSAGE);

                                clearFields();

//                                                } else {
//                                                    JOptionPane.showMessageDialog(this, "Username already exist."
//                                                            + "\nPlease enter another Username.");
//                                                    txtUsername.requestFocus();
//                                                }
                            } else {
                                JOptionPane.showMessageDialog(this, "Employee code already exist."
                                        + "\nPlease enter another employee code.","Enter another employee code",JOptionPane.WARNING_MESSAGE);
                                txtempcode.requestFocus();
                            }
//                                        } else {
//                                            JOptionPane.showMessageDialog(this, "Please enter password");
//                                            txtPassword.requestFocus();
//                                        }
//                                    } else {
//                                        JOptionPane.showMessageDialog(this, "Please enter username");
//                                        txtUsername.requestFocus();
//                                    }
//                                } else {
//                                    JOptionPane.showMessageDialog(this, "Please enter user role");
//                                    txtUserrole.requestFocus();
//                                }
                        } else {
                            JOptionPane.showMessageDialog(this, "Please select office","Select Office",JOptionPane.WARNING_MESSAGE);
                            cbOffice.requestFocus();
                        }
//                        } else {
//                            JOptionPane.showMessageDialog(this, "Please enter 10 digit mobile number");
//                            txtContactNo.requestFocus();
//                        }
                    } else {
                        JOptionPane.showMessageDialog(this, "Please enter last name","Enter last name",JOptionPane.WARNING_MESSAGE);
                        txtLastname.requestFocus();
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "Please enter first name","Enter first name",JOptionPane.WARNING_MESSAGE);
                    txtFirst_name.requestFocus();
                }

            } else {
                JOptionPane.showMessageDialog(this, "Please enter empoyee code","Enter employee code",JOptionPane.WARNING_MESSAGE);
                txtempcode.requestFocus();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnSubmitUserActionPerformed

    private void btnHomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHomeActionPerformed
        // TODO add your handling code here:
        start_page start = new start_page();
        start.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnHomeActionPerformed

    private void btnClearUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearUserActionPerformed
        // TODO add your handling code here:
        clearFields();
    }//GEN-LAST:event_btnClearUserActionPerformed

    private void cbOfficeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbOfficeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbOfficeActionPerformed

    private void btnSelectBulkCSVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSelectBulkCSVActionPerformed
        try {
            final JFileChooser fileDialog = new JFileChooser();
            fileDialog.setAcceptAllFileFilterUsed(false);
            fileDialog.addChoosableFileFilter(new FileNameExtensionFilter("CSV", "csv"));
            int returnVal = fileDialog.showOpenDialog(this);

            if (returnVal == JFileChooser.APPROVE_OPTION) {
                selectedBulkCSVFile = fileDialog.getSelectedFile();
                lblSelectedCSVPath.setText("Selected CSV File : " + selectedBulkCSVFile.getAbsolutePath());
                btnBulkSubmit.setEnabled(true);
            } else {
                //JOptionPane.showMessageDialog(this, "You cancelled image selection.");
                selectedBulkCSVFile = null;
                btnBulkSubmit.setEnabled(false);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnSelectBulkCSVActionPerformed

    @SuppressWarnings("CallToPrintStackTrace")
    private void btnBulkSubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBulkSubmitActionPerformed
        Connection con = null;
        try {
            if (selectedBulkCSVFile != null && selectedBulkCSVFile.exists()) {
                Class.forName("com.mysql.jdbc.Driver");

                con = DriverManager.getConnection("jdbc:mysql://" + Config.DBHOST + ":3306/" + Config.SCHEMANAME, Config.DBUSER, Config.DBPASS);
                Statement st = con.createStatement();
                @SuppressWarnings("UnusedAssignment")
                int recordsInserted = 0;

                String path = selectedBulkCSVFile.getAbsolutePath();
                path = path.replaceAll(Matcher.quoteReplacement("\\"), Matcher.quoteReplacement("\\\\"));
                String query = "LOAD DATA LOCAL infile '" + path + "' "
                        + "INTO TABLE user_master "
                        + "fields terminated BY \",\" "
                        + "lines terminated BY \"\\n\" "
                        + "(" + Config.BULKUSERFIELDS + ")";
                //System.out.println("Query to insert bulk products : " + query);
                recordsInserted = st.executeUpdate(query);
                con.close();
                JOptionPane.showMessageDialog(this, recordsInserted + " records inserted.","Records inserted",JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (ClassNotFoundException | SQLException | HeadlessException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Some problem in inserting bulk records.\n\n"
                    + "Possible Reasons:\n"
                    + "1. CSV format might be wrong\n"
                    + "2. Records might be already exist","Exception",JOptionPane.ERROR_MESSAGE);
        } finally {
            selectedBulkCSVFile = null;
            lblSelectedCSVPath.setText(null);
            btnBulkSubmit.setEnabled(false);
            try {
                con.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }//GEN-LAST:event_btnBulkSubmitActionPerformed

    private void btnCSVFieldsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCSVFieldsActionPerformed
        JOptionPane.showMessageDialog(this, "Fields required to insert users in bulk;\n\n"
                + Config.BULKUSERFIELDS,"Required fields for bulk entry",JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_btnCSVFieldsActionPerformed

    public void clearFields() {

        txtempcode.setText("");
        txtFirst_name.setText("");
        txtLastname.setText("");
        txtContactNo.setText("");
        txtUserrole.setText("");
        txtUsername.setText("");
        txtPassword.setText("");
        cbOffice.setSelectedIndex(0);
    }

    private void fetchOffice() //FETCH VALUE IN COMBOBOX
    {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://" + Config.DBHOST + ":3306/" + Config.SCHEMANAME, Config.DBUSER, Config.DBPASS);
            String sql = "SELECT office_name FROM office_master";

            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                String office_name = rs.getString("office_name");
                cbOffice.addItem(office_name);
//                String inv_code = rs.getString("inv_code");
//                jComboBox2.addItem(inv_code);
            }

        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(this, e.getMessage(),"Exception",JOptionPane.ERROR_MESSAGE);
        }
    }

    private boolean isUsernameExist(String username) {
        boolean rv = true;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://" + Config.DBHOST + ":3306/" + Config.SCHEMANAME, Config.DBUSER, Config.DBPASS);
            String sql = "SELECT count(*) as total FROM user_master where username = '" + username + "'";

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

    private boolean isEmpCodeExist(String empCode) {
        boolean rv = true;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://" + Config.DBHOST + ":3306/" + Config.SCHEMANAME, Config.DBUSER, Config.DBPASS);
            String sql = "SELECT count(*) as total FROM user_master where emp_code = '" + empCode + "'";

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

    private String getOfficeCodeByName(String officeName) {
        String rv = "";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://" + Config.DBHOST + ":3306/" + Config.SCHEMANAME, Config.DBUSER, Config.DBPASS);
            String sql = "SELECT office_code FROM office_master where office_name ='" + officeName + "'";

            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                rv = rs.getString("office_code");
            }
            con.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return rv;
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
            java.util.logging.Logger.getLogger(user_add.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(user_add.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(user_add.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(user_add.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new user_add().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBulkSubmit;
    private javax.swing.JButton btnCSVFields;
    private javax.swing.JButton btnClearUser;
    private javax.swing.JButton btnHome;
    private javax.swing.JButton btnSelectBulkCSV;
    private javax.swing.JButton btnSubmitUser;
    private javax.swing.JComboBox cbOffice;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel lblBulkHeading;
    private javax.swing.JLabel lblContactNo;
    private javax.swing.JLabel lblEmpCode;
    private javax.swing.JLabel lblFirst_Name;
    private javax.swing.JLabel lblLast_name;
    private javax.swing.JLabel lblOffice;
    private javax.swing.JLabel lblSelectedCSVPath;
    private javax.swing.JLabel lblUse_Name;
    private javax.swing.JLabel lblUser_rolr;
    private javax.swing.JTextField txtContactNo;
    private javax.swing.JTextField txtFirst_name;
    private javax.swing.JTextField txtLastname;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtUsername;
    private javax.swing.JTextField txtUserrole;
    private javax.swing.JTextField txtempcode;
    // End of variables declaration//GEN-END:variables
}
