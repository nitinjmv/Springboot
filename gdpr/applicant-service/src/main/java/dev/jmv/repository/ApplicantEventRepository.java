package dev.jmv.repository;

import dev.jmv.entity.ApplicantEvent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApplicantEventRepository extends JpaRepository<ApplicantEvent, Long> {

}
