package com.galaxe.sonarQube.model;

import java.time.Period;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties
public class Measure {
	
	public Metric metric;
	public String value;
	public List<Period> period;
	public boolean bestValue;
	
	
	public Metric getMetric() {
		return metric;
	}
	public void setMetric(Metric metric) {
		this.metric = metric;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public Measure() {
		super();
	}
	public List<Period> getPeriod() {
		return period;
	}
	public void setPeriod(List<Period> period) {
		this.period = period;
	}
	public Measure(Metric metric, String value, List<Period> period, boolean bestValue) {
		super();
		this.metric = metric;
		this.value = value;
		this.period = period;
		this.bestValue = bestValue;
	}
	public boolean isBestValue() {
		return bestValue;
	}
	public void setBestValue(boolean bestValue) {
		this.bestValue = bestValue;
	}
	
	

}
