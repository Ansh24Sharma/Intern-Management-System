package com.yash.model;

public class Task {
	 private String title;
	 private String description;
	 private String projectName;
	 private String dueDate;
	 private String status;
	 private Long intern_id;
	 private Intern assignedIntern;
	
	 
	 public Task() {
		super();
	}


	public Long getIntern_id() {
		return intern_id;
	}


	public void setIntern_id(Long intern_id) {
		this.intern_id = intern_id;
	}


	public Task(String title, String description, String projectName, String dueDate, String status, Long intern_id,
			Intern assignedIntern) {
		super();
		this.title = title;
		this.description = description;
		this.projectName = projectName;
		this.dueDate = dueDate;
		this.status = status;
		this.intern_id = intern_id;
		this.assignedIntern = assignedIntern;
	}


	public Task(String title, String description, String projectName, String dueDate, String status,
			Intern assignedIntern) {
		super();
		this.title = title;
		this.description = description;
		this.projectName = projectName;
		this.dueDate = dueDate;
		this.status = status;
		this.assignedIntern = assignedIntern;
	}
	
    

	public Task(String title, String description, String projectName, String dueDate, String status) {
		super();
		this.title = title;
		this.description = description;
		this.projectName = projectName;
		this.dueDate = dueDate;
		this.status = status;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public String getProjectName() {
		return projectName;
	}


	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}


	public String getDueDate() {
		return dueDate;
	}


	public void setDueDate(String string) {
		this.dueDate = string;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public Intern getAssignedIntern() {
		return assignedIntern;
	}


	public void setAssignedIntern(Intern assignedIntern) {
		this.assignedIntern = assignedIntern;
	} 

}
