package com.company.Entity;

public class SecondaryStudent extends Student{
    public static int sCount;
    public SecondaryStudent(int id, String name) {
        super(id, name);
        sCount++;
    }
}
