package com.company.Ex2andEx3.entity;

import java.time.LocalDate;;

public class Group {
    private int groupID;
    private String groupName;
    private int creatorID;
    private Account[] accounts;
    private LocalDate createDate;

    public int getGroupID() {
        return groupID;
    }
    public String getGroupName() {
        return groupName;
    }
    public int getCreatorID() {
        return creatorID;
    }
    public Account[] getAccounts() {
        return accounts;
    }
    public LocalDate getCreateDate() {
        return createDate;
    }

    public void setGroupID(int groupID) {
        this.groupID = groupID;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public void setCreatorID(int creatorID) {
        this.creatorID = creatorID;
    }

    public void setAccounts(Account[] accounts) {
        this.accounts = accounts;
    }

    public void setCreateDate(LocalDate createDate) {
        this.createDate = createDate;
    }
}
