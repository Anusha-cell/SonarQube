package com.galaxe.sonarQube.issue.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;

@JsonIgnoreProperties(ignoreUnknown=true)

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Root{
    private int total;
    private int p;
    private int ps;
    private Paging paging;
    private int effortTotal;
    private int debtTotal;
    private List<Issue> issues;
    private List<Component> components;
    private List<Object> facets;
}
