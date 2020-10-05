package com.galaxe.sonarQube.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties
public class Measures {
	
private String metric;
	
	private String value;
	
	private String bestValue;
	
	private String status;
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

	public String getMetric() {
		return metric;
	}

	public void setMetric(String metric) {
		this.metric = metric;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getBestValue() {
		return bestValue;
	}

	public void setBestValue(String bestValue) {
		this.bestValue = bestValue;
	}
	

}

