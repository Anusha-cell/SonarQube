package com.galaxe.sonarQube.controller;



import java.io.ByteArrayInputStream;
import java.io.IOException;
import javax.servlet.http.HttpServletResponse;
import org.apache.poi.util.IOUtils;
import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.galaxe.sonarQube.exception.DataIntegrityViolationException;
import com.galaxe.sonarQube.model.DateRange;
import com.galaxe.sonarQube.model.ProjectMetricsRequest;
import com.galaxe.sonarQube.service.SonarQubeInterface;


@RestController
@RequestMapping(path = "/Sonarqube")
public class SonarQubeController {
	
	@Autowired
		private SonarQubeInterface sonarQubeService;
	
		private static final org.jboss.logging.Logger logger = LoggerFactory.logger(SonarQubeController.class);

		//retrieves project metrics based on project key

		@PostMapping("/Metrics")
		public String getAllMetrics(@RequestBody ProjectMetricsRequest projectMetricsRequest) throws IOException{
			
        return sonarQubeService.getAllMetricsofProject(projectMetricsRequest);
		}
		
		//Retrieves all the projects

		@GetMapping(value="/SearchAllProject")
	     public String searchAllProject() throws IOException{
	        return sonarQubeService.getsearchAllproject();
	    }
		
		//Returns project history

	    @PostMapping("/getSearchHistory") 
	    public String getProjectHistory(@RequestBody ProjectMetricsRequest request)throws IOException{
	    
	    	return sonarQubeService.getProjectHistory(request);
	    }
		
		
	  //Retrieves all the project(by default it retrieves only 100 projects here)

	    @GetMapping(value="/SearchProject")
	    public String searchProject(){
	        return sonarQubeService.getsearchproject();
	    }
	
	  //Returns all the metrics based on the duration
  
	  @PostMapping("/getMetricsBasedOnId") 
	  public String getMetricsById(@RequestBody ProjectMetricsRequest projectMetricsRequest) throws IOException { 
		  
		return sonarQubeService.getMetricsById(projectMetricsRequest);
	  }
	  
	 
	  //Generates an excel sheet

	  @PostMapping("/getMetricsExcelsheet")
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

	    @PostMapping("/getById")//change
	    public ResponseEntity<Object> getMetricsById(@PathVariable int id)
	    {
	    	
		    	return ResponseEntity.ok().body(sonarQubeService.getMetricById(id));
			
	    }
	    
	    //Retrieves the record from DB based on the duration

	    @PostMapping("/getDataBasedOnDuration")
	    public ResponseEntity<Object> getMetricsByDuration(@RequestBody DateRange dateRange)
	    {
	    	try {
	            if(dateRange==null)
	            
	                throw new NullPointerException("NullPointerException : " + dateRange);
	    			logger.info("In ResourceService getMetricsByDuration method ended");

					throw new com.galaxe.sonarQube.exception.NullPointerException(HttpStatus.NOT_FOUND);
	        } catch (DataIntegrityViolationException e) {
				logger.debug("In ResourceService getMetricsByDuration Method throwed NullPointerException ", e.getMessage(),
						e);
		}
			return ResponseEntity.ok().body(sonarQubeService.getMetricByDuration(dateRange));
	    	
	    }
	    
		//Retrieves all the issues and storing it in DB
	    
	    @PostMapping("/getAllIssues")
		public String getAllIssues(@RequestBody ProjectMetricsRequest projectMetricsRequest) throws IOException{
			
        return sonarQubeService.getAllIssues(projectMetricsRequest);
		}
	    
	    
		//Retrieves all the issues and storing in excel sheet

	    @PostMapping("/getExcelsheetForIssues")
	    public void getExcelsheetForIssues(@RequestBody ProjectMetricsRequest projectMetricsRequest , HttpServletResponse response) throws IOException {
		    response.setContentType("application/octet-stream");
			response.setHeader("Content-Disposition", "attachment; filename=ProjectReport.xlsx");
			ByteArrayInputStream stream = sonarQubeService.getExcelSheetForIssues(projectMetricsRequest);
			IOUtils.copy(stream, response.getOutputStream());
		}
	    
}
	 
	 
	 
	 
	
	    
	    
	    
	    
