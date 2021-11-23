package com.company.Ex5;

public class QLCB {

    public void themCanBo (String hoten, int tuoi, CanBo.GioiTinh gioiTinh, String diaChi) {
        CanBo canBo = new CanBo(hoten,tuoi,gioiTinh,diaChi);
    }
    public void timCanBo (CanBo[] canBos,String hoTen) {
        for (CanBo canBo : canBos){
            if (canBo.getHoten()== hoTen)
                System.out.println(canBo);
        }
    }

}
