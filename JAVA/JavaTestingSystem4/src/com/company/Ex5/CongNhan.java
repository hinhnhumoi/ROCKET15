package com.company.Ex5;

public class CongNhan extends CanBo{
    private int bac;
    public CongNhan(String hoten, int tuoi,CanBo.GioiTinh gioiTinh, String diaChi,int bac) {
        super(hoten, tuoi,gioiTinh, diaChi);
        this.bac= bac;
    }
}
