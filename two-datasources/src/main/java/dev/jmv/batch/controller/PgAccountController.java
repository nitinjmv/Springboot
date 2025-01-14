package dev.jmv.batch.controller;

import dev.jmv.batch.domain.pg.Account;
import dev.jmv.batch.service.AccountServicePg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/accounts/pg")
public class PgAccountController {

    @Autowired
    private AccountServicePg accountService;

    @GetMapping
    public ResponseEntity<List<Account>> getAllAccounts() {
        return ResponseEntity.ok(accountService.getAllAccounts());
    }

    @GetMapping("{id}")
    public ResponseEntity<Account> getAccountById(Long id) {
        return ResponseEntity.ok(accountService.getAccountById(id));
    }

    @PostMapping("bulkUpload")
    public ResponseEntity<List<Account>> createBulkAccounts(@RequestParam(name = "file") MultipartFile file) throws IOException {
        return ResponseEntity.ok(accountService.createBulkAccounts(file));
    }

    @PostMapping
    public ResponseEntity<Account> createAccount(@RequestBody Account account) {
        return ResponseEntity.ok(accountService.createAccount(account));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteAccountById(@PathVariable Long id) {
        accountService.deleteAccountById(id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteAll() {
        accountService.deleteAll();
        return ResponseEntity.noContent().build();
    }
}
