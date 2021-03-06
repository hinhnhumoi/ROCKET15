package com.vti.service;

import com.vti.entity.Account;
import com.vti.entity.Department;
import com.vti.repository.IAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AccountService implements IAccountService{

    @Autowired
    private IAccountRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Account account = repository.findByuserName(username);
        if (account == null){
            throw new UsernameNotFoundException(username);
        }

        return new User(
                account.getUserName(),
                account.getPassword(),
                AuthorityUtils.createAuthorityList(account.getRole()));
    }

    @Override
    public Account getAccountByUsername(String username) {
        return repository.findByuserName(username);
    }

}
