package com.galaxe.sonarQube.issue.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown=true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Issue{
    private String key;
    private String rule;
    private String severity;
    private String component;
    private String project;
    private int line;
    private String hash;
    private TextRange textRange;
    private List<Object> flows;
    private String status;
    private String resolution;
    private String message;
    private String effort;
    private String debt;
    private List<Object> tags;
    private String creationDate;
    private String updateDate;
    private String type;
    private String assignee;
    private String organization;
}
