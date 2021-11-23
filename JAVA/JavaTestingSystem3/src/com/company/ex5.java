package com.company;

public class ex5 {
    public static void main(String[] args) {
    //Q1
        Department dep1 = new Department();
        dep1.departmentID =1;
        dep1.departmentName = "sales";

        Department dep2 = new Department();
        dep1.departmentID =2;
        dep1.departmentName = "sales";

        System.out.println(dep1);
    //Q2 easy
    //Q3
        System.out.println(dep1.hashCode());
    //Q4 easy
    //Q5
        System.out.println (dep1.equals(dep2));

    }
}
