package dev.jmv.controller;

import dev.jmv.model.EncryptionRequest;
import dev.jmv.model.EncryptionResponse;
import dev.jmv.service.EncryptionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("encrypt")
@RequiredArgsConstructor
public class EncryptionController {

    private final EncryptionService encryptionService;

    @PostMapping
    public ResponseEntity<EncryptionResponse> encrypt(@RequestBody EncryptionRequest encryptionRequest) {
        return ResponseEntity.ok(encryptionService.encryptMessage(encryptionRequest));
    }
}
