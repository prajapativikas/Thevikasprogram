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
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author nimbus
 */
public class Show_input extends javax.swing.JFrame {

    /**
     * Creates new form Show_input
     */
    SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd");

    public Show_input() {
        initComponents();

        if (Config.currentUserRole != null && Config.currentUserRole.trim().length() > 0 && Config.currentUserRole.trim().equalsIgnoreCase("admin")) {
            btnDeleteRecord.setEnabled(true);
        } else {
            btnDeleteRecord.setEnabled(false);
        }

        try {
            Image i = ImageIO.read(getClass().getResource("sls_logo.png"));
            setIconImage(i);
        } catch (IOException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }

        this.setTitle(Config.PRODUCTTITLE + "_" + Config.VERSION + " - Products List (Current User : " + Config.currentUserFullName + ")");
        //fill_combo();
        setProductNameCombo();
        setProductBrandCombo();
        show_table();

        jxdpStartDate.setFormats(formater);
        jxdpStartDate.getEditor().setEditable(false);
        jxdpEndDate.setFormats(formater);
        jxdpEndDate.getEditor().setEditable(false);

        //To set the upper bound (Blocking future dates)
        Calendar calendar = jxdpStartDate.getMonthView().getCalendar();
        calendar.setTime(new Date());
        jxdpStartDate.getMonthView().setUpperBound(calendar.getTime());

        Calendar calendar1 = jxdpEndDate.getMonthView().getCalendar();
        calendar1.setTime(new Date());
        jxdpEndDate.getMonthView().setUpperBound(calendar1.getTime());
        //To set the upper bound (Blocking future dates)

        tblPurchasedProducts.setAutoCreateRowSorter(true);
    }

    private void setProductNameCombo() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://" + Config.DBHOST + ":3306/" + Config.SCHEMANAME, Config.DBUSER, Config.DBPASS);
            String sql = "select distinct name from purchase_table ";

            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            cbProductName.removeAll();
            while (rs.next()) {
                String product_name = rs.getString("name");
                cbProductName.addItem(product_name);
            }
        } catch (ClassNotFoundException | SQLException e) {
        }
    }

    private void setProductBrandCombo() {
        try {
            String name = cbProductName.getSelectedItem().toString().trim();
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://" + Config.DBHOST + ":3306/" + Config.SCHEMANAME, Config.DBUSER, Config.DBPASS);
            String sql = "select distinct p_brand from purchase_table ";
            // String sql = "SELECT distinct p_brand from purchase_table where name = '" + name + "'";

            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            cbProductBrand.removeAll();
            while (rs.next()) {
                String product_Brand = rs.getString("p_brand");
                cbProductBrand.addItem(product_Brand);
            }
        } catch (ClassNotFoundException | SQLException e) {
        }
    }

