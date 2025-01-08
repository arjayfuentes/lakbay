package com.arjayprojects.lakbay.service.impl;

import com.arjayprojects.lakbay.model.entity.Account;
import com.arjayprojects.lakbay.repositories.AccountRepository;
import com.arjayprojects.lakbay.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Override
    public Account save(Account account) {
        return accountRepository.save(account);
    }

    @Override
    public List<Account> findAll() {
        return StreamSupport.stream(accountRepository
                                .findAll()
                                .spliterator(),
                        false)
                .collect(Collectors.toList());
    }

}
