package com.company.Backend;

import com.company.Entity.Ex1Student;

import java.util.*;

public class Exercise1 {
    public static void Q1 (){
        List<Ex1Student> ex1Students = new ArrayList<>();
        ex1Students.add(new Ex1Student("Nguyễn Văn A"));
        ex1Students.add(new Ex1Student("Nguyễn Văn B"));
        ex1Students.add(new Ex1Student("Nguyễn Thị C"));
        ex1Students.add(new Ex1Student("Nguyễn Văn D"));
        ex1Students.add(new Ex1Student("Nguyễn Văn E"));
        ex1Students.add(new Ex1Student("Nguyễn Thị F"));

        System.out.println("Tổng số phần tử của list là: "+ ex1Students.size());
        System.out.println(" Phần tử thứ 4 của list: "+ ex1Students.get(3));
        System.out.println(" Phần tử đầu của list: "+ ex1Students.get(0));
        System.out.println(" Phần tử cuối của list: "+ ex1Students.get(ex1Students.size()-1));
        ex1Students.add(0,new Ex1Student("Nguyễn Văn Thêm"));
        System.out.println(" Phần tử đầu của list sau khi thêm : "+ ex1Students.get(0));
        ex1Students.add ( new Ex1Student("Đào Thanh Tùng"));

//        List<Ex1Student> ex1StudentsNguoc = new ArrayList<>();
//        for (int i= ex1Students.size()-1;i>=0;i--) {
//            ex1StudentsNguoc.add(ex1Students.get(i));
//        }
//        inStudent(ex1Students);
//        inStudent(ex1StudentsNguoc);
//
//        Collections.reverse(ex1Students);
        inStudent(ex1Students);
        Collections.sort(ex1Students);
        System.out.println("SAu khi sap xep theo ten: ");
        inStudent(ex1Students);
    }
    public static void Q2 () {
        Stack<Ex1Student> studentStack = new Stack<Ex1Student>();
        Ex1Student.count =0;
        studentStack.push(new Ex1Student("Nguyễn Văn Nam"));
        studentStack.push(new Ex1Student("Nguyễn Văn Huyên"));
        studentStack.push(new Ex1Student("Trần Văn Nam"));
        studentStack.push(new Ex1Student("Nguyễn Văn A"));
        System.out.println(studentStack.size());
        for (int i=0;i<4;i++) System.out.println(studentStack.pop());

        Queue<Ex1Student> studentQueue = new LinkedList<Ex1Student>();
        studentQueue.add (new Ex1Student("Nguyễn Văn NamL"));
        studentQueue.add(new Ex1Student("Nguyễn Văn HuyênL"));
        studentQueue.add(new Ex1Student("Trần Văn NamL"));
        studentQueue.add(new Ex1Student("Nguyễn Văn AL"));
        for (int i=0;i<4;i++) System.out.println(studentQueue.poll());
    }

    public static void Q3 () {
        Ex1Student.count=0;
        Ex1Student student1 =new Ex1Student("Đào Thanh Tùng");
        Ex1Student student2 =new Ex1Student("Đào Thanh Tùng");
        Ex1Student student3 =new Ex1Student("Trần Anh Tuấn");
        Ex1Student student4 =new Ex1Student("Đào Thanh Tùng");
        Ex1Student student5 =new Ex1Student("Ngô Sỹ Tiến");

        Set<Ex1Student> ex1Students= new HashSet<>();
        ex1Students.add(student1);
        ex1Students.add(student2);
        ex1Students.add(student3);
        ex1Students.add(student4);
        ex1Students.add(student5);
        for (Ex1Student student : ex1Students) {
            System.out.println(student);
        }
        // in ra hoc sinh thu 3
        Iterator<Ex1Student> iteratorQ3 = ex1Students.iterator();
        for (int i=0;i<=2;i++) iteratorQ3.next();
        System.out.println("hoc sinh thu 3 trong ds: "+iteratorQ3.next());
    }

    public static void Q67 () {
        Map<Integer,String> students = new HashMap<Integer,String>();
        Ex1Student.count=0;
        Ex1Student student1 =new Ex1Student("Trần Anh Tuấn");
        Ex1Student student2 =new Ex1Student("Đào Thanh Tùng");
        Ex1Student student3 =new Ex1Student("Ngô Sỹ Tiến");
        students.put(1,student1.getName());
        students.put(2,student2.getName());
        students.put(3,student3.getName());
        for (int i: students.keySet()){
            System.out.println(i);
        }
        for (String i: students.values()){
            System.out.println(i);
        }
    }
    public static void inStudent (List<Ex1Student> ex1Students ){
        for (int i=0;i<=ex1Students.size()-1;i++)
            System.out.println(ex1Students.get(i));
    }
}
