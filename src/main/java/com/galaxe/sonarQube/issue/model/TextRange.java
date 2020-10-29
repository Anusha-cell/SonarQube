package com.galaxe.sonarQube.issue.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;

@JsonIgnoreProperties(ignoreUnknown=true)
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TextRange{
    private int startLine;
    private int endLine;
    private int startOffset;
    private int endOffset;
}
