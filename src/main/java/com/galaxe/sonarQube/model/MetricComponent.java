package com.galaxe.sonarQube.model;

import java.util.List;


public class MetricComponent {
private String id;
	
	private String key;
	
	private String name;
	
	private String description;
	
	private String qualifier;
	
	private String status;
	
	public String getNoofduplications() {
		return noofduplications;
	}

	public void setNoofduplications(String noofduplications) {
		this.noofduplications = noofduplications;
	}

	public String getNoofsecurityhotspots() {
		return noofsecurityhotspots;
	}

	public void setNoofsecurityhotspots(String noofsecurityhotspots) {
		this.noofsecurityhotspots = noofsecurityhotspots;
	}

	public String getReliability() {
		return reliability;
	}

	public void setReliability(String reliability) {
		this.reliability = reliability;
	}

	public String getMaintainability() {
		return maintainability;
	}

	public void setMaintainability(String maintainability) {
		this.maintainability = maintainability;
	}

	private String noofduplications;
	private String noofsecurityhotspots;
	private String reliability;
	private String maintainability;
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	private String organizationName;
	
	private String lastAnalysisDate;
	
	public String getOrganizationName() {
		return organizationName;
	}

	public void setOrganizationName(String organizationName) {
		this.organizationName = organizationName;
	}

	

	/*
	 * public Date getLastAnalysisDate() { return lastAnalysisDate; }
	 * 
	 * public void setLastAnalysisDate(Date lastAnalysisDate) {
	 * this.lastAnalysisDate = lastAnalysisDate; }
	 */

	public String getLastAnalysisDate() {
		return lastAnalysisDate;
	}

	public void setLastAnalysisDate(String lastAnalysisDate) {
		this.lastAnalysisDate = lastAnalysisDate;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getQualifier() {
		return qualifier;
	}

	public void setQualifier(String qualifier) {
		this.qualifier = qualifier;
	}

	public List<Measures> getMeasures() {
		return measures;
	}

	public void setMeasures(List<Measures> measures) {
		this.measures = measures;
	}

	private List<Measures> measures;
}
