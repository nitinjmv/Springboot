package com.example.sbpgcrypto.controller;

import com.example.sbpgcrypto.dto.BulkPansDto;
import com.example.sbpgcrypto.entity.Pan;
import com.example.sbpgcrypto.service.PanService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("pans")
@RequiredArgsConstructor
public class PanController {

    final PanService panService;

    @Value("${pgcrypto.secret}")
    private String key;

    @PostMapping("bulk")
    public void uploadPans(
            @RequestBody BulkPansDto bulkPansDto,
            @RequestParam("type") String type,
            @RequestParam("status") String status) {
        log.info("Bulk upload with key {}", key);
        panService.bulkUpload(bulkPansDto, type, status);
    }

    @PostMapping
    public Pan createPan(@RequestBody Pan account) {
        log.info("Add account with key {}", key);
        return panService.createPan(account);
    }

    @GetMapping("status/{status}")
    public List<Pan> getPansByStatus(@PathVariable String status) {
        return panService.getPansByStatus(status);
    }

    @GetMapping("type/{type}")
    public List<Pan> getPansByType(@PathVariable String type) {
        return panService.getPansByType(type);
    }

    @GetMapping
    public List<Pan> getPans() {
        log.info("Get all with key {}", key);
        return panService.getPans();
    }

//    @GetMapping("{limit}")
//    public List<String> getPansByReadLimit(
//            @PathVariable("limit") int limit){
//        return panService.getPanByReadLimit(limit);
//    }

    @GetMapping("limit")
    public List<String> getPansByReadLimitRequestParam(
            @RequestParam Long accountReadLimit) {
        return panService.getPanByReadLimit(accountReadLimit);
    }

}
