package com.vti.controller;


import com.vti.dto.UserProfileDTO;
import com.vti.entity.User;
import com.vti.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.function.Function;

@RestController
@RequestMapping(value = "api/v1/users")
@CrossOrigin(origins = "http://127.0.0.1:5500")
public class UserController {

    @Autowired
    private IUserService userService;


    @GetMapping
    public  ResponseEntity<?>  getAllUsers (Pageable pageable, @RequestParam(required = false) String search){

        Page<User> entitiesPage = userService.getAllUsers(pageable, search);
        Page<UserProfileDTO> dtoPage = entitiesPage.map(new Function<User, UserProfileDTO>() {
            @Override
            public UserProfileDTO apply(User entity) {
                String groupName = entity.getGroup().getName();
                UserProfileDTO dto = new UserProfileDTO(
                        entity.getId(),
                        entity.getFullName(),
                        entity.getUsername(),
                        entity.getEmail(),
                        groupName
                );
                return dto;
            }
        });

        return new ResponseEntity<>(dtoPage, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> getUserById (@PathVariable(name = "id") short id){
        User entity = userService.getUserById(id);

        String groupName = entity.getGroup().getName();
        UserProfileDTO dto = new UserProfileDTO(
                entity.getId(),
                entity.getFullName(),
                entity.getUsername(),
                entity.getEmail(),
                groupName
        );

        return  new ResponseEntity<>(dto, HttpStatus.OK);
    }
}
