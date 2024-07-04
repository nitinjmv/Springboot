package com.example.sbpgcrypto.repository;

import com.example.sbpgcrypto.entity.Account;
import com.example.sbpgcrypto.entity.Pan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PanRepository extends JpaRepository<Pan, Long> {

    @Query(value =
            "SELECT pgp_sym_decrypt(pan.PAN_NUMBER\\:\\:bytea, '${pgcrypto.secret}') FROM PAN_TABLE pan where pan.STS = 'active' LIMIT ?1"
            , nativeQuery = true
    )
    List<String> findPansByReadLimit(@Param("panReadLimit") Long panReadLimit);

    List<Pan> findByType(String type);

    List<Pan> findByStatus(String status);
}
