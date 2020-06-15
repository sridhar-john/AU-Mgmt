package com.accolite.model;

public class Opportunity {

	
	private int id ;
	private String opportunityName ;
	private int experience ;
	private String hiringManager ;
	private String skill ;
	private String creator ;
	private String creatorEmail ;
	private String jobLocation;
	private String joiningDate;
	private String updatedDate;
	public Opportunity() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Opportunity(int id, String opportunityName, int experience, String hiringManager, String skill,
			String creator, String creatorEmail, String jobLocation, String joiningDate, String updatedDate) {
		super();
		this.id = id;
		this.opportunityName = opportunityName;
		this.experience = experience;
		this.hiringManager = hiringManager;
		this.skill = skill;
		this.creator = creator;
		this.creatorEmail = creatorEmail;
		this.jobLocation = jobLocation;
		this.joiningDate = joiningDate;
		this.updatedDate = updatedDate;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getopportunityName() {
		return opportunityName;
	}
	public void setopportunityName(String opportunityName) {
		this.opportunityName = opportunityName;
	}
	public int getExperience() {
		return experience;
	}
	public void setExperience(int experience) {
		this.experience = experience;
	}
	public String gethiringManager() {
		return hiringManager;
	}
	public void sethiringManager(String hiringManager) {
		this.hiringManager = hiringManager;
	}
	public String getSkill() {
		return skill;
	}
	public void setSkill(String skill) {
		this.skill = skill;
	}
	public String getCreator() {
		return creator;
	}
	public void setCreator(String creator) {
		this.creator = creator;
	}
	public String getcreatorEmail() {
		return creatorEmail;
	}
	public void setcreatorEmail(String creatorEmail) {
		this.creatorEmail = creatorEmail;
	}
	public String getjobLocation() {
		return jobLocation;
	}
	public void setjobLocation(String jobLocation) {
		this.jobLocation = jobLocation;
	}
	public String getjoiningDate() {
		return joiningDate;
	}
	public void setjoiningDate(String joiningDate) {
		this.joiningDate = joiningDate;
	}
	public String getupdatedDate() {
		return updatedDate;
	}
	public void setupdatedDate(String updatedDate) {
		this.updatedDate = updatedDate;
	}
	
	
	

}
