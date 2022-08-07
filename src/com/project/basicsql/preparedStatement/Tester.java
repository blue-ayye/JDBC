package com.project.basicsql.preparedStatement;

public class Tester {

	public static void main(String[] args) {
		UserEntity user = new UserEntity(2, "dasfsd", "lN", "neM");
		IUserDao dao = new UserDaoImpl();
		
		dao.insertData(user);
//		dao.updateData(user);
//		dao.readDataByID(user);
		dao.readDataAll();
//		dao.deleteDataByID(user);
//		dao.deleteDataAll();

	}

}
