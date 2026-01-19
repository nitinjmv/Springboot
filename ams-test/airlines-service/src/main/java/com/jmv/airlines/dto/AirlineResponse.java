package com.jmv.airlines.dto;

import lombok.Data;

import java.util.Map;
import java.util.UUID;

@Data
public class AirlineResponse {

    private UUID id;
    private String name;
    private String country;
    private Map<String, Object> customFields;
}
