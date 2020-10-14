package com.galaxe.sonarQube.entity;

import java.sql.Date;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
@Entity
@Table(name="sonar11")
public class SonarqubeEntity {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer sonarId;
	
	@Column(name = "Team")
	private String organizationName="eXtreme";
	
	@Column(name = "product")
	private String product="BenifitOverview";

	@Column(name = "project")
	private String project;
	
	@Column(name = "size")
	private String size="SMALL";

	@Column(name = "lastAnalysisDate")
	//@JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss[.SSS][.SS][.S]")

	private Timestamp date;
	
	@Column(name = "mode")
	private String mode;
	
	@Column(name = "index")
	private int index;
	
	@Column(name = "status")
	private String status;

	@Column(name = "linesofcode")
	private String linesofcode;

	@Column(name = "noofbugs")
	private String noofbugs;

	@Column(name = "noofvulnerabilities")
	private String noofvulnerabilities;

	@Column(name = "noofcodesmells")
	private String noofcodesmells;

	@Column(name = "percentcoverage")
	private String percentcoverage;

	@Column(name = "noofsecurityhotspots")
	private String noofsecurityhotspots;

	@Column(name = "reliability")
	private String reliability;

	@Column(name = "security")
	private String security;

	@Column(name = "maintainability")
	private String maintainability="1";

	@Column(name = "percentduplication")
	private String percentduplication;
	
	@Column(name = "projectkey")
	private String projectkey;

	@Column(name = "projectid")
	private String projectid;

	@Column(name = "projectdescription")
	private String projectdescription;
	
	@Column(name = "projectqualifier")
	private String projectqualifier;
	
	@Column(name = "violations")
	private String violations;
}
