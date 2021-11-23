package com.company.Backend;

import com.company.Entity.Ex1Student;
import com.company.Entity.Ex2Student;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Exercise2 {
    public static void Q1(){
        List<Ex2Student> students = new ArrayList<>();
        students.add(new Ex2Student(1, "Đào Thanh Tùng", LocalDate.of(1997,1,28),10));
        students.add(new Ex2Student(2, "Trần Anh Tuấn", LocalDate.of(2001,10,2),80));
        students.add(new Ex2Student(3, "Ngô Sỹ Tiến", LocalDate.of(2001,5,10),85));
        students.add(new Ex2Student(4, "Đào Thanh Tùng", LocalDate.of(1997,1,28),93));
        students.add(new Ex2Student(5, "Đào Thanh Tùng", LocalDate.of(2001,3,30),99));
        inStudent(students);
        Collections.sort(students);
        inStudent(students);

    }    public static void inStudent (List<Ex2Student> ex2Students ){
        for (int i=0;i<=ex2Students.size()-1;i++)
            System.out.println(ex2Students.get(i));
    }
}
