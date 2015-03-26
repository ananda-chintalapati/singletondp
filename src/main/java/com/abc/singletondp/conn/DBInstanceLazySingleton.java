package com.abc.singletondp.conn;

import java.sql.Connection;

import com.abc.singletondp.db.DBConfig;

public class DBInstanceLazySingleton {

	private DBInstanceLazySingleton() {
		
	}
	
	private static class LazyHolder {
		private static DBInstanceLazySingleton db = new DBInstanceLazySingleton();
	}
	
	public static DBInstanceLazySingleton getInstance() {
		return LazyHolder.db;
	}
	
	public static Connection getConnection() {
		return DBConfig.getConnection();
	}
}
