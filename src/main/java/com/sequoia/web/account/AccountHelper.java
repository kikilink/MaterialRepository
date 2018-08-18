package com.sequoia.web.account;

import javax.inject.Inject;

import com.sequoia.domain.Account;
import com.sequoia.domain.UserDetails;
import com.sequoia.service.AccountService;

import org.dozer.Mapper;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
public class AccountHelper {

    @Inject
    protected Mapper beanMapper;

    @Inject
    protected AccountService accountService;


    public void newAccount(AccountForm form) {
        Account account = beanMapper.map(form, Account.class);
        accountService.insertAccount(account);
    }

    public void editAccount(AccountForm form) {
        UserDetails userDetails = (UserDetails) SecurityContextHolder
                .getContext().getAuthentication().getPrincipal();
        Account account = userDetails.getAccount();

        // does not map "username" to use that of session object
        beanMapper.map(form, account, "accountExcludeUsername");
        accountService.updateAccount(account);

        // reflect new value to session object
        beanMapper.map(accountService.getAccount(account.getUsername()),
                account);

    }
}
