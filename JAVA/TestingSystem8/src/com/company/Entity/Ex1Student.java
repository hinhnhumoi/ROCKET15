package com.company.Entity;

public class Ex1Student implements Comparable<Ex1Student>{
    private int id;
    private String name;
    public static int count=0;

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

    public Ex1Student(String name) {
        count++;
        this.name = name;
        this.id=count;
    }

    @Override
    public String toString() {
        return "Ex1Student " + id + ", name:  " + name ;
    }

    @Override
    public int compareTo(Ex1Student o) {
        return this.name.compareTo(o.name);
    }
}
