package dev.jmv.repository.pg;

import dev.jmv.domain.pg.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepositoryPg extends JpaRepository<Account, Long> {
}
