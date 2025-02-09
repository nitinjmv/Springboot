package dev.jmv.repository;

import dev.jmv.domain.Encryption;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EncryptionRepository extends JpaRepository<Encryption, Long> {
}
