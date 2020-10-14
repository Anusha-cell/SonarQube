package com.galaxe.sonarQube.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@JsonIgnoreProperties
@Data
public class Measures {
	
    private String metric;
	private String value;
	private String bestValue;
	private String status;
	private String noofduplications;
	private String noofsecurityhotspots;
	private String reliability;
	private String maintainability;
	private String date;
	
}

