package com.galaxe.sonarQube.controller;






import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.galaxe.sonarQube.service.SonarQubeInterface;


@RestController
@RequestMapping(path = "/sonarQube")
public class SonarQubeController {
	
	@Autowired
	private SonarQubeInterface sonarQubeService;
	 
	    @GetMapping(value="/Metrics/{ProjectName}")
	    public String getAllMetrics(@PathVariable String projectKey){
	        return sonarQubeService.getAllMetricsofProject(projectKey);
	    }
	    
	    @GetMapping(value="/SearchProject")
	    public String searchProject(){
	        return sonarQubeService.getsearchproject();
	    }
	    @GetMapping(value="/projectStatus/{projectKey}")
	    public String projectStatus(@PathVariable String projectKey){
	        return sonarQubeService.getProjetcstatus(projectKey);
	    }
	    
	    @GetMapping(value="/userGroup")
	    public String getUsergroup(){
	        return sonarQubeService.getUsergroup();
	    }
	    

	    @GetMapping(value="/user/{userGroup}")
	    public String getUser(@PathVariable String userGroup){
	        return sonarQubeService.getUserinUsergroup(userGroup);
	    }
	    
	    @GetMapping(value="/listOfOrganization")
	    public String listOfOrganization(){
	        return sonarQubeService.listOfOrganization();
	    }
	    
	
	 @GetMapping(value = "/details/{organization}") 
	 public String getAllMetricsByOrganizationName(@PathVariable(value="organization") String organizationName) throws IOException {
		 return sonarQubeService.getAllMetricsofProjectByOrganizationName(organizationName);
	  }
	 
	 @GetMapping(value = "/userdetails/{username}") 
	 public String getAllMetricsByUserDetail(@PathVariable(value="username") String username) throws IOException {
		 return sonarQubeService.getAllMetricsofProjectByOrganizationName(username);
	  }
	 
	 
	 
	 @GetMapping(value = "/project/{token}") 
	 public String getAllMetricsofProjectByUserToken(@PathVariable(value="token") String token) throws IOException {
		 return sonarQubeService.getAllMetricsofProjectByUserToken(token);
	  }
	 
	 
	    
	    
	    
	    
	    
}
