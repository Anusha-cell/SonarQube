package com.galaxe.sonarQube.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


import lombok.Data;

@Data
@Entity
@Table(name = "issue5")
public class SonarIssueEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private int id;
	
	@Column(name = "total")
	private int total;
	
	@Column(name = "rule")
	public String rule;
	
	@Column(name = "assignee")
	public String assignee;
	
	@Column(name = "severity")
	public String severity;
	
	@Column(name = "resolution")
	public String resolution;
	
	@Column(name = "status")
	public String status;
	
	@Column(name = "component")
	public String component;
	
	
	@Column(name = "project")
	public String project;
	
	@Column(name = "line")
	public int line;
	
	@Column(name = "message")
	public String message;
	
	@Column(name = "effort")
	public String effort;
	
	@Column(name = "debt")
	public String debt;
	
	@Column(name = "creationDate")
    public String creationDate;
	
	@Column(name = "updateDate")
	public String updateDate;
	
	@Column(name = "type")
	public String type;
	
	@Column(name = "organization")
	public String organization;

	

	
}
