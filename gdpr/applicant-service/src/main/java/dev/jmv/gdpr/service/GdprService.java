package dev.jmv.gdpr.service;

import dev.jmv.gdpr.model.GdprEligibleRecord;
import dev.jmv.gdpr.repository.GdprApplicantRepository;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class GdprService {

    private GdprApplicantRepository gdprApplicantRepository;

    public GdprEligibleRecord getEligibleRecords(Date cutOffDate) {
        return gdprApplicantRepository.getEligibleRecords(cutOffDate);
    }
}
