package com.galaxe.sonarQube.model;


public class Component {
	

	private String organization;
	
	private String key;
	
	private String name;
	
	private String visibility;
	
	private String qualifier;
	
	private String lastAnalysisDate;
	
	private String revision;
    private String status;
 //   private Metric metric;
    
   
    
     
	

	public Component() {
		super();
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	

	public Component(String organization, String key, String name, String visibility, String qualifier,
			String lastAnalysisDate, String revision, String status) {
		super();
		this.organization = organization;
		this.key = key;
		this.name = name;
		this.visibility = visibility;
		this.qualifier = qualifier;
		this.lastAnalysisDate = lastAnalysisDate;
		this.revision = revision;
		this.status = status;
	}

	public String getRevision() {
		return revision;
	}

	public void setRevision(String revision) {
		this.revision = revision;
	}

	public String getOrganization() {
		return organization;
	}

	public void setOrganization(String organization) {
		this.organization = organization;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public String getLastAnalysisDate() {
		return lastAnalysisDate;
	}

	public void setLastAnalysisDate(String lastAnalysisDate) {
		this.lastAnalysisDate = lastAnalysisDate;
	}

		

	
	
}
