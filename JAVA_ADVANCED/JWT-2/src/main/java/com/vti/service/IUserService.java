package com.vti.service;

import com.vti.dto.UserProfileDTO;
import com.vti.entity.Group;
import com.vti.entity.User;
import com.vti.form.UserFormForFilter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface IUserService extends UserDetailsService {
    public User getUserByUsername(String username);

    public User getUserById (short id);

    public Page<User> getAllUsers(Pageable pageable, String search);
}
