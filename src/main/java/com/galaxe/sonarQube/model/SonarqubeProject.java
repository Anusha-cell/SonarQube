package com.galaxe.sonarQube.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown=true)
public class SonarqubeProject {
	
    private Paging paging;
	
	private List<Component> components;

	
}
