package com.company.entity;

public class User {

    /**
     * This class is User
     *
     * @Description: every user of the company
     * @author : Tung
     * @create_date: ${13-8-2021}
     * @version : 1.0
     * @modifier : Tung
     * @modifier_date : ${13-8-2021}
     */

    private int id;
    private String fullName;
    private String email;
    private String passWord;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public User(int id, String fullName, String email, String passWord) {
        this.id = id;
        this.fullName = fullName;
        this.email = email;
        this.passWord = passWord;
    }
}
