package com.galaxe.sonarQube.controller;



import java.io.ByteArrayInputStream;
import java.io.IOException;
import javax.servlet.http.HttpServletResponse;
import org.apache.poi.util.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.galaxe.sonarQube.model.DateRange;
import com.galaxe.sonarQube.model.ProjectMetricsRequest;
import com.galaxe.sonarQube.service.SonarQubeInterface;


@RestController
@RequestMapping(path = "/Sonarqube")
public class SonarQubeController {
	
	@Autowired
	private SonarQubeInterface sonarQubeService;
	
	 
		//retrieves project metrics based on project key

		@PostMapping("/Metrics")
		public String getAllMetrics(@RequestBody ProjectMetricsRequest projectMetricsRequest) throws JsonParseException, JsonMappingException, IOException, NotFoundException{
			
        return sonarQubeService.getAllMetricsofProject(projectMetricsRequest);
		}
		
		//Retrieves all the projects

		@GetMapping(value="/SearchAllProject")
	     public String searchAllProject(){
	        return sonarQubeService.getsearchAllproject();
	    }
		
		//Returns project history

	    @PostMapping("/getSearchHistory") 
	    public String getProjectHistory(@RequestBody ProjectMetricsRequest request)throws JsonParseException, JsonMappingException, IOException{
	    
	    	return sonarQubeService.getProjectHistory(request);
	    }
		
		
		//retrieves all the project details

	    @GetMapping(value="/SearchProject")
	    public String searchProject(){
	        return sonarQubeService.getsearchproject();
	    }
	
	  //Returns all the metrics based on the duration
  
	  @PostMapping("/getMetricsBasedOnId") 
	  public String getMetricsById(@RequestBody ProjectMetricsRequest projectMetricsRequest) throws JsonParseException, JsonMappingException, IOException { 
		  
		return sonarQubeService.getMetricsById(projectMetricsRequest);
	  }
	  
	 
	  //Generates an excel sheet

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
	    
		//Retrieves the record from the DB by sonarId

	    @PostMapping("/getById")
	    public ResponseEntity<Object> getMetricsById(@RequestBody com.galaxe.sonarQube.entity.SonarqubeEntity entity)
	    {
			return ResponseEntity.ok().body(sonarQubeService.getMetricById(entity));
	    	
	    }
	    
	    //Retrieves the record from DB based on the duration

	    @PostMapping("/getDataBasedOnDuration")
	    public ResponseEntity<Object> getMetricsByDuration(@RequestBody DateRange dateRange)
	    {
			return ResponseEntity.ok().body(sonarQubeService.getMetricByDuration(dateRange));
	    	
	    }
	    
}
	 
	 
	 
	 
	
	    
	    
	    
	    
