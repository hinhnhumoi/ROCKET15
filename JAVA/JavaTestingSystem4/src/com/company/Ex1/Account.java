package com.company.Ex1;

import java.time.LocalDate;

public class Account {
    int accountID;
    String email;
    String userName;
    String fullName;
    LocalDate createDate;

    @Override
    public String toString() {
        return "Account{" +
                "accountID=" + accountID +
                ", email='" + email + '\'' +
                ", userName='" + userName + '\'' +
                ", fullName='" + fullName + '\'' +
                ", createDate=" + createDate +
                '}';
    }

    public Account() {
    }
    public Account(String email, String userName, String firstName, String lastName) {
        this.email = email;
        this.userName = userName;
        this.fullName = firstName +lastName;
    }

    public Account(int accountID, String email, String userName, String fullName) {
        this.accountID = accountID;
        this.email = email;
        this.userName = userName;
        this.fullName = fullName;
        this.createDate= LocalDate.now();
    }

}

