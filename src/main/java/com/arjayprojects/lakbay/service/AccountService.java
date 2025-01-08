package com.arjayprojects.lakbay.service;

import com.arjayprojects.lakbay.model.entity.Account;

import java.util.List;

public interface AccountService {

    Account save(Account account);

    List<Account> findAll();

}
