package com.galaxe.sonarQube.model;


public class Project {
	
	private String organization;
	private String projectKey;
	private String name;
	private String qualifier;
	private String visibility;
	//private List<String> projects;//
	
	
	
	public Project() {
		super();
	}
	
	public Project(String organization, String projectKey, String name, String qualifier, String visibility) {
		super();
		this.organization = organization;
		this.projectKey = projectKey;
		this.name = name;
		this.qualifier = qualifier;
		this.visibility = visibility;
		//this.projects = projects;
	}
	
	public String getOrganization() {
		return organization;
	}
	public void setOrganization(String organization) {
		this.organization = organization;
	}
	public String getProjectKey() {
		return projectKey;
	}
	public void setProjectKey(String projectKey) {
		this.projectKey = projectKey;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		name = name;
	}
	public String getQualifier() {
		return qualifier;
	}
	public void setQualifier(String qualifier) {
		this.qualifier = qualifier;
	}
	public String getVisibility() {
		return visibility;
	}
	public void setVisibility(String visibility) {
		this.visibility = visibility;
	}
	
	
	

}