//    public void fill_combo()  //FETCH VALUE IN COMBOBOX
//    {
//        try{
//             Class.forName("com.mysql.jdbc.Driver");
//            Connection con=DriverManager.getConnection("jdbc:mysql://" + Config.DBHOST + ":3306/" + Config.SCHEMANAME, Config.DBUSER, Config.DBPASS);
//            String sql = "select * from purchase_table ";
//            
//            PreparedStatement ps = con.prepareStatement(sql);
//            ResultSet rs = ps.executeQuery();
//            
//            while(rs.next())
//            {   
//                String request = rs.getString("request");
//                cbRequestedBy.addItem(request);
//                String product_type = rs.getString("p_type");
//                cbProductType.addItem(product_type);
//                 String product_Brand = rs.getString("p_brand");
//                cbProductBrand.addItem(product_Brand);
//                   
//            }
//            
//        }
//        catch (Exception e)
//        {
//            JOptionPane.showMessageDialog(this, e.getMessage());
//        }
//    }
    private void show_table() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://" + Config.DBHOST + ":3306/" + Config.SCHEMANAME, Config.DBUSER, Config.DBPASS);
            String sql = "select * from purchase_table where active = 1";

            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            int i = 0;
            while (rs.next()) {
                String id = rs.getString("id_code") + rs.getString("id_no");
                String name = rs.getString("name");
                String date = rs.getString("date");
                String processor = rs.getString("processor");
                String p_brand = rs.getString("p_brand");
                String model_number = rs.getString("model_no");
                String serial_number = rs.getString("serial_no");
                String product_cost = rs.getString("p_cost");
                String request = rs.getString("request");
                String alloted_to = rs.getString("allot_to");
                String comment = rs.getString("comment");
                boolean status = rs.getBoolean("status");
                boolean Break = rs.getBoolean("break");
                String ram = rs.getString("ram");
                String mac = rs.getString("mac_address");
                String ip = rs.getString("ip_address");
                request = fetchFullNameByEmpCode(request);
                alloted_to = fetchFullNameByEmpCode(alloted_to);

                //Temp
//                String[] columnNames = {"Id", "Name", "Date", "Brand", "Model", 
//                    "Serial", "Cost", "RequestedBy", "AllotedTo", "Comment", "IsAlloted", 
//                    "IsBreakDown", "Processor", "RAM", "Mac", "IP", "Delete"};
//                Object[] data
//                        = {id, name, date, p_brand, model_number, serial_number, product_cost, request, alloted_to, comment, status, Break, processor, ram, mac, ip, "Delete"};
//                DefaultTableModel model = (DefaultTableModel) tblPurchasedProducts.getModel();
//                model.addRow(data);
//             
                //Temp
                DefaultTableModel model = (DefaultTableModel) tblPurchasedProducts.getModel();
                model.addRow(new Object[]{id, name, date, p_brand, model_number, serial_number, product_cost, request, alloted_to, comment, status, Break, processor, ram, mac, ip});
                i++;
            }

            lblResFound.setText("Records Count : " + i);
        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(this, e.getMessage(),"Exception", JOptionPane.ERROR_MESSAGE);
        }
    }

    private String fetchFullNameByEmpCode(String empCode) {
        String rv = "";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://" + Config.DBHOST + ":3306/" + Config.SCHEMANAME, Config.DBUSER, Config.DBPASS);
            String sql = "SELECT concat(user_f_name, \" \", user_l_name) as fullname "
                    + "FROM user_master where emp_code = '" + empCode + "'";

            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            int i = 0;
            while (rs.next()) {
                rv = rs.getString("fullname");
            }
            con.close();
        } catch (Exception e) {
        }
        return rv;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnView = new javax.swing.JButton();
        lblProductName = new javax.swing.JLabel();
        lblProductBrand = new javax.swing.JLabel();
        cbProductName = new javax.swing.JComboBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPurchasedProducts = new javax.swing.JTable();
        cbProductBrand = new javax.swing.JComboBox();
        btnClear = new javax.swing.JButton();
        btnHome = new javax.swing.JButton();
        lblStartDate = new javax.swing.JLabel();
        jxdpStartDate = new org.jdesktop.swingx.JXDatePicker();
        jxdpEndDate = new org.jdesktop.swingx.JXDatePicker();
        lblendDate = new javax.swing.JLabel();
        btnExportData = new javax.swing.JButton();
        lblResFound = new javax.swing.JLabel();
        lblAllotment = new javax.swing.JLabel();
        cbAllotment = new javax.swing.JComboBox();
        lblBreakdown = new javax.swing.JLabel();
        cbBreakDown = new javax.swing.JComboBox();
        btnDeleteRecord = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Products List");
        setResizable(false);

        btnView.setText("View");
        btnView.setToolTipText("Click to view products list");
        btnView.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewActionPerformed(evt);
            }
        });

        lblProductName.setText("Product Name");

        lblProductBrand.setText("Product Brand");

        cbProductName.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "All" }));
        cbProductName.setToolTipText("Select product name");
        cbProductName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbProductNameActionPerformed(evt);
            }
        });

        tblPurchasedProducts.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Product ID", "Product Name", "Purchase Date", "Product Brand", "Model No.", "Serial No.", "Product Cost", "Requested By", "Alloted To", "Comment", "Is Alloted", "Is Break Down", "Processor", "RAM", "MAC", "IP"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblPurchasedProducts.setToolTipText("");
        tblPurchasedProducts.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblPurchasedProductsMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblPurchasedProducts);

        cbProductBrand.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "All" }));
        cbProductBrand.setToolTipText("Select product brand");
        cbProductBrand.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbProductBrandActionPerformed(evt);
            }
        });

        btnClear.setText("Clear");
        btnClear.setToolTipText("Click to clear filters");
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

        lblStartDate.setText("Start Date");

        jxdpStartDate.setToolTipText("Select start date");

        jxdpEndDate.setToolTipText("Select end date");

        lblendDate.setText("End Date");

        btnExportData.setText("Export Data");
        btnExportData.setToolTipText("Click to export products list");
        btnExportData.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExportDataActionPerformed(evt);
            }
        });

        lblAllotment.setText("Allotment");

        cbAllotment.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "All", "Alloted", "UnAlloted" }));
        cbAllotment.setToolTipText("Select allotment");

        lblBreakdown.setText("Break Down");

        cbBreakDown.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "All", "True", "False" }));
        cbBreakDown.setToolTipText("Select breakdown");

        btnDeleteRecord.setText("Delete");
        btnDeleteRecord.setToolTipText("Click to delete products list");
        btnDeleteRecord.setDefaultCapable(false);
        btnDeleteRecord.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteRecordActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1130, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblProductName)
                            .addComponent(cbProductName, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnHome)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnView)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnClear)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnExportData)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnDeleteRecord)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblResFound, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblProductBrand)
                                    .addComponent(cbProductBrand, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(1, 1, 1)
                                        .addComponent(lblAllotment)
                                        .addGap(94, 94, 94)
                                        .addComponent(lblBreakdown))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(cbAllotment, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(cbBreakDown, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jxdpStartDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblStartDate, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jxdpEndDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblendDate, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(31, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblProductName)
                    .addComponent(lblProductBrand)
                    .addComponent(lblStartDate)
                    .addComponent(lblendDate)
                    .addComponent(lblAllotment)
                    .addComponent(lblBreakdown))
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbProductName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbProductBrand, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jxdpStartDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jxdpEndDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbAllotment, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbBreakDown, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblResFound, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnView)
                        .addComponent(btnClear)
                        .addComponent(btnHome)
                        .addComponent(btnExportData)
                        .addComponent(btnDeleteRecord)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        btnView.getAccessibleContext().setAccessibleDescription("");
        btnClear.getAccessibleContext().setAccessibleDescription("");
        btnHome.getAccessibleContext().setAccessibleDescription("");
        btnExportData.getAccessibleContext().setAccessibleDescription("");
        btnDeleteRecord.getAccessibleContext().setAccessibleDescription("");

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnViewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewActionPerformed
        // TODO add your handling code here:
        viewData();
    }//GEN-LAST:event_btnViewActionPerformed

    private void viewData() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://" + Config.DBHOST + ":3306/" + Config.SCHEMANAME, Config.DBUSER, Config.DBPASS);

            // if (jComboBox3.getSelectedItem().toString().equals("all"))    //for 1st and 2nd combo box
            // {
            //String sql = "select * from purchase_table where p_type = '"+jComboBox1.getSelectedItem().toString()+"' and p_brand = '"+jComboBox2.getSelectedItem().toString()+"'";
            String sql = "select * from purchase_table where active = 1";
            if (cbProductName.getSelectedItem() != null && !cbProductName.getSelectedItem().toString().trim().equalsIgnoreCase("all")) {
                if (sql.toLowerCase().contains("where")) {
                    sql += " and name = '" + cbProductName.getSelectedItem().toString().trim() + "'";
                } else {
                    sql += " where name = '" + cbProductName.getSelectedItem().toString().trim() + "'";
                }
            }

            if (cbProductBrand.getSelectedItem() != null && !cbProductBrand.getSelectedItem().toString().trim().equalsIgnoreCase("all")) {
                if (sql.toLowerCase().contains("where")) {
                    sql += " and p_brand = '" + cbProductBrand.getSelectedItem().toString().trim() + "'";
                    //  sql += " and p_brand = '" + cbProductBrand.getSelectedItem().toString().trim() + "'" + "and name = '" + cbProductName.getSelectedItem().toString().trim() + "'";
                    //sql += " and p_brand = '" + cbProductBrand.getSelectedItem().toString().trim() + "and name = '" + cbProductName.getSelectedItem().toString().trim() + "'";
                } else {
                    sql += " where p_brand = '" + cbProductBrand.getSelectedItem().toString().trim() + "'";
                    //  sql += " where p_brand = '" + cbProductBrand.getSelectedItem().toString().trim() + "and name = '" + cbProductName.getSelectedItem().toString().trim() + "'";
                    //   sql += " where p_brand = '" + cbProductBrand.getSelectedItem().toString().trim() + "'" + "and name = '" + cbProductName.getSelectedItem().toString().trim() + "'";
                }
            }

            if (cbAllotment.getSelectedItem() != null && !cbAllotment.getSelectedItem().toString().trim().equalsIgnoreCase("all")) {
                int allotedVal = 0;
                if (cbAllotment.getSelectedItem().toString().trim().equalsIgnoreCase("Alloted")) {
                    allotedVal = 1;
                }

                if (sql.toLowerCase().contains("where")) {
                    sql += " and status = " + allotedVal;
                } else {
                    sql += " where status = " + allotedVal;
                }
            }

            if (cbBreakDown.getSelectedItem() != null && !cbBreakDown.getSelectedItem().toString().trim().equalsIgnoreCase("all")) {
                int breakDownVal = 0;
                if (cbBreakDown.getSelectedItem().toString().trim().equalsIgnoreCase("True")) {
                    breakDownVal = 1;
                }

                if (sql.toLowerCase().contains("where")) {
                    sql += " and break = " + breakDownVal;
                } else {
                    sql += " where break = " + breakDownVal;
                }
            }

            Date startDate = null, endDate = null;
            boolean isDateOk;
            if (jxdpStartDate.getDate() != null) {
                startDate = jxdpStartDate.getDate();
            }
            if (jxdpEndDate.getDate() != null) {
                endDate = jxdpEndDate.getDate();
            }

            if (startDate == null && endDate == null) {
                isDateOk = true;
            } else if (startDate != null && endDate != null) {
                if (startDate.after(endDate)) {
                    isDateOk = false;
                } else {
                    isDateOk = true;
                    if (sql.toLowerCase().contains("where")) {
                        sql += " and date between '" + formater.format(jxdpStartDate.getDate())
                                + "' and '" + formater.format(jxdpEndDate.getDate()) + "'";
                    } else {
                        sql += " where date between '" + formater.format(jxdpStartDate.getDate())
                                + "' and '" + formater.format(jxdpEndDate.getDate()) + "'";
                    }
                }
            } else {
                isDateOk = false;
            }

            if (isDateOk) {
                DefaultTableModel model = (DefaultTableModel) tblPurchasedProducts.getModel();
                if (model.getRowCount() > 0) {
                    for (int i = model.getRowCount() - 1; i > -1; i--) {
                        model.removeRow(0);
                    }
                }

                PreparedStatement ps = con.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();
                int i = 0;
                while (rs.next()) {
                    String id = rs.getString("id_code") + rs.getString("id_no");
                    String name = rs.getString("name");
                    String date = rs.getString("date");
                    String processor = rs.getString("processor");
                    String p_brand = rs.getString("p_brand");
                    String model_number = rs.getString("model_no");
                    String serial_number = rs.getString("serial_no");
                    String product_cost = rs.getString("p_cost");
                    String request = rs.getString("request");
                    String alloted_to = rs.getString("allot_to");
                    String comment = rs.getString("comment");
                    String ram = rs.getString("ram");
                    String mac = rs.getString("mac_address");
                    String ip = rs.getString("ip_address");
                    boolean status = rs.getBoolean("status");
                    boolean Break = rs.getBoolean("break");

                    request = fetchFullNameByEmpCode(request);
                    alloted_to = fetchFullNameByEmpCode(alloted_to);

                    model.addRow(new Object[]{id, name, date, p_brand, model_number, serial_number, product_cost, request, alloted_to, comment, status, Break, processor, ram, mac, ip});
                    i++;
                }

                lblResFound.setText("Records Count : " + i);
            } else {
                JOptionPane.showMessageDialog(this, "Please select proper start and end dates", "Invalid date", JOptionPane.WARNING_MESSAGE);
            }
        } catch (ClassNotFoundException | SQLException | HeadlessException e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Exception", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        // TODO add your handling code here:
        //  DefaultTableModel model = (DefaultTableModel)jTable1.getModel();
        //   model.removeRow(0);

        DefaultTableModel model = (DefaultTableModel) tblPurchasedProducts.getModel();
        if (model.getRowCount() > 0) {
            for (int i = model.getRowCount() - 1; i > -1; i--) {
                model.removeRow(0);
            }
        }

        cbProductName.setSelectedIndex(0);
        cbProductBrand.setSelectedIndex(0);
        jxdpStartDate.setDate(null);
        jxdpEndDate.setDate(null);

        viewData();
    }//GEN-LAST:event_btnClearActionPerformed

    private void tblPurchasedProductsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblPurchasedProductsMouseClicked

    }//GEN-LAST:event_tblPurchasedProductsMouseClicked

    private void btnHomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHomeActionPerformed
        // TODO add your handling code here:
        start_page page = new start_page();
        page.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnHomeActionPerformed

    private void clearFields(boolean productDropdown) {
//        jxdpPurchaseDate.setDate(null);
//        txtModelNo.setText("");
//        txtSerialNo.setText(null);
//        txtProcessor.setText("");
//        txtProductBrand.setText("");
//        txtProductCost.setText("");
//        taComment.setText("");
//        txtMacAddress.setText("");
//        lblImage.setIcon(null);
//        txtIPAddress.setText("");
//        txtRAM.setText("");

        try {
            if (productDropdown) {
                cbProductName.setSelectedIndex(0);
            }
        } catch (Exception e) {

        }
    }
    private void cbProductNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbProductNameActionPerformed
        // TODO add your handling code here:
        try {
            clearFields(false);
            System.out.println(cbProductName.getSelectedItem());
            if (cbProductName.getSelectedItem() != null) {
                fetchProductIds(cbProductName.getSelectedItem().toString().trim());
            }

            String prName = cbProductName.getSelectedItem().toString();

            Class.forName("com.mysql.jdbc.Driver");
            String sql;
            Connection con = DriverManager.getConnection("jdbc:mysql://" + Config.DBHOST + ":3306/" + Config.SCHEMANAME, Config.DBUSER, Config.DBPASS);
            sql = "SELECT p_brand FROM purchase_table where name='" + prName + "'";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

//                String inv_name = rs.getString("inv_name");
//                jComboBox1.addItem(inv_name);
                String p_brand = rs.getString("p_brand");

            }
        } catch (Exception e) {
        }
    }//GEN-LAST:event_cbProductNameActionPerformed

    private void fetchProductIds(String product_name) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://" + Config.DBHOST + ":3306/" + Config.SCHEMANAME, Config.DBUSER, Config.DBPASS);
            String id = "";

            if (product_name.toString().equalsIgnoreCase("All")) {

                cbProductBrand.removeAllItems();
                cbProductBrand.addItem("All");
                setProductBrandCombo();
            } else {

                id = "select p_brand from purchase_table where name = '" + product_name.trim() + "' and active = 1";
                PreparedStatement ps = con.prepareStatement(id);

                ResultSet rs = ps.executeQuery();
                cbProductBrand.removeAllItems();
                cbProductBrand.addItem("All");

                while (rs.next()) {
                    String p_brand = rs.getString("p_brand");

                    cbProductBrand.addItem(p_brand);

                }
            }
            System.out.println("product_name" + product_name);

        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("[fetch_data] Problem : " + e.getMessage());
        }
    }


    private void btnExportDataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExportDataActionPerformed
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
                        JOptionPane.showMessageDialog(this, "You can export CSV file only", "CSV Only", JOptionPane.WARNING_MESSAGE);
                    }
                } else {
                    selectedFile = new File(selectedFile.getAbsolutePath() + ".csv");
                    exportCSV(selectedFile);
                }
            }
        } catch (HeadlessException e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Exception" , JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnExportDataActionPerformed

    private void btnDeleteRecordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteRecordActionPerformed
        try {
            if (tblPurchasedProducts.getSelectedRows() != null && tblPurchasedProducts.getSelectedRows().length > 0) {
                int selectedRows[] = tblPurchasedProducts.getSelectedRows();
                for (int i = 0; i < selectedRows.length; i++) {
                    //JOptionPane.showMessageDialog(this, tblPurchasedProducts.getValueAt(selectedRows[i], 0) + " Is Alloted : " + tblPurchasedProducts.getValueAt(selectedRows[i], 10));
                    if (tblPurchasedProducts.getValueAt(selectedRows[i], 10).toString().equalsIgnoreCase("false")) {
                        Class.forName("com.mysql.jdbc.Driver");
                        Connection con = DriverManager.getConnection("jdbc:mysql://" + Config.DBHOST + ":3306/" + Config.SCHEMANAME, Config.DBUSER, Config.DBPASS);
                        String sql = "update purchase_table set active = 0 "
                                + "where concat(id_code, id_no) = '" + tblPurchasedProducts.getValueAt(selectedRows[i], 0).toString().trim() + "'";
                        PreparedStatement stmt = con.prepareStatement(sql);
                        stmt.executeUpdate();
                        con.close();
                        JOptionPane.showMessageDialog(this, "Product(" + tblPurchasedProducts.getValueAt(selectedRows[i], 0).toString().trim() + ") deleted successfully", "Deleted successfully", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(this, "Product(" + tblPurchasedProducts.getValueAt(selectedRows[i], 0).toString().trim() + ") is alloted to someone.\nSo can not delete it.", "Can not delete", JOptionPane.WARNING_MESSAGE );
                    }
                }
            } else {
                 JOptionPane.showMessageDialog(this, "Please select product(s) to delete", "Select product(s)" , JOptionPane.WARNING_MESSAGE);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Could not delete product(s)", "Can not delete" , JOptionPane.ERROR_MESSAGE);
        } finally {
            btnClear.doClick();
        }
    }//GEN-LAST:event_btnDeleteRecordActionPerformed

    private void cbProductBrandActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbProductBrandActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbProductBrandActionPerformed

    private void exportCSV(File selectedFile) {
        try {
            //String sql = "select * from purchase_table";
            String sql = "SELECT concat(pt.id_code, pt.id_no) as product_id, pt.name as product_name, pt.date as purchase_date, "
                    + "pt.p_brand as product_brand, pt.model_no, pt.serial_no, pt.p_cost as product_cost, "
                    + "concat(u.user_f_name, \" \", u.user_l_name) as requested_by, "
                    + "concat(um.user_f_name, \" \", um.user_l_name) as alloted_to, pt.comment, pt.status as is_alloted, pt.break as is_breakdown, pt.mac_address, pt.ip_address, pt.ram "
                    + "FROM purchase_table as pt "
                    + "left join user_master as u "
                    + "on pt.request = u.emp_code "
                    + "left join user_master as um "
                    + "on pt.allot_to = um.emp_code "
                    + "WHERE pt.active = 1";

            if (cbProductName.getSelectedItem() != null && !cbProductName.getSelectedItem().toString().trim().equalsIgnoreCase("all")) {
                if (sql.toLowerCase().contains("where")) {
                    sql += " and pt.name = '" + cbProductName.getSelectedItem().toString().trim() + "'";
                } else {
                    sql += " where pt.name = '" + cbProductName.getSelectedItem().toString().trim() + "'";
                }
            }

            if (cbProductBrand.getSelectedItem() != null && !cbProductBrand.getSelectedItem().toString().trim().equalsIgnoreCase("all")) {
                if (sql.toLowerCase().contains("where")) {
                    sql += " and pt.p_brand = '" + cbProductBrand.getSelectedItem().toString().trim() + "'";
                } else {
                    sql += " where pt.p_brand = '" + cbProductBrand.getSelectedItem().toString().trim() + "'";
                }
            }

            if (cbAllotment.getSelectedItem() != null && !cbAllotment.getSelectedItem().toString().trim().equalsIgnoreCase("all")) {
                int allotedVal = 0;
                if (cbAllotment.getSelectedItem().toString().trim().equalsIgnoreCase("Alloted")) {
                    allotedVal = 1;
                }

                if (sql.toLowerCase().contains("where")) {
                    sql += " and pt.status = " + allotedVal;
                } else {
                    sql += " where pt.status = " + allotedVal;
                }
            }

            if (cbBreakDown.getSelectedItem() != null && !cbBreakDown.getSelectedItem().toString().trim().equalsIgnoreCase("all")) {
                int breakDownVal = 0;
                if (cbBreakDown.getSelectedItem().toString().trim().equalsIgnoreCase("True")) {
                    breakDownVal = 1;
                }

                if (sql.toLowerCase().contains("where")) {
                    sql += " and pt.break = " + breakDownVal;
                } else {
                    sql += " where pt.break = " + breakDownVal;
                }
            }

            Date startDate = null, endDate = null;
            boolean isDateOk = false;
            if (jxdpStartDate.getDate() != null) {
                startDate = jxdpStartDate.getDate();
            }
            if (jxdpEndDate.getDate() != null) {
                endDate = jxdpEndDate.getDate();
            }

            if (startDate == null && endDate == null) {
                isDateOk = true;
            } else if (startDate != null && endDate != null) {
                if (startDate.after(endDate)) {
                    isDateOk = false;
                } else {
                    isDateOk = true;
                    if (sql.toLowerCase().contains("where")) {
                        sql += " and pt.date between '" + formater.format(jxdpStartDate.getDate())
                                + "' and '" + formater.format(jxdpEndDate.getDate()) + "'";
                    } else {
                        sql += " where pt.date between '" + formater.format(jxdpStartDate.getDate())
                                + "' and '" + formater.format(jxdpEndDate.getDate()) + "'";
                    }
                }
            } else {
                isDateOk = false;
            }

            System.out.println("Query : " + sql);

            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://" + Config.DBHOST + ":3306/" + Config.SCHEMANAME, Config.DBUSER, Config.DBPASS);
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            //File f = new File("D:\\products.csv");
            try (CSVWriter writer = new CSVWriter(new FileWriter(selectedFile), ',', CSVWriter.NO_QUOTE_CHARACTER)) {
                writer.writeAll(rs, true);
                writer.close();
            }

            JOptionPane.showMessageDialog(this, "Purchased products data exported", "Products list exported", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Exception", JOptionPane.ERROR_MESSAGE);
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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Show_input.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        }
        //</editor-fold>

        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Show_input().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnDeleteRecord;
    private javax.swing.JButton btnExportData;
    private javax.swing.JButton btnHome;
    private javax.swing.JButton btnView;
    private javax.swing.JComboBox cbAllotment;
    private javax.swing.JComboBox cbBreakDown;
    private javax.swing.JComboBox cbProductBrand;
    private javax.swing.JComboBox cbProductName;
    private javax.swing.JScrollPane jScrollPane1;
    private org.jdesktop.swingx.JXDatePicker jxdpEndDate;
    private org.jdesktop.swingx.JXDatePicker jxdpStartDate;
    private javax.swing.JLabel lblAllotment;
    private javax.swing.JLabel lblBreakdown;
    private javax.swing.JLabel lblProductBrand;
    private javax.swing.JLabel lblProductName;
    private javax.swing.JLabel lblResFound;
    private javax.swing.JLabel lblStartDate;
    private javax.swing.JLabel lblendDate;
    private javax.swing.JTable tblPurchasedProducts;
    // End of variables declaration//GEN-END:variables
}
