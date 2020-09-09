package com.galaxe.sonarQube.service;

public interface SonarQubeInterface {
	public String  getAllMetricsofProject(String ProjectName);
	public String getsearchproject() ;
	public String getProjetcstatus(String projectKey);
	public String getUsergroup();
	public String getUserinUsergroup(String userGroup);
	public String listOfOrganization();
	//public String getAllMetricsofProjectByOrganizationName(String organizationName);
	public String getAllMetricsofProjectByOrganizationName(String organizationName);
	public String getAllMetricsofProjectByUserName(String username);
	//public String getAllMetricsofProjectByOrganizationName(int token);
	public String getAllMetricsofProjectByUserToken(String token);

}
