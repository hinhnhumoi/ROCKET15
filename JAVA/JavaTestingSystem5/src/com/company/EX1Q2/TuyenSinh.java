package com.company.EX1Q2;

import java.util.ArrayList;
import java.util.Scanner;

public class TuyenSinh implements ITuyenSinh{
    private ArrayList<Student> studentList ;
    Scanner scanner =new Scanner(System.in);

    public TuyenSinh () {
        studentList = new ArrayList<Student>();
        scanner = new Scanner(System.in);

    };

    @Override
    public void addStudent() {
        System.out.println("Nhap SBD thi sinh: ");
        int sbd = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Nhap ten thi sinh: ");
        String name = scanner.nextLine();
        System.out.println("Nhap dia chi thi sinh: ");
        String diaChi = scanner.nextLine();
        System.out.println("Nhap khoi thi cua sinh: ");
        String khoi = scanner.nextLine();
        Student student = new Student (sbd,name,diaChi,new Block(khoi));
        studentList.add(student);
    }

    @Override
    public void showInfo() {
        for (Student student : studentList) {
            System.out.println(student);
        }

    }

    @Override
    public void findID(int ID) {
        for (Student student : studentList) {
            if (student.getID() == ID)
            System.out.println(student);
        }

    }
}
