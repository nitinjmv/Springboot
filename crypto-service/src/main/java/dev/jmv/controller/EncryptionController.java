package dev.jmv.controller;

import dev.jmv.model.EncryptionRequest;
import dev.jmv.model.EncryptionResponse;
import dev.jmv.service.EncryptionService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("encrypt")
@RequiredArgsConstructor
public class EncryptionController {

    private final EncryptionService encryptionService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<EncryptionResponse> encrypt(@RequestBody EncryptionRequest encryptionRequest) {
        return ResponseEntity.ok(encryptionService.encryptMessage(encryptionRequest));
    }

    @GetMapping
    public ResponseEntity<List<EncryptionResponse>> getAllEncryption() {
        return ResponseEntity.ok(encryptionService.getAllEncryption());
    }
}
