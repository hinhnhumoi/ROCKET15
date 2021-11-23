package com.company.EX2Q2;

import java.util.Scanner;

public class Student extends Person{
    private int msv;
    private double diemTB;
    private String email;


    @Override
    public void InputInfo() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhap ma sinh vien"); this.msv=scanner.nextInt();
        super.InputInfo();
        System.out.println("Nhap diem TB cua sinh vien"); this.diemTB=scanner.nextDouble(); scanner.nextLine();
        System.out.println("Nhap email sinh vien"); this.email=scanner.nextLine();
    }

    @Override
    public void ShowInfo() {
        super.ShowInfo();
        System.out.println("ma sinh vien: "+ msv + ", diem TB: " + diemTB + ", Email: " + email);
    }

    public int getMsv() {
        return msv;
    }

    public void setMsv(int msv) {
        this.msv = msv;
    }

    public double getDiemTB() {
        return diemTB;
    }

    public void setDiemTB(double diemTB) {
        this.diemTB = diemTB;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
