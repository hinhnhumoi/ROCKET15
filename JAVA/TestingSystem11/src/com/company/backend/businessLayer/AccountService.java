package com.company.backend.businessLayer;

import com.company.backend.dataLayer.AccountRepository;
import com.company.entity.Account;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AccountService {
    AccountRepository accountRepository =new AccountRepository();

    public AccountService() throws SQLException, IOException {
    }


    public List<Account> getListAccount (){
        List<Account> accounts = new ArrayList<>();
        return accounts;
    }
}
