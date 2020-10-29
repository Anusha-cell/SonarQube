package com.galaxe.sonarQube.model;


import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown=true)
public class Period {

    @JsonProperty("mode")  
    private String mode;
    
    @JsonProperty("index")  
    private int index;
    
    @JsonProperty("date")
    private Timestamp date;

	
	
}

   

	

	
	

