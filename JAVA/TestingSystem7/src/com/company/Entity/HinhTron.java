package com.company.Entity;

public class HinhTron extends HinhHoc{

    public HinhTron(double a) throws Exception {
        super(a);
    }

    @Override
    public double ChuVi(float a) {
        return Config.pi*2*a;
    }

    @Override
    public double DienTich(float a) {
        return Config.pi*a*a;
    }
}
