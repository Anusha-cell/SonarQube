package com.galaxe.sonarQube.serviceImpl;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.galaxe.sonarQube.constant.Constant;
import com.galaxe.sonarQube.entity.SonarIssueEntity;
import com.galaxe.sonarQube.entity.SonarqubeEntity;
import com.galaxe.sonarQube.exception.ResourceNotFoundException;
import com.galaxe.sonarQube.issue.model.Root;
import com.galaxe.sonarQube.model.DateRange;
import com.galaxe.sonarQube.model.Paging;
import com.galaxe.sonarQube.model.ProjectMetricsRequest;
import com.galaxe.sonarQube.model.SonarqubeProject;
import com.galaxe.sonarQube.repository.IssueRepository;
import com.galaxe.sonarQube.repository.SonarRepository;
import com.galaxe.sonarQube.service.SonarQubeInterface;
import com.galaxe.sonarQube.serviceImpl.util.SonarUtility;


@Service
public class SonarQubeServiceImpl implements SonarQubeInterface {
	
	
	
	private static final org.jboss.logging.Logger logger = LoggerFactory.logger(SonarQubeServiceImpl.class);


	@Autowired
	private RestTemplate template;
	
	@Autowired
	private SonarRepository repository;
	
	@Autowired
	private IssueRepository issueRepository;

	
	@Value("${searchprojectUrl}")	
	private String searchProjectUrl;
	
	@Value("${projectstatusUrl}")	
	private String projectstatusUrl;
	
	@Value("${projecthistoryUrl}")	
	private String projecthistoryUrl;
	
	@Value("${metricUrl}")	
	private String metricUrl;
	
	@Value("${issueUrl}")
	private String issueUrl;
	
	
	
	//Retrieves all the projects
	@Override
	public String getsearchAllproject() throws IOException {
		
		String result="";
	    List<String> object=new ArrayList<>();
        StringBuilder builder=new StringBuilder();
        SonarqubeProject sonarqubeProject;

		int j=1;
		do
		{
        
        String url=searchProjectUrl+"?p="+j;
	    ResponseEntity<String> res=template.exchange(url, HttpMethod.GET, new HttpEntity<Object>(createHeaders(Constant.USERNAME, Constant.PASSWORD)), String.class);
	    builder.append(res.getBody());
		result=builder.toString();
		
		ObjectMapper mapper=new ObjectMapper();
		sonarqubeProject=mapper.readValue(builder.toString(), SonarqubeProject.class);
		object.add(result);
		j++;
	    }while(j<=(sonarqubeProject.getPaging().getTotal()/100)+1); 
		
		ObjectMapper mapper=new ObjectMapper();
		
		sonarqubeProject=mapper.readValue(result, SonarqubeProject.class);
		
		return result;
    
	}
	
	//Retrieves all the project(by default it retrieves only 100 projects here)
	@Override
	public String getsearchproject() {
	    ResponseEntity<String> res=template.exchange(searchProjectUrl, HttpMethod.GET, new HttpEntity<Object>(createHeaders(Constant.USERNAME, Constant.PASSWORD)), String.class);

		return res.getBody();
	}
	
	
	//Return project status
	@Override
	public String getProjetcstatus(String projectKey) {
		return template.getForObject(projectstatusUrl+projectKey, String.class);
	}
	

	
	
	HttpHeaders createHeaders(String username, String password) {
		return new HttpHeaders() {
			{
				String auth = username + ":" + password;
				byte[] encodedAuth = org.apache.tomcat.util.codec.binary.Base64.encodeBase64(auth.getBytes(Charset.forName("US-ASCII")));
				String authHeader = "Basic " + new String(encodedAuth);
				set("Authorization", authHeader);
			}
		};
	}
	
	
	//Returns all the metrics based on the duration
	@Override
	public String getMetricsById(ProjectMetricsRequest projectMetricsRequest) throws IOException {
		
		List<String> projectKeyList=getKeys(projectMetricsRequest.getProjectKey());
		String result=" ";
	    StringBuilder builder=new StringBuilder();
	    Paging paging;
		List<String> object=new ArrayList<>();

	    int j=1;
	   
	    for(int i=0;i<projectKeyList.size();i++)
		{
	    	do {
	    		
		
			String url=projecthistoryUrl+Constant.METRICS+projectMetricsRequest.getMetrics()+Constant.COMPONENTS+projectKeyList.get(i)+Constant.PAGE+j;
	        ResponseEntity<String> res=template.exchange(url, HttpMethod.GET, new HttpEntity<Object>(createHeaders(Constant.USERNAME, Constant.PASSWORD)), String.class);
	        builder.append(res.getBody());
			result=builder.toString();
			ObjectMapper mapper=new ObjectMapper();
    		paging=mapper.readValue(builder.toString(), Paging.class);
    		object.add(result);
    		j++;
    		
    		
    	    }while(j<=(paging.getTotal()/100)+1); 
		
	    	
		}
		
		ObjectMapper mapper=new ObjectMapper();
		com.galaxe.sonarQube.model.Root metricsModel=new com.galaxe.sonarQube.model.Root();
		metricsModel=mapper.readValue(result, com.galaxe.sonarQube.model.Root.class);
		
		SonarqubeEntity sonarEntity=new SonarqubeEntity();
		SonarUtility.metricsMapper(metricsModel,sonarEntity);
			
		return result;
	}
	
