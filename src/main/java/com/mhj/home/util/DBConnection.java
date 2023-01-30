package com.mhj.home.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DBConnection {
	
	//getConnection
	public static Connection getConnection() throws Exception {
		//1. 연결 정보
		String user = "user01";
		String password = "user01";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String driver = "oracle.jdbc.driver.OracleDriver";
		
		//2. Driver를 메모리에 로딩
		Class.forName(driver);	 //문자열을 클래스로 만드는 작업
		
		//3. DB 연결
		return DriverManager.getConnection(url, user, password);
	}
	
	public static void disConnection(PreparedStatement st, Connection connection) throws Exception {
		st.close();
		connection.close();
	}
	
	public static void disConnection(ResultSet rs, PreparedStatement st, Connection connection) throws Exception {
		rs.close();
		st.close();
		connection.close();
	}
	
	//배포 전 삭제
	public static void main(String[] args) {
		try {
			Connection connection = DBConnection.getConnection();
			System.out.println(connection != null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
