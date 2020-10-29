package com.galaxe.sonarQube.serviceImpl.util;

import java.util.List;
import com.galaxe.sonarQube.entity.SonarIssueEntity;
import com.galaxe.sonarQube.entity.SonarqubeEntity;
import com.galaxe.sonarQube.issue.model.Issue;
import com.galaxe.sonarQube.issue.model.Root;
import com.galaxe.sonarQube.model.Measure;

import com.galaxe.sonarQube.model.Period;



public class SonarUtility {
	
	private SonarUtility(){}
	
	
	 public static SonarqubeEntity metricsMapper(com.galaxe.sonarQube.model.Root metricsModel, SonarqubeEntity sonarEntity) {
			
			List<Measure> sonarMetrics = metricsModel.getComponent().getMeasures();
			
			
			
			sonarEntity.setProject(metricsModel.getComponent().getName());
			sonarEntity.setProjectdescription(metricsModel.getComponent().getDescription());
			sonarEntity.setProjectid(metricsModel.getComponent().getId());
			sonarEntity.setProjectkey(metricsModel.getComponent().getKey());
			sonarEntity.setProjectqualifier(metricsModel.getComponent().getQualifier());
			
			for(Measure metrics:sonarMetrics) {
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
					
				
				if(metrics.getMetric().equals("reliability")) {
					sonarEntity.setReliability(metrics.getValue());
				}
				if(metrics.getMetric().equals("security_hotspots")) {
					sonarEntity.setNoofsecurityhotspots(metrics.getValue());
				
				}
				
			if(metrics.getMetric().equals("noofsecurityhotspots")) {
					sonarEntity.setNoofsecurityhotspots(metrics.getValue());
				
				}
			}
			Period period = metricsModel.getPeriod();
			sonarEntity.setDate(period.getDate());
			sonarEntity.setMode(period.getMode());
			sonarEntity.setIndex(period.getIndex());
			return sonarEntity;
			
			
	}

	
	 public static List<SonarIssueEntity> metricsMapper(Root metricsModel, List<SonarIssueEntity> sonarIssueEntities) {
			
		 List<Issue> issues=metricsModel.getIssues();
			
			metricsModel.setTotal(metricsModel.getTotal());
			
			
			 for(int i= 0 ;i<issues.size();i++){
				 SonarIssueEntity sonarIssueEntityList=new SonarIssueEntity();
				 sonarIssueEntityList.setSeverity(issues.get(i).getSeverity());
				 sonarIssueEntityList.setLine(issues.get(i).getLine());
				 sonarIssueEntityList.setMessage(issues.get(i).getMessage());
				 sonarIssueEntityList.setOrganization(issues.get(i).getOrganization());
				 sonarIssueEntityList.setProject(issues.get(i).getProject());
				 sonarIssueEntityList.setRule(issues.get(i).getRule());
				 sonarIssueEntityList.setEffort(issues.get(i).getEffort());
				 sonarIssueEntityList.setDebt(issues.get(i).getDebt());
				 sonarIssueEntityList.setCreationDate(issues.get(i).getCreationDate());
				 sonarIssueEntityList.setUpdateDate(issues.get(i).getUpdateDate());
				 sonarIssueEntityList.setType(issues.get(i).getType());
				 sonarIssueEntityList.setComponent(issues.get(i).getComponent());
				 sonarIssueEntityList.setTotal(metricsModel.getTotal());
				 sonarIssueEntityList.setAssignee(issues.get(i).getAssignee());
				 sonarIssueEntityList.setStatus(issues.get(i).getStatus());
				 sonarIssueEntityList.setResolution(issues.get(i).getResolution());
					
				sonarIssueEntities.add(sonarIssueEntityList);
					
			

		}
			return sonarIssueEntities;
			
		}


	}
