package com.company.Entity;

public class Student{
    private int id;
    private String name;
    private static String college = "Đại học Bách Khoa";
    private static int moneyGroup;
    public static int count;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static String getCollege() {
        return college;
    }

    public static void setCollege(String college) {
        Student.college = college;
    }

    public static int getMoneyGroup() {
        return moneyGroup;
    }

    public static void setMoneyGroup(int moneyGroup) {
        Student.moneyGroup = moneyGroup;
    }

    public Student(int id, String name) {
        if (count>=6) System.out.println("Vượt quá số HS cho phép!!!");
        else {
        this.id = id;
        this.name = name;
        moneyGroup += 100;
        count++;}
    };

    @Override
    public String toString() {
        return ("ID: " + id +", Name: " +name +", school: " + college);
    }

    public static void MoneySpending (Student a, int money){
        moneyGroup -= money;
    }

    public static void MoneyFunding (Student[] students, int money){
        for (Student student: students) {
            moneyGroup+=money;
        }
    }
}
