package com.jmv.airlines.dto;

import lombok.Data;

import java.util.Map;

@Data
public class AirlineRequest {

    private String name;
    private String country;

    private Map<String, Object> customFields;
}
