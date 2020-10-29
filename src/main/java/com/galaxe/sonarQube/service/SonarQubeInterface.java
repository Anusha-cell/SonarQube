package com.galaxe.sonarQube.service;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import org.springframework.stereotype.Service;


import com.galaxe.sonarQube.model.DateRange;
import com.galaxe.sonarQube.model.ProjectMetricsRequest;

@Service
public interface SonarQubeInterface {
	
    //Retrieves all the metrics from the end point URL and storing it in DB
	public String  getAllMetricsofProject(ProjectMetricsRequest projectMetricsRequest) throws IOException;
	
	
	//Return project status based on the project key
	public String getProjetcstatus(String projectKey);
	
	//Returns all the metrics based on the duration
	public String getMetricsById(ProjectMetricsRequest projectMetricsRequest) throws IOException;
	
    //Generates an excel sheet
	public ByteArrayInputStream getGroupRepoDetails(ProjectMetricsRequest projectMetricsRequest) throws IOException;
	
	//Retrieves all the projects
	public String getsearchAllproject() throws  IOException;
	
	//Returns project history
	public String getProjectHistory(ProjectMetricsRequest request)throws  IOException;
	
	//Retrieves the record from the DB by sonarId
	public Object getMetricById(int id);
	
    //Retrieves the record from DB based on the duration
	public Object getMetricByDuration(DateRange dateRange);
	
	//Retrieves all the issues and storing it in DB
	public String getAllIssues(ProjectMetricsRequest projectMetricsRequest) throws IOException;

	
	//Retrieves all the issues and storing in excel sheet
	public ByteArrayInputStream getExcelSheetForIssues(ProjectMetricsRequest projectMetricsRequest) throws IOException;


	//Retrieves all the project(by default it retrieves only 100 projects here)	

	public String getsearchproject();

}

