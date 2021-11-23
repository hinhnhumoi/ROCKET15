package com.company.Ex5;

public class CanBo {
    private String hoten;
    private int tuoi;
    private GioiTinh gioiTinh;
    private String diaChi;

    public enum GioiTinh {
        Nam,
        Nu,
        Unknown
    }

    public String getHoten() {
        return hoten;
    }
    public void setHoten(String hoten) {
        this.hoten = hoten;
    }
    public int getTuoi() {
        return tuoi;
    }
    public void setTuoi(int tuoi) {
        this.tuoi = tuoi;
    }
    public GioiTinh getGioiTinh() {
        return gioiTinh;
    }
    public void setGioiTinh(GioiTinh gioiTinh) {
        this.gioiTinh = gioiTinh;
    }
    public String getDiaChi() {
        return diaChi;
    }
    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }
    public CanBo(String hoten, int tuoi, GioiTinh gioiTinh, String diaChi) {
        this.hoten = hoten;
        this.tuoi = tuoi;
        this.gioiTinh = gioiTinh;
        this.diaChi = diaChi;
    }

    @Override
    public String toString() {
        return "CanBo{" +
                "hoten='" + hoten + '\'' +
                ", tuoi=" + tuoi +
                ", gioiTinh=" + gioiTinh +
                ", diaChi='" + diaChi + '\'' +
                '}';
    }
}
