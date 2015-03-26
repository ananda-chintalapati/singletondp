package com.abc.singletondp.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConfig {

	static final String CONNECTION_URL = "jdbc:mysql://localhost/EMP";
	static final String DB_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_USER = "root";
	static final String DB_PASS = "admin";
	
	public static Connection getConnection() {
		Connection conn = null;
		
		try {
			Class.forName(DB_DRIVER);
			conn = DriverManager.getConnection(CONNECTION_URL, DB_USER, DB_PASS);
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}  catch (SQLException e) {
			e.printStackTrace();
		}
		
		return conn;
	}
}
