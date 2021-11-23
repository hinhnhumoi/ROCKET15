package com.company;

import java.text.ParseException;
import java.time.LocalDate;
import java.util.Scanner;

public class TS2Ex5 {
    public static void main(String[] args) throws ParseException {

//        Scanner scanner = new Scanner(System.in);
////Q1 Viết lệnh cho phép người dùng nhập 3 số nguyên vào chương trình
//        System.out.println(" Nhập 3 số nguyên: ");
//        int a1=scanner.nextInt();
//        int a2=scanner.nextInt();
//        int a3=scanner.nextInt();
//        System.out.println("Input: " + a1 +","+ a2 +","+ a3);
//
//    //q2 nhap 2 so thuc
//        System.out.println(" Nhập 2 số thực: ");
//        double b1 = scanner.nextDouble();
//        double b2 = scanner.nextDouble();
//        System.out.println("input: " + b1 + "," +b2);
//    //Q3 nhap ho ten
//        System.out.println("Nhap ho cua ban:");
//        String c1=scanner.nextLine();
//        System.out.println("Nhap ten cua ban:");
//        String c2=scanner.nextLine();
//        System.out.println("ho ten ban la: "+ c1 +c2);
//    //Q4 Nhap ngay sinh
//        System.out.println("Nhap ngay sinh:");
//        int d1=scanner.nextInt();
//        System.out.println("Nhap thang sinh:");
//        int d2=scanner.nextInt();
//        System.out.println("Nhap nam sinh:");
//        int d3=scanner.nextInt();
//        LocalDate d = LocalDate.of(d3,d2,d1);
//        System.out.println("Ngay Sinh cua ban la: " +d);
    //Q5
        Q5();
    }
    private static void Q5 () {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhap vao thong tin account:");
        account acc = new account();
        System.out.print(" Id: ");
            acc.accountID = scanner.nextInt();
        System.out.println(" Email ");
            acc.email = scanner.next();
        System.out.println(" Full name ");
            acc.fullName = scanner.next();
        System.out.println(" User Name ");
            acc.fullName = scanner.next();
        System.out.println(" 1 to 4 : position : ");
            int posNum = scanner.nextInt();
        switch (posNum){
            case 1:
                position pos1 = new position();
                pos1.PositionName = "DEV";
                acc.positions = pos1;
                break;
            case 2:
                position pos2 = new position();
                pos2.PositionName = "Test";
                acc.positions = pos2;
                break;
            case 3:
                position pos3 = new position();
                pos3.PositionName = "ScrumMaster,";
                acc.positions = pos3;
                break;
            case 4:
                position pos4 = new position();
                pos4.PositionName = "PM";
                acc.positions = pos4;
                break;
        }
    }
}
