package com.company.entity;

public class Manager extends User{

    /**
     * This class is Manager
     *
     * @Description: every Manager of the company
     * @author : Tung
     * @create_date: ${13-8-2021}
     * @version : 1.0
     * @modifier : Tung
     * @modifier_date : ${13-8-2021}
     */

    private int expInYear;


    public Manager(int id, String fullName, String email, String passWord, int expInYear) {
        super(id, fullName, email, passWord);
        this.expInYear = expInYear;
    }

    public int getExpInYear() {
        return expInYear;
    }

    public void setExpInYear(int expInYear) {
        this.expInYear = expInYear;
    }
}

