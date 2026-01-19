package com.jmv.airlines.domain.exception;

public class RuleViolationException extends RuntimeException {
    public RuleViolationException(String message) {
        super(message);
    }
}
