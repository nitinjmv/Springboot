package com.jmv.airlines.dto;


import lombok.Data;

@Data
public class CustomFieldDefinitionRequest {

    private String entityType;   // AIRLINE
    private String fieldName;    // fleetSize
    private String fieldType;    // STRING, NUMBER, BOOLEAN
    private boolean required;
    private String errorMessage;

    private String rules;        // SpEL expression
}
