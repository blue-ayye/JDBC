package com.project.basicsql.executeQuery;

public interface IDao {
	void insertData(String query);
	void updateData(String query);
	void readDataByID(String query);
	void readDataAll(String query);
	void deleteDataByID(String query);
	void deleteDataAll(String query);
}
