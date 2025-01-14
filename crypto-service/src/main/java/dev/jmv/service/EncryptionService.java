package dev.jmv.service;

import dev.jmv.domain.Encryption;
import dev.jmv.model.EncryptionRequest;
import dev.jmv.model.EncryptionResponse;
import dev.jmv.repository.EncryptionRepository;
import dev.jmv.util.Status;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Base64;
import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class EncryptionService {

    private final EncryptionRepository encryptionRepository;

    public EncryptionResponse encryptMessage(EncryptionRequest encryptionRequest) {
        var cipher = encrypt(encryptionRequest.getMessage());
        var encryptionBody = Encryption.builder()
                .status(Status.SUCCESS)
                .message(encryptionRequest.getMessage())
                .cipher(cipher)
                .clientId(encryptionRequest.getClientId())
                .build();
        return buildEncryptionResponse(encryptionRepository.save(encryptionBody));
    }

    private String encrypt(String message) {
        return Base64.getEncoder().encodeToString(message.getBytes());
    }
    public List<EncryptionResponse> getAllEncryption() {
        return buildEncryptionResponse(encryptionRepository.findAll());
    }

    private EncryptionResponse buildEncryptionResponse(Encryption encryption) {
        return EncryptionResponse.builder()
                .id(String.valueOf(encryption.getId()))
                .cipher(encryption.getCipher())
                .build();
    }

    private List<EncryptionResponse> buildEncryptionResponse(List<Encryption> encryptionList) {
        return encryptionList.stream()
                .map(e-> EncryptionResponse.builder()
                        .id(String.valueOf(e.getId()))
                        .cipher(e.getCipher())
                        .build())
                .collect(Collectors.toList());
    }
}
