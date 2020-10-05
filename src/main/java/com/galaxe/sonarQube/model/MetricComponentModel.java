package com.galaxe.sonarQube.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties
public class MetricComponentModel {
	private MetricComponent component;

	public MetricComponent getComponent() {
		return component;
	}

	public void setComponent(MetricComponent component) {
		this.component = component;
	}

}
