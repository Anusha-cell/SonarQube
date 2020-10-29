package com.galaxe.sonarQube.model;

import lombok.Data;

@Data
public class ProjectMetricsRequest {
	
	private String projectKey;
	private String startDate;
	private String endDate;
	private String metrics;
	private int ps;
	private int p;
	private String components;
	
}
