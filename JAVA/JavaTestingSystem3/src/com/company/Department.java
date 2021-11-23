package com.company;

public class Department {
    int departmentID;
    String departmentName;

    @Override
    public String toString () {
    return "ID :" + departmentID + ", Department Name: " + departmentName;
    }

    @Override
    public boolean equals (Object obj){
        Department a  =new Department();
        obj = (Object) a;
//        if (obj == null) return false;
        if (this.departmentName == a.departmentName) return true;
        else return false;
    }
}

