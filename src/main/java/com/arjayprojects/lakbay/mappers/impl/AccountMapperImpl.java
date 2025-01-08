package com.arjayprojects.lakbay.mappers.impl;

import com.arjayprojects.lakbay.model.dto.AccountDto;
import com.arjayprojects.lakbay.model.entity.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.modelmapper.ModelMapper;
import com.arjayprojects.lakbay.mappers.Mapper;


@Component
public class AccountMapperImpl implements Mapper<Account, AccountDto>{


    @Autowired
    private ModelMapper modelMapper;

    @Override
    public AccountDto mapTo(Account Account) {
        return modelMapper.map(Account, AccountDto.class);
    }

    @Override
    public Account mapFrom(AccountDto AccountDto) {
        return modelMapper.map(AccountDto, Account.class);
    }
}
