package com.vti.service;

import com.vti.dto.UserProfileDTO;
import com.vti.entity.User;
import com.vti.repository.IUserRepository;
import com.vti.specification.UserSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService implements IUserService {

    @Autowired
    private IUserRepository repository;

    @Override
    public Page<User> getAllUsers( Pageable pageable, String search) {
        Specification<User> where = null;

        if (!StringUtils.isEmpty(search)) {
            UserSpecification nameSpecification = new UserSpecification("fullName", "LIKE", search);
            UserSpecification usernameSpecification = new UserSpecification("username", "LIKE", search);
            where = Specification.where(nameSpecification).or(usernameSpecification);
        }
        return repository.findAll(where,pageable);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = repository.findByUsername(username);
        if (user == null){
            throw new UsernameNotFoundException(username);
        }

        return new org.springframework.security.core.userdetails.User(
                user.getUsername(),
                user.getPassword(),
                AuthorityUtils.createAuthorityList(user.getRole()));

    }

    @Override
    public User getUserByUsername(String username) {
        return repository.findByUsername(username);
    }

    @Override
    public User getUserById(short id) {
        return repository.findById(id).get();
    }


}
