package com.galaxe.sonarQube.model;

import java.time.Period;
import java.util.List;

import lombok.Data;

@Data
public class ProjectMetric {
	
	public Component component;
	public List<Metric> metrics;
	public List<Period> periods;
	
	
	

}
