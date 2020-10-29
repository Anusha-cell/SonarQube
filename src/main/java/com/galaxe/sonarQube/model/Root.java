package com.galaxe.sonarQube.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.galaxe.sonarQube.issue.model.Paging;

import lombok.Data;

@JsonIgnoreProperties(ignoreUnknown=true)
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Root {
	
	private Paging paging;
    private List<Measure> measures;
    private Component component;
    private Period period;
}
