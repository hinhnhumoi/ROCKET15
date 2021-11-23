package com.company.Entity;

public abstract class HinhHoc {
    private double a;
    public static int count;

    public abstract double ChuVi(float a);
    public abstract double DienTich (float a);

    public HinhHoc(double a) throws Exception {
        super();
        count++;
        if (count<= Config.soHinhToiDa)  this.a = a;
            else throw new HinhHocException();
    }
}
