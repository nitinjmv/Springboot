package com.jmv.airlines.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AMSErrorResponse {
    private String errorCode;
    private String message;
}
