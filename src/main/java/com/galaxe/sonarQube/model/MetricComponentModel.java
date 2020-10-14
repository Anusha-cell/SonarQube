package com.galaxe.sonarQube.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@JsonIgnoreProperties
public class MetricComponentModel {
	
	private MetricComponent component;
	private Period period;
	
}
