package com.galaxe.sonarQube.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


import lombok.Data;

@JsonIgnoreProperties(ignoreUnknown=true)
@Data
public class Component {
	

	private String organization;
	
	private String key;
	
	private String id;
	 
	private String description;
	
	private String name;
	
	private String visibility;
	
	private String qualifier;
	
	private String lastAnalysisDate;
	
	private String revision;
 
	private List<Measure> measures;

	
	
}
