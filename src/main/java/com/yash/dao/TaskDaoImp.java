package com.yash.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.yash.model.Task;
import com.yash.util.Dbutil;

public class TaskDaoImp implements TaskDao{
	private Connection conn = null;
	private PreparedStatement stmt = null;
	private ResultSet rs = null;
	
	public Task saveTask(Task task) throws SQLException{
		try {
			conn = Dbutil.getConnection(); 
		    String sql = "INSERT INTO assigned_tasks (title, description, projectName, dueDate, status,intern_id) VALUES (?, ?, ?, ?, ?,?)";
		    stmt = conn.prepareStatement(sql);
		    stmt.setString(1, task.getTitle());  
		    stmt.setString(2, task.getDescription());
		    stmt.setString(3, task.getProjectName());
		    stmt.setString(4, task.getDueDate());
		    stmt.setString(5, task.getStatus());
	        stmt.setLong(6, task.getIntern_id());
		    stmt.executeUpdate();

		    return task;

		  } finally {
			  Dbutil.closeConnection(conn); 
		      Dbutil.closePreparedStatement(stmt);  
		  }
	}
	public List<Task> getDetails() {
		List<Task> tasks = new ArrayList<>();
	    try {
	      conn = Dbutil.getConnection();
	      String sql = "select * from assigned_tasks"; 
	      stmt = Dbutil.createPreparedStatement(conn, sql);
	   //   stmt.setInt(1, assigned_intern_id);
	      rs = Dbutil.getResultSet(stmt);
	      while (rs.next()) {
	        Task task = new Task(
	           rs.getString("title"), 
	           rs.getString("description"),
	           rs.getString("projectName"),
	           rs.getString("dueDate"),
	           rs.getString("status"));
	        
	        tasks.add(task);
	      }
	    }
	      catch (SQLException e) {
				System.out.println(e);;
			}
	    finally {
	    	Dbutil.closeConnection(conn);
			Dbutil.closePreparedStatement(stmt);
			Dbutil.closeResultSet(rs);
	    }
	    return tasks;
    }
	public List<Task> getDetailsById(Long id) {
		List<Task> tasks = new ArrayList<>();
	    try {
	      conn = Dbutil.getConnection();
	      String sql = "select * from assigned_tasks where intern_id = ?"; 
	      stmt = Dbutil.createPreparedStatement(conn, sql);
	      stmt.setLong(1, id);
	      rs = Dbutil.getResultSet(stmt);
	      while (rs.next()) {
	        Task task = new Task(
	           rs.getString("title"), 
	           rs.getString("description"),
	           rs.getString("projectName"),
	           rs.getString("dueDate"),
	           rs.getString("status"));
	        
	        tasks.add(task);
	      }
	    }
	      catch (SQLException e) {
				System.out.println(e);;
			}
	    finally {
	    	Dbutil.closeConnection(conn);
			Dbutil.closePreparedStatement(stmt);
			Dbutil.closeResultSet(rs);
	    }
	    return tasks;
    }
	public boolean deleteTask(String title) throws SQLException {
		boolean rowDeleted;
		try {
			conn = Dbutil.getConnection();
			String sql = "delete from assigned_tasks where title = ?";
			stmt = Dbutil.createPreparedStatement(conn, sql);
			stmt.setString(1, title);
			rowDeleted = stmt.executeUpdate() > 0;
		} finally {
			Dbutil.closeConnection(conn);
			Dbutil.closePreparedStatement(stmt);
		}
		return rowDeleted;
	}
}
