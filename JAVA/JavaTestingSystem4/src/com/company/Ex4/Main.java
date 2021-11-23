package com.company.Ex4;

public class Main {
    public static void main(String[] args) {
        Student student = new Student(1, "Tran Anh Tuan","Hung Yen");
        System.out.println(student.printStudent());
        student.setMark(6);
        System.out.println(student.printStudent());
        student.addMark(3);
        System.out.println(student.printStudent());
    }
}
