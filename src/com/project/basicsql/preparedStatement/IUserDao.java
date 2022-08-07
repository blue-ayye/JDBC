package com.project.basicsql.preparedStatement;

public interface IUserDao {

	void insertData(UserEntity user);
	void updateData(UserEntity user);
	void readDataByID(UserEntity user);
	void readDataAll();
	void deleteDataByID(UserEntity user);
	void deleteDataAll();
}
