package com.galaxe.sonarQube.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@JsonIgnoreProperties
public class Paging {
	
	private int pageIndex;
	private int pageSize;
	private int total;
	
}
