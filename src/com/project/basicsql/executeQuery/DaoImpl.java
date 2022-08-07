package com.project.basicsql.executeQuery;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.project.basicsql.ConnectionProvider;

public class DaoImpl implements IDao {

	@Override
	public void insertData(String query) {
		String msg = "Data added";
		executeUpdate(query, msg);
	}

	@Override
	public void updateData(String query) {
		String msg = "Data updated";
		executeUpdate(query, msg);
	}

	@Override
	public void readDataByID(String query) {
		String msg = "Data Read";
		executeQuery(query, msg);
	}

	@Override
	public void readDataAll(String query) {
		String msg = "Data Read";
		executeQuery(query, msg);
	}

	@Override
	public void deleteDataByID(String query) {
		String msg = "Data deleted by ID";
		executeUpdate(query, msg);
	}

	@Override
	public void deleteDataAll(String query) {
		String msg = "All Data deleted";
		executeUpdate(query, msg);
	}

	private void executeUpdate(String query, String msg) {
		try {
			Statement statement = ConnectionProvider.getConnection().createStatement();
			statement.executeUpdate(query);
			System.out.println(msg);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			ConnectionProvider.closeConnection();
		}
	}
	
	private void executeQuery(String query, String msg) {
		try {
			Statement statement = ConnectionProvider.getConnection().createStatement();
			ResultSet resultSet = statement.executeQuery(query);
			while (resultSet.next()) {
				System.out.println("ID:" + resultSet.getInt(1));
				System.out.println("First Name:" + resultSet.getString(2));
				System.out.println("Last Name:" + resultSet.getString(3));
				System.out.println("Email Address:" + resultSet.getString(4));
				System.out.println("--------------------------------------");
			}
			System.out.println(msg);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			ConnectionProvider.closeConnection();
		}
	}
}
