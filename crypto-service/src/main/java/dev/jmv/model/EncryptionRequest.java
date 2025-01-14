package dev.jmv.model;

import lombok.*;


@Data
public class EncryptionRequest {

    private String message;

    private String clientId;
}
