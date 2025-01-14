package dev.jmv.controller;

import dev.jmv.model.AccountDetails;
import dev.jmv.repository.AccountDetailsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("accounts")
@RequiredArgsConstructor
public class AccountController {

    private final AccountDetailsRepository accountDetailsRepository;

    @GetMapping
    public ResponseEntity<List<AccountDetails>> findAll() {
        return ResponseEntity.ok(accountDetailsRepository.findAll());
    }

}
