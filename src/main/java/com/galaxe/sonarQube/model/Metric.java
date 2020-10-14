package com.galaxe.sonarQube.model;

import java.util.List;

import lombok.Data;

@Data
public class Metric {
	
	private String complexity;
	private String violations;
	private String ncloc;
	private String bugs;
	private String vulnerabilities;
	private String code_smells;
	private String security_rating;
	private String reliability_rating;
	private String coverage;
	private String duplicated_lines;
	private String sqale_rating;
	private String date;
	private List<History> histories;

	
	

}
