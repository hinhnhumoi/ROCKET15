package com.company.Ex1;

import java.util.Arrays;
import java.util.Date;

public class Group {
    int groupID;
    String groupName;
    int creatorID;
    Account[] accounts;
    Date createDate;

    @Override
    public String toString() {
        return "Group{" +
                "groupID=" + groupID +
                ", groupName='" + groupName + '\'' +
                ", creatorID=" + creatorID +
                ", accounts=" + Arrays.toString(accounts) +
                ", createDate=" + createDate +
                '}';
    }

    public Group(int groupID, String groupName, int creatorID, Account[] accounts, Date createDate) {
        this.groupID = groupID;
        this.groupName = groupName;
        this.creatorID = creatorID;
        this.accounts = accounts;
        this.createDate = createDate;
    }
}
