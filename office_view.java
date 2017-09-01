/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slproject;

import au.com.bytecode.opencsv.CSVWriter;
import java.awt.HeadlessException;
import java.awt.Image;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author sLD20-Admin
 */
public class office_view extends javax.swing.JFrame {

    /**
     * Creates new form office_view
     */
    public office_view() {
        initComponents();
        show_table();
        try {
            Image i = ImageIO.read(getClass().getResource("sls_logo.png"));
            setIconImage(i);
        } catch (IOException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.setTitle(Config.PRODUCTTITLE + "_" + Config.VERSION + " - Office List (Current User : " + Config.currentUserFullName + ")");
         tblOffice.setAutoCreateRowSorter(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnHomeOffice = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblOffice = new javax.swing.JTable();
        lblCountRecord = new javax.swing.JLabel();
        btnHome = new javax.swing.JButton();
        btnOfficeExport = new javax.swing.JButton();

        btnHomeOffice.setText("Home");
        btnHomeOffice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHomeOfficeActionPerformed(evt);
            }
        });

        jButton1.setText("Home");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        tblOffice.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Office Name", "Office Code"
            }
        ));
        tblOffice.setEnabled(false);
        jScrollPane1.setViewportView(tblOffice);

        btnHome.setText("Home");
        btnHome.setToolTipText("Click to go to home");
        btnHome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHomeActionPerformed(evt);
            }
        });

        btnOfficeExport.setText("Export Data");
        btnOfficeExport.setToolTipText("Click to export office list");
        btnOfficeExport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOfficeExportActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(15, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(154, 154, 154)
                        .addComponent(lblCountRecord)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addComponent(btnHome)
                .addGap(18, 18, 18)
                .addComponent(btnOfficeExport)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(13, Short.MAX_VALUE)
                .addComponent(lblCountRecord)
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnHome)
                    .addComponent(btnOfficeExport))
                .addGap(38, 38, 38)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33))
        );

        btnHome.getAccessibleContext().setAccessibleDescription("");
        btnOfficeExport.getAccessibleContext().setAccessibleDescription("");

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnHomeOfficeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHomeOfficeActionPerformed

    }//GEN-LAST:event_btnHomeOfficeActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        start_page start = new start_page();
        start.setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnHomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHomeActionPerformed
        // TODO add your handling code here:
        start_page start = new start_page();
        start.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnHomeActionPerformed

    private void btnOfficeExportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOfficeExportActionPerformed
        // TODO add your handling code here:
         try {
            File selectedFile = null;
            final JFileChooser fileDialog = new JFileChooser();
            fileDialog.setAcceptAllFileFilterUsed(false);
            fileDialog.addChoosableFileFilter(new FileNameExtensionFilter("CSV", "csv"));
            int returnVal = fileDialog.showSaveDialog(this);

            if (returnVal == JFileChooser.APPROVE_OPTION) {
                selectedFile = fileDialog.getSelectedFile();
                System.out.println("selected file is" + selectedFile);

                if (selectedFile.getAbsolutePath().contains(".")) {
                    if (selectedFile.getAbsolutePath().endsWith(".csv")) {
                        exportCSV(selectedFile);
                    } else {
                        JOptionPane.showMessageDialog(this, "You can export CSV file only","CSV only",JOptionPane.WARNING_MESSAGE);
                    }
                } else {
                    selectedFile = new File(selectedFile.getAbsolutePath() + ".csv");
                    exportCSV(selectedFile);
                }
            }
        } catch (HeadlessException e) {
            JOptionPane.showMessageDialog(this, e.getMessage(),"Exception",JOptionPane.ERROR_MESSAGE);
        }
         
    }//GEN-LAST:event_btnOfficeExportActionPerformed
   
     private void exportCSV(File selectedFile) {
        try {
            DefaultTableModel model = (DefaultTableModel) tblOffice.getModel();
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://" + Config.DBHOST + ":3306/" + Config.SCHEMANAME, Config.DBUSER, Config.DBPASS);
//            if (model.getRowCount() > 0) {
//                for (int i = model.getRowCount() - 1; i > -1; i--) {
//                    model.removeRow(0);
//                }
//            }

//             String sql = "select * from allot_table where name = '"+jComboBox1.getSelectedItem().toString()+"' and p_type = '"+jComboBox2.getSelectedItem().toString()+"'";
          String sql = "SELECT office_name, "
                    + "office_code FROM "
                    + "office_master";

            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            try (CSVWriter writer = new CSVWriter(new FileWriter(selectedFile), ',', CSVWriter.NO_QUOTE_CHARACTER)) {
                writer.writeAll(rs, true);
                writer.close();
            }
            
            JOptionPane.showMessageDialog(this, "Office list exported","Office list exported",JOptionPane.INFORMATION_MESSAGE);
            
        } catch (HeadlessException | IOException | ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(this, e.getMessage(),"Exception",JOptionPane.ERROR_MESSAGE);
        }
    }
    private void show_table() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://" + Config.DBHOST + ":3306/" + Config.SCHEMANAME, Config.DBUSER, Config.DBPASS);
            String sql = "SELECT office_name, "
                    + "office_code FROM "
                    + "office_master";

            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            int i = 0;
            tblOffice.removeAll();
            while (rs.next()) {
                
                 String office_name = rs.getString("office_name");
                  String office_code = rs.getString("office_code");
               

                DefaultTableModel model = (DefaultTableModel) tblOffice.getModel();
                model.addRow(new Object[]{office_name, office_code});
                i++;
            }
            lblCountRecord.setText("Records Count : " + i);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage(),"Exception",JOptionPane.ERROR_MESSAGE);
        }
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
            java.util.logging.Logger.getLogger(office_view.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(office_view.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(office_view.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(office_view.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new office_view().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnHome;
    private javax.swing.JButton btnHomeOffice;
    private javax.swing.JButton btnOfficeExport;
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblCountRecord;
    private javax.swing.JTable tblOffice;
    // End of variables declaration//GEN-END:variables
}
