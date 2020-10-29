package com.galaxe.sonarQube.issue.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;

@JsonIgnoreProperties(ignoreUnknown=true)
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Component{
	
    private String organization;
    private String key;
    private String uuid;
    private boolean enabled;
    private String qualifier;
    private String name;
    private String longName;
    private String path;
}
