package com.vti.repository;

import com.vti.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface IUserRepository extends JpaRepository<User,Short>, JpaSpecificationExecutor<User> {
    public  User findByUsername (String username);


}
