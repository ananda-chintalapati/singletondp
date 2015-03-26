package com.abc.singletondp.trigger;

import java.sql.Connection;
import java.sql.SQLException;

import com.abc.singletondp.conn.DBConnection;

public class DBEnumConn {

	public static void main(String[] args) throws SQLException {
		
		System.out.println("Obtaining DB Connection");
		Connection conn = DBConnection.INSTANCE.getConnection();
		System.out.println("Connection successful "+ conn);
		conn.close();
	}

}
