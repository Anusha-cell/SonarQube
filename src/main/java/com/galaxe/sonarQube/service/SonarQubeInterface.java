package com.galaxe.sonarQube.service;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import org.springframework.http.ResponseEntity;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.galaxe.sonarQube.model.DateModel;
import com.galaxe.sonarQube.model.ProjectMetricsRequest;

public interface SonarQubeInterface {
	public String  getAllMetricsofProject(ProjectMetricsRequest projectMetricsRequest);
	public String getsearchproject() ;
	public String getProjetcstatus(String projectKey);
	public String getUsergroup();
	public String getUserinUsergroup(String userGroup);
	//public String listOfOrganization();
	//public String getAllMetricsofProjectByOrganizationName(String organizationName);
	//public String getAllMetricsofProjectByUserName(String username);
	//public String getAllMetricsofProjectByUserToken(String token);
	//public String getAllIssuesOfProject();
	//public String getIssuesBasedOnTypeAndSeverities();
	//public String getIssuesForTheAssignee(String componentKeys, String assignee);
	//public String getIssuesBasedOnDuration();
	//public String getIssuesBasedOnDuration(String projectKey,String from, String to);
     public String getIssuesBasedOnDuration(List<String> metric, List<String> portfolio);
	//public String getAllMetricsofProject(List<String> projectKey);
	public String getMetricsById(ProjectMetricsRequest projectMetricsRequest) throws JsonParseException, JsonMappingException, IOException;
	//public ResponseEntity<Object> getMetricsBasedOnDuration(String string, String string2);
	public List<String> getMetricsBasedOnDuration(Date from, Date to, List<String> list);
	public List<String> getMetrics();
	public List<String> getMetricsBasedOnKey(String key);
	public ByteArrayInputStream getGroupRepoDetails(ProjectMetricsRequest projectMetricsRequest) throws JsonParseException, JsonMappingException, IOException;
	public String getsearchAllproject();
	public String getProjectHistory(ProjectMetricsRequest request)throws JsonParseException, JsonMappingException, IOException;;

}

