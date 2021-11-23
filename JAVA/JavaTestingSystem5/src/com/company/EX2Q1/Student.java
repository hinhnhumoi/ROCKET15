package com.company.EX2Q1;

public class Student implements IStudent{
    private int id;
    private String name;
    private int group;

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

    public int getGroup() {
        return group;
    }

    public void setGroup(int group) {
        this.group = group;
    }

    @Override
    public void Attendance() {
        System.out.printf(this.name + " dang diem danh");
    }

    @Override
    public void Learn() {
        System.out.println(this.name + " dang hoc bai");
    }

    @Override
    public void Clean() {
        System.out.printf(this.name + "dang don ve sinh");
    }

    public Student(int id, String name, int group) {
        this.id = id;
        this.name = name;
        this.group = group;
    }
}
