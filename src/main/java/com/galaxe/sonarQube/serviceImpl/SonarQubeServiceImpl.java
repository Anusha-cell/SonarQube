package com.galaxe.sonarQube.serviceImpl;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.galaxe.sonarQube.constant.Constant;
import com.galaxe.sonarQube.entity.SonarqubeEntity;
import com.galaxe.sonarQube.exception.DataIntegrityViolationException;
import com.galaxe.sonarQube.exception.ResourceNotFoundException;
import com.galaxe.sonarQube.model.DateRange;
import com.galaxe.sonarQube.model.MetricComponentModel;
import com.galaxe.sonarQube.model.ProjectMetricsRequest;
import com.galaxe.sonarQube.repository.SonarRepository;
import com.galaxe.sonarQube.service.SonarQubeInterface;
import com.galaxe.sonarQube.serviceImpl.util.SonarUtility;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;


@Service
public class SonarQubeServiceImpl implements SonarQubeInterface {

	@Autowired
	private RestTemplate template;
	
	@Autowired
	private SonarRepository repository;

	
	@Value("${searchprojectUrl}")	
	private String searchProjectUrl;
	
	@Value("${projectstatusUrl}")	
	private String projectstatusUrl;
	
	@Value("${projecthistoryUrl}")	
	private String projecthistoryUrl;
	
	@Value("${metricUrl}")	
	private String metricUrl;
	
	
	//Retrieves all the projects
	@Override
	public String getsearchAllproject() {
	
        String result="";
        StringBuffer buffer=new StringBuffer();
        String uri=searchProjectUrl;
		ResponseEntity<String> res=template.exchange(uri, HttpMethod.GET, new HttpEntity<Object>(createHeaders(Constant.USERNAME, Constant.PASSWORD)), String.class);
		buffer.append(res.getBody());
		result=buffer.toString();
			 	
		return result;
    
	}
	
	//Retrieves all the project
	@Override
	public String getsearchproject() {
		ResponseEntity<String> res = template.exchange(searchProjectUrl, HttpMethod.GET,new HttpEntity<String>(createHeaders(Constant.USERNAME, Constant.PASSWORD)), String.class);
		return res.getBody();
		
   }
	
	
	//Return project status
	@Override
	public String getProjetcstatus(String projectKey) {
		String s = template.getForObject(projectstatusUrl+projectKey,
				String.class);
		return s;
	}
	

	String createHeaders(String username, String password) {

		String auth = username + ":" + password;
		byte[] encodedAuth = org.apache.tomcat.util.codec.binary.Base64.encodeBase64(auth.getBytes(StandardCharsets.US_ASCII));
		return "Basic" + new String(encodedAuth);
     }
	
	
	//Returns all the metrics based on the duration
	@Override
	public String getMetricsById(ProjectMetricsRequest projectMetricsRequest) throws  JsonParseException, JsonMappingException, IOException {
		
		List<String> projectKeyList=getKeys(projectMetricsRequest.getProjectKey());
		String result=" ";
	    StringBuffer buffer=new StringBuffer();
	    for(int i=0;i<projectKeyList.size();i++)
		{
		
			String url=projecthistoryUrl+"metrics="+projectMetricsRequest.getMetrics()+"&component="+projectKeyList.get(i)+"&from="+projectMetricsRequest.getStartDate()+"&to="+projectMetricsRequest.getEndDate();
	        System.out.println("ANusha check2" +url);
	        ResponseEntity<String> res=template.exchange(url, HttpMethod.GET, new HttpEntity<Object>(createHeaders(Constant.USERNAME, Constant.PASSWORD)), String.class);
			buffer.append(res.getBody());
			result=buffer.toString();
			System.out.println(result);
		}
			
		return result;
	}
	
