package com.galaxe.sonarQube.serviceImpl;



import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import com.galaxe.sonarQube.entity.SonarqubeEntity;
import com.galaxe.sonarQube.model.Component;
import com.galaxe.sonarQube.model.DateModel;
import com.galaxe.sonarQube.model.Measure;
import com.galaxe.sonarQube.model.Measures;
import com.galaxe.sonarQube.model.Metric;
import com.galaxe.sonarQube.model.MetricComponentModel;
import com.galaxe.sonarQube.model.MetricModel;
import com.galaxe.sonarQube.model.Project;
import com.galaxe.sonarQube.model.ProjectMetric;
import com.galaxe.sonarQube.model.ProjectMetricsRequest;
import com.galaxe.sonarQube.model.SonarqubeProject;
import com.galaxe.sonarQube.service.SonarQubeInterface;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;


@Service
public class SonarQubeServiceImpl implements SonarQubeInterface {

	@Autowired
	private RestTemplate template;
	

	private ProjectMetricsRequest projectMetricsRequest;
	
	@Override
	public String getsearchAllproject() {
	
		//for()
		String url="http://localhost:9000/api/projects/search?";
		//List<String> projectKeyList=getKeys(projectMetricsRequest.getProjectKey());
        int MAX_SIZE=500;
        int page=3;
        int total=1018;
        String result=" ";
        StringBuffer buffer=new StringBuffer();
       //while(total>9)	
      //  int totalResult = (total.toFloat()/1000).round();

        for(int p=1;p<=page;p++) {
			
        //	do
        //	{
        
        	//  int  r=total%MAX_SIZE;
        //	  total=total/1000;
        	
			 String uri=url+"ps="+MAX_SIZE+"&p="+p;
			 ResponseEntity<String> res=template.exchange(uri, HttpMethod.GET, new HttpEntity<Object>(createHeaders("admin", "admin")), String.class);
			//result =result+res.getBody();
	         res.getBody().length();
			System.out.println("length for each itearation"+p+ res.getBody().length());
			buffer.append(res.getBody());
			result=buffer.toString();
			
			
			System.out.println("Anusha:" +result);
			System.out.println("Anusha:" +result.length());
			System.out.println("p :"+p);

        }	
		//}
		
		//variable x = (expression)? value if true: value if false
		//		b = (a == 1) ? 20: 30;
		//b=ps a=	lenght of record

		
		
		
		/* int projectKeyList=getValues(projectMetricsRequest.getPg()); StringBuffer
		 * buffer=new StringBuffer(); String result=" "; //String[] a = null;
		 * 
		 * for(int i=20;i<=projectKeyList;i++) {
		 * 
		 * String uri=url+"?ps="+i; System.out.println("Anusha Code check11" +uri);
		 * ResponseEntity<String> res=template.exchange(uri, HttpMethod.GET, new
		 * HttpEntity<Object>(createHeaders("admin", "admin")), String.class);
		 * System.out.println("Anusha Code check2: " +res);
		 * buffer.append(res.getBody()); result=buffer.toString();
		 * 
		 * }
		 */
		return result;
    
	}
	
	
	 public List<String> getComponents(String components){
	  
	 if(components!=null && components.trim().length()>0) { String str[] =
	 components.split(","); List<String> list= Arrays.asList(str);
	  
	 return list.stream().distinct().collect(Collectors.toList()); } return null;
	 }
	 
	 
	
	     
	
