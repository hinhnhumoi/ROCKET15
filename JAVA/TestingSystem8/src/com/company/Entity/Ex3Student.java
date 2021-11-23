package com.company.Entity;

public class Ex3Student<T extends Number>{
    private T id;
    private String name;

    public T getId() {
        return id;
    }
    public void setId(T id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public Ex3Student(T id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student" + id + ", name: " + name ;
    }
}
