/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restoremultipledump;

import java.awt.HeadlessException;
import java.awt.Image;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

/**
 *
 * @author sLD20-Admin
 */
public class Directory extends javax.swing.JFrame {

    File selectedFile;

    public Directory() {
        initComponents();

        pb_process.setVisible(false);
     //   lbl_process.setVisible(false);
        try {
            Image i = ImageIO.read(getClass().getResource("sls_logo.png"));
            setIconImage(i);
        } catch (IOException ex) {
            Logger.getLogger(Directory.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblselect = new javax.swing.JLabel();
        cbselect = new javax.swing.JComboBox();
        lblpath = new javax.swing.JLabel();
        btnselect = new javax.swing.JButton();
        lbl_selected_path = new javax.swing.JLabel();
        btn_restore = new javax.swing.JButton();
        pb_process = new javax.swing.JProgressBar();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblselect.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblselect.setText("Schema");

        cbselect.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Select Schema", "fusion", "slquiz", "sledstudio" }));
        cbselect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbselectActionPerformed(evt);
            }
        });

        lblpath.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblpath.setText("Path");

        btnselect.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnselect.setText("Select Folder");
        btnselect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnselectActionPerformed(evt);
            }
        });

        btn_restore.setText("Restore");
        btn_restore.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_restoreActionPerformed(evt);
            }
        });

        pb_process.setForeground(new java.awt.Color(0, 204, 51));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblselect)
                            .addComponent(lblpath))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(cbselect, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnselect, javax.swing.GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btn_restore)
                                .addGap(0, 191, Short.MAX_VALUE))
                            .addComponent(lbl_selected_path, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(pb_process, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblselect)
                    .addComponent(cbselect, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(lblpath))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(btnselect, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(lbl_selected_path, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 71, Short.MAX_VALUE)
                .addComponent(pb_process, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23)
                .addComponent(btn_restore)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cbselectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbselectActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbselectActionPerformed

    private void btnselectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnselectActionPerformed
        try {
            final JFileChooser fileDialog = new JFileChooser();
            fileDialog.setAcceptAllFileFilterUsed(false);
            fileDialog.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            //fileDialog.addChoosableFileFilter(new FileNameExtensionFilter("Sql", "sql"));
            int returnVal = fileDialog.showOpenDialog(this);

            if (returnVal == JFileChooser.APPROVE_OPTION) {
                selectedFile = fileDialog.getSelectedFile();
                //JOptionPane.showMessageDialog(this, "You selected file : " + selectedFile.getAbsolutePath());
                lbl_selected_path.setText(selectedFile.getAbsolutePath());
                lbl_selected_path.setToolTipText(selectedFile.getAbsolutePath());
            } else {
                JOptionPane.showMessageDialog(this, "You cancelled folder selection.");
            }
        } catch (HeadlessException e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnselectActionPerformed

    private void btn_restoreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_restoreActionPerformed
        // TODO add your handling code here:

        new Thread() {
            public void run() {

//        lbl_process.setText("0 %");
                pb_process.setMinimum(0);
                pb_process.setMaximum(100);
                pb_process.setValue(0);
                pb_process.setVisible(true);
//        lbl_process.setVisible(true);
                pb_process.setStringPainted(true);
                repaint();
//        for (int i = 1; i <= 100; i++) {
////            lbl_process.setText(i + " %");
//            pb_process.setValue(i);
//            pb_process.setStringPainted(true);
//            System.out.println("Percentage : " + i);
////            try {
////                java.lang.Thread.sleep(2000);
////            } catch (InterruptedException ex) {
////                Logger.getLogger(Directory.class.getName()).log(Level.SEVERE, null, ex);
////            }
//        }

                if (cbselect.getSelectedIndex() != 0) {
                    if (selectedFile != null && selectedFile.exists() && selectedFile.isDirectory()) {
                        List<File> sqlFilesList = listSQLFilesOfDirecotry(selectedFile.getAbsolutePath().trim());

                        if (sqlFilesList != null && sqlFilesList.size() > 0) {
                            Iterator<File> itZip = sqlFilesList.iterator();
                            int i = 1;

//                    lbl_process.setText(0 + " %");
//                    pb_process.setValue(0);
//                    lbl_process.setVisible(true);
//                    pb_process.setVisible(true);
//                    pb_process.invalidate();
//                    pb_process.repaint();
                            while (itZip.hasNext()) {
//                        int percentage = ((i - 1) * 100) / sqlFilesList.size();
////                        lbl_process.setText(percentage + " %");
//                        pb_process.setValue(percentage);
//                        pb_process.setStringPainted(true);

                                String currentFilePath = itZip.next().getAbsolutePath().trim();
                                if (!currentFilePath.contains(" ")) {
                                    String currentSchema = null;
                                    currentSchema = cbselect.getSelectedItem().toString().trim() + "_" + i;

                                    if (currentSchema != null) {
                                        System.out.println(
                                                "Processing schema " + currentSchema + " from : " + selectedFile.getAbsolutePath());
                                        DBfunctions.createSchema(currentSchema);
                                        DBfunctions.restoreSQL(currentSchema, currentFilePath);
                                    }
                                }

                                int percentage = (i * 100) / sqlFilesList.size();
////                        lbl_process.setText(percentage + " %");
                                pb_process.setValue(percentage);
                                pb_process.setStringPainted(true);
                                repaint();
                                System.out.println("\n\nSetting Percentage : " + percentage + "\n");
//                        changePercentage(percentage);
                                i++;
                            }

                            pb_process.setValue(100);
                            pb_process.setStringPainted(true);
                            
                            JOptionPane.showMessageDialog(null, "SQL files restored...!!!");

                        } else {
                            JOptionPane.showMessageDialog(null, "No sql file found in folder");
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "please select file from the folder");
                    }

                } else {
                    JOptionPane.showMessageDialog(null, "Please select the schema");
                }
            }
        }.start();
    }//GEN-LAST:event_btn_restoreActionPerformed

    public void changePercentage(int per) {
        try {
            SwingUtilities.invokeLater(new Runnable() {
                public void run() {
                    if (per <= 100 && per >= 0) {
                        System.out.println("\n\nPercentage completed : " + per + "\n");
//                        lbl_process.setText(per + " %");
                        pb_process.setValue(per);
                        pb_process.setStringPainted(true);
                        repaint();
                    }
                }
            });
            java.lang.Thread.sleep(100);
        } catch (Exception e) {

        }
    }

    private static List<File> listSQLFilesOfDirecotry(String toString) {
        List<File> rv = new ArrayList<File>();
        try {
            File f = new File(toString);
            if (f.isDirectory()) {
                File fa[] = f.listFiles(new FilenameFilter() {
                    @Override
                    public boolean accept(File dir, String filename) {
                        return filename.endsWith(".sql");
                    }
                });
                rv = Arrays.asList(fa);
            }
        } catch (Exception e) {
            System.out.println("file is not available");
        }
        return rv;//To change body of generated methods, choose Tools | Templates.
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Directory().setVisible(true);
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_restore;
    private javax.swing.JButton btnselect;
    private javax.swing.JComboBox cbselect;
    private javax.swing.JLabel lbl_selected_path;
    private javax.swing.JLabel lblpath;
    private javax.swing.JLabel lblselect;
    private javax.swing.JProgressBar pb_process;
    // End of variables declaration//GEN-END:variables
}
