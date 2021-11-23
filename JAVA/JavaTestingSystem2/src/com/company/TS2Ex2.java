package com.company;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class TS2Ex2 {
    public static void main(String[] args) {
//    //q2
//        int a = 100000000;
//        System.out.printf(Locale.US,"a= %,d\n",a);
//    //q3
//        double a1= 5.567098;
//        System.out.printf("a%5.4f",a1);
    //Q5
        String pattern ="dd-MM-yyyy HH:mm:ss";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        String date = simpleDateFormat.format(new Date());
        System.out.println(date);
    }
}
