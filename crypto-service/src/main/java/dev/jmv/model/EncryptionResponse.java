package dev.jmv.model;

import lombok.Builder;
import lombok.Data;

@Builder
public class EncryptionResponse {

    private String id;
    private String cipher;
}
