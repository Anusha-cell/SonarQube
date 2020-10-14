package com.galaxe.sonarQube.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@JsonIgnoreProperties
@Data
public class Component {
	

	private String organization;
	
	private String key;
	
	private String name;
	
	private String visibility;
	
	private String qualifier;
	
	private String lastAnalysisDate;
	
	private String revision;
 
	
	
}
