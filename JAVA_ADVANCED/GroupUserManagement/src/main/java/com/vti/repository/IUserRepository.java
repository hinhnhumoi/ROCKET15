package com.vti.repository;

import com.vti.entity.User;
import com.vti.entity.enumurate.UserStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IUserRepository extends JpaRepository<User,Short>, JpaSpecificationExecutor<User> {

    public boolean existsByUsername (String username);

    public  User findByUsername (String username);

    public boolean existsByEmail (String email);

    public User findByEmail (String email);

    @Query( "select status from User where email = :email" )
    public UserStatus findStatusByEmail (String email);

}
