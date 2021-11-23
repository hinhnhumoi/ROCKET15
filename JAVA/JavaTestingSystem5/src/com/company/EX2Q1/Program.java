package com.company.EX2Q1;

import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Student[] students = new Student[10];
        for (int i=0;i<10;i++) {
            System.out.printf("Nhap Id cua sinh vien"+(i+1)+" :");
            int id = scanner.nextInt();
            scanner.nextLine();
            System.out.printf("Nhap ten cua sinh vien"+(i+1)+" :");
            String ten = scanner.nextLine();
            System.out.printf("Nhap nhom cua sinh vien"+(i+1)+" :");
            int group = scanner.nextInt();
        }
    }
}
