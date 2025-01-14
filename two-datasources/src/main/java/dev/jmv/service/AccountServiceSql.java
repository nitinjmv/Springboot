package dev.jmv.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import dev.jmv.domain.sql.Account;
import dev.jmv.repository.sql.AccountRepositorySql;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AccountServiceSql {

    @Autowired
    private AccountRepositorySql accountRepositorySql;

    public Account createAccount(Account account) {
        return accountRepositorySql.save(account);
    }

    public List<Account> getAllAccounts() {
        return accountRepositorySql.findAll();
    }

    public List<Account> createBulkAccounts(MultipartFile file) throws IOException {
        var mapper = new ObjectMapper();
        var rootNode = mapper.readTree(file.getInputStream());

        var accounts = mapper.readValue(rootNode.traverse(), new TypeReference<List<Account>>(){});
        accounts.stream().map(a -> {
            a.setFileName(file.getOriginalFilename());
            return a;
        }).collect(Collectors.toList());
        return accountRepositorySql.saveAll(accounts);
    }

    public Account getAccountById(Long id) {
        return accountRepositorySql.findById(id).orElse(null);
    }

    public void deleteAccountById(Long id) {
        accountRepositorySql.deleteById(id);
    }

    public void deleteAll() {
        accountRepositorySql.deleteAll();
    }
}
