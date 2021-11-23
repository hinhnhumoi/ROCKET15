package com.company.backend.businesslayer;

import com.company.backend.datalayer.AccountRepository;
import com.company.entity.Account;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AccountService {
    private AccountRepository accountRepository;

    public AccountService() {
        accountRepository = new AccountRepository();
    }

    public List<Account> getListAccount () throws SQLException, ClassNotFoundException {

        return  accountRepository.getListAccounts();
    }
}
