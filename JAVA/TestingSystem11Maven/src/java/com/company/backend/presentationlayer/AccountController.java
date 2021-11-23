package com.company.backend.presentationlayer;

import com.company.backend.businesslayer.AccountService;
import com.company.entity.Account;

import java.sql.SQLException;
import java.util.List;

public class AccountController {
    private AccountService accountService;

    public AccountController() {
        accountService = new AccountService();
    }

    public List<Account> getListAccount () throws SQLException, ClassNotFoundException {
        return accountService.getListAccount();
    }
}
