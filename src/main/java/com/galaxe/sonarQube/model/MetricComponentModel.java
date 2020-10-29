package com.galaxe.sonarQube.model;




import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


import lombok.Data;

@JsonIgnoreProperties(ignoreUnknown=true)
@Data
public class MetricComponentModel {
	

	private MetricComponent component;
    

	private Period period;
	
}
