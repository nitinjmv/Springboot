package dev.jmv.config;

import dev.jmv.model.AccountDetails;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.StringJoiner;

@Component
public class AccountDetailsProcessor implements ItemProcessor<AccountDetails, AccountDetails> {
    @Override
    public AccountDetails process(AccountDetails accountDetails) throws Exception {
        accountDetails.setAccount_number(updateAccountNum(accountDetails.getAccount_number()));
        return accountDetails;
    }

    private String updateAccountNum(String acc) {
        return acc.concat("****");
    }
}
