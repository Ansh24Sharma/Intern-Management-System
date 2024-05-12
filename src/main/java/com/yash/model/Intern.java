package com.yash.model;

import java.io.Serializable;

public class Intern implements Serializable{
	private Long id;
	private Long mobileno;
	private String email;
	private String name;
	private String coursename;
	private String branch;
	private String collegename;
	private String collegelocation;
	private String referralname;
	private String yop;
	private String currentsem;
	private String knowntech;
	private String interntech; 
	private int internshipduration;
	private String startdate;
	private String enddate;
	
	public Intern() {
		super();
	}

	public Intern(Long id, Long mobileno, String email, String name, String coursename, String branch,
			String collegename, String collegelocation, String referralname, String yop, String currentsem,
			String knowntech, String interntech, int internshipduration, String startdate, String enddate) {
		super();
		this.id = id;
		this.mobileno = mobileno;
		this.email = email;
		this.name = name;
		this.coursename = coursename;
		this.branch = branch;
		this.collegename = collegename;
		this.collegelocation = collegelocation;
		this.referralname = referralname;
		this.yop = yop;
		this.currentsem = currentsem;
		this.knowntech = knowntech;
		this.interntech = interntech;
		this.internshipduration = internshipduration;
		this.startdate = startdate;
		this.enddate = enddate;
	}




	public Long getId() {
		return id;
	}




	public void setId(Long id) {
		this.id = id;
	}




	public Intern(Long mobileno, String email, String name, String coursename, String branch,
			String collegename, String collegelocation, String referralname, String yop, String currentsem, String knowntech, String interntech, int internshipduration, String startdate, String enddate) {
		super();
		this.mobileno = mobileno;
		this.email = email;
		this.name = name;
		this.coursename = coursename;
		this.branch = branch;
		this.collegename = collegename;
		this.collegelocation = collegelocation;
		this.referralname = referralname;
		this.yop = yop;
		this.currentsem = currentsem;
		this.knowntech = knowntech;
		this.interntech = interntech;
		this.internshipduration = internshipduration;
		this.startdate = startdate;
		this.enddate = enddate;
	}

	public Intern(String email, String name, String coursename, String branch, String collegename,
			String collegelocation, String referralname, String yop, String currentsem, String knowntech,
			String interntech, String startdate) {
		super();
		this.email = email;
		this.name = name;
		this.coursename = coursename;
		this.branch = branch;
		this.collegename = collegename;
		this.collegelocation = collegelocation;
		this.referralname = referralname;
		this.yop = yop;
		this.currentsem = currentsem;
		this.knowntech = knowntech;
		this.interntech = interntech;
		this.startdate = startdate;
	}

	public Long getMobileno() {
		return mobileno;
	}

	public void setMobileno(Long mobileno) {
		this.mobileno = mobileno;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCoursename() {
		return coursename;
	}

	public void setCoursename(String coursename) {
		this.coursename = coursename;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public String getCollegename() {
		return collegename;
	}

	public void setCollegename(String collegename) {
		this.collegename = collegename;
	}

	public String getCollegelocation() {
		return collegelocation;
	}

	public void setCollegelocation(String collegelocation) {
		this.collegelocation = collegelocation;
	}

	public String getReferralname() {
		return referralname;
	}

	public void setReferralname(String referralname) {
		this.referralname = referralname;
	}

	public String getYop() {
		return yop;
	}

	public void setYop(String string) {
		this.yop = string;
	}

	public String getCurrentsem() {
		return currentsem;
	}

	public void setCurrentsem(String currentsem) {
		this.currentsem = currentsem;
	}

	public String getKnowntech() {
		return knowntech;
	}

	public void setKnowntech(String knowntech) {
		this.knowntech = knowntech;
	}

	public String getInterntech() {
		return interntech;
	}

	public void setInterntech(String interntech) {
		this.interntech = interntech;
	}
	

	public String getStartdate() {
		return startdate;
	}

	public void setStartdate(String startdate) {
		this.startdate = startdate;
	}

	public String getEnddate() {
		return enddate;
	}

	public void setEnddate(String enddate) {
		this.enddate = enddate;
	}

	public int getInternshipduration() {
		return internshipduration;
	}

	public void setInternshipduration(int durationinMonths) {
		this.internshipduration = durationinMonths;
	}

	@Override
	public String toString() {
		return "Intern [mobileno=" + mobileno + ", email=" + email + ", name=" + name + ", coursename=" + coursename
				+ ", branch=" + branch + ", collegename=" + collegename + ", collegelocation=" + collegelocation
				+ ", referralname=" + referralname + ", yop=" + yop + ", currentsem=" + currentsem + ", knowntech="
				+ knowntech + ", interntech=" + interntech + ", internshipduration=" + internshipduration + ", startdate="
				+ startdate + ", enddate=" + enddate + "]";
	}
	
}
