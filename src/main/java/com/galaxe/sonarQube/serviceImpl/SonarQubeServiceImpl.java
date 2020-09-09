package com.galaxe.sonarQube.serviceImpl;

import java.nio.charset.Charset;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.galaxe.sonarQube.service.SonarQubeInterface;

@Service
public class SonarQubeServiceImpl implements SonarQubeInterface{
	
	@Autowired
	private RestTemplate template;
	//Test Comment

	@Override
	public String getAllMetricsofProject(String ProjectName) {
		String uri="http://localhost:9000/api/measures/component?name=ncloc,complexity,violations,ncloc,bugs,vulnerabilities,code_smells,security_rating,reliability_rating,coverage,duplicated_lines,sqale_rating&component="+ProjectName;
		String s = template.getForObject(uri,String.class);
		return s;
	}
	@Override
	public String getsearchproject() {
		ResponseEntity<String> res = template.exchange("http://localhost:9000/api/projects/search", HttpMethod.GET,
				new HttpEntity(createHeaders("admin", "admin")), String.class);
		String s = res.getBody();
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
				byte[] encodedAuth = Base64.encodeBase64(auth.getBytes(Charset.forName("US-ASCII")));
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
	public String listOfOrganization() {
		ResponseEntity<String> res = template.exchange("http://localhost:9000/api/organizations/search",HttpMethod.GET,
				new HttpEntity(createHeaders("admin", "admin")), String.class);
		String s = res.getBody();
		return s;
				
	}
	/*
	 * @Override public String getAllMetricsofProjectByOrganizationName(String
	 * organization) {
	 * 
	 * String uri=
	 * "http://localhost:9000/api/measures/component?metricKeys=ncloc,complexity,violations,ncloc,bugs,vulnerabilities,code_smells,security_rating,reliability_rating,coverage,duplicated_lines,sqale_rating&component="
	 * +organization; String s = template.getForObject(uri,String.class); return s;
	 * }
	 */
	@Override
	public String getAllMetricsofProjectByOrganizationName(String organizationName) {
		
		ResponseEntity<String> res = template.exchange("http://localhost:9000/api/projects/search", HttpMethod.GET,
				new HttpEntity(createHeaders("admin", "admin")), String.class);
		String s = res.getBody();
		return s;
	}
	@Override
	public String getAllMetricsofProjectByUserName(String username) {
		
		ResponseEntity<String> res = template.exchange("http://localhost:9000/api/projects/search", HttpMethod.GET,
				new HttpEntity(createHeaders("admin", "admin")), String.class);
		String s = res.getBody();
		return s;
	}
	

@Override
public String getAllMetricsofProjectByUserToken(String token) {
	ResponseEntity<String> res = template.exchange("http://localhost:9000/api/projects/search", HttpMethod.GET,
			new HttpEntity(createHeaders("admin", "admin")), String.class);
	String s = res.getBody();
	return s;
	}

}

