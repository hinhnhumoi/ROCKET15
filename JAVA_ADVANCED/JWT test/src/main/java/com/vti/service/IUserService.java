package com.vti.service;

import com.vti.entity.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.List;

public interface IUserService extends UserDetailsService {
    User getUserByUsername(String username);

    List<User> getAllUsers();

}
