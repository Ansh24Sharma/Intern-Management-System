package com.yash.dao;

import java.sql.SQLException;
import java.util.List;

import com.yash.model.Task;

public interface TaskDao {
	public Task saveTask(Task task) throws SQLException;
	public List<Task> getDetails();
	public List<Task> getDetailsById(Long id);
	public boolean deleteTask(String title) throws SQLException;
}
