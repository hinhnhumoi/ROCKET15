package com.company.backend.presentationlayer;

import com.company.backend.businesslayer.UserService;

import java.io.IOException;
import java.sql.SQLException;

public class UserController {
    private UserService userService;

    public UserController() {
        userService = new UserService();
    }

    public void getUserProject(int id) throws SQLException, IOException {
         userService.getUserProject(id);
    }

    public void getProjectManager () throws SQLException, IOException {
        userService.getProjectManager();
    }

    public void login(String email, String password) throws SQLException, IOException {
        userService.login(email,password);
    }
}
