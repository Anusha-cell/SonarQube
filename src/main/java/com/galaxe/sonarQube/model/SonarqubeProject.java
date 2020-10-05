package com.galaxe.sonarQube.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties
public class SonarqubeProject {
	
private Paging paging;
	
	private List<Component> components;

	public Paging getPaging() {
		return paging;
	}

	public void setPaging(Paging paging) {
		this.paging = paging;
	}

	public List<Component> getComponents() {
		return components;
	}

	public SonarqubeProject() {
		super();
	}

	public void setComponents(List<Component> components) {
		this.components = components;
	}

	public SonarqubeProject(Paging paging, List<Component> components) {
		super();
		this.paging = paging;
		this.components = components;
	}

}
