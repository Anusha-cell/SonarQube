package com.galaxe.sonarQube.model;


import java.sql.Date;
import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonFormat;
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
   // @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", timezone="Europe/Berlin")
    private Timestamp date;

	
	
}

   

	

	
	