    //Generates an excel sheet
	@Override
	public ByteArrayInputStream getGroupRepoDetails(ProjectMetricsRequest projectMetricsRequest) throws IOException {
		
		List<SonarqubeEntity> sonarEntityList=null;
        List<String> list=new ArrayList<>();
		List<String> projectKeyList=getKeys(projectMetricsRequest.getProjectKey());
		
		String result="";
		
        StringBuilder builder=new StringBuilder();
		for(int i=0;i<projectKeyList.size();i++)
		{
			
			


	//String url=metricUrl+Constant.metric+projectMetricsRequest.getMetrics()+Constant.components+projectKeyList.get(i)+"&from="+projectMetricsRequest.getStartDate()+"&to="+projectMetricsRequest.getEndDate();
			String url=metricUrl+"metricKeys="+projectMetricsRequest.getMetrics()+Constant.COMPONENTS+projectKeyList.get(i)+"&additionalFields=period";
			ResponseEntity<String> res=template.exchange(url, HttpMethod.GET, new HttpEntity<Object>(createHeaders(Constant.USERNAME, Constant.PASSWORD)), String.class);
			builder.append(res.getBody());
    		result=builder.toString();
    		list.add(result);
        
		}
		
		List<SonarqubeEntity> sonarEntityList1 = new ArrayList<SonarqubeEntity>();

		ObjectMapper mapper=new ObjectMapper(); 
		com.galaxe.sonarQube.model.Root metricsModel=new com.galaxe.sonarQube.model.Root();
		metricsModel=mapper.readValue(result, com.galaxe.sonarQube.model.Root.class);
		SonarqubeEntity sonarEntity=new SonarqubeEntity();
		com.galaxe.sonarQube.serviceImpl.util.SonarUtility.metricsMapper(metricsModel,sonarEntity);
		repository.save(sonarEntity);
		java.lang.reflect.Field[] fields = SonarqubeEntity.class.getDeclaredFields();
		ArrayList<Object[]> gitData=new ArrayList<Object[]>();
		 
		sonarEntityList1.add(sonarEntity);	
		for (SonarqubeEntity gitInfo : sonarEntityList1) {
				 
			    gitData.add(new
				Object[]{gitInfo.getSonarId(),gitInfo.getOrganizationName(),gitInfo.getProduct(),gitInfo.getProject(),gitInfo.getSize(),gitInfo.getDate(),gitInfo.getMode(),gitInfo.getIndex(),gitInfo.getLinesofcode(),gitInfo.getNoofbugs(),gitInfo.getNoofvulnerabilities(),gitInfo.getNoofcodesmells(),gitInfo.getPercentcoverage(),gitInfo.getNoofsecurityhotspots(),gitInfo.getReliability(),gitInfo.getSecurity(),gitInfo.getPercentduplication(),gitInfo.getProjectkey(),gitInfo.getProjectid(),gitInfo.getProjectdescription(),gitInfo.getProjectqualifier(),gitInfo.getViolations()});
			  
		  }
		  ByteArrayInputStream inputStream= com.galaxe.sonarQube.exceltransformer.ExcelDetailsTransformer.generateExcel(fields,gitData);
		
		 
		  return inputStream;
		
	}

