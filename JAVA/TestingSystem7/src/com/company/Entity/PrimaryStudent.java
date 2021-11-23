package com.company.Entity;

public class PrimaryStudent extends Student{
    public static int pCount;
    public PrimaryStudent(int id, String name) {
        super(id, name);
        pCount++;
    }
}
