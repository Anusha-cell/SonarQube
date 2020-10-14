package com.galaxe.sonarQube.model;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@JsonIgnoreProperties
public class MetricModel {
	
	private Paging paging;
	private List<Measures> measures;
	
	
	

}
