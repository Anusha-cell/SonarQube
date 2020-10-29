package com.galaxe.sonarQube.issue.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@JsonIgnoreProperties(ignoreUnknown=true)
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MainRoot {
	
  @JsonProperty("root")

   private List<Root> roots;
}
