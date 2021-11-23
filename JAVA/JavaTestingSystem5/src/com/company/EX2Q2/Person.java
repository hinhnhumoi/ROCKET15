package com.company.EX2Q2;

import java.time.LocalDate;
import java.util.Scanner;

public class Person {
    private String ten;
    private LocalDate ngaySinh;
    private Gender.gender gioiTinh;
    private String diaChi;

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public LocalDate getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(LocalDate ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public Person() {
    }

    public Person(String ten, LocalDate ngaySinh, Gender.gender gioiTinh, String diaChi) {
        this.ten = ten;
        this.ngaySinh = ngaySinh;
        this.gioiTinh = gioiTinh;
        this.diaChi = diaChi;
    }
    public void InputInfo(){
        Scanner scanner=new Scanner(System.in);
        System.out.println("Nhap ten :"); this.ten =scanner.nextLine();
//        System.out.println("Nhap ngay sinh cua sinh vien:"); String ngaySinh =scanner.nextLine();
//        LocalDate date = LocalDate.parse(ngaySinh);
        System.out.println("Nhap ngay sinh (yyyy,mm,dd):"); this.ngaySinh = LocalDate.of(scanner.nextInt(),scanner.nextInt(),scanner.nextInt());
        scanner.nextLine();
        System.out.println("Nhap gioi tinh (1:nam, 2:nu,3: unknown) :"); int gt = scanner.nextInt();
        scanner.nextLine();
        switch (gt){
            case 1: this.gioiTinh = Gender.gender.nam; break;
            case 2: this.gioiTinh = Gender.gender.nu; break;
            case 3: this.gioiTinh = Gender.gender.unkhown; break;
        }
        System.out.println("Nhap dia chi :"); this.diaChi =scanner.nextLine();
    }
    public void ShowInfo() {
        System.out.println("Ten: " +ten +", Ngay sinh: " + ngaySinh + ", Gioi tinh: " +gioiTinh +", Dia chi:" +diaChi);
    }
}
