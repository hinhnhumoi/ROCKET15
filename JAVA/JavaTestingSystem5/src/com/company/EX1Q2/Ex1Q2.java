package com.company.EX1Q2;

import java.util.Scanner;

public class Ex1Q2 {
    public static void main(String[] args) {
        TuyenSinh tuyenSinh = new TuyenSinh();
        Scanner scanner= new Scanner(System.in);
        while (true){
            System.out.println("1.Thêm thí sinh.");
            System.out.println("2.Hiển thị thông tin các thí sinh");
            System.out.println("3.Tìm thí sinh dựa vào SBD");
            System.out.println("4.Kết thúc chương trình.");
            int temp = scanner.nextInt();
            switch (temp){
                case 1:
                    tuyenSinh.addStudent();
                    break;
                case 2:
                    tuyenSinh.showInfo();
                    break;
                case 3:
                    System.out.println("Nhap id can tim:");
                    int idTim = scanner.nextInt();
                    tuyenSinh.findID(idTim);
                    break;
                case 4:
                    return;
            }
        }
    }
}
