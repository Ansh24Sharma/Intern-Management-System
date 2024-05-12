package com.yash.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Dbutil {
	private static final String url = "jdbc:mysql://localhost:3306/internmanage?useSSL=false";
	private static final String user = "root";
	private static final String password = "root";
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public Dbutil() {
		super();
		// TODO Auto-generated constructor stub
	}

	public static Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(url, user, password);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;
	}

	public static void closeConnection(Connection connection) {
		try {
			if (connection == null || !connection.isClosed())
				connection.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public static PreparedStatement createPreparedStatement(Connection connection, String query) {
		try {
			return connection.prepareStatement(query);
		} catch (Exception e) {

			return null; // TODO: handle exception
		}

	}

	public static void closePreparedStatement(PreparedStatement preparedStatement) {
		try {
			if (preparedStatement == null || !preparedStatement.isClosed())
				preparedStatement.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	

	public static ResultSet getResultSet(PreparedStatement preparedStatement) {
		try {
			return preparedStatement.executeQuery();
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
	}
	
	public static void closeResultSet(ResultSet resultset) {
		try {
			if(resultset == null || !resultset.isClosed())
				resultset.close();
		}catch(Exception e) {
			
		}
	}

}
