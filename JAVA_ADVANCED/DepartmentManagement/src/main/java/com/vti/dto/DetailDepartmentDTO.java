package com.vti.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class DetailDepartmentDTO {
    private short id;

    private String name;

    private AccountDTO author;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date createDate;

    public DetailDepartmentDTO(short id, String name, AccountDTO author, Date createDate) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.createDate = createDate;
    }

    public DetailDepartmentDTO() {
    }

    public short getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public AccountDTO getAuthor() {
        return author;
    }

    public Date getCreateDate() {
        return createDate;
    }
}
