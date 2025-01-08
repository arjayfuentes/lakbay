package com.arjayprojects.lakbay.controllers;


import com.arjayprojects.lakbay.model.dto.AccountDto;
import com.arjayprojects.lakbay.model.entity.Account;
import com.arjayprojects.lakbay.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.arjayprojects.lakbay.mappers.Mapper;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @Autowired
    private Mapper <Account, AccountDto> accountMapper;

    public AccountController(Mapper<Account, AccountDto> accountMapper) {
        this.accountMapper = accountMapper;
    }

    @PostMapping
    public ResponseEntity<AccountDto> createAccount(@RequestBody AccountDto accountDto) {
        Account account = accountMapper.mapFrom(accountDto);
        Account savedAccount = accountService.save(account);
        return new ResponseEntity<>(accountMapper.mapTo(savedAccount), HttpStatus.CREATED);
    }


    @GetMapping
    public List<AccountDto> listAuthors() {
        List<Account> authors = accountService.findAll();
        return authors.stream()
                .map(accountMapper::mapTo)
                .collect(Collectors.toList());
    }
}
