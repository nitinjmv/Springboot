package dev.jmv.repository;

import dev.jmv.model.EncryptionRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EncryptionRepository extends JpaRepository<EncryptionRequest, Long> {
}
