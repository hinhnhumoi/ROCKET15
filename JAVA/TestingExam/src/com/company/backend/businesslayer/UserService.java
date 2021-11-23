package com.company.backend.businesslayer;

import com.company.backend.datalayer.UserRepository;
import com.company.entity.User;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class UserService implements IUserService{
    private UserRepository userRepository;

    public UserService() {
        userRepository = new UserRepository();
    }

    public void getUserProject(int id) throws SQLException, IOException {
        if (id > userRepository.getListProjectId().size()){
            System.out.println("Số project hiện tại nhỏ hơn " + userRepository.getListProjectId().size()+"\n");
        }
        userRepository.getUserProject(id);
    }

    @Override
    public void getProjectManager() throws SQLException, IOException {
        userRepository.getProjectManager();
    }

    @Override
    public void login(String email, String password) throws SQLException, IOException {
        userRepository.login(email,password);
    }
}
