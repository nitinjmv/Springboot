package dev.jmv.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import dev.jmv.domain.pg.Account;
import dev.jmv.repository.pg.AccountRepositoryPg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AccountServicePg {

    @Autowired
    private AccountRepositoryPg accountRepositoryPg;

    public Account createAccount(Account account) {
        return accountRepositoryPg.save(account);
    }

    public List<Account> getAllAccounts() {
        return accountRepositoryPg.findAll();
    }

    public List<Account> createBulkAccounts(MultipartFile file) throws IOException {
        var mapper = new ObjectMapper();
        var rootNode = mapper.readTree(file.getInputStream());

        var accounts = mapper.readValue(rootNode.traverse(), new TypeReference<List<Account>>(){});
        accounts.stream().map(a -> {
            a.setFileName(file.getOriginalFilename());
            return a;
        }).collect(Collectors.toList());
        return accountRepositoryPg.saveAll(accounts);
    }

    public Account getAccountById(Long id) {
        return accountRepositoryPg.findById(id).orElse(null);
    }

    public void deleteAccountById(Long id) {
        accountRepositoryPg.deleteById(id);
    }

    public void deleteAll() {
        accountRepositoryPg.deleteAll();
    }
}
