package com.sequoia.mapper;

import com.sequoia.domain.Account;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by sunjun on 16/8/2.
 */
@Repository
public interface AccountMapper {

    Account getAccountByUsername(String username);

    
    List<Account> getAllKFAccount();

    Account getAccountByUsernameAndPassword(String username, String password);

    void insertAccount(Account account);

    void updateAccount(Account account);

    void insertSignon(Account account);

    void updateSignon(Account account);
}
