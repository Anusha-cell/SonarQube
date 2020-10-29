package com.galaxe.sonarQube.model;

import java.time.Period;
import java.util.List;

import lombok.Data;

@Data
public class ProjectMetric {
	
	private Component component;
	private List<Metric> metrics;
	private List<Period> periods;
	
	
	

}