	@Override
	public String getsearchproject() {
		ResponseEntity<String> res = template.exchange("http://localhost:9000/api/projects/search", HttpMethod.GET,
				new HttpEntity(createHeaders("admin", "admin")), String.class);
		String s = res.getBody();
		
		/*
		 * String url=
		 * "http://localhost:9000/api/measures/component?metricKeys=ncloc,complexity,violations,ncloc,bugs,vulnerabilities,code_smells,security_rating,reliability_rating,coverage,duplicated_lines,sqale_rating";
		 * 
		 * ObjectMapper mapper=new ObjectMapper(); SonarqubeProject sonarProject=new
		 * SonarqubeProject(); try { sonarProject=mapper.readValue(s,
		 * SonarqubeProject.class); } catch (IOException e) { // TODO Auto-generated
		 * catch block e.printStackTrace(); }
		 * 
		 * List<String> projectKeys=new ArrayList<String>();
		 * 
		 * List<Component> projectList = sonarProject.getComponents();
		 * 
		 * for(Component project:projectList) { projectKeys.add(project.getKey()); }
		 * System.out.println("HEKOOOOO" +projectKeys); List<String> projectMetics=new
		 * ArrayList<String>();
		 * 
		 * for(String a:projectKeys) {
		 * 
		 * String uri=url+"&component="+a;
		 * 
		 * 
		 * String s1 = template.getForObject(uri,String.class); projectMetics.add(s1); }
		 * System.out.println(projectMetics);
		 */

	    return s;
		
}
	@Override
	public String getProjetcstatus(String projectKey) {
		String s = template.getForObject(
				"http://localhost:9000/api/qualitygates/project_status?projectKey="+projectKey,
				String.class);
		return s;
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
	
	@Override
	public String getUsergroup() {
		ResponseEntity<String> res=template.exchange("http://localhost:9000/api/user_groups/search", HttpMethod.GET, new HttpEntity(createHeaders("admin", "admin")), String.class);
		String s=res.getBody();
		return s;
	}
	
	@Override
	public String getUserinUsergroup(String userGroup) {
		ResponseEntity<String> res=template.exchange("http://localhost:9000/api/user_groups/users?name="+userGroup, HttpMethod.GET, new HttpEntity(createHeaders("admin", "admin")), String.class);
		String s=res.getBody();
		return s;
	}



	@Override
	public String getIssuesBasedOnDuration(List<String> metric, List<String> portfolio) {
		
		String uri="http://localhost:9000/api/measures/search_history?metrics=ncloc,violations,coverage,vulnerabilities,code_smells,security_rating,reliability_rating,&component=com.galaxe:gitconnector"+metric.getClass() +portfolio.getClass();
		String s = template.getForObject(uri,String.class);
		return s;
	}
	
	
	
	
	
	@Override
	public String getMetricsById(ProjectMetricsRequest projectMetricsRequest) throws  JsonParseException, JsonMappingException, IOException {
		System.out.println("ANUSHA CHECK1"+projectMetricsRequest.getMetrics());
		List<String> projectKeyList=getKeys(projectMetricsRequest.getProjectKey());
				
		List<String> list1=new ArrayList<String>();
	    String result=" ";
		
		for(int i=0;i<projectKeyList.size();i++)
		{
		String uri="http://localhost:9000/api/measures/search_history?"; 
		
		//if(projectMetricsRequest.getMetrics()!=null && projectMetricsRequest.getProjectKey()!=null && projectMetricsRequest.getStartDate()!=null && projectMetricsRequest.getEndDate()!=null )
		//{
			
			String url=uri+"metrics="+projectMetricsRequest.getMetrics()+"&component="+projectKeyList.get(i)+"&from="+projectMetricsRequest.getStartDate()+"&to="+projectMetricsRequest.getEndDate();
	        System.out.println("ANusha check2" +url);
	        ResponseEntity<String> res=template.exchange(url, HttpMethod.GET, new HttpEntity(createHeaders("admin", "admin")), String.class);
			String list=res.getBody();
			result=result+list;
		}
			
	        System.out.println("Metrics:" +result);
		
		    return result;
		
}
	
     
    
	@SuppressWarnings("unchecked")
	@Override
	public List<String> getMetricsBasedOnDuration(Date startDate, Date endDate, List<String> list){
		
		
		ResponseEntity<String> res = template.exchange("http://localhost:9000/api/projects/search", HttpMethod.GET,
				new HttpEntity(createHeaders("admin", "admin")), String.class);
		String s = res.getBody();
		
		String url="http://localhost:9000/api/measures/search_history?metrics=";

	     ObjectMapper mapper=new ObjectMapper();
	     
			SonarqubeProject sonarProject=new SonarqubeProject();
			
			MetricModel metricModel=new MetricModel();
			try {
				sonarProject=mapper.readValue(s, SonarqubeProject.class);
				metricModel=mapper.readValue(s, MetricModel.class);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}				
			
			
			List<String> projectKeys=new ArrayList<String>();
			List<String> metric=new ArrayList<String>();
			
			List<Component> projectList = sonarProject.getComponents();
			List<Measures> list1=metricModel.getMeasures();
			for(Component project:projectList) {
				projectKeys.add(project.getKey());
				
			}
			
			
			List<String> projectMetics=new ArrayList<String>();
			
			for(String a:projectKeys) 
			{	
			String uri=url+"&component="+a;
			}
			for(Measures measure:list1) {
			//	 url=uri+measure.getMetric()+"="+measure.getMetric();
				
			
			String s1 = template.getForObject(url,String.class);
			projectMetics.add(s1);
			}
			System.out.println(projectMetics);

	    return (List<String>) projectMetics;
		
	}
	@Override
	public List<String> getMetrics() {
		ResponseEntity<String> res = template.exchange("http://localhost:9000/api/projects/search", HttpMethod.GET,
				new HttpEntity(createHeaders("admin", "admin")), String.class);
		String s = res.getBody();
		
		String url="http://localhost:9000/api/measures/search_history?metrics=ncloc,violations,coverage,vulnerabilities,code_smells,security_rating,reliability_rating";

	     ObjectMapper mapper=new ObjectMapper();
	     
			SonarqubeProject sonarProject=new SonarqubeProject();
			MetricModel metricModel=new MetricModel();
			try {
				sonarProject=mapper.readValue(s, SonarqubeProject.class);
				metricModel=mapper.readValue(s, MetricModel.class);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}				
			
			
			List<String> projectKeys=new ArrayList<String>();
			List<String> metric=new ArrayList<String>();
			
			List<Component> projectList = sonarProject.getComponents();
			List<Measures> list=metricModel.getMeasures();
			for(Component project:projectList) {
				projectKeys.add(project.getKey());
				
			}
			
			
			List<String> projectMetics=new ArrayList<String>();
			
			for(String a:projectKeys) 
			{	
			String uri=url+"&component="+a;


			String s1 = template.getForObject(uri,String.class);
			projectMetics.add(s1);
			}
			System.out.println(projectMetics);

	    return projectMetics;
		
	}
	@Override
	public List<String> getMetricsBasedOnKey(String key) {
	
		String url="http://localhost:9000/api/measures/component?metricKeys=";

		return null;
	}
	@Override
	public ByteArrayInputStream getGroupRepoDetails(ProjectMetricsRequest projectMetricsRequest) throws JsonParseException, JsonMappingException, IOException {
		System.out.println("ANUSHA CHECK1"+projectMetricsRequest.getMetrics());
		  List<SonarqubeEntity> sonarEntityList=null;

		List<String> projectKeyList=getKeys(projectMetricsRequest.getProjectKey());
		
		
		String result=" ";

		for(int i=0;i<projectKeyList.size();i++)
		{
		String uri="http://localhost:9000/api/measures/search_history?"; 

	//	if(projectMetricsRequest.getMetrics()!=null && projectMetricsRequest.getProjectKey()!=null && projectMetricsRequest.getStartDate()!=null && projectMetricsRequest.getEndDate()!=null )
	//	{
			
	    
		String url=uri+"metrics="+projectMetricsRequest.getMetrics()+"&component="+projectKeyList.get(i)+"&from="+projectMetricsRequest.getStartDate()+"&to="+projectMetricsRequest.getEndDate();
	    System.out.println("ANusha check2" +url);
	    ResponseEntity<String> res=template.exchange(url, HttpMethod.GET, new HttpEntity(createHeaders("admin", "admin")), String.class);
		String list1=res.getBody();
		result=result+list1;
        System.out.println("Metrics:" +result);
        
		//}
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
				 Object[]{gitInfo.getSonarId(),gitInfo.getOrganizationName(),gitInfo.getProduct(),gitInfo.getProject(),gitInfo.getSize(),gitInfo.getLastAnalysisDate(),gitInfo.getStatus(),gitInfo.getLinesofcode(),gitInfo.getNoofbugs(),gitInfo.getNoofvulnerabilities(),gitInfo.getNoofcodesmells(),gitInfo.getPercentcoverage(),gitInfo.getNoofsecurityhotspots(),gitInfo.getReliability(),gitInfo.getSecurity(),gitInfo.getMaintainability(),gitInfo.getPercentduplication(),gitInfo.getProjectid(),gitInfo.getProjectkey(),gitInfo.getProjectdescription(),gitInfo.getProjectqualifier(),gitInfo.getViolations()});
			  
		}
		ByteArrayInputStream inputStream= com.galaxe.sonarQube.exceltransformer.ExcelDetailsTransformer.generateExcel(fields,gitData);
		
		return inputStream;
		
	}


