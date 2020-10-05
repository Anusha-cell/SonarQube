package com.galaxe.sonarQube.model;

import java.time.Period;
import java.util.List;

public class ProjectMetric {
	
	public Component component;
	public List<Metric> metrics;
	public List<Period> periods;
	public Component getComponent() {
		return component;
	}
	public void setComponent(Component component) {
		this.component = component;
	}
	public List<Metric> getMetrics() {
		return metrics;
	}
	public void setMetrics(List<Metric> metrics) {
		this.metrics = metrics;
	}
	public List<Period> getPeriods() {
		return periods;
	}
	public void setPeriods(List<Period> periods) {
		this.periods = periods;
	}
	
	

}
