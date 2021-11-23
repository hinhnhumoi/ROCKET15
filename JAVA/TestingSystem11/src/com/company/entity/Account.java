package com.company.entity;

import java.sql.Date;
import java.time.LocalDate;

public class Account {
    private int id;
    private String email;
    private String userName;
    private String fullName;
    private Date createDate;

    public Account(int id, String email, String userName, String fullName, Date createDate) {
        this.id = id;
        this.email = email;
        this.userName = userName;
        this.fullName = fullName;
        this.createDate = createDate;
    }
}

