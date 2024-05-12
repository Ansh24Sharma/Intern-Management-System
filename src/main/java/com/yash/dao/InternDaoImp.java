package com.yash.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.yash.model.Intern;
import com.yash.util.Dbutil;

public class InternDaoImp implements InternDao {
	private Connection conn = null;
	private PreparedStatement stmt = null;
	private ResultSet rs = null;
	
	public Intern saveIntern(Intern intern) throws SQLException {
	    try {
	      conn = Dbutil.getConnection();
	      String sql = "INSERT INTO intern (name, email, mobileno, coursename, branch, collegename, collegelocation, referralname, yop, currentsem, knowntech, interntech, internshipduration, startdate, enddate) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	      stmt = conn.prepareStatement(sql);
	      stmt.setString(1, intern.getName());
	      stmt.setString(2, intern.getEmail());
	      stmt.setLong(3, intern.getMobileno()); 
	      stmt.setString(4, intern.getCoursename());
	      stmt.setString(5, intern.getBranch());
	      stmt.setString(6, intern.getCollegename());
	      stmt.setString(7, intern.getCollegelocation());
	      stmt.setString(8, intern.getReferralname());
	      stmt.setString(9, intern.getYop());
	      stmt.setString(10, intern.getCurrentsem());
	      stmt.setString(11, intern.getKnowntech());
	      stmt.setString(12, intern.getInterntech());
	      stmt.setInt(13, intern.getInternshipduration());
	      stmt.setString(14, intern.getStartdate());
	      stmt.setString(15, intern.getEnddate());
	      stmt.executeUpdate();
	      
	   
	      return intern;
	    } finally {
	      Dbutil.closeConnection(conn); 
	      Dbutil.closePreparedStatement(stmt);
	     
	    }
	  }

	@Override
	public List<Intern> getDetails() {
		List<Intern> interns = new ArrayList<>();
	    try {
	      conn = Dbutil.getConnection();
	      String sql = "select * from intern"; 
	      stmt = Dbutil.createPreparedStatement(conn, sql);
	      rs = Dbutil.getResultSet(stmt);
	      while (rs.next()) {
	        Intern intern = new Intern(
	        	rs.getLong("id"),	
	            rs.getLong("mobileno"),
	            rs.getString("email"),
	            rs.getString("name"),
	            rs.getString("coursename"),
	            rs.getString("branch"),
	            rs.getString("collegename"),
	            rs.getString("collegelocation"),
	            rs.getString("referralname"),
	            rs.getString("yop"),
	            rs.getString("currentsem"),
	            rs.getString("knowntech"),
	            rs.getString("interntech"),
	            rs.getInt("internshipduration"),
	            rs.getString("startdate"),
	            rs.getString("enddate"));
	        
	        interns.add(intern);
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
	    return interns;
    }
	
	public boolean deleteIntern(String name) throws SQLException {
		boolean rowDeleted;
		try {
			conn = Dbutil.getConnection();
			String sql = "delete from intern where name = ?";
			stmt = Dbutil.createPreparedStatement(conn, sql);
			stmt.setString(1, name);
			rowDeleted = stmt.executeUpdate() > 0;
		} finally {
			Dbutil.closeConnection(conn);
			Dbutil.closePreparedStatement(stmt);
		}
		return rowDeleted;
	}
	
	public Intern updateIntern(Intern intern) throws SQLException{
		try {
			conn = Dbutil.getConnection();
			String sql = "update intern set email= ?, mobileno=?, coursename=?, branch=?, collegename=?, collegelocation=?, referralname=?, yop=?, currentsem=?, knowntech=?, interntech=?, internshipduration=?, startdate=?, enddate=? where name=?";
			
			stmt = Dbutil.createPreparedStatement(conn, sql);
			
		    stmt.setString(1, intern.getEmail());
		    stmt.setLong(2, intern.getMobileno()); 
		    stmt.setString(3, intern.getCoursename());
		    stmt.setString(4, intern.getBranch());
		    stmt.setString(5, intern.getCollegename());
		    stmt.setString(6, intern.getCollegelocation());
		    stmt.setString(7, intern.getReferralname());
		    stmt.setString(8, intern.getYop());
		    stmt.setString(9, intern.getCurrentsem());
		    stmt.setString(10, intern.getKnowntech());
		    stmt.setString(11, intern.getInterntech());
		    stmt.setInt(12, intern.getInternshipduration());
		    stmt.setString(13, intern.getStartdate());
		    stmt.setString(14, intern.getEnddate());
		    stmt.setString(15, intern.getName());
		    
		    stmt.executeUpdate();
		    
		    
	        return intern;
			
			
		} finally {
			Dbutil.closeConnection(conn);
			Dbutil.closePreparedStatement(stmt);
		}
	}
	
	public List<Intern> getInternDetailsByName(String name) throws SQLException {
	    List<Intern> internlist = new ArrayList<>();

	    try {
	        conn = Dbutil.getConnection();
	        String sql = "select * from intern where name = ?";
	        stmt = Dbutil.createPreparedStatement(conn, sql);
	        stmt.setString(1, name);
	        rs = stmt.executeQuery();

	        while (rs.next()) {
	            Intern intern = new Intern();
	            intern.setName(rs.getString("name"));
	            intern.setEmail(rs.getString("email"));
	            intern.setMobileno(rs.getLong("mobileno"));
	            intern.setCoursename(rs.getString("coursename"));
	            intern.setBranch(rs.getString("branch"));
	            intern.setCollegename(rs.getString("collegename"));
	            intern.setCollegelocation(rs.getString("collegelocation"));
	            intern.setReferralname(rs.getString("referralname"));
	            intern.setYop(rs.getString("yop"));
	            intern.setCurrentsem(rs.getString("currentsem"));
	            intern.setKnowntech(rs.getString("knowntech"));
	            intern.setInterntech(rs.getString("interntech"));
	            intern.setInternshipduration(rs.getInt("internshipduration"));
	            intern.setStartdate(rs.getString("startdate"));
	            intern.setEnddate(rs.getString("enddate"));

	            internlist.add(intern);
	        }
	    } finally {
	        Dbutil.closeConnection(conn);
	        Dbutil.closePreparedStatement(stmt);
	        Dbutil.closeResultSet(rs); 
	    }

	    return internlist;
	}

}

