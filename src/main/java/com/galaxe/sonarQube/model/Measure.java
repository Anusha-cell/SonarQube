package com.galaxe.sonarQube.model;

import java.time.Period;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


import lombok.Data;

@JsonIgnoreProperties(ignoreUnknown=true)
@Data
public class Measure {
	

	private String metric;
	private String value;
	private List<Period> period;
	private boolean bestValue;
    private List<History> history;

	
	
	
	

}
