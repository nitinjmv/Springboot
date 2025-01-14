package dev.jmv.config;

import dev.jmv.model.AccountDetails;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

@Component
public class AccountDetailsProcessor implements ItemProcessor<AccountDetails, AccountDetails> {
    @Override
    public AccountDetails process(AccountDetails accountDetails) throws Exception {
        return accountDetails;
    }
}
