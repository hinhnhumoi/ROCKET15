package com.company.Entity;

public class HinhVuong extends HinhHoc{
    public HinhVuong(double a) throws Exception {
        super(a);
    }

    @Override
    public double ChuVi(float a) {
        return 4*a;
    }

    @Override
    public double DienTich(float a) {
        return a*a;
    }
}
