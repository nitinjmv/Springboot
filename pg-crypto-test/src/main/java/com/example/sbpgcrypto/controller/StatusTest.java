package com.example.sbpgcrypto.controller;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/status")
public class StatusTest {

    @GetMapping
    public ResponseEntity<StatusDto> getStatus(){
        return ResponseEntity.ok(StatusDto.builder().status("started").build());
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<StatusDto> postStatus(@RequestBody StatusDto statusDto){
        return ResponseEntity.ok(statusDto);
    }

}

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
class StatusDto{
    private String status;
}