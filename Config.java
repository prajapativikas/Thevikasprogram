/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slproject;

/**
 *
 * @author lenovo
 */
public class Config {
    static String VERSION = "V-1.0.0";
    static String PRODUCTTITLE = "SIS";
    
    static String currentUserRole = "";
    static String currentUserFullName = "";
    static String DBHOST = "localhost";
    static String SCHEMANAME = "school";
    static String DBUSER = "root";
    static String DBPASS = "root";
    
    static String BULKUSERFIELDS = "emp_code, user_f_name, user_l_name, user_contact, office_code, user_role, username, password, active";
    static String BULKPRODUCTSFIELDS = "id_no, id_code, name, date, processor, p_brand, model_no, serial_no, p_cost, comment, status, sell, break, mac_address, ip_address, ram, active";
    
    static String IMGPATH;
}
