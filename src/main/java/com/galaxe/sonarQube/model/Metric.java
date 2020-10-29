package com.galaxe.sonarQube.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@JsonIgnoreProperties(ignoreUnknown=true)

@Data
public class Metric {
	
	
	private List<History> histories;

	
	

}
