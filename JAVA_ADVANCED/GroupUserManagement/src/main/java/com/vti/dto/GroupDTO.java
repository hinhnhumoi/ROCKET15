package com.vti.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class GroupDTO {
    private short id;

    private String name;

    private UserInfoDTO creator;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date createDate;

    public GroupDTO(short id, String name, UserInfoDTO creator, Date createDate) {
        this.id = id;
        this.name = name;
        this.creator = creator;
        this.createDate = createDate;
    }

    public GroupDTO() {
    }

    public short getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public UserInfoDTO getCreator() {
        return creator;
    }

    public Date getCreateDate() {
        return createDate;
    }
}
