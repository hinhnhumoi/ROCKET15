package com.vti.dto;

public class UserInfoDTO {
    private short id;

    private String fullName;

    public UserInfoDTO(short id, String fullName) {
        this.id = id;
        this.fullName = fullName;
    }

    public UserInfoDTO() {
    }

    public short getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }
}
