package com.vti.controller;

import com.vti.dto.LoginInfoDTO;
import com.vti.entity.User;
import com.vti.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping(value = "api/v1/login")
@CrossOrigin(origins = "http://127.0.0.1:5500")
public class LoginController {

    @Autowired
    private IUserService service;

    @GetMapping
    public ResponseEntity<?> login (Principal principal){

        String username = principal.getName();
        User entity = service.getUserByUsername(username);

        LoginInfoDTO dto = new LoginInfoDTO(entity.getId(), entity.getFullName(), entity.getRole());

        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

}