    //Generates an excel sheet
	@Override
	public ByteArrayInputStream getGroupRepoDetails(ProjectMetricsRequest projectMetricsRequest) throws JsonParseException, JsonMappingException, IOException {
		
		List<SonarqubeEntity> sonarEntityList=null;

		List<String> projectKeyList=getKeys(projectMetricsRequest.getProjectKey());
		
		String result="";
        StringBuffer buffer=new StringBuffer();
		for(int i=0;i<projectKeyList.size();i++)
		{

		String url=projecthistoryUrl+"metrics="+projectMetricsRequest.getMetrics()+"&component="+projectKeyList.get(i)+"&from="+projectMetricsRequest.getStartDate()+"&to="+projectMetricsRequest.getEndDate();
	    ResponseEntity<String> res=template.exchange(url, HttpMethod.GET, new HttpEntity<Object>(createHeaders(Constant.USERNAME, Constant.PASSWORD)), String.class);
		buffer.append(res.getBody());
		result=buffer.toString();
        
		}
		
		ObjectMapper mapper=new ObjectMapper(); 
		  MetricComponentModel metricsModel=new MetricComponentModel(); 
		  metricsModel=mapper.readValue(result,MetricComponentModel.class);
		 
		  SonarqubeEntity sonarEntity=new SonarqubeEntity();
		  com.galaxe.sonarQube.serviceImpl.util.SonarUtility.metricsMapper(metricsModel,sonarEntity);
		  java.lang.reflect.Field[] fields = SonarqubeEntity.class.getDeclaredFields();
		  ArrayList<Object[]> gitData=new ArrayList<Object[]>();
		 
		  sonarEntityList = new ArrayList<SonarqubeEntity>();
		  sonarEntityList.add(sonarEntity);	
		  for (SonarqubeEntity gitInfo : sonarEntityList) {
				 
			    gitData.add(new
				Object[]{gitInfo.getSonarId(),gitInfo.getOrganizationName(),gitInfo.getProduct(),gitInfo.getProject(),gitInfo.getSize(),gitInfo.getDate(),gitInfo.getStatus(),gitInfo.getLinesofcode(),gitInfo.getNoofbugs(),gitInfo.getNoofvulnerabilities(),gitInfo.getNoofcodesmells(),gitInfo.getPercentcoverage(),gitInfo.getNoofsecurityhotspots(),gitInfo.getReliability(),gitInfo.getSecurity(),gitInfo.getMaintainability(),gitInfo.getPercentduplication(),gitInfo.getProjectid(),gitInfo.getProjectkey(),gitInfo.getProjectdescription(),gitInfo.getProjectqualifier(),gitInfo.getViolations()});
			  
		  }
		  ByteArrayInputStream inputStream= com.galaxe.sonarQube.exceltransformer.ExcelDetailsTransformer.generateExcel(fields,gitData);
		
		  return inputStream;
		
	}

	//Returns project history
	@Override
	public String getProjectHistory(ProjectMetricsRequest request)throws JsonParseException, JsonMappingException, IOException {
		

		List<String> projectKeyList=getKeys(request.getProjectKey());
	    StringBuffer buffer=new StringBuffer();
		String result="";

         for(int i=0;i<projectKeyList.size();i++)
		{
 
        	String url=projecthistoryUrl+"metrics="+request.getMetrics()+"&component="+projectKeyList.get(i);
 		
        	ResponseEntity<String> res=template.exchange(url, HttpMethod.GET, new HttpEntity<Object>(createHeaders(Constant.USERNAME, Constant.PASSWORD)), String.class);
    		buffer.append(res.getBody());
    		result=buffer.toString();
	     }
         
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
	public String getAllMetricsofProject(ProjectMetricsRequest projectMetricsRequest) throws JsonParseException, JsonMappingException, IOException, NotFoundException {
		List<String> projectKeyList=getKeys(projectMetricsRequest.getProjectKey());
	    String result=" ";
		
		StringBuffer buffer=new StringBuffer();
 			
         for( int i=0;i<projectKeyList.size();i++)
		{
 
        	String url=metricUrl+"metricKeys="+projectMetricsRequest.getMetrics()+"&component="+projectKeyList.get(i)+"&additionalFields=period";
			ResponseEntity<String> res=template.exchange(url, HttpMethod.GET, new HttpEntity<Object>(createHeaders(Constant.USERNAME, Constant.PASSWORD)), String.class);
    		buffer.append(res.getBody());
    		result=buffer.toString();
	    }
 	
 		ObjectMapper mapper=new ObjectMapper();
		MetricComponentModel metricsModel=new MetricComponentModel();
		metricsModel=mapper.readValue(result, MetricComponentModel.class);
		
		SonarqubeEntity sonarEntity=new SonarqubeEntity();
		SonarUtility.metricsMapper(metricsModel,sonarEntity);
		
		repository.save(sonarEntity);
		
 		return result;
	}


	//Retrieves the record from the DB by sonarId
	@Override
	public Object getMetricById(SonarqubeEntity entity) {

		Optional <SonarqubeEntity > productDb = this.repository.findById(entity.getSonarId());

        if (productDb.isPresent()) {
            return productDb.get();
        } else {
            throw new ResourceNotFoundException("Record not found for the given duration: " + entity.getSonarId());
        }
	}
	

    //Retrieves the record from DB based on the duration
	@Override
	public Object getMetricByDuration(DateRange dateRange) {
		
            List<SonarqubeEntity> productDb = this.repository.findByPriorityBetween(dateRange.getFromdate(), dateRange.getToDate());
            System.out.println(dateRange.getFromdate()+" "+dateRange.getToDate());
            if(productDb!=null)
            {
            return productDb;
        } else {
            throw new DataIntegrityViolationException("Record not found with id : " + dateRange.getFromdate() +dateRange.getToDate());
        }
	}
	
	
}
