package com.yash.dao;

import java.sql.SQLException;
import java.util.List;

import com.yash.model.Intern;

public interface InternDao {
	public List<Intern> getDetails();
	public Intern saveIntern(Intern intern) throws SQLException;
	public boolean deleteIntern(String name) throws SQLException ;
	public Intern updateIntern(Intern intern) throws SQLException;
	public List<Intern> getInternDetailsByName(String name) throws SQLException;
}
