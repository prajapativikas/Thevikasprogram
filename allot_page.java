package slproject;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author nimbus
 */
public class allot_page extends javax.swing.JFrame {

    /**
     * Creates new form allot_page
     */
    SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd");
    String currentImgPath;

    public allot_page() {
        initComponents();

        try {
            Image i = ImageIO.read(getClass().getResource("sls_logo.png"));
            setIconImage(i);
        } catch (IOException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.setTitle(Config.PRODUCTTITLE + "_" + Config.VERSION + " - Allot Product (Current User : " + Config.currentUserFullName + ")");
        hideButtons();
        btnAllotProduct.getParent().setLayout(null);
        btnAllotProduct.setBounds(230, 324, 110, 28);
        btnAllotProduct.setVisible(true);
        cbTaskToDo.setSelectedIndex(0);
       
        fetchProductNames();
        if (cbProductName.getSelectedItem() != null && cbProductName.getSelectedItem().toString().trim().length() > 0) {
            fetchProductIds(cbProductName.getSelectedItem().toString());
        }

        cbRequestBy.setEnabled(false);
        cbAllotTo.setEnabled(false);

        jxdpDate.setFormats(formater);
        jxdpDate.getEditor().setEditable(false);

        //To set the upper bound (Blocking future dates)
        Calendar calendar = jxdpDate.getMonthView().getCalendar();
        calendar.setTime(new Date());
        jxdpDate.getMonthView().setUpperBound(calendar.getTime());

        //Break Down Button
//        btnBreakDownProduct.getParent().setLayout(null);
//        btnBreakDownProduct.setBounds(200, 324, 150, 28);
        //Break Down Button
        //Re-Allot Button
//        btnReAllotProduct.getParent().setLayout(null);
//        btnReAllotProduct.setBounds(220, 324, 130, 28);
        //Re-Allot Button
        //Un-Allot Button
//        btnUnAllotProduct.getParent().setLayout(null);
//        btnUnAllotProduct.setBounds(220, 324, 130, 28);
        //Un-Allot Button
    }

    private void clearFieldOnDDChange() {
        jxdpDate.setDate(null);
        lblModelNo.setText("");
        lblSerialNo.setText("");
        cbRequestBy.removeAllItems();
        cbRequestBy.setEnabled(false);
        cbAllotTo.removeAllItems();
        cbAllotTo.setEnabled(false);
        taComment.setText("");
        lblImage.setIcon(null);
        lblAllotedDate.setText("");
        lblDisplayDate.setText("");
    }

    private void hideButtons() {
        btnAllotProduct.setVisible(false);
        btnReAllotProduct.setVisible(false);
        btnUnAllotProduct.setVisible(false);
        btnBreakDownProduct.setVisible(false);
        btnRepairProduct.setVisible(false);
    }

    private void clearFields(boolean productDropdown) {
        jxdpDate.setDate(null);
        lblModelNo.setText("");
        lblSerialNo.setText(null);
        cbRequestBy.setEnabled(false);
        cbAllotTo.setEnabled(false);
        taComment.setText("");
        lblImage.setIcon(null);
        lblAllotedDate.setText("");
        lblDisplayDate.setText("");

        try {
            if (productDropdown) {
                cbProductName.setSelectedIndex(0);
            }
        } catch (Exception e) {

        }
    }

    private void fillRequestByAndAllotToCombo() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://" + Config.DBHOST + ":3306/" + Config.SCHEMANAME, Config.DBUSER, Config.DBPASS);
            String id = "SELECT concat(user_f_name, \" \", user_l_name) as fullname FROM user_master where active = 1";
            PreparedStatement ps = con.prepareStatement(id);
            ResultSet rs = ps.executeQuery();

            cbRequestBy.removeAllItems();
            cbAllotTo.removeAllItems();
            while (rs.next()) {
                String name = rs.getString(1);
                cbRequestBy.addItem(name);
                cbAllotTo.addItem(name);
            }

            cbRequestBy.setEnabled(true);
            cbAllotTo.setEnabled(true);
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("[fetchProductNames] Problem : " + e.getMessage());
        }
    }

    private void fetchProductNames() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://" + Config.DBHOST + ":3306/" + Config.SCHEMANAME, Config.DBUSER, Config.DBPASS);
            String query = "";
            if (cbTaskToDo.getSelectedIndex() == 0 || cbTaskToDo.getSelectedIndex() == 3) {
                query = "select distinct name from purchase_table where status = 0 and break = 0";
            } else if (cbTaskToDo.getSelectedIndex() == 1 || cbTaskToDo.getSelectedIndex() == 2) {
                query = "select distinct name from purchase_table where status = 1";
            } else if (cbTaskToDo.getSelectedIndex() == 4) {
                query = "select distinct name from purchase_table where break = 1";
            }
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            cbProductName.removeAllItems();
            while (rs.next()) {
                String name = rs.getString(1);
                cbProductName.addItem(name);

            }
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("[fetch_data] Problem : " + e.getMessage());
        }
    }

    private void fetchProductIds(String productName) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://" + Config.DBHOST + ":3306/" + Config.SCHEMANAME, Config.DBUSER, Config.DBPASS);
            String id = "";
            if (cbTaskToDo.getSelectedIndex() == 0 || cbTaskToDo.getSelectedIndex() == 3) {
                id = "select id_no from purchase_table where name = '" + productName.trim() + "' "
                        + "and status = 0 and break = 0 and active = 1";
            } else if (cbTaskToDo.getSelectedIndex() == 1 || cbTaskToDo.getSelectedIndex() == 2) {
                id = "select id_no from purchase_table where name = '" + productName.trim() + "' "
                        + "and status = 1 and active = 1";
            } else if (cbTaskToDo.getSelectedIndex() == 4) {
                id = "select id_no from purchase_table where name = '" + productName.trim() + "' "
                        + "and break = 1 and active = 1";
            }
            PreparedStatement ps = con.prepareStatement(id);
            ResultSet rs = ps.executeQuery();

            cbProductIdNo.removeAllItems();
            while (rs.next()) {
                String name = rs.getString(1);
                cbProductIdNo.addItem(name);

            }
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("[fetch_data] Problem : " + e.getMessage());
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField2 = new javax.swing.JTextField();
        lblId = new javax.swing.JLabel();
        lblName = new javax.swing.JLabel();
        lblDate = new javax.swing.JLabel();
        lblModel = new javax.swing.JLabel();
        lblSerial = new javax.swing.JLabel();
        lblComment = new javax.swing.JLabel();
        btnAllotProduct = new javax.swing.JButton();
        btnShow = new javax.swing.JButton();
        cbProductIdNo = new javax.swing.JComboBox();
        btnBreakDownProduct = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        taComment = new javax.swing.JTextArea();
        lblRequest = new javax.swing.JLabel();
        btnHome = new javax.swing.JButton();
        jxdpDate = new org.jdesktop.swingx.JXDatePicker();
        lblAllotTo = new javax.swing.JLabel();
        lblImgText = new javax.swing.JLabel();
        lblImage = new javax.swing.JLabel();
        cbProductName = new javax.swing.JComboBox();
        cbRequestBy = new javax.swing.JComboBox();
        cbAllotTo = new javax.swing.JComboBox();
        lblModelNo = new javax.swing.JLabel();
        lblSerialNo = new javax.swing.JLabel();
        lblTask = new javax.swing.JLabel();
        cbTaskToDo = new javax.swing.JComboBox();
        btnReAllotProduct = new javax.swing.JButton();
        btnUnAllotProduct = new javax.swing.JButton();
        btnRepairProduct = new javax.swing.JButton();
        lblAllotedDate = new javax.swing.JLabel();
        lblDisplayDate = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Allot Product");
        setResizable(false);

        lblId.setText("Id");

        lblName.setText("Name");

        lblDate.setText("Date");

        lblModel.setText("Model No.");

        lblSerial.setText("Serial No.");

        lblComment.setText("Comment");

        btnAllotProduct.setText("Allot Product");
        btnAllotProduct.setToolTipText("Click to allot product");
        btnAllotProduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAllotProductActionPerformed(evt);
            }
        });

        btnShow.setText("Show");
        btnShow.setToolTipText("Click to show product details");
        btnShow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnShowActionPerformed(evt);
            }
        });

        cbProductIdNo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbProductIdNoActionPerformed(evt);
            }
        });

        btnBreakDownProduct.setText("Break Down Product");
        btnBreakDownProduct.setToolTipText("Click to breadown product");
        btnBreakDownProduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBreakDownProductActionPerformed(evt);
            }
        });

        taComment.setColumns(20);
        taComment.setRows(5);
        taComment.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                taCommentMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(taComment);

        lblRequest.setText("Request By");

        btnHome.setText("Home");
        btnHome.setToolTipText("Click to go to home");
        btnHome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHomeActionPerformed(evt);
            }
        });

        jxdpDate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jxdpDateActionPerformed(evt);
            }
        });

        lblAllotTo.setText("Allot To");

        lblImgText.setText("Image");

        lblImage.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblImageMouseClicked(evt);
            }
        });

        cbProductName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbProductNameActionPerformed(evt);
            }
        });

        cbRequestBy.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Requested By" }));

        cbAllotTo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Allot To" }));

        lblTask.setText("Task To Do");

        cbTaskToDo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Allot Product", "Un-Allot Product", "Re-Allot Product", "Break Down Product", "Repair Product" }));
        cbTaskToDo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbTaskToDoActionPerformed(evt);
            }
        });

        btnReAllotProduct.setText("Re-Allot Product");
        btnReAllotProduct.setToolTipText("Click to reallot product");
        btnReAllotProduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReAllotProductActionPerformed(evt);
            }
        });

        btnUnAllotProduct.setText("Un-Allot Product");
        btnUnAllotProduct.setToolTipText("Click to unallot product");
        btnUnAllotProduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUnAllotProductActionPerformed(evt);
            }
        });

        btnRepairProduct.setText("Repair Product");
        btnRepairProduct.setToolTipText("Click to repair product");
        btnRepairProduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRepairProductActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblTask)
                        .addGap(25, 25, 25)
                        .addComponent(cbTaskToDo, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)
                        .addComponent(lblName)
                        .addGap(47, 47, 47)
                        .addComponent(cbProductName, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnShow, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(lblModel)
                                                .addComponent(lblRequest)
                                                .addComponent(lblComment)
                                                .addComponent(lblDate))
                                            .addGap(27, 27, 27))
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(lblAllotedDate, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(18, 18, 18)))
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(lblDisplayDate, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(lblModelNo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(cbRequestBy, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jxdpDate, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 153, Short.MAX_VALUE)))
                                    .addGap(21, 21, 21)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(lblImgText)
                                        .addComponent(lblSerial)
                                        .addComponent(lblAllotTo)
                                        .addComponent(lblId, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(9, 9, 9))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(btnReAllotProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnAllotProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(16, 16, 16)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(9, 9, 9)
                                .addComponent(btnBreakDownProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(172, 172, 172)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnHome, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnUnAllotProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnRepairProduct))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cbProductIdNo, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(cbAllotTo, javax.swing.GroupLayout.Alignment.LEADING, 0, 150, Short.MAX_VALUE)
                                        .addComponent(lblSerialNo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(lblImage, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnShow)
                    .addComponent(lblName)
                    .addComponent(cbProductName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTask)
                    .addComponent(cbTaskToDo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cbProductIdNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblId))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(lblAllotedDate, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 13, Short.MAX_VALUE)
                        .addComponent(lblDisplayDate, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblSerialNo, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblSerial))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblAllotTo)
                            .addComponent(cbAllotTo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblImgText)
                            .addComponent(lblImage, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 55, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnBreakDownProduct, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnHome, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnAllotProduct)
                            .addComponent(btnReAllotProduct)
                            .addComponent(btnUnAllotProduct)
                            .addComponent(btnRepairProduct))
                        .addGap(21, 21, 21))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jxdpDate, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblDate))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblModelNo, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblModel))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblRequest)
                            .addComponent(cbRequestBy, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1)
                            .addComponent(lblComment))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnShowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnShowActionPerformed
        try {
            clearFields(false);

            if (cbProductName.getSelectedItem() != null && cbProductName.getSelectedItem().toString().trim().length() > 0) {

                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://" + Config.DBHOST + ":3306/" + Config.SCHEMANAME, Config.DBUSER, Config.DBPASS);
                String sql = "select * from purchase_table where name = '"
                        + cbProductName.getSelectedItem().toString().trim() + "' and id_no = '"
                        + cbProductIdNo.getSelectedItem().toString().trim() + "'";

                String dateQuery = "";

                if (cbTaskToDo.getSelectedIndex() == 1 || cbTaskToDo.getSelectedIndex() == 2) {
                    sql += " and status = 1";
                    dateQuery = "SELECT alloted_date as date, comment FROM allot_table "
                            + "where id_no = '" + cbProductIdNo.getSelectedItem().toString().trim() + "' and "
                            + "id_code = (select inv_code from inventory_master "
                            + "where inv_name = '" + cbProductName.getSelectedItem().toString().trim() + "')";
                    lblAllotedDate.setText("Alloted");
                } else if (cbTaskToDo.getSelectedIndex() == 0 || cbTaskToDo.getSelectedIndex() == 3) {
                    sql += " and status = 0";
                    dateQuery = "SELECT date, comment FROM purchase_table "
                            + "where id_no = '" + cbProductIdNo.getSelectedItem().toString().trim() + "' and "
                            + "name = '" + cbProductName.getSelectedItem().toString().trim() + "'";
                    lblAllotedDate.setText("Purchase");
                } else if (cbTaskToDo.getSelectedIndex() == 4) {
                    sql += " and break = 1";
                    dateQuery = "SELECT breakdown_date as date, comment FROM breakdown_repair "
                            + "where id_no = '" + cbProductIdNo.getSelectedItem().toString().trim() + "' and "
                            + "id_code = (select inv_code from inventory_master "
                            + "where inv_name = '" + cbProductName.getSelectedItem().toString().trim() + "')";
                    lblAllotedDate.setText("Breakdown");
                }

                PreparedStatement ps = con.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();
                int i = 0;

                while (rs.next()) {
                    lblModelNo.setText(rs.getString(7));
                    lblSerialNo.setText(rs.getString(8));
                    //taComment.setText(rs.getString(11));

                    File f;
                    if (rs.getBinaryStream(16) != null) {
                        try ( //16=Image
                                InputStream in = rs.getBinaryStream(16)) {
                            f = new File("allot_product.jpg");
                            currentImgPath = f.getAbsolutePath();
                            try (OutputStream os = new FileOutputStream(f)) {
                                int c;
                                while ((c = in.read()) > -1) {
                                    os.write(c);
                                }
                            }
                        }

                        BufferedImage img = ImageIO.read(f);
//                Image scimg = img.getScaledInstance(lblImage.getWidth(),
//                        lblImage.getHeight(), 4);
                        Image scimg = img.getScaledInstance(150, 96, 4);
                        ImageIcon imageIcon = new ImageIcon(scimg);

                        lblImage.setIcon(imageIcon);
                    } else {
                        lblImage.setIcon(null);
                    }

                    i++;
                }

                //Fetch Date
                ps = con.prepareStatement(dateQuery);
                rs = ps.executeQuery();
                while (rs.next()) {
                    lblDisplayDate.setText(rs.getDate("date") + "");
                    taComment.setText(rs.getString("comment").trim());
                }
                //Fetch Date
                
                

                con.close();

                if (cbTaskToDo.getSelectedIndex() == 0 || cbTaskToDo.getSelectedIndex() == 2) {
                    if (i > 0) {
                        fillRequestByAndAllotToCombo();
                    }
                } else if (cbTaskToDo.getSelectedIndex() == 1) {
                    //Fetch requested by and alloted to names
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection conn = DriverManager.getConnection("jdbc:mysql://" + Config.DBHOST + ":3306/" + Config.SCHEMANAME, Config.DBUSER, Config.DBPASS);
                    String query = "select concat(u.user_f_name, \" \", u.user_l_name) as requested_by, "
                            + "concat(um.user_f_name, \" \", um.user_l_name) as alloted_to "
                            + "from purchase_table as pt "
                            + "left join user_master as u "
                            + "on pt.request = u.emp_code "
                            + "left join user_master as um "
                            + "on pt.allot_to = um.emp_code "
                            + "where pt.name = '" + cbProductName.getSelectedItem().toString().trim()
                            + "' and pt.id_no = '" + cbProductIdNo.getSelectedItem().toString().trim()
                            + "' and pt.status = 1 and u.active = 1 and um.active = 1";
                    PreparedStatement pst = conn.prepareStatement(query);
                    ResultSet rst = pst.executeQuery();

                    while (rst.next()) {
                        cbRequestBy.addItem(rst.getString("requested_by"));
                        cbAllotTo.addItem(rst.getString("alloted_to"));
                    }
                    conn.close();
                    //Fetch requested by and alloted to names
                }
            } else {
                JOptionPane.showMessageDialog(this, "No product available", "No product", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (ClassNotFoundException | SQLException | IOException e) {
            JOptionPane.showMessageDialog(this, e.getMessage(),"Exception", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_btnShowActionPerformed

    private void btnAllotProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAllotProductActionPerformed
        try {
            if (cbProductName.getSelectedItem() != null && cbProductName.getSelectedItem().toString().length() > 0) {
                if (cbProductIdNo.getSelectedItem() != null && cbProductIdNo.getSelectedItem().toString().length() > 0) {
                    if (jxdpDate.getDate() != null) {
                        if (isGTOrEQPurchaseDate(cbProductIdNo.getSelectedItem().toString().trim(), cbProductName.getSelectedItem().toString().trim(), jxdpDate.getDate())) {
                            if (cbRequestBy.getSelectedItem() != null && cbRequestBy.getSelectedItem().toString().trim().length() > 0) {
                                if (cbAllotTo.getSelectedItem() != null && cbAllotTo.getSelectedItem().toString().trim().length() > 0) {
                                    Class.forName("com.mysql.jdbc.Driver");
                                    Connection con = DriverManager.getConnection("jdbc:mysql://" + Config.DBHOST + ":3306/" + Config.SCHEMANAME, Config.DBUSER, Config.DBPASS);
                                    Statement st = con.createStatement();

                                    String idNo = cbProductIdNo.getSelectedItem().toString();
                                    String name = cbProductName.getSelectedItem().toString().trim();
                                    String allotedDate = formater.format(jxdpDate.getDate());
                                    String requestedBy = cbRequestBy.getSelectedItem().toString().trim();
                                    String allotTo = cbAllotTo.getSelectedItem().toString().trim();
                                    String comment = taComment.getText();

//            name = fetchProductCodeByName(name);
                                    String query = "insert into allot_table(id_no, id_code, alloted_date, requested_by, allot_to, comment) "
                                            + "values ('" + idNo + "',(SELECT inv_code FROM inventory_master "
                                            + "where inv_name = '" + name + "'),'" + allotedDate + "',"
                                            + "(select emp_code from user_master "
                                            + "where concat(user_f_name, \" \", user_l_name) = '" + requestedBy + "'),"
                                            + "(select emp_code from user_master "
                                            + "where concat(user_f_name, \" \", user_l_name) = '" + allotTo + "'),'" + comment + "')";
                                    st.executeUpdate(query);
                                    String sql = "update purchase_table set "
                                            + "request = (select emp_code from user_master "
                                            + "where concat(user_f_name, \" \", user_l_name) = '" + requestedBy + "'), "
                                            + "allot_to = (select emp_code from user_master "
                                            + "where concat(user_f_name, \" \", user_l_name) = '" + allotTo + "'), "
                                            + "status = 1 where id_no = '" + cbProductIdNo.getSelectedItem().toString() + "' and name = '" + name + "'";
                                    st.executeUpdate(sql);
                                    JOptionPane.showMessageDialog(this, "Product alloted successfully", "Alloted successfully", JOptionPane.INFORMATION_MESSAGE);

                                    clearFields(true);

                                    fetchProductNames();
                                    if (cbProductName.getSelectedItem() != null && cbProductName.getSelectedItem().toString().length() > 0) {
                                        fetchProductIds(cbProductName.getSelectedItem().toString());
                                    } else {
                                        cbProductIdNo.removeAllItems();
                                    }
                                } else {
                                    JOptionPane.showMessageDialog(this, "Please select allot to","Select allot", JOptionPane.WARNING_MESSAGE);
                                    cbAllotTo.requestFocus();
                                }
                            } else {
                                JOptionPane.showMessageDialog(this, "Please select request by", "Select request by", JOptionPane.WARNING_MESSAGE);
                                cbRequestBy.requestFocus();
                            }
                        } else {
                            JOptionPane.showMessageDialog(this, "Allot Date should be greater than or equal to Purchase Date","Select date", JOptionPane.WARNING_MESSAGE);
                            jxdpDate.setDate(null);
                            jxdpDate.requestFocus();
                        }
                    } else {
                        JOptionPane.showMessageDialog(this, "Please select date", "Select date", JOptionPane.WARNING_MESSAGE);
                        jxdpDate.requestFocus();
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "Please select product id", "Select product ID", JOptionPane.WARNING_MESSAGE);
                    cbProductIdNo.requestFocus();
                }
            } else {
                JOptionPane.showMessageDialog(this, "Please select product name", "Select product name", JOptionPane.WARNING_MESSAGE);
                cbProductName.requestFocus();
            }
        } catch (ClassNotFoundException | SQLException | HeadlessException e) {
            JOptionPane.showMessageDialog(this, e.getMessage(),"Exception", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnAllotProductActionPerformed

    private boolean isGTOrEQPurchaseDate(String idNo, String productName, Date allotDate) {
        boolean rv = true;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://" + Config.DBHOST + ":3306/" + Config.SCHEMANAME, Config.DBUSER, Config.DBPASS);
            String query = "SELECT date FROM purchase_table "
                    + "where id_no = '" + idNo + "' and name = '" + productName + "'";
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                //rv = rs.getString("inv_code");
                Date purchaseDate = rs.getDate("date");
                if (allotDate.before(purchaseDate)) {
                    rv = false;
                }
            }
        } catch (ClassNotFoundException | SQLException e) {
        }
        return rv;
    }

    private boolean isGTOrEQAllotDate(String idNo, String productName, Date unAllotDate) {
        boolean rv = true;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://" + Config.DBHOST + ":3306/" + Config.SCHEMANAME, Config.DBUSER, Config.DBPASS);
            String query = "SELECT alloted_date FROM allot_table "
                    + "where id_no = '" + idNo + "' and id_code = (select inv_code "
                    + "from inventory_master where inv_name = '" + productName + "')";
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                //rv = rs.getString("inv_code");
                Date allotedDate = rs.getDate("alloted_date");
                if (unAllotDate.before(allotedDate)) {
                    rv = false;
                }
            }
        } catch (ClassNotFoundException | SQLException e) {
        }
        return rv;
    }

    private boolean isGTOrEQBreakdownDate(String idNo, String productName, Date repairDate) {
        boolean rv = true;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://" + Config.DBHOST + ":3306/" + Config.SCHEMANAME, Config.DBUSER, Config.DBPASS);
            String query = "SELECT breakdown_date FROM breakdown_repair "
                            + "where id_no = '" + idNo + "' and "
                            + "id_code = (select inv_code from inventory_master "
                            + "where inv_name = '" + productName + "')";
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                //rv = rs.getString("inv_code");
                Date breakDownDate = rs.getDate("breakdown_date");
                if (repairDate.before(breakDownDate)) {
                    rv = false;
                }
            }
        } catch (ClassNotFoundException | SQLException e) {
        }
        return rv;
    }

    private String fetchProductCodeByName(String productName) {
        String rv = "";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://" + Config.DBHOST + ":3306/" + Config.SCHEMANAME, Config.DBUSER, Config.DBPASS);
            String id = "SELECT inv_code FROM inventory_master where inv_name = 'CCTV'";
            PreparedStatement ps = con.prepareStatement(id);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                rv = rs.getString("inv_code");
            }
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("[fetchProductCodeByName] Problem : " + e.getMessage());
        }
        return rv;
    }

    private void btnBreakDownProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBreakDownProductActionPerformed
        try {
            if (cbProductName.getSelectedItem() != null && cbProductName.getSelectedItem().toString().length() > 0) {
                if (cbProductIdNo.getSelectedItem() != null && cbProductIdNo.getSelectedItem().toString().length() > 0) {
                    if (jxdpDate.getDate() != null) {
                        if (isGTOrEQPurchaseDate(cbProductIdNo.getSelectedItem().toString().trim(), cbProductName.getSelectedItem().toString().trim(), jxdpDate.getDate())) {
                            Class.forName("com.mysql.jdbc.Driver");
                            Connection con = DriverManager.getConnection("jdbc:mysql://" + Config.DBHOST + ":3306/" + Config.SCHEMANAME, Config.DBUSER, Config.DBPASS);
                            Statement st = con.createStatement();

                            String idNo = cbProductIdNo.getSelectedItem().toString();
                            String name = cbProductName.getSelectedItem().toString().trim();
                            String date = formater.format(jxdpDate.getDate());
                            String comment = taComment.getText();
                            if (comment != null && comment.length() > 0) {
                                comment = comment.trim();
                            }

                            String sql = "update purchase_table set break = 1 "
                                    + "where id_no = '" + idNo + "' "
                                    + "and name = '" + name + "'";
                            st.executeUpdate(sql);

                            sql = "insert into breakdown_repair(id_no, id_code, breakdown_date, comment) "
                                    + "values('" + idNo + "', "
                                    + "(SELECT inv_code FROM inventory_master where inv_name = '" + name + "'), "
                                    + "'" + date + "', '" + comment + "')";
                            st.executeUpdate(sql);

                            con.close();

                            JOptionPane.showMessageDialog(this, "Product breakdown successfully","Breakdown successfully",JOptionPane.INFORMATION_MESSAGE);

                            clearFields(true);

                            fetchProductNames();
                            if (cbProductName.getSelectedItem() != null && cbProductName.getSelectedItem().toString().length() > 0) {
                                fetchProductIds(cbProductName.getSelectedItem().toString());
                            } else {
                                cbProductIdNo.removeAllItems();
                            }
                        } else {
                            JOptionPane.showMessageDialog(this, "Breakdown Date should be greater than or equal to Purchase Date","Select proper date",JOptionPane.WARNING_MESSAGE);
                            jxdpDate.setDate(null);
                            jxdpDate.requestFocus();
                        }
                    } else {
                        JOptionPane.showMessageDialog(this, "Please select date", "Select date", JOptionPane.WARNING_MESSAGE);
                        jxdpDate.requestFocus();
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "Please select product id","Select product ID", JOptionPane.WARNING_MESSAGE);
                    cbProductIdNo.requestFocus();
                }
            } else {
                JOptionPane.showMessageDialog(this, "Please select product name", "Select product name", JOptionPane.WARNING_MESSAGE);
                cbProductName.requestFocus();
            }
        } catch (ClassNotFoundException | SQLException | HeadlessException e) {
            JOptionPane.showMessageDialog(this, e.getMessage(),"Exception", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_btnBreakDownProductActionPerformed

    private void btnHomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHomeActionPerformed
        // TODO add your handling code here:
        start_page start = new start_page();
        start.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnHomeActionPerformed

    private void cbProductNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbProductNameActionPerformed
        clearFieldOnDDChange();

        if (cbProductName.getSelectedItem() != null) {
            fetchProductIds(cbProductName.getSelectedItem().toString().trim());
        }
    }//GEN-LAST:event_cbProductNameActionPerformed

    private void jxdpDateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jxdpDateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jxdpDateActionPerformed

    private void cbTaskToDoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbTaskToDoActionPerformed
        //JOptionPane.showMessageDialog(this, "cbTaskToDoActionPerformed called");
        hideButtons();
        clearFieldOnDDChange();

        if (cbTaskToDo.getSelectedIndex() == 0) {
            btnAllotProduct.getParent().setLayout(null);
            btnAllotProduct.setBounds(230, 324, 110, 28);
            btnAllotProduct.setVisible(true);
        } else if (cbTaskToDo.getSelectedIndex() == 1) {
            btnUnAllotProduct.getParent().setLayout(null);
            btnUnAllotProduct.setBounds(220, 324, 130, 28);
            btnUnAllotProduct.setVisible(true);
        } else if (cbTaskToDo.getSelectedIndex() == 2) {
            btnReAllotProduct.getParent().setLayout(null);
            btnReAllotProduct.setBounds(220, 324, 130, 28);
            btnReAllotProduct.setVisible(true);
        } else if (cbTaskToDo.getSelectedIndex() == 3) {
            btnBreakDownProduct.getParent().setLayout(null);
            btnBreakDownProduct.setBounds(200, 324, 150, 28);
            btnBreakDownProduct.setVisible(true);
        } else if (cbTaskToDo.getSelectedIndex() == 4) {
            btnRepairProduct.getParent().setLayout(null);
            btnRepairProduct.setBounds(200, 324, 150, 28);
            btnRepairProduct.setVisible(true);
        }

        fetchProductNames();

        if (cbProductName.getSelectedItem() != null && cbProductName.getSelectedItem().toString().length() > 0) {
            fetchProductIds(cbProductName.getSelectedItem().toString());
        } else {
            cbProductIdNo.removeAllItems();
        }
    }//GEN-LAST:event_cbTaskToDoActionPerformed

    private void cbProductIdNoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbProductIdNoActionPerformed
        clearFieldOnDDChange();
    }//GEN-LAST:event_cbProductIdNoActionPerformed

    private void btnUnAllotProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUnAllotProductActionPerformed
        try {
            if (cbProductName.getSelectedItem() != null && cbProductName.getSelectedItem().toString().length() > 0) {
                if (cbProductIdNo.getSelectedItem() != null && cbProductIdNo.getSelectedItem().toString().length() > 0) {
                    if (jxdpDate.getDate() != null) {
                        if (isGTOrEQAllotDate(cbProductIdNo.getSelectedItem().toString().trim(), cbProductName.getSelectedItem().toString().trim(), jxdpDate.getDate())) {
                            if (cbRequestBy.getSelectedItem() != null && cbRequestBy.getSelectedItem().toString().trim().length() > 0) {
                                if (cbAllotTo.getSelectedItem() != null && cbAllotTo.getSelectedItem().toString().trim().length() > 0) {
                                    Class.forName("com.mysql.jdbc.Driver");
                                    Connection con = DriverManager.getConnection("jdbc:mysql://" + Config.DBHOST + ":3306/" + Config.SCHEMANAME, Config.DBUSER, Config.DBPASS);
                                    Statement st = con.createStatement();

                                    String idNo = cbProductIdNo.getSelectedItem().toString();
                                    String name = cbProductName.getSelectedItem().toString().trim();
                                    String date = formater.format(jxdpDate.getDate());
                                    String comment = taComment.getText();

                                    String sql = "update purchase_table set "
                                            + "status = 0, request = null, allot_to = null, comment = '" + comment + "' "
                                            + "where id_no = '" + idNo + "' "
                                            + "and name = '" + name + "'";
                                    st.executeUpdate(sql);

                                    sql = "update allot_table set unalloted_date = '" + date + "' "
                                            + "where id_no = '" + idNo + "' "
                                            + "and id_code = (SELECT inv_code FROM inventory_master "
                                            + "where inv_name = '" + name + "');";
                                    st.executeUpdate(sql);
                                    con.close();

                                    JOptionPane.showMessageDialog(this, "Succesfully un-alloted","Un-allot successfully",JOptionPane.INFORMATION_MESSAGE);

                                    clearFields(true);

                                    fetchProductNames();
                                    if (cbProductName.getSelectedItem() != null && cbProductName.getSelectedItem().toString().length() > 0) {
                                        fetchProductIds(cbProductName.getSelectedItem().toString());
                                    } else {
                                        cbProductIdNo.removeAllItems();
                                    }
                                } else {
                                    JOptionPane.showMessageDialog(this, "Please select allot to","Select allot to",JOptionPane.WARNING_MESSAGE);
                                    cbAllotTo.requestFocus();
                                }
                            } else {
                                JOptionPane.showMessageDialog(this, "Please select request by","Select request by",JOptionPane.WARNING_MESSAGE);
                                cbRequestBy.requestFocus();
                            }
                        } else {
                            JOptionPane.showMessageDialog(this, "Un-Allot Date should be greater than or equal to Alloted Date","Select proper date",JOptionPane.WARNING_MESSAGE);
                            jxdpDate.setDate(null);
                            jxdpDate.requestFocus();
                        }
                    } else {
                        JOptionPane.showMessageDialog(this, "Please select date","Select date",JOptionPane.WARNING_MESSAGE);
                        jxdpDate.requestFocus();
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "Please select product id","Select product id", JOptionPane.WARNING_MESSAGE);
                    cbProductIdNo.requestFocus();
                }
            } else {
                JOptionPane.showMessageDialog(this, "Please select product name","Select product name", JOptionPane.WARNING_MESSAGE);
                cbProductName.requestFocus();
            }
        } catch (Exception e) {
        }
    }//GEN-LAST:event_btnUnAllotProductActionPerformed

    private void btnReAllotProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReAllotProductActionPerformed
        try {
            if (cbProductName.getSelectedItem() != null && cbProductName.getSelectedItem().toString().length() > 0) {
                if (cbProductIdNo.getSelectedItem() != null && cbProductIdNo.getSelectedItem().toString().length() > 0) {
                    if (jxdpDate.getDate() != null) {
                        if (isGTOrEQAllotDate(cbProductIdNo.getSelectedItem().toString().trim(), cbProductName.getSelectedItem().toString().trim(), jxdpDate.getDate())) {
                            if (cbRequestBy.getSelectedItem() != null && cbRequestBy.getSelectedItem().toString().trim().length() > 0) {
                                if (cbAllotTo.getSelectedItem() != null && cbAllotTo.getSelectedItem().toString().trim().length() > 0) {
                                    Class.forName("com.mysql.jdbc.Driver");
                                    Connection con = DriverManager.getConnection("jdbc:mysql://" + Config.DBHOST + ":3306/" + Config.SCHEMANAME, Config.DBUSER, Config.DBPASS);
                                    Statement st = con.createStatement();

                                    String idNo = cbProductIdNo.getSelectedItem().toString();
                                    String name = cbProductName.getSelectedItem().toString().trim();
                                    String date = formater.format(jxdpDate.getDate());
                                    String requestedBy = cbRequestBy.getSelectedItem().toString().trim();
                                    String allotTo = cbAllotTo.getSelectedItem().toString().trim();
                                    String comment = taComment.getText();

                                    //For un-allot
                                    String sql = "update purchase_table set "
                                            + "status = 0, request = null, allot_to = null "
                                            + "where id_no = '" + idNo + "' "
                                            + "and name = '" + name + "'";
                                    st.executeUpdate(sql);
                                    sql = "update allot_table set unalloted_date = '" + date + "', "
                                            + "comment = '" + comment + "' "
                                            + "where id_no = '" + idNo + "' "
                                            + "and id_code = (SELECT inv_code FROM inventory_master "
                                            + "where inv_name = '" + name + "');";
                                    st.executeUpdate(sql);
                                    //For un-allot

                                    ////For allot
                                    sql = "insert into allot_table(id_no, id_code, alloted_date, requested_by, allot_to, comment) "
                                            + "values ('" + idNo + "',(SELECT inv_code FROM inventory_master "
                                            + "where inv_name = '" + name + "'),'" + date + "',"
                                            + "(select emp_code from user_master "
                                            + "where concat(user_f_name, \" \", user_l_name) = '" + requestedBy + "'),"
                                            + "(select emp_code from user_master "
                                            + "where concat(user_f_name, \" \", user_l_name) = '" + allotTo + "'),'" + comment + "')";
                                    st.executeUpdate(sql);
                                    sql = "update purchase_table set "
                                            + "request = (select emp_code from user_master "
                                            + "where concat(user_f_name, \" \", user_l_name) = '" + requestedBy + "'), "
                                            + "allot_to = (select emp_code from user_master "
                                            + "where concat(user_f_name, \" \", user_l_name) = '" + allotTo + "'), "
                                            + "status = 1 where id_no = '" + cbProductIdNo.getSelectedItem().toString() + "'";
                                    st.executeUpdate(sql);
                                    ////For allot

                                    con.close();

                                    JOptionPane.showMessageDialog(this, "Succesfully re-alloted","Re-allot successfully",JOptionPane.INFORMATION_MESSAGE);

                                    clearFields(true);

                                    fetchProductNames();
                                    if (cbProductName.getSelectedItem() != null && cbProductName.getSelectedItem().toString().length() > 0) {
                                        fetchProductIds(cbProductName.getSelectedItem().toString());
                                    } else {
                                        cbProductIdNo.removeAllItems();
                                    }
                                } else {
                                    JOptionPane.showMessageDialog(this, "Please select allot to","Select allot",JOptionPane.WARNING_MESSAGE);
                                    cbAllotTo.requestFocus();
                                }
                            } else {
                                JOptionPane.showMessageDialog(this, "Please select request by","Select request by",JOptionPane.WARNING_MESSAGE);
                                cbRequestBy.requestFocus();
                            }
                        } else {
                            JOptionPane.showMessageDialog(this, "Re-Allot Date should be greater than or equal to Allot Date","Select proper date",JOptionPane.WARNING_MESSAGE);
                            jxdpDate.setDate(null);
                            jxdpDate.requestFocus();
                        }
                    } else {
                        JOptionPane.showMessageDialog(this, "Please select date","Select date",JOptionPane.WARNING_MESSAGE);
                        jxdpDate.requestFocus();
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "Please select product id","Select product ID",JOptionPane.WARNING_MESSAGE);
                    cbProductIdNo.requestFocus();
                }
            } else {
                JOptionPane.showMessageDialog(this, "Please select product name","Select product name",JOptionPane.WARNING_MESSAGE);
                cbProductName.requestFocus();
            }
        } catch (Exception e) {
        }

    }//GEN-LAST:event_btnReAllotProductActionPerformed

    private void btnRepairProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRepairProductActionPerformed
        try {
            if (cbProductName.getSelectedItem() != null && cbProductName.getSelectedItem().toString().length() > 0) {
                if (cbProductIdNo.getSelectedItem() != null && cbProductIdNo.getSelectedItem().toString().length() > 0) {
                    if (jxdpDate.getDate() != null) {
                        if (isGTOrEQBreakdownDate(cbProductIdNo.getSelectedItem().toString().trim(), cbProductName.getSelectedItem().toString().trim(), jxdpDate.getDate())) {
                            Class.forName("com.mysql.jdbc.Driver");
                            Connection con = DriverManager.getConnection("jdbc:mysql://" + Config.DBHOST + ":3306/" + Config.SCHEMANAME, Config.DBUSER, Config.DBPASS);
                            Statement st = con.createStatement();

                            String idNo = cbProductIdNo.getSelectedItem().toString();
                            String name = cbProductName.getSelectedItem().toString().trim();
                            String date = formater.format(jxdpDate.getDate());
                            String comment = taComment.getText();

                            String sql = "SELECT breakdown_date FROM breakdown_repair "
                                    + "where id_no = '" + idNo + "' "
                                    + "and id_code = (select inv_Code from inventory_master "
                                    + "where inv_name = '" + name + "') and repair_date is null";
                            PreparedStatement ps = con.prepareStatement(sql);
                            ResultSet rs = ps.executeQuery();

                            Date breakdown_date = new Date();
                            while (rs.next()) {
                                breakdown_date = rs.getDate("breakdown_date");
                            }

                            if (!jxdpDate.getDate().before(breakdown_date)) {
                                sql = "update purchase_table set break = 0 "
                                        + "where id_no = '" + idNo + "' "
                                        + "and name = '" + name + "'";
                                st.executeUpdate(sql);

                                sql = "update breakdown_repair set repair_date = '" + date + "', comment = '" + comment + "' "
                                        + "where id_no = '" + idNo + "' "
                                        + "and id_code = (SELECT inv_code FROM inventory_master "
                                        + "where inv_name = '" + name + "') and repair_date is null";
                                st.executeUpdate(sql);

                                con.close();

                                JOptionPane.showMessageDialog(this, "Product repaired successfully","Repaired successfully",JOptionPane.INFORMATION_MESSAGE);

                                clearFields(true);

                                fetchProductNames();
                                if (cbProductName.getSelectedItem() != null && cbProductName.getSelectedItem().toString().length() > 0) {
                                    fetchProductIds(cbProductName.getSelectedItem().toString());
                                } else {
                                    cbProductIdNo.removeAllItems();
                                }
                            } else {
                                JOptionPane.showMessageDialog(this, "Repair date should be greater than or equal to breakdown date","Select proper date",JOptionPane.WARNING_MESSAGE);
                                jxdpDate.requestFocus();
                            }
                        } else {
                            JOptionPane.showMessageDialog(this, "Repair Date should be greater than or equal to Breakdown Date","Select proper date",JOptionPane.WARNING_MESSAGE);
                            jxdpDate.setDate(null);
                            jxdpDate.requestFocus();
                        }
                    } else {
                        JOptionPane.showMessageDialog(this, "Please select date","Select date",JOptionPane.WARNING_MESSAGE);
                        jxdpDate.requestFocus();
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "Please select product id","Select product ID",JOptionPane.WARNING_MESSAGE);
                    cbProductIdNo.requestFocus();
                }
            } else {
                JOptionPane.showMessageDialog(this, "Please select product name","Select product name",JOptionPane.WARNING_MESSAGE);
                cbProductName.requestFocus();
            }
        } catch (ClassNotFoundException | SQLException | HeadlessException e) {
            JOptionPane.showMessageDialog(this, e.getMessage(),"Exception",JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnRepairProductActionPerformed

    private void lblImageMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblImageMouseClicked
                   Config.IMGPATH = currentImgPath;
        
        ProductImage pi = new ProductImage();
        pi.setVisible(true);
    }//GEN-LAST:event_lblImageMouseClicked

    private void taCommentMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_taCommentMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_taCommentMouseClicked

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
            java.util.logging.Logger.getLogger(allot_page.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new allot_page().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAllotProduct;
    private javax.swing.JButton btnBreakDownProduct;
    private javax.swing.JButton btnHome;
    private javax.swing.JButton btnReAllotProduct;
    private javax.swing.JButton btnRepairProduct;
    private javax.swing.JButton btnShow;
    private javax.swing.JButton btnUnAllotProduct;
    private javax.swing.JComboBox cbAllotTo;
    private javax.swing.JComboBox cbProductIdNo;
    private javax.swing.JComboBox cbProductName;
    private javax.swing.JComboBox cbRequestBy;
    private javax.swing.JComboBox cbTaskToDo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField2;
    private org.jdesktop.swingx.JXDatePicker jxdpDate;
    private javax.swing.JLabel lblAllotTo;
    private javax.swing.JLabel lblAllotedDate;
    private javax.swing.JLabel lblComment;
    private javax.swing.JLabel lblDate;
    private javax.swing.JLabel lblDisplayDate;
    private javax.swing.JLabel lblId;
    private javax.swing.JLabel lblImage;
    private javax.swing.JLabel lblImgText;
    private javax.swing.JLabel lblModel;
    private javax.swing.JLabel lblModelNo;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblRequest;
    private javax.swing.JLabel lblSerial;
    private javax.swing.JLabel lblSerialNo;
    private javax.swing.JLabel lblTask;
    private javax.swing.JTextArea taComment;
    // End of variables declaration//GEN-END:variables
}