	//Returns project history
	@Override
	public String getProjectHistory(ProjectMetricsRequest request)throws IOException {
		

		List<String> projectKeyList=getKeys((request.getProjectKey()));
	    StringBuilder builder=new StringBuilder();
		String result="";
		List<String> object=new ArrayList<>();
		com.galaxe.sonarQube.model.Root root=new com.galaxe.sonarQube.model.Root();
		int j=1;

        for(int i=0;i<projectKeyList.size();i++)
		{
        	do
 			{
 
        	String url=projecthistoryUrl+Constant.METRICS+request.getMetrics()+Constant.COMPONENTS+projectKeyList.get(i)+Constant.PAGE+j;
 		
        	ResponseEntity<String> res=template.exchange(url, HttpMethod.GET, new HttpEntity<Object>(createHeaders(Constant.USERNAME, Constant.PASSWORD)), String.class);
        	builder.append(res.getBody());
    		result=builder.toString();
    		
    		ObjectMapper mapper=new ObjectMapper();
    		root=mapper.readValue(builder.toString(), com.galaxe.sonarQube.model.Root.class);
    		object.add(result);
    		j++;
    		
    		
    	    }while(j<=(root.getPaging().getTotal()/100)+1); 
		}	
    		ObjectMapper mapper=new ObjectMapper();
    		com.galaxe.sonarQube.model.Root roots=new com.galaxe.sonarQube.model.Root();
    		roots=mapper.readValue(result, com.galaxe.sonarQube.model.Root.class);
	     
         
 			return result;
		
}
	
    //To retrieve all the project keys passed in the body
    public List<String> getKeys(String key){
		
		if(key!=null && key.trim().length()>0)
		{
			String[] str = key.split(",");
			
			
			List<String> list= Arrays.asList(str);
			
			return list.stream().distinct().collect(Collectors.toList());
		}
		return Collections.emptyList();
		}
    
    //Retrieves all the metrics from the end point URL and storing it in DB
	@SuppressWarnings({ "unused"})
	@Override
	public String getAllMetricsofProject(ProjectMetricsRequest projectMetricsRequest) throws IOException {
		List<String> projectKeyList=getKeys(projectMetricsRequest.getProjectKey());
	    String result=" ";
		
	    com.galaxe.sonarQube.model.Root modelRoot=new com.galaxe.sonarQube.model.Root();
	    List<String> list=new ArrayList<>();
		StringBuilder builder=new StringBuilder();
 		
         for( int i=0;i<projectKeyList.size();i++)
		{
        	String url=metricUrl+"metricKeys="+projectMetricsRequest.getMetrics()+Constant.COMPONENTS+projectKeyList.get(i)+"&additionalFields=period";
			ResponseEntity<String> res=template.exchange(url, HttpMethod.GET, new HttpEntity<Object>(createHeaders(Constant.USERNAME, Constant.PASSWORD)), String.class);
			builder.append(res.getBody());
    		result=builder.toString();
    		list.add(result);
    		
		}
	    
 	
 		ObjectMapper mapper=new ObjectMapper();
		com.galaxe.sonarQube.model.Root metricsModel=new com.galaxe.sonarQube.model.Root();
		SonarqubeEntity sonarEntity=new SonarqubeEntity();
		SonarqubeEntity sonarqubeEntity;

		for(String root:list)
		{
		metricsModel=mapper.readValue(root, com.galaxe.sonarQube.model.Root.class);
		
		sonarqubeEntity=SonarUtility.metricsMapper(metricsModel,sonarEntity);
		
		repository.save(sonarqubeEntity);
		}
		
 		return result;
	}


	//Retrieves the record from the DB by sonarId
	@Override
	public Object getMetricById(int id) {

		Optional <SonarqubeEntity > productDb = this.repository.findById(id);

        if (productDb.isPresent()) {
            return productDb.get();
        } else {
            throw new ResourceNotFoundException("Record not found for the given duration: " + id);
        }
}
	

    //Retrieves the record from DB based on the duration
	@Override
	public Object getMetricByDuration(DateRange dateRange) {
		
		List<SonarqubeEntity> productDb = this.repository.findByPriorityBetween(dateRange.getFromdate(), dateRange.getToDate());
        System.out.println(dateRange.getFromdate()+" "+dateRange.getToDate());
		return productDb;
        
    
   }

