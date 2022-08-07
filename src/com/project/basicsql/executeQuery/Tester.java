package com.project.basicsql.executeQuery;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Tester {
	String url = "jdbc:mysql://localhost:3306/developer";
	String user = "root";
	String password = "123456";
	static String insertQuery = "insert into users value(3,'name3','lastname1','some@gmail.com')";
	static String updateQuery = "update users set email = 'w@email.com' where id = 3";
	static String readByIDQuery = "select * from users where id = 3";
	static String readAllDataQuery = "select * from users";
	static String deleteByIDQuery = "delete from users where id = 2";
	static String deleteAllDataQuery = "delete from users";
	Connection connection = null;

	public static void main(String[] args) throws SQLException {
//		Tester tester = new Tester();
//		tester.insertQuery();
//		tester.updateQuery();
//		tester.readDataByID();
//		tester.readAllData();
//		tester.deleteByID();
//		tester.deleteAllData();

//		 -----------------------------------------------

		DaoImpl daoImpl = new DaoImpl();
		
		daoImpl.insertData(insertQuery);
//		daoImpl.updateData(updateQuery);
//		daoImpl.readDataByID(readByIDQuery);
		daoImpl.readDataAll(readAllDataQuery);
//		daoImpl.deleteDataByID(deleteByIDQuery);
//		daoImpl.deleteDataAll(deleteAllDataQuery);
	}

	private void insertQuery() throws SQLException {
		try {
			connection = DriverManager.getConnection(url, user, password);
			System.out.println("Connected to DB: " + connection);
			Statement statement = connection.createStatement();
			statement.executeUpdate(insertQuery);
			System.out.println("Data addded!");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			if (connection != null) {
				connection.close();
			}
		}
	}

	private void updateQuery() throws SQLException {
		try {
			connection = DriverManager.getConnection(url, user, password);
			System.out.println("Connected to DB: " + connection);
			Statement statement = connection.createStatement();
			statement.executeUpdate(updateQuery);
			System.out.println("Data updated!");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			if (connection != null) {
				connection.close();
			}
		}
	}

	private void readDataByID() throws SQLException {
		try {
			connection = DriverManager.getConnection(url, user, password);
			System.out.println("Connected to DB: " + connection);
			Statement statement = connection.createStatement();

			ResultSet resultSet = statement.executeQuery(readByIDQuery);
			resultSet.next();
			System.out.println("ID:" + resultSet.getInt(1));
			System.out.println("First Name:" + resultSet.getString(2));
			System.out.println("Last Name:" + resultSet.getString(3));
			System.out.println("Email Address:" + resultSet.getString(4));

			System.out.println("Data updated!");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			if (connection != null) {
				connection.close();
			}
		}
	}

	private void readAllData() throws SQLException {
		try {
			connection = DriverManager.getConnection(url, user, password);
			System.out.println("Connected to DB: " + connection);
			Statement statement = connection.createStatement();

			ResultSet resultSet = statement.executeQuery(readAllDataQuery);
			while (resultSet.next()) {
				System.out.println("ID:" + resultSet.getInt(1));
				System.out.println("First Name:" + resultSet.getString(2));
				System.out.println("Last Name:" + resultSet.getString(3));
				System.out.println("Email Address:" + resultSet.getString(4));

				System.out.println("--------------------------------------");
			}
			System.out.println("Data updated!");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			if (connection != null) {
				connection.close();
			}
		}
	}

	private void deleteByID() throws SQLException {
		try {
			connection = DriverManager.getConnection(url, user, password);
			System.out.println("Connected to DB: " + connection);
			Statement statement = connection.createStatement();
			statement.executeUpdate(deleteByIDQuery);
			System.out.println("Data deleted!");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			if (connection != null) {
				connection.close();
			}
		}
	}

	private void deleteAllData() throws SQLException {
		try {
			connection = DriverManager.getConnection(url, user, password);
			System.out.println("Connected to DB: " + connection);
			Statement statement = connection.createStatement();
			statement.executeUpdate(deleteAllDataQuery);
			System.out.println("All Data deleted!");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			if (connection != null) {
				connection.close();
			}
		}
	}
}
