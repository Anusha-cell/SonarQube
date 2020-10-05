package com.galaxe.sonarQube.model;

import java.util.List;


public class ProjectStatusModel {
	
	private String status;
	
	private List<Condition> conditions;
	
	private List<Periods> periods;
	
	private boolean ignoredConditions;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<Condition> getConditions() {
		return conditions;
	}

	public void setConditions(List<Condition> conditions) {
		this.conditions = conditions;
	}

	public List<Periods> getPeriods() {
		return periods;
	}

	public void setPeriods(List<Periods> periods) {
		this.periods = periods;
	}

	public boolean isIgnoredConditions() {
		return ignoredConditions;
	}

	public void setIgnoredConditions(boolean ignoredConditions) {
		this.ignoredConditions = ignoredConditions;
	}

}
