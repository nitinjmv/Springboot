package dev.jmv.batch.repository.pg;

import dev.jmv.batch.domain.pg.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepositoryPg extends JpaRepository<Account, Long> {
}
