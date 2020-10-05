package com.galaxe.sonarQube.controller;



import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.apache.poi.util.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.galaxe.sonarQube.model.Component;
import com.galaxe.sonarQube.model.DateModel;
import com.galaxe.sonarQube.model.Metric;
import com.galaxe.sonarQube.model.ProjectMetricsRequest;
import com.galaxe.sonarQube.service.SonarQubeInterface;


@RestController
@RequestMapping(path = "/sonarQube")
public class SonarQubeController {
	
	@Autowired
	private SonarQubeInterface sonarQubeService;
	
	 
		//retrieves project metrics based on project key

		@PostMapping("/Metrics")
		public String getAllMetrics(@RequestBody ProjectMetricsRequest projectMetricsRequest){
			
        return sonarQubeService.getAllMetricsofProject(projectMetricsRequest);
		}
		@GetMapping(value="/SearchAllProject")
	     public String searchAllProject(){
	        return sonarQubeService.getsearchAllproject();
	    }
	    @PostMapping("/getSearchHistory") 
	    public String getProjectHistory(@RequestBody ProjectMetricsRequest request)throws JsonParseException, JsonMappingException, IOException{
	    
	    	return sonarQubeService.getProjectHistory(request);
	    }
		
		
		//retrieves all the project details

	    @GetMapping(value="/SearchProject")
	    public String searchProject(){
	        return sonarQubeService.getsearchproject();
	    }
	
	  @PostMapping("/getMetricsBasedOnId") 
	  public String getMetricsById(@RequestBody ProjectMetricsRequest projectMetricsRequest) throws JsonParseException, JsonMappingException, IOException { 
		  
		return sonarQubeService.getMetricsById(projectMetricsRequest);

	  
	  
	  }
	  
	  @GetMapping(value="/getMetrics")
	    public List<String> getMetrics(){
	        return sonarQubeService.getMetrics();
	    }
	  
	 
	  @RequestMapping(value = "/galaxe-dev/projects/projectReportByGroupName", consumes = "application/json", method = RequestMethod.POST)
	    public void getGroupRepoDetails(@RequestBody ProjectMetricsRequest projectMetricsRequest , HttpServletResponse response) throws IOException {
		    response.setContentType("application/octet-stream");
			response.setHeader("Content-Disposition", "attachment; filename=ProjectReport.xlsx");
			ByteArrayInputStream stream = sonarQubeService.getGroupRepoDetails(projectMetricsRequest);
			IOUtils.copy(stream, response.getOutputStream());
		}
       
	  
	  
	 

	    
		//retrieves project status based on project key

	    @GetMapping(value="/projectStatus/{projectKey}")
	    public String projectStatus(@PathVariable String projectKey){
	        return sonarQubeService.getProjetcstatus(projectKey);
	    }
	    
		//retrieves group deatils

	    @GetMapping(value="/userGroup")
	    public String getUsergroup(){
	        return sonarQubeService.getUsergroup();
	    }
	    
		//retrieves user details for the user

	    @GetMapping(value="/user/{userGroup}")
	    public String getUser(@PathVariable String userGroup){
	        return sonarQubeService.getUserinUsergroup(userGroup);
	    }
	    
	    
}
	 
	 
	 
	 
	
	    
	    
	    
	    