	//Retrieves all the issues and storing it in DB
	@Override
	public String getAllIssues(ProjectMetricsRequest projectMetricsRequest) throws IOException {
	
		
		List<String> projectKeyList=getKeys(projectMetricsRequest.getProjectKey());
	    String result="";
	    List<String> object=new ArrayList<>();
		StringBuilder builder=new StringBuilder();
		Root root=null;
		int j=1;
		for( int i=0;i<projectKeyList.size();i++)
		{
		do {	
        
 
         	String url=issueUrl+Constant.COMPONENT+projectKeyList.get(i)+Constant.PAGE+j;
         	
         			//"&createdAfter="+projectMetricsRequest.getStartDate()+"&createdBefore="+projectMetricsRequest.getEndDate();
			ResponseEntity<String> res=template.exchange(url, HttpMethod.GET, new HttpEntity<Object>(createHeaders(Constant.USERNAME, Constant.PASSWORD)), String.class);
			builder.append(res.getBody());
    		result=builder.toString();
    		
    		ObjectMapper mapper=new ObjectMapper();
    		root=mapper.readValue(builder.toString(), Root.class);
    		object.add(result);
    		j++;
		}while(j<=(root.getTotal()/100)+1);
		
		}
		
		
		
 		ObjectMapper mapper=new ObjectMapper();
		Root metricsModel;
		List<SonarIssueEntity> sonarIssueEntities=new ArrayList<>();
		List<SonarIssueEntity> sonarIssueEntitiesList;
		for (String root2:object)
		{
		metricsModel=mapper.readValue(root2, Root.class);
		sonarIssueEntitiesList=SonarUtility.metricsMapper(metricsModel,sonarIssueEntities);
			issueRepository.saveAll(sonarIssueEntitiesList);
		  }
			
 		return result;	
		
	}

	
	
	
	//Retrieves all the issues and storing in excel sheet
	@SuppressWarnings("unused")
	@Override
	public ByteArrayInputStream getExcelSheetForIssues(ProjectMetricsRequest projectMetricsRequest) throws IOException {
		
		List<String> projectKeyList=getKeys(projectMetricsRequest.getProjectKey());
	    String result;
	    List<String> object=new ArrayList<>();

		StringBuilder builder=new StringBuilder();
 		Root root;
		ByteArrayInputStream inputStream=null;
		int j=1;
		for( int i=0;i<projectKeyList.size();i++)
		{
		
		do
        {
			String url=issueUrl+Constant.COMPONENT+projectKeyList.get(i)+Constant.PAGE+j;
			ResponseEntity<String> res=template.exchange(url, HttpMethod.GET, new HttpEntity<Object>(createHeaders(Constant.USERNAME, Constant.PASSWORD)), String.class);
			builder.append(res.getBody());
    		result=builder.toString();
    		
    		ObjectMapper mapper=new ObjectMapper();
    		root=mapper.readValue(builder.toString(), Root.class);
    		object.add(result);
    		j++;
    		
		}while(j<=(root.getTotal()/100)+1);
			
		}
		ObjectMapper mapper=new ObjectMapper();
		Root metricsModel;
		List<SonarIssueEntity> sonarIssueEntities=new ArrayList<>();
		List<SonarIssueEntity> sonarIssueEntitiesList;
		List<SonarIssueEntity>issueEntity=new ArrayList<SonarIssueEntity>();
		for (String root2:object)
		{
		metricsModel=mapper.readValue(root2, Root.class);
		sonarIssueEntitiesList=SonarUtility.metricsMapper(metricsModel,sonarIssueEntities);
		for(int k= 0 ;k<sonarIssueEntitiesList.size();k++) {
			issueRepository.save(sonarIssueEntities.get(k));
			
			 java.lang.reflect.Field[] fields = SonarIssueEntity.class.getDeclaredFields();
			 ArrayList<Object[]> gitData=new ArrayList<Object[]>();
			 issueEntity.add(sonarIssueEntities.get(k));	
			 for (SonarIssueEntity gitInfo : sonarIssueEntitiesList) {
				 
				    gitData.add(new
					Object[]{gitInfo.getId(),gitInfo.getTotal(),gitInfo.getRule(),gitInfo.getAssignee(),gitInfo.getSeverity(),gitInfo.getResolution(),gitInfo.getStatus(),gitInfo.getComponent(),gitInfo.getProject(),gitInfo.getLine(),gitInfo.getMessage(),gitInfo.getEffort(),gitInfo.getDebt(),gitInfo.getCreationDate(),gitInfo.getUpdateDate(),gitInfo.getType(),gitInfo.getOrganization()});
				  }
			   inputStream= com.galaxe.sonarQube.exceltransformer.ExcelDetailsTransformer.generateExcel(fields,gitData);
		  }
		
		
		  }
		return inputStream;

	}
	
	
}
