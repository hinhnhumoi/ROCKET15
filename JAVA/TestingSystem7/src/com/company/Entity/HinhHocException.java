package com.company.Entity;

public class HinhHocException extends Exception{
    public HinhHocException () {
        super(" Số lượng hình đã tạo vượt quá" + Config.soHinhToiDa + "vui lòng kiểm tra lại!");
    }
}
