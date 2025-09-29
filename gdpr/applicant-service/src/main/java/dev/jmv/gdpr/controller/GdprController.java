package dev.jmv.gdpr.controller;

import dev.jmv.gdpr.model.GdprEligibleRecord;
import dev.jmv.gdpr.service.GdprService;
import dev.jmv.gdpr.util.Constants;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping(Constants.GDPR)
@RequiredArgsConstructor
public class GdprController {

    private final GdprService retentionService;

    @GetMapping(value = Constants.ELIGIBLE)
    public ResponseEntity<GdprEligibleRecord> eligible(@PathVariable("cutOffDate")Date cutOffDate) {

        return retentionService.getEligibleRecords(cutOffDate);
    }
}
