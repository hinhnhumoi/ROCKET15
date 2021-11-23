package com.company.Ex5;

public class NhanVien extends CanBo{
    private String congViec;
    public NhanVien(String hoten, int tuoi,CanBo.GioiTinh gioiTinh, String diaChi,String viec) {
        super(hoten, tuoi, gioiTinh, diaChi);
        this.congViec = viec;
    }
}
