package com.vti.controller;

import com.vti.dto.AccountDTO;
import com.vti.dto.DepartmentDTO;
import com.vti.dto.DetailDepartmentDTO;
import com.vti.dto.LoginInfoDTO;
import com.vti.entity.Account;
import com.vti.entity.Department;
import com.vti.form.DepartmentFormForCreating;
import com.vti.form.DepartmentFormForFilter;
import com.vti.form.DepartmentFormForUpdating;
import com.vti.service.AccountService;
import com.vti.service.DepartmentService;
import com.vti.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;
import java.util.function.Function;

@RestController
@RequestMapping(value = "api/v1/login")
@CrossOrigin(origins = "http://127.0.0.1:5500")
public class LoginController {

    @Autowired
    private IAccountService service;

    @GetMapping
    public ResponseEntity<?> login (Principal principal){

        String username = principal.getName();
        Account entity = service.getAccountByUsername(username);

        LoginInfoDTO dto = new LoginInfoDTO(entity.getId(), entity.getFullName(), entity.getRole());

        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

}
