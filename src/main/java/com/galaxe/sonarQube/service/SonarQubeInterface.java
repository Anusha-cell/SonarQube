package com.galaxe.sonarQube.service;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.galaxe.sonarQube.entity.SonarqubeEntity;
import com.galaxe.sonarQube.model.DateRange;
import com.galaxe.sonarQube.model.ProjectMetricsRequest;

public interface SonarQubeInterface {
	
    //Retrieves all the metrics from the end point URL and storing it in DB
	public String  getAllMetricsofProject(ProjectMetricsRequest projectMetricsRequest) throws JsonParseException, JsonMappingException, IOException, NotFoundException;
	
	//Retrieves all the project
	public String getsearchproject() ;
	
	//Return project status based on the project key
	public String getProjetcstatus(String projectKey);
	
	//Returns all the metrics based on the duration
	public String getMetricsById(ProjectMetricsRequest projectMetricsRequest) throws JsonParseException, JsonMappingException, IOException;
	
    //Generates an excel sheet
	public ByteArrayInputStream getGroupRepoDetails(ProjectMetricsRequest projectMetricsRequest) throws JsonParseException, JsonMappingException, IOException;
	
	//Retrieves all the projects
	public String getsearchAllproject();
	
	//Returns project history
	public String getProjectHistory(ProjectMetricsRequest request)throws JsonParseException, JsonMappingException, IOException;
	
	//Retrieves the record from the DB by sonarId
	public Object getMetricById(SonarqubeEntity entity);
	
    //Retrieves the record from DB based on the duration
	public Object getMetricByDuration(DateRange dateRange);;

}

