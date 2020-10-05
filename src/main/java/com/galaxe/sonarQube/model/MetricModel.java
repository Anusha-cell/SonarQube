package com.galaxe.sonarQube.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@JsonIgnoreProperties
public class MetricModel {
	
	private Paging paging;
	private List<Measures> measures;
	public Paging getPaging() {
		return paging;
	}
	public void setPaging(Paging paging) {
		this.paging = paging;
	}
	public List<Measures> getMeasures() {
		return measures;
	}
	public void setMeasures(List<Measures> measures) {
		this.measures = measures;
	}
	
	

}
