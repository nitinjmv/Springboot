package dev.jmv.batch.repository.sql;

import dev.jmv.batch.domain.sql.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepositorySql extends JpaRepository<Account, Long> {
}
