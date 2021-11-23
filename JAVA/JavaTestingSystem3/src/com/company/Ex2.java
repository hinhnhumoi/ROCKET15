package com.company;

import java.time.LocalDate;

public class Ex2 {
    public static void main(String[] args) {
        Account[] accounts = new Account[5];
        for (int i=0;i<accounts.length;i++)
        {
            accounts[i] = new Account();
            accounts[i].accountID =i;
            accounts[i].email ="email" + i;
            accounts[i].fullName ="Nguyễn Văn " + i;
            accounts[i].userName ="Account " +i;
            accounts[i].createDate= LocalDate.now();
        }
        for (int i=0;i<accounts.length;i++)
        {
            System.out.println(accounts[i].accountID);
            System.out.println(accounts[i].fullName);
            System.out.println(accounts[i].userName);
            System.out.println(accounts[i].email);
            System.out.println(accounts[i].createDate);
        }

    }
}
