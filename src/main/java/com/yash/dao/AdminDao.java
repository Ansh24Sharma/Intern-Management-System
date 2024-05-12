package com.yash.dao;

import java.sql.SQLException;

import com.yash.model.Admin;

public interface AdminDao {
	
	public Admin saveAdmin(Admin admin) throws SQLException;
	Admin getAdminByUsername(String username) throws SQLException;
}
