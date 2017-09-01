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
public class inventory_view extends javax.swing.JFrame {

    /**
     * Creates new form inventory_view
     */
    public inventory_view() {
        initComponents();
        show_table();
        try {
            Image i = ImageIO.read(getClass().getResource("sls_logo.png"));
            setIconImage(i);
        } catch (IOException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.setTitle(Config.PRODUCTTITLE + "_" + Config.VERSION + " - Inventory List (Current User : " + Config.currentUserFullName + ")");
        tableInventory.setAutoCreateRowSorter(true);
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
        jScrollPane1 = new javax.swing.JScrollPane();
        tableInventory = new javax.swing.JTable();
        lblCountRecord = new javax.swing.JLabel();
        btnHome = new javax.swing.JButton();
        btnExportInventory = new javax.swing.JButton();

        jLabel1.setText("jLabel1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        tableInventory.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Inventory Name", "Inventory Code"
            }
        ));
        tableInventory.setEnabled(false);
        jScrollPane1.setViewportView(tableInventory);

        btnHome.setText("Home");
        btnHome.setToolTipText("Click to go to home");
        btnHome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHomeActionPerformed(evt);
            }
        });

        btnExportInventory.setText("Export Data");
        btnExportInventory.setToolTipText("Click to inventory list");
        btnExportInventory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExportInventoryActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(65, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnHome)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(72, 72, 72)
                                .addComponent(lblCountRecord))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(btnExportInventory)))
                        .addContainerGap(239, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(58, 58, 58))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnHome)
                    .addComponent(btnExportInventory))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblCountRecord)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        btnExportInventory.getAccessibleContext().setAccessibleDescription("");

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnHomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHomeActionPerformed
        // TODO add your handling code here: 
        start_page start = new start_page();
        start.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnHomeActionPerformed

    private void btnExportInventoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExportInventoryActionPerformed
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
         
             
    }//GEN-LAST:event_btnExportInventoryActionPerformed

private void exportCSV(File selectedFile) {
        try {
            DefaultTableModel model = (DefaultTableModel) tableInventory.getModel();
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://" + Config.DBHOST + ":3306/" + Config.SCHEMANAME, Config.DBUSER, Config.DBPASS);
//            if (model.getRowCount() > 0) {
//                for (int i = model.getRowCount() - 1; i > -1; i--) {
//                    model.removeRow(0);
//                }
//            }

//             String sql = "select * from allot_table where name = '"+jComboBox1.getSelectedItem().toString()+"' and p_type = '"+jComboBox2.getSelectedItem().toString()+"'";
          String sql = "SELECT * FROM inventory_master";

            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            try (CSVWriter writer = new CSVWriter(new FileWriter(selectedFile), ',', CSVWriter.NO_QUOTE_CHARACTER)) {
                writer.writeAll(rs, true);
                writer.close();
            }
            
            JOptionPane.showMessageDialog(this, "Inventory data exported","Inventory exported",JOptionPane.INFORMATION_MESSAGE);
            
        } catch (HeadlessException | IOException | ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(this, e.getMessage(),"Exception",JOptionPane.ERROR_MESSAGE);
        }
    }



private void show_table() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://" + Config.DBHOST + ":3306/" + Config.SCHEMANAME, Config.DBUSER, Config.DBPASS);
            String sql = "SELECT * FROM inventory_master";

            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            int i = 0;
            tableInventory.removeAll();
            while (rs.next()) {
                
                String inv_name = rs.getString("inv_name");
                String inv_code = rs.getString("inv_code");
             

                DefaultTableModel model = (DefaultTableModel) tableInventory.getModel();
                model.addRow(new Object[]{inv_name, inv_code});
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
            java.util.logging.Logger.getLogger(inventory_view.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(inventory_view.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(inventory_view.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(inventory_view.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new inventory_view().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnExportInventory;
    private javax.swing.JButton btnHome;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblCountRecord;
    private javax.swing.JTable tableInventory;
    // End of variables declaration//GEN-END:variables
}