package com.jmv.airlines.dto;

import lombok.Data;

@Data
public class CustomFieldDefinitionResponse {

    private Long id;
    private String entityType;
    private String fieldName;
    private String fieldType;
    private boolean required;
    private String errorMessage;

    private String rules;
}
