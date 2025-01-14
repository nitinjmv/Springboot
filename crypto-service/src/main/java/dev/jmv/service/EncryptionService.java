package dev.jmv.service;

import dev.jmv.model.EncryptionRequest;
import dev.jmv.model.EncryptionResponse;
import dev.jmv.repository.EncryptionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Base64;


@Service
@RequiredArgsConstructor
public class EncryptionService {

    private final EncryptionRepository encryptionRepository;

    public EncryptionResponse encryptMessage(EncryptionRequest encryptionRequest) {
        var cipher = encrypt(encryptionRequest.getMessage());
        encryptionRequest.setCipher(cipher);
        return buildEncryptionResponse(encryptionRepository.save(encryptionRequest));
    }

    private String encrypt(String message) {
        return Base64.getEncoder().encodeToString(message.getBytes());
    }

    private EncryptionResponse buildEncryptionResponse(EncryptionRequest encryptionRequest) {
        return EncryptionResponse.builder()
                .id(String.valueOf(encryptionRequest.getId()))
                .cipher(encryptionRequest.getCipher())
                .build();
    }
}
