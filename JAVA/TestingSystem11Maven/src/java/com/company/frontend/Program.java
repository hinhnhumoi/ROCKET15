package com.company.frontend;

import com.company.backend.presentationlayer.AccountController;

import java.sql.SQLException;

public class Program {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        AccountController accountController = new AccountController();
        accountController.getListAccount();
    }
}
