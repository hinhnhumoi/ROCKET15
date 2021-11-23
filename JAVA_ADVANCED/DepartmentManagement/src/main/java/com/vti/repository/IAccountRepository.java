package com.vti.repository;

import com.vti.entity.Account;
import com.vti.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAccountRepository extends JpaRepository<Account,Short> {
    public  Account findByuserName (String username);
}
