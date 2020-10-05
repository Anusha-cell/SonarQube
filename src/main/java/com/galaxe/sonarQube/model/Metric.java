package com.galaxe.sonarQube.model;

import java.util.List;

public class Metric {
	
	private String complexity;
	private String violations;
	private String ncloc;
	private String bugs;
	private String vulnerabilities;
	private String code_smells;
	private String security_rating;
	private String reliability_rating;
	private String coverage;
	private String duplicated_lines;
	private String sqale_rating;
	private List<String> metrics;
	
	public List<String> getMetrics() {
		return metrics;
	}
	public void setMetrics(List<String> metrics) {
		this.metrics = metrics;
	}
	private List<History> histories;
	public List<History> getHistories() {
		return histories;
	}
	public void setHistories(List<History> histories) {
		this.histories = histories;
	}
	public Metric() {
		super();
	}
	private List<String> metric;
	
	
	
	public Metric(String complexity, String violations, String ncloc, String bugs, String vulnerabilities,
			String code_smells, String security_rating, String reliability_rating, String coverage,
			String duplicated_lines, String sqale_rating, List<String> metrics, List<History> histories,
			List<String> metric) {
		super();
		this.complexity = complexity;
		this.violations = violations;
		this.ncloc = ncloc;
		this.bugs = bugs;
		this.vulnerabilities = vulnerabilities;
		this.code_smells = code_smells;
		this.security_rating = security_rating;
		this.reliability_rating = reliability_rating;
		this.coverage = coverage;
		this.duplicated_lines = duplicated_lines;
		this.sqale_rating = sqale_rating;
		this.metrics = metrics;
		this.histories = histories;
		this.metric = metric;
	}
	public List<String> getMetric() {
		return metric;
	}
	public void setMetric(List<String> metric) {
		this.metric = metric;
	}
	public String getComplexity() {
		return complexity;
	}
	public void setComplexity(String complexity) {
		this.complexity = complexity;
	}
	public String getViolations() {
		return violations;
	}
	public void setViolations(String violations) {
		this.violations = violations;
	}
	public String getNcloc() {
		return ncloc;
	}
	public void setNcloc(String ncloc) {
		this.ncloc = ncloc;
	}
	public String getBugs() {
		return bugs;
	}
	public void setBugs(String bugs) {
		this.bugs = bugs;
	}
	public String getVulnerabilities() {
		return vulnerabilities;
	}
	public void setVulnerabilities(String vulnerabilities) {
		this.vulnerabilities = vulnerabilities;
	}
	public String getCode_smells() {
		return code_smells;
	}
	public void setCode_smells(String code_smells) {
		this.code_smells = code_smells;
	}
	public String getSecurity_rating() {
		return security_rating;
	}
	public void setSecurity_rating(String security_rating) {
		this.security_rating = security_rating;
	}
	public String getReliability_rating() {
		return reliability_rating;
	}
	public void setReliability_rating(String reliability_rating) {
		this.reliability_rating = reliability_rating;
	}
	public String getCoverage() {
		return coverage;
	}
	public void setCoverage(String coverage) {
		this.coverage = coverage;
	}
	public String getDuplicated_lines() {
		return duplicated_lines;
	}
	public void setDuplicated_lines(String duplicated_lines) {
		this.duplicated_lines = duplicated_lines;
	}
	public String getSqale_rating() {
		return sqale_rating;
	}
	public void setSqale_rating(String sqale_rating) {
		this.sqale_rating = sqale_rating;
	}
	
	
	

}
