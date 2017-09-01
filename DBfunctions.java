/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restoremultipledump;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author sLD20-Admin
 */
   import java.io.BufferedInputStream;
import java.io.File;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class DBfunctions {

	//static CRUD crud = new CRUD();
	
	public static boolean schemaExists(String schemaName) {
            
		boolean rv = false;
		try {
			// Check if schema exist or not
			Connection conn = Dbcrud.openConnection("sakila");
			if (conn == null) {
				conn = Dbcrud.openConnection("test");
			}
			Statement stmt = conn.createStatement();

			ResultSet rs = stmt.executeQuery(
					"SELECT count(SCHEMA_NAME) as sn FROM INFORMATION_SCHEMA.SCHEMATA WHERE SCHEMA_NAME = '"
							+ schemaName + "'");

			while (rs.next()) {
				if (rs.getInt("sn") > 0)
					rv = true;
			}
			Dbcrud.closeConnection();
			// Check if schema exist or not
		} catch (Exception e) {
			// TODO: handle exception
		}
		return rv;
	}

	public static void truncateTable(String schemaName, String tableName[]) {
		try {
			// Truncate table data
			Connection conn = Dbcrud.openConnection(schemaName);
			Statement stmt = conn.createStatement();

			for (int i = 0; i < tableName.length; i++) {
				stmt.executeUpdate("truncate " + tableName[i]);
			}
			Dbcrud.closeConnection();
			// Truncate table data
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public static void createSchema(String schemaName) {
		try {
			// Truncate table data
			Connection conn = Dbcrud.openConnection("sakila");
			if (conn == null) {
				conn = Dbcrud.openConnection("test");
			}
			Statement stmt = conn.createStatement();

			stmt.executeUpdate("create schema " + schemaName);
			Dbcrud.closeConnection();
			// Truncate table data
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public static void dropSchema(String schemaName) {
		try {
			// Truncate table data
			Connection conn = Dbcrud.openConnection(schemaName);
			Statement stmt = conn.createStatement();

			stmt.executeUpdate("drop schema " + schemaName);
			Dbcrud.closeConnection();
			// Truncate table data
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public static String getMySQLPath() {
		String rv = "";
		try {// Truncate table data
			Connection conn = Dbcrud.openConnection("sakila");
			if (conn == null) {
				conn = Dbcrud.openConnection("test");
			}
			Statement stmt = conn.createStatement();

			ResultSet rs = stmt.executeQuery("select @@basedir as basedir");

			while (rs.next()) {
				rv = rs.getString("basedir") + "bin";
			}

			Dbcrud.closeConnection();
			// Truncate table data
		} catch (Exception e) {
			// TODO: handle exception
		}
		return rv;
	}

	public static void runCmd(String command) {
		try {
			if (!command.startsWith("cmd.exe /c ")) {
				command = "cmd.exe /c " + command;
			}

			Process runtimeProcess = Runtime.getRuntime().exec(command);
			BufferedInputStream testOutput = new BufferedInputStream(runtimeProcess.getInputStream());
			int read = 0;
			byte[] output = new byte[1024];
			while ((read = testOutput.read(output)) != -1) {
				System.out.println(output[read]);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public static void backupSQL(String schemaName, String destPath) {
		try {
			/* NOTE: Used to create a cmd command */
			String executeCmd = "cmd.exe /c \"" + getMySQLPath() + File.separator + "mysqldump\" "
					+ "-u root -proot --no-create-db " + schemaName + " > " + destPath;
			System.out.println("executing command : " + executeCmd + "\n\nPlease wait...");
			/* NOTE: Executing the command here */
			runCmd(executeCmd);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void restoreSQL(String schemaName, String dbPath) {
		try {
			/* NOTE: Used to create a cmd command */
			String executeCmd = "cmd.exe /c \"" + getMySQLPath() + File.separator + "mysql\" -u " + Constants.DBUSERNAME + " -p"
					+ Constants.DBUSERPASS + " " + schemaName + " < " + dbPath;
			 System.out.println("executing command : " + executeCmd +
			 "\n\nPlease wait...");
			/* NOTE: Executing the command here */
			runCmd(executeCmd);
			// System.out.println("complete");
		} catch (Exception e) {
			// System.out.println("not available");
			e.printStackTrace();
		}
	}
}