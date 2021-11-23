package com.vti.dto;

public class UserProfileDTO {
    private short id;

    private String fullName;

    private String username;

    private String email;

    private String group;


    public UserProfileDTO() {
    }

    public UserProfileDTO(short id, String fullName, String username, String email, String group) {
        this.id = id;
        this.fullName = fullName;
        this.username = username;
        this.email = email;
        this.group = group;
    }

    public short getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getGroup() {
        return group;
    }
}
