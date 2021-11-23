package com.company.Ex5;

public class KiSu extends CanBo{
    private String nganhDaoTao;
    public KiSu(String hoten, int tuoi,CanBo.GioiTinh gioiTinh, String diaChi,String nganh) {
        super(hoten, tuoi,gioiTinh, diaChi);
        this.nganhDaoTao=nganh;
    }
}
