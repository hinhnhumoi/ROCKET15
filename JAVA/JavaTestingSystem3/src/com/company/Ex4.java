package com.company;

import java.util.Scanner;

public class Ex4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in)   ;
    //Q1
        //String split ????
    //Q2
        System.out.println("Nhap 2 xau ki tu: ");
        String s1a = scanner.nextLine();
        String s1b = scanner.nextLine();
        System.out.println(s1a + s1b);
        System.out.println(s1a.concat(s1b));
    //Q3 nhap ten va kiem tra, neu chua viet hoa chu cai dau thi viet hoa
        System.out.println(" Nhap ten cua ban: ");
        String s3 = scanner.next();
        if (s3.charAt(0) >65 && s3.charAt(0) <90 )
            System.out.println("Ten cua ban da viet hoa dung cach:" + s3);
        else {
            char s31 = (char) (s3.charAt(0) -32);
            System.out.println("Ten cua ban sau khi viet hoa chu cai dau: " +s31 + s3.substring(1));
        }
    //Q4
        System.out.println(" Nhap ten cua ban: ");
        String s4 = scanner.next();
        for (int i=0;i<s4.length();i++){
            System.out.println("ki tu thu "+ (i+1) + "la " + s4.charAt(i));
        }
    //Q5 de vl ko can lam


    }
}
