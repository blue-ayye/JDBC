package com.project.basicsql.preparedStatement;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.project.basicsql.ConnectionProvider;

public class UserDaoImpl implements IUserDao {
//	static String insertQuery = "insert into users value(3,'name3','lastname1','some@gmail.com')";
//	static String updateQuery = "update users set email = 'w@email.com' where id = 3";
//	static String readByIDQuery = "select * from users where id = 3";
//	static String readAllDataQuery = "select * from users";
//	static String deleteByIDQuery = "delete from users where id = 2";
//	static String deleteAllDataQuery = "delete from users";

	@Override
	public void insertData(UserEntity user) {
		System.out.println("UserDaoImpl.insertData()");
		String query = "insert into users value(?,?,?,?)";
		try {
			PreparedStatement preparedStatement = ConnectionProvider.getConnection().prepareStatement(query);
			preparedStatement.setInt(1, user.getId());
			preparedStatement.setString(2, user.getFirstName());
			preparedStatement.setString(3, user.getLastName());
			preparedStatement.setString(4, user.getEmail());
			preparedStatement.execute();
			System.out.println("Added user!");
			System.out.println(user);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			ConnectionProvider.closeConnection();
		}
	}

	@Override
	public void updateData(UserEntity user) {
		System.out.println("UserDaoImpl.updateData()");
		String query = "update users set fName = ?, lName = ?, email = ? where id = ?";
		try {
			PreparedStatement preparedStatement = ConnectionProvider.getConnection().prepareStatement(query);
			preparedStatement.setString(1, user.getFirstName());
			preparedStatement.setString(2, user.getLastName());
			preparedStatement.setString(3, user.getEmail());
			preparedStatement.setInt(4, user.getId());
			preparedStatement.execute();
			System.out.println("Updated user!");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			ConnectionProvider.closeConnection();
		}
	}

	@Override
	public void readDataByID(UserEntity user) {
		System.out.println("UserDaoImpl.readDataByID()");
		String query = "select * from users where id = ?";
		try {
			PreparedStatement preparedStatement = ConnectionProvider.getConnection().prepareStatement(query);
			preparedStatement.setInt(1, user.getId());
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				UserEntity userEntity = new UserEntity(
						preparedStatement.getResultSet().getInt(1),
						preparedStatement.getResultSet().getString(2),
						preparedStatement.getResultSet().getString(3),
						preparedStatement.getResultSet().getString(4));
				System.out.println(userEntity);
			}
			System.out.println("Read user!");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			ConnectionProvider.closeConnection();
		}
	}

	@Override
	public void readDataAll() {
		System.out.println("UserDaoImpl.readDataByID()");
		String query = "select * from users";
		try {
			PreparedStatement preparedStatement = ConnectionProvider.getConnection().prepareStatement(query);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				UserEntity userEntity = new UserEntity(
						preparedStatement.getResultSet().getInt(1),
						preparedStatement.getResultSet().getString(2),
						preparedStatement.getResultSet().getString(3),
						preparedStatement.getResultSet().getString(4));
				System.out.println(userEntity);
			}
			System.out.println("Read users!");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			ConnectionProvider.closeConnection();
		}

	}

	@Override
	public void deleteDataByID(UserEntity user) {
		System.out.println("UserDaoImpl.deleteDataByID()");
		String query = "delete from users where id = ?";
		try {
			PreparedStatement preparedStatement = ConnectionProvider.getConnection().prepareStatement(query);
			preparedStatement.setInt(1, user.getId());
			preparedStatement.execute();
			System.out.println("Deleted user!");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			ConnectionProvider.closeConnection();
		}
	}

	@Override
	public void deleteDataAll() {
		System.out.println("UserDaoImpl.deleteDataAll()");
		String query = "delete from users";
		try {
			PreparedStatement preparedStatement = ConnectionProvider.getConnection().prepareStatement(query);
			preparedStatement.execute();
			System.out.println("Deleted all users!");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			ConnectionProvider.closeConnection();
		}
	}

}
