package com.galaxe.sonarQube.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;

@JsonIgnoreProperties(ignoreUnknown=true)
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Paging {
	
	private int pageIndex;
	private int pageSize;
	private int total;
	
}
