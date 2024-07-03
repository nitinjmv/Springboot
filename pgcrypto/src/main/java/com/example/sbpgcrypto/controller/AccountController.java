package com.example.sbpgcrypto.controller;

import com.example.sbpgcrypto.dto.BulkAccountsDto;
import com.example.sbpgcrypto.entity.Account;
import com.example.sbpgcrypto.service.AccountService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("accounts")
@RequiredArgsConstructor
public class AccountController {

    final AccountService accountService;

    @Value("${pgcrypto.secret}")
    private String key;

    @PostMapping("bulk")
    public void uploadAccounts(
            @RequestBody BulkAccountsDto bulkAccountsDto,
            @RequestParam("type") String type,
            @RequestParam("status") String status){
        log.info("Bulk upload with key {}", key);
        accountService.bulkUpload(bulkAccountsDto, type, status);
    }
    @PostMapping
    public Account createAccount(@RequestBody Account account){
        log.info("Add account with key {}", key);
        return accountService.createAccount(account);
    }

    @GetMapping("status/{status}")
    public List<Account> getAccountsByStatus(@PathVariable String status){
        return accountService.getAccountsByStatus(status);
    }

    @GetMapping("type/{type}")
    public List<Account> getAccountsByType(@PathVariable String type){
        return accountService.getAccountsByType(type);
    }

    @GetMapping
    public List<Account> getAccounts(){
        log.info("Get all with key {}", key);
        return accountService.getAccounts();
    }

//    @GetMapping("{limit}")
//    public List<String> getAccountsByReadLimit(
//            @PathVariable("limit") int limit){
//        return accountService.getAccountByReadLimit(limit);
//    }

    @GetMapping("limit")
    public List<String> getAccountsByReadLimitRequestParam(
            @RequestParam Long accountReadLimit){
        return accountService.getAccountByReadLimit(accountReadLimit);
    }

}
