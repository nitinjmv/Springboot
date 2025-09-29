package dev.jmv.gdpr.repository;

import dev.jmv.entity.Applicant;
import dev.jmv.gdpr.model.GdprEligibleRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public interface GdprApplicantRepository extends JpaRepozsitory<Applicant, Long> {


    @Query(value = "SELECT * FROM ",
            nativeQuery = true)

    GdprEligibleRecord getEligibleRecords(Date cutOffDate);
}
