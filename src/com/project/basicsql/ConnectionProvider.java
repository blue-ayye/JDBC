package com.project.basicsql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionProvider {

	private static String url = "jdbc:mysql://localhost:3306/java_dev";
	private static String user = "root";
	private static String password = "123456";

	private static Connection connection = null;

	static {
		try {
			connection = DriverManager.getConnection(url, user, password);
			System.out.println("ConnectionProvider: Established connection to " + url);
		} catch (SQLException e) {
			System.out.println("No connection established to " + url);
			System.out.println(e.getMessage());
		}
	}

	public static Connection getConnection() {
		if (connection == null)
			System.out.println("ConnectionProvider.getConnection().connection = null");
		return connection;
	}

	public static Connection closeConnection() {
		if (connection == null)
			System.out.println("ConnectionProvider.closeConnection().connection = null");
		return connection;
	}

}
