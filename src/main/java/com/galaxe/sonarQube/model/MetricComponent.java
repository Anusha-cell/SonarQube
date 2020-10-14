package com.galaxe.sonarQube.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@JsonIgnoreProperties
public class MetricComponent {
   
	private String id;
	private String key;
	private String name;
	private String description;
	private String qualifier;
	private String status;
	private String noofduplications;
	private String noofsecurityhotspots;
	private String reliability;
	private String maintainability;
	private String organizationName;
	private List<Measures> measures;
}
