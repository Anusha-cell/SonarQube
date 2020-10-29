package com.galaxe.sonarQube.model;

import java.util.List;

import lombok.Data;
@Data
public class ProjectStatusModel {
	
	private String status;
	
	private List<Condition> conditions;
	
	//private List<Period> periods;
	
	private boolean ignoredConditions;

}
