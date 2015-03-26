package com.abc.singletondp.conn;

import java.sql.Connection;

import com.abc.singletondp.db.DBConfig;

public enum DBConnection {
	INSTANCE;
	private final Connection connection;
	
	DBConnection() {
		connection = DBConfig.getConnection();
	}
	
	public static DBConnection getInstance() {
		return INSTANCE;
	}
	
	public Connection getConnection() {
		return connection;
	}
}
