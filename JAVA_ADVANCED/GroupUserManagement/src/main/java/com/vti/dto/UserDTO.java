package com.vti.dto;

public class UserDTO {
    private short id;

    private String fullName;

    public UserDTO(short id, String fullName) {
        this.id = id;
        this.fullName = fullName;
    }

    public UserDTO() {
    }

    public short getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }
}
