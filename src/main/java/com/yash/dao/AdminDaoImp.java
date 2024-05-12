package com.yash.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.yash.model.Admin;
import com.yash.util.Dbutil;

public class AdminDaoImp implements AdminDao{
	
	private Connection connection = null;
	private PreparedStatement preparedStatement = null;
	private ResultSet resultset = null;
	
	
	  public AdminDaoImp() {
		super();
	}


	public Admin saveAdmin(Admin admin) throws SQLException {
		    try {
		      connection = Dbutil.getConnection();
		      String sql = "INSERT INTO admin (name, password, username) VALUES (?, ?, ?)";
		      preparedStatement = connection.prepareStatement(sql);
		      preparedStatement.setString(1, admin.getName());
		      preparedStatement.setString(2, admin.getPassword()); 
		      preparedStatement.setString(3, admin.getUsername());
		      preparedStatement.executeUpdate();
		       
		      return admin;
		    } finally {
		      Dbutil.closeConnection(connection); 
		      Dbutil.closePreparedStatement(preparedStatement);
		     
		    }
		  }
	
	 public Admin getAdminByUsername(String username) throws SQLException{
		  try {
			  connection = Dbutil.getConnection();
			  String sql = "SELECT * FROM admin WHERE username = ?";
			  preparedStatement = connection.prepareStatement(sql);
		      preparedStatement.setString(1, username);
		      resultset = preparedStatement.executeQuery();
		      if (resultset.next()) {
		        Admin admin = new Admin();
		        admin.setId(resultset.getLong("id"));
		        admin.setPassword(resultset.getString("password"));
		        admin.setUsername(resultset.getString("username"));
		        return admin;
		      } else {
		        return null;
		      }
		    }
		  finally {
		      Dbutil.closeConnection(connection); 
		      Dbutil.closePreparedStatement(preparedStatement);
		      Dbutil.closeResultSet(resultset);
		    }
		  }
}
