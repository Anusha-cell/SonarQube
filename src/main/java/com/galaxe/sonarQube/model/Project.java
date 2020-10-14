package com.galaxe.sonarQube.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@JsonIgnoreProperties
public class Project {
	
	private String organization;
	private String projectKey;
	private String name;
	private String qualifier;
	private String visibility;
	
	

}
