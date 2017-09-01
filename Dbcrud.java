/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restoremultipledump;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author sLD20-Admin
 */
public class Dbcrud {
//	private static final Logger slf4jLogger = LoggerFactory.getLogger(CRUD.class);

	 //DBFunctions config = new  DBFunctions();
	public static Connection conn = null;

    /**
     *
     * @param schemaName
     * @return
     * @throws SQLException
     */
    public static Connection openConnection(String schemaName) throws SQLException {
		try {
	//		slf4jLogger.info("[openConnection] openConnection called.");

			Class.forName("com.mysql.jdbc.Driver");

			// Change the connection url specific to your database, driver
			String url = "jdbc:mysql://localhost:3306/" + schemaName + "?allowMultiQueries=true";

			String user = Constants.DBUSERNAME;
			String password = Constants.DBUSERPASS;

			conn = DriverManager.getConnection(url, user, password);


			// System.out.println("Successfully connected");
		} catch (Exception e) {
			// System.out.println("[openConnection] Problem...!!!");
			e.printStackTrace();

		}
		return conn;
	}

	public static void closeConnection() {
		try {
	//		slf4jLogger.info("[closeConnection] closeConnection called.");
			conn.close();
		} catch (Exception e) {
			// TODO: handle exception
		//	slf4jLogger.error("[closeConnection] Problem : " + e.getMessage());
		}
	}
}
