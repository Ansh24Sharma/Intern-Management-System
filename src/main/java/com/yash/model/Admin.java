package com.yash.model;

public class Admin {
	private long id;
	private String username;
	private String password;
	private String name;
	
	public Admin() {
		super();
	}

	public Admin(long id, String username, String password) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
	}

	public Admin(String name, String username, String password) {
		super();
		this.username = username;
		this.password = password;
		this.name = name;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
