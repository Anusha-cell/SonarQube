package com.galaxe.sonarQube.model;

import java.time.Period;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@JsonIgnoreProperties
public class Measure {
	
	public Metric metric;
	public String value;
	public List<Period> period;
	public boolean bestValue;
	
	
	
	

}
