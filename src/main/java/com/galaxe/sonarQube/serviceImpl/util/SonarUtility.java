package com.galaxe.sonarQube.serviceImpl.util;

import java.util.List;

import com.galaxe.sonarQube.entity.SonarqubeEntity;
import com.galaxe.sonarQube.model.Measures;
import com.galaxe.sonarQube.model.MetricComponentModel;
import com.galaxe.sonarQube.model.Period;



public class SonarUtility {
	
	
	 public static void metricsMapper(MetricComponentModel metricsModel, SonarqubeEntity sonarEntity) {
			
			List<Measures> sonarMetrics = metricsModel.getComponent().getMeasures();
			
			sonarEntity.setProject(metricsModel.getComponent().getName());
			sonarEntity.setProjectdescription(metricsModel.getComponent().getDescription());
			sonarEntity.setProjectid(metricsModel.getComponent().getId());
			sonarEntity.setProjectkey(metricsModel.getComponent().getKey());
			sonarEntity.setProjectqualifier(metricsModel.getComponent().getQualifier());
			
			for(Measures metrics:sonarMetrics) {
				if(metrics.getMetric().equals("bugs")) {
					sonarEntity.setNoofbugs(metrics.getValue());
				}
				if(metrics.getMetric().equals("vulnerabilities")) {
					sonarEntity.setNoofvulnerabilities(metrics.getValue());
				}
				if(metrics.getMetric().equals("security_rating")) {
					sonarEntity.setSecurity(metrics.getValue());
				}
				if(metrics.getMetric().equals("ncloc")) {
					sonarEntity.setLinesofcode(metrics.getValue());
				}
				if(metrics.getMetric().equals("coverage")) {
					sonarEntity.setPercentcoverage(metrics.getValue());
				}
				if(metrics.getMetric().equals("violations")) {
					sonarEntity.setViolations(metrics.getValue());
				}
				if(metrics.getMetric().equals("code_smells")) {
					sonarEntity.setNoofcodesmells(metrics.getValue());
				}
				if(metrics.getMetric().equals("reliability_rating")) {
					sonarEntity.setReliability(metrics.getValue());
				}
			
				if(metrics.getMetric().equals("duplicated_lines")) {
					sonarEntity.setPercentduplication(metrics.getValue());
				}
					if(metrics.getMetric().equals("maintainability")) {
					 sonarEntity.setMaintainability(metrics.getValue());}
				
				if(metrics.getMetric().equals("reliability")) {
					sonarEntity.setReliability(metrics.getValue());
				}
				if(metrics.getMetric().equals("noofsecurityhotspots")) {
					sonarEntity.setNoofsecurityhotspots(metrics.getValue());
				
				}
				
			if(metrics.getMetric().equals("noofsecurityhotspots")) {
					sonarEntity.setNoofsecurityhotspots(metrics.getValue());
				
				}
				
				if(metrics.getMetric().equals("status")) {
					sonarEntity.setStatus(metrics.getValue());
				
			}
				
			
			
		}
			Period period = metricsModel.getPeriod();
			sonarEntity.setDate(period.getDate());
			sonarEntity.setMode(period.getMode());
			sonarEntity.setIndex(period.getIndex());

			
	}}


