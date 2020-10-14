package com.galaxe.sonarQube.model;

import lombok.Data;

@Data
public class ProjectMetricsRequest {
	
	public String projectKey;
	public String startDate;
	public String endDate;
	public String metrics;
	public int ps;
	public int p;
	public String components;
	
}