	@Override
	public
	
	
	
	String getProjectHistory(ProjectMetricsRequest request)throws JsonParseException, JsonMappingException, IOException {
		

		System.out.println("ANUSHA CHECK1"+request.getMetrics());
		List<String> projectKeyList=getKeys(request.getProjectKey());
	    int page=request.getP();	
		List<String> list1=new ArrayList<String>();
	    String result=" ";
		String uri="http://localhost:9000/api/measures/search_history?"; 
		int p=1;
		int i ;
 		for (p=1; p<=page; p++){

         for( i=0;i<projectKeyList.size();i++)
		{
 

		   
			String url=uri+"metrics="+request.getMetrics()+"&component="+projectKeyList.get(i)+"&ps="+1000+"&p="+p;
 		
	        System.out.println("ANusha check2" +url);
	        ResponseEntity<String> res=template.exchange(url, HttpMethod.GET, new HttpEntity(createHeaders("admin", "admin")), String.class);
			String list=res.getBody();
			
			result=result+list;
	     }
         }
       
	        System.out.println("Metrics:" +result);
		
		    return result;
		
}
	
	 public List<String> getKeys(String key){
			
			if(key!=null && key.trim().length()>0)
			{
				String str[] = key.split(",");
				List<String> list= Arrays.asList(str);
				
				return list.stream().distinct().collect(Collectors.toList());
			}
			return null;
			}


	@Override
	public String getAllMetricsofProject(ProjectMetricsRequest projectMetricsRequest) {
		List<String> projectKeyList=getKeys(projectMetricsRequest.getProjectKey());
	   // int page=request.getP();	
		//List<String> list1=new ArrayList<String>();
	    String result=" ";
		String uri="http://localhost:9000/api/measures/component_tree?"; 
		int p=1;
		int i;
		int total=1018 ;
		
 		for (p=1; p<=3; p++){

 			
         for( i=0;i<projectKeyList.size();i++)
		{
 

		   
			String url=uri+"metricKeys="+projectMetricsRequest.getMetrics()+"&component="+projectKeyList.get(i)+"&ps="+500+"&p="+p;
 		
	        System.out.println("ANusha check2" +url);
	        ResponseEntity<String> res=template.exchange(url, HttpMethod.GET, new HttpEntity(createHeaders("admin", "admin")), String.class);
			String list=res.getBody();
			
			result=result+list;
	     }
 		}
       
	        System.out.println("Metrics:" +result);
		
		    return result;
	}
}
