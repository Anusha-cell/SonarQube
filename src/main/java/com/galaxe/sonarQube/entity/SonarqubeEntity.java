package com.galaxe.sonarQube.entity;


public class SonarqubeEntity {
	
    private Integer sonarId;
	
	public Integer getSonarId() {
		return sonarId;
	}

	public void setSonarId(Integer sonarId) {
		this.sonarId = sonarId;
	}

	public String getOrganizationName() {
		return organizationName;
	}

	public void setOrganizationName(String organizationName) {
		this.organizationName = organizationName;
	}

	public String getProduct() {
		return product;
	}

	public void setProduct(String product) {
		this.product = product;
	}

	public String getProject() {
		return project;
	}

	public void setProject(String project) {
		this.project = project;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public String getLastAnalysisDate() {
		return lastAnalysisDate;
	}

	public void setLastAnalysisDate(String lastAnalysisDate) {
		this.lastAnalysisDate = lastAnalysisDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getLinesofcode() {
		return linesofcode;
	}

	public void setLinesofcode(String linesofcode) {
		this.linesofcode = linesofcode;
	}

	public String getNoofbugs() {
		return noofbugs;
	}

	public void setNoofbugs(String noofbugs) {
		this.noofbugs = noofbugs;
	}

	public String getNoofvulnerabilities() {
		return noofvulnerabilities;
	}

	public void setNoofvulnerabilities(String noofvulnerabilities) {
		this.noofvulnerabilities = noofvulnerabilities;
	}

	public String getNoofcodesmells() {
		return noofcodesmells;
	}

	public void setNoofcodesmells(String noofcodesmells) {
		this.noofcodesmells = noofcodesmells;
	}

	public String getPercentcoverage() {
		return percentcoverage;
	}

	public void setPercentcoverage(String percentcoverage) {
		this.percentcoverage = percentcoverage;
	}

	public String getNoofsecurityhotspots() {
		return noofsecurityhotspots;
	}

	public void setNoofsecurityhotspots(String noofsecurityhotspots) {
		this.noofsecurityhotspots = noofsecurityhotspots;
	}

	public String getReliability() {
		return reliability;
	}

	public void setReliability(String reliability) {
		this.reliability = reliability;
	}

	public String getSecurity() {
		return security;
	}

	public void setSecurity(String security) {
		this.security = security;
	}

	public String getMaintainability() {
		return maintainability;
	}

	public void setMaintainability(String maintainability) {
		this.maintainability = maintainability;
	}

	public String getPercentduplication() {
		return percentduplication;
	}

	public void setPercentduplication(String percentduplication) {
		this.percentduplication = percentduplication;
	}

	public String getProjectkey() {
		return projectkey;
	}

	public void setProjectkey(String projectkey) {
		this.projectkey = projectkey;
	}

	public String getProjectid() {
		return projectid;
	}

	public void setProjectid(String projectid) {
		this.projectid = projectid;
	}

	public String getProjectdescription() {
		return projectdescription;
	}

	public void setProjectdescription(String projectdescription) {
		this.projectdescription = projectdescription;
	}

	public String getProjectqualifier() {
		return projectqualifier;
	}

	public void setProjectqualifier(String projectqualifier) {
		this.projectqualifier = projectqualifier;
	}

	public String getViolations() {
		return violations;
	}

	public void setViolations(String violations) {
		this.violations = violations;
	}

	private String organizationName="eXtreme";
	
	private String product="BenifitOverview";
	private String project;
	
	private String size="SMALL";


	private String lastAnalysisDate;


	private String status="OK";


	private String linesofcode;


	private String noofbugs;


	private String noofvulnerabilities;


	private String noofcodesmells;


	private String percentcoverage;

    private String noofsecurityhotspots;


	private String reliability;


	private String security;


	private String maintainability="1";


	private String percentduplication;
	
	
	private String projectkey;


	private String projectid;


	

	private String projectdescription;
	

	private String projectqualifier;
	
	private String violations;
	

}
