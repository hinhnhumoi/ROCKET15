package com.company.Backend;

import com.company.Entity.*;

import java.util.ArrayList;
import java.util.Scanner;

public class Ex1 {

    public static void Q12() {
        Student student1= new Student(1, "Nguyễn Văn A");
        Student student2= new Student(2, "Nguyễn Văn B");
        Student student3= new Student(3, "Nguyễn Văn C");
        Student[] students = {student1,student2,student3};

        for (Student student : students) {
            System.out.println(student);
        }

        Student.setCollege("Đại học Công Nghệ");
        for (Student student : students) {
            System.out.println(student);
        }

        System.out.println("Tiền ban đầu: "+Student.getMoneyGroup());
        Student.MoneySpending(student1,50);
        Student.MoneySpending(student2,20);
        Student.MoneySpending(student3,150);
        System.out.println("Tiền sau khi tiêu: "+ Student.getMoneyGroup());
        Student.MoneyFunding(students,50);
        System.out.println("Tiền sau khi đóng "+ Student.getMoneyGroup());
    }

    public static void StudentCount () {
        System.out.println("Số student: "+ Student.count);
    }
    public static void PStudentCount () {
        System.out.println("Số primary student: "+ PrimaryStudent.pCount);
    }
    public static void SStudentCount () {
        System.out.println("Số secondary student: "+ SecondaryStudent.sCount);
    }

    public static void Q6() {
        ArrayList<Student> students = new ArrayList<Student>();
            Student student1 = new PrimaryStudent(1, "Nguyễn Văn A");
            students.add(student1);
            Student student2 = new PrimaryStudent(2, "Nguyễn Văn B");
            students.add(student2);
            Student student3 = new SecondaryStudent(3, "Nguyễn Văn c");
            students.add(student3);
            Student student4 = new SecondaryStudent(4, "Nguyễn Văn d");
            students.add(student4);
            Student student5 = new SecondaryStudent(5, "Nguyễn Văn e");
            students.add(student5);
            Student student6 = new SecondaryStudent(6, "Nguyễn Văn f");
            students.add(student6);
            Student student7 = new SecondaryStudent(6, "Nguyễn Văn g");
            students.add(student7);
        StudentCount();
        PStudentCount();
        SStudentCount();
        for (Student student: students) {
            System.out.println(student);
        }
    }

    public static void Q9() throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Tao hinh tron: ");
        HinhTron[] hinhTrons = new HinhTron[4];
        for (int i=0;i<4;i++) {
            System.out.println("Nhap ban kinh hinh tron so " +(i+1)+" :");
            double a =scanner.nextDouble();
             hinhTrons[i] = new HinhTron(a);
        }
        System.out.println("Tao hinh Vuong: ");
        HinhVuong[] hinhVuongs = new HinhVuong[3];
        for (int i=0;i<3;i++) {
            System.out.println("Nhap canh hinh vuong so " +(i+1) + " :");
            double a =scanner.nextDouble();
            hinhVuongs[i] = new HinhVuong(a);
        }
    }
}
